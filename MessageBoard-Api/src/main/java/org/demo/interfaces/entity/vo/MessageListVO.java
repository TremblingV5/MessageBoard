package org.demo.interfaces.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "MessageListVO")
public class MessageListVO {
    @ApiModelProperty(value = "Page num")
    private Integer page_num;
}
