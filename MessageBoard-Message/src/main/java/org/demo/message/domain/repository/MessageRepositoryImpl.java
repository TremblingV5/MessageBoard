package org.demo.message.domain.repository;

import cn.hutool.core.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.demo.message.domain.model.Message;
import org.demo.message.infrastructure.jpa.JpaMessageRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MessageRepositoryImpl implements MessageRepository {
    private final JpaMessageRepository jpaMessageRepository;

    public MessageRepositoryImpl(JpaMessageRepository jpaMessageRepository) {
        this.jpaMessageRepository = jpaMessageRepository;
    }

    @Override
    public Message save(Message message) {
        return jpaMessageRepository.save(message);
    }

    public List<Message> findMessageList(int pageNum) {
        List<Message> messageList = jpaMessageRepository.findAll(
                Sort.by(Sort.Direction.DESC, "date")
        );

        int[] pageRange = PageUtil.transToStartEnd(pageNum, 5);

        return messageList.subList(pageRange[0], pageRange[1]);
    }
}
