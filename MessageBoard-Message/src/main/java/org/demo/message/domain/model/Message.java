package org.demo.message.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.demo.message.domain.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@Accessors(chain = true)
@Entity // Must use javax.persistence.Entity
@Table(name = "message")
@org.hibernate.annotations.Table(appliesTo = "message")
public class Message extends BaseEntity {
    @Column(name = "content", nullable = false, length = 255)
    private String content;

    @Column(name = "user", nullable = false, length = 255)
    private String user;

    @Column(name = "date")
    private Timestamp date;

    public String getTimeInterval() {
        Long curr = new Date().getTime();
        Long dis = curr - date.getTime();
        dis /= 1000;

        if (dis < 60) {
            return "刚刚";
        } else if (dis < 3600) {
            return dis / 60 + "分钟前";
        } else if (dis < 86400) {
            return dis / 3600 + "小时前";
        } else {
            return dis / 86400 + "天前";
        }
    }

    public org.demo.interfaces.entity.pojo.Message toDto() {
        return org.demo.interfaces.entity.pojo.Message.builder()
                .id(this.getId())
                .content(this.getContent())
                .user(this.getUser())
                .time(this.getTimeInterval())
                .build();
    }
}
