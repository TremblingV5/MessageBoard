package org.demo.service.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.demo.entity.db.Message;
import org.demo.mapper.MessageMapper;
import org.demo.service.base.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public Message getMessageById(Long id) {
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<Message> list = messageMapper.selectList(wrapper);
        if (0 < list.size()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public List<Message> getMessageList() {
        List<Message> list = messageMapper.selectList(new QueryWrapper<Message>().orderByDesc("date"));
        return list;
    }

    public Message addMessage(String content, String username) {
        Message message = new Message();
        message.setContent(content).setUser(username);

        messageMapper.insert(message);
        return message;
    }
}
