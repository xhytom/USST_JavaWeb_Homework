package org.example.backend.controller;

import org.example.backend.entity.Ad;
import org.example.backend.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AdController控制器类，处理广告相关的HTTP请求
 */
@RestController  // 标注该类为REST风格的控制器
@RequestMapping("/api/ads")  // 定义请求路径为/api/ads
public class AdController {

    @Autowired
    private AdService adService;  // 自动注入AdService

    /**
     * 获取所有广告
     * @return 广告列表
     */
    @GetMapping  // 处理GET请求
    public List<Ad> getAllAds() {
        return adService.listAds();  // 调用service层获取所有广告
    }

    /**
     * 添加广告
     * @param ad 广告对象
     * @return 操作结果
     */
    @PostMapping  // 处理POST请求
    public String addAd(@RequestBody Ad ad) {
        adService.saveAd(ad);  // 调用service层保存广告
        return "广告添加成功";
    }

    /**
     * 更新广告
     * @param id 广告ID
     * @param ad 更新的广告对象
     * @return 操作结果
     */
    @PutMapping("/{id}")  // 处理PUT请求
    public String updateAd(@PathVariable Long id, @RequestBody Ad ad) {
        ad.setId(id);  // 设置广告的ID
        adService.saveAd(ad);  // 调用service层更新广告
        return "广告更新成功";
    }

    /**
     * 删除广告
     * @param id 广告ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")  // 处理DELETE请求
    public String deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);  // 调用service层删除广告
        return "广告删除成功";
    }
}
