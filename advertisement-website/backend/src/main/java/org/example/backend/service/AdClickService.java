package org.example.backend.service;

import java.util.Map;

/**
 * AdClickService接口，提供广告点击统计的业务逻辑
 */
public interface AdClickService {

    /**
     * 获取广告的点击统计数据（点击率、转化率等）
     * @param adId 广告ID
     * @return 统计数据
     */
    Map<String, Object> getAdStats(Long adId);
}
