package org.demo.interfaces.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "MessageVO")
public class MessageVO {
    private String content;
    private String user;
    private String time;
}
