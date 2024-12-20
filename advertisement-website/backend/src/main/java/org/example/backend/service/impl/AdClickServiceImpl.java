package org.example.backend.service.impl;

import org.example.backend.service.AdClickService;
import org.example.backend.mapper.AdMapper;
import org.example.backend.mapper.AdClicksMapper;
import org.example.backend.entity.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * AdClickService实现类，提供广告点击统计的具体实现
 */
@Service
public class AdClickServiceImpl implements AdClickService {

    @Autowired
    private AdClicksMapper adClicksMapper;

    @Autowired
    private AdMapper adMapper;

    @Override
    public Map<String, Object> getAdStats(Long adId) {
        Ad ad = adMapper.selectById(adId);  // 获取广告基本信息
        int clickCount = adClicksMapper.countByAdId(adId);  // 获取广告的点击次数
        int impressionCount = ad.getImpressionCount();  // 获取广告展示次数

        Map<String, Object> stats = new HashMap<>();
        stats.put("clickRate", (double) clickCount / impressionCount);  // 计算点击率
        stats.put("conversionRate", ad.getConversionCount() / (double) clickCount);  // 计算转化率
        stats.put("revenue", ad.getRevenue());  // 返回广告收益
        return stats;
    }
}
