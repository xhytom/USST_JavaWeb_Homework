package org.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体类，用于映射用户表的字段
 */
@Data
@TableName("users")  // 映射到数据库中的users表
public class User {
    @TableId
    private Long id;  // 用户ID，主键
    private String username;  // 用户名，唯一
    private String password;  // 用户密码
    private String role;  // 用户角色（ADVERTISER, ADMIN, WEBSITE_OWNER）
    private LocalDateTime createdTime;  // 创建时间
}
