package org.demo.message.domain.repository;

import cn.hutool.core.util.PageUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.demo.message.domain.model.Message;
import org.demo.message.domain.model.QMessage;
import org.demo.message.infrastructure.cache.LocalCacheUtil;
import org.demo.message.infrastructure.jpa.JpaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MessageRepositoryImpl implements MessageRepository {
    private final JpaMessageRepository jpaMessageRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public MessageRepositoryImpl(JpaMessageRepository jpaMessageRepository) {
        this.jpaMessageRepository = jpaMessageRepository;
    }

    @Override
    public Message save(Message Message) {
        return jpaMessageRepository.save(Message);
    }

    public List<Message> findMessageList(int pageNum) {
        QMessage qMessage = QMessage.message;
        List<Message> MessageList = jpaQueryFactory.selectFrom(qMessage).fetch();

//        List<Message> MessageList = jpaMessageRepository.findAll(
//                Sort.by(Sort.Direction.DESC, "date")
//        );

        int[] pageRange = PageUtil.transToStartEnd(pageNum - 1, 5);

        val size = MessageList.size();
        int start = pageRange[0];
        int end = pageRange[1];
        if (size < end) {
            end = size;
        }

        return MessageList.subList(start, end);
    }
}
