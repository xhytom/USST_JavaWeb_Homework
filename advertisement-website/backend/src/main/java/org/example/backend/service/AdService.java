package org.example.backend.service;

import org.example.backend.entity.Ad;

import java.util.List;

/**
 * AdService接口，定义了广告相关的业务逻辑
 */
public interface AdService {
    // 获取所有广告
    List<Ad> listAds();

    // 保存广告
    void saveAd(Ad ad);

    // 删除广告
    void deleteAd(Long id);
}
