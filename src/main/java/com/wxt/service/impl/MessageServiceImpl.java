package com.wxt.service.impl;

import com.wxt.entity.Message;
import com.wxt.mapper.MessageMapper;
import com.wxt.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wxt
 * @since 2023-03-18
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
