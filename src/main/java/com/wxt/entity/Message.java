package com.wxt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wxt
 * @since 2023-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("message")

public class Message implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String keymessage;

    private String valuemessage;

    private String qq;

    private String url;


}
