package org.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.backend.entity.AdClick;
import org.apache.ibatis.annotations.Mapper;

/**
 * AdClicksMapper接口，用于操作广告点击表的数据
 */
@Mapper  // 标注为Mapper接口
public interface AdClicksMapper extends BaseMapper<AdClick> {
    // 这里可以扩展一些自定义的查询方法
    int countByAdId(Long adId);  // 根据广告ID查询点击次数
}
