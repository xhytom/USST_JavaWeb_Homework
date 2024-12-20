package org.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.backend.entity.Ad;
import org.apache.ibatis.annotations.Mapper;

/**
 * AdMapper接口，继承MyBatis-Plus的BaseMapper，提供CRUD操作
 */
@Mapper  // 标注为Mapper接口
public interface AdMapper extends BaseMapper<Ad> {
    // BaseMapper已提供了基本的CRUD方法，无需手动实现
}
