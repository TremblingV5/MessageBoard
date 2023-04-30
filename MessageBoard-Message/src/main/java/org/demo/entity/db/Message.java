package org.demo.entity.db;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Message {
    private Long id;
    private String content;
    private String user;
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
}
