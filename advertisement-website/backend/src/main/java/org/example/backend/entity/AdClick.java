package org.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * AdClick实体类，用于映射广告点击数据表
 */
@Data
@TableName("ad_clicks")  // 映射到数据库中的ad_clicks表
public class AdClick {

    @TableId
    private Long id;  // 主键ID
    private Long adId;  // 广告ID，外键关联广告表
    private String userIp;  // 用户IP，用于记录点击的用户信息
    private String timestamp;  // 点击时间戳
}
