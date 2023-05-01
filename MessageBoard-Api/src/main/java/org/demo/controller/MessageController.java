package org.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.demo.common.CommonResult;
import org.demo.entity.vo.MessageListVO;
import org.demo.entity.vo.MessageVO;
import org.demo.protocol.MessageServiceImpl;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "message")
@Api(value = "MessageController", tags = "消息接口")
public class MessageController {
    @DubboReference
    private MessageServiceImpl messageService;

    @ApiOperation(value = "List all messages")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public CommonResult listMessage(MessageListVO vo) {
        CommonResult result = new CommonResult().init();

        try {
            org.demo.entity.response.ListMessageResponse resp = messageService.ListMessage(
                    org.demo.entity.request.ListMessageRequest.builder()
                        .page(vo.getPage_num())
                        .build()
            );
            result.success("message_list", resp.getMessageList());
        } catch (Exception e) {
            result.fail(1, e.toString());
        }

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "Add a message")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public CommonResult addMessage(MessageVO vo) {
        CommonResult result = new CommonResult().init();

        try {
            org.demo.entity.response.AddMessageResponse resp = messageService.AddMessage(
                    org.demo.entity.request.AddMessageRequest.builder()
                        .content(vo.getContent())
                        .user(vo.getUser())
                        .build()
            );
            result.success("message", resp.getMessage());
        } catch (Exception e) {
            result.fail(1, e.toString());
        }

        return (CommonResult) result.end();
    }
}
