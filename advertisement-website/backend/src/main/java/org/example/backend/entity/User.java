package org.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户实体类，用于映射用户信息
 */
@Data
@TableName("users")  // 映射数据库中的 users 表
public class User {

    @TableId
    private Long id;  // 主键ID
    private String username;  // 用户名
    private String password;  // 密码
    private String email;  // 邮箱
    private String role;  // 用户角色
}
