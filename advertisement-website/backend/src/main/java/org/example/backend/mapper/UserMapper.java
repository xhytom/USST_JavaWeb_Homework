package org.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper接口，用于操作用户数据表
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);  // 根据用户名查找用户
}
