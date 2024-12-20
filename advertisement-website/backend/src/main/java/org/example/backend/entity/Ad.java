package org.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 广告实体类，用于映射广告表的字段
 */
@Data  // 自动生成getter和setter方法
@TableName("ads")  // 映射到数据库中的ads表
public class Ad {
    @TableId
    private Long id;  // 广告ID，主键
    private String title;  // 广告标题
    private String description;  // 广告描述
    private String imageUrl;  // 广告图片URL
    private String linkUrl;  // 广告链接URL
    private String category;  // 广告类别
    private String keywords;  // 广告关键词
    private LocalDateTime startTime;  // 广告开始时间
    private LocalDateTime endTime;  // 广告结束时间
    private Integer clickCount;  // 点击次数
    private Integer impressionCount;  // 展示次数
    private Integer conversionCount;  // 转化次数
    private Double revenue;  // 广告收益
    private LocalDateTime createdTime;  // 创建时间
}
