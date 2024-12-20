package org.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.backend.entity.Ad;
import org.example.backend.mapper.AdMapper;
import org.example.backend.service.AdService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdService实现类，提供广告业务逻辑的实现
 */
@Service  // 标注为Spring Service类，自动注入
public class AdServiceImpl extends ServiceImpl<AdMapper, Ad> implements AdService {

    /**
     * 获取所有广告
     * @return 返回广告列表
     */
    @Override
    public List<Ad> listAds() {
        return list();  // MyBatis-Plus提供的list()方法，自动查询所有广告
    }

    /**
     * 保存广告
     * @param ad 广告对象
     */
    @Override
    public void saveAd(Ad ad) {
        save(ad);  // MyBatis-Plus提供的save()方法，自动插入或更新广告
    }

    /**
     * 删除广告
     * @param id 广告ID
     */
    @Override
    public void deleteAd(Long id) {
        removeById(id);  // MyBatis-Plus提供的removeById()方法，删除指定ID的广告
    }
}
