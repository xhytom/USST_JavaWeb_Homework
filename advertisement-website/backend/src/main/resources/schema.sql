-- CREATE DATABASE usst_ads;  -- 创建广告数据库

USE usst_ads;  -- 选择刚创建的数据库

-- 创建广告表，存储广告的基本信息
CREATE TABLE ads (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,             -- 广告标题
    description TEXT,                        -- 广告描述
    image_url VARCHAR(255),                  -- 广告图片URL
    link_url VARCHAR(255),                   -- 广告链接URL
    category VARCHAR(50),                    -- 广告类别
    keywords VARCHAR(255),                   -- 广告关键词
    start_time TIMESTAMP,                    -- 广告开始时间
    end_time TIMESTAMP,                      -- 广告结束时间
    click_count INT DEFAULT 0,               -- 点击次数
    impression_count INT DEFAULT 0,          -- 展示次数
    conversion_count INT DEFAULT 0,          -- 转化次数
    revenue DECIMAL(10, 2) DEFAULT 0.00,     -- 广告收益
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 创建时间
);

-- 创建用户表，存储用户信息
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,     -- 用户名，唯一
    password VARCHAR(100) NOT NULL,          -- 密码
    role ENUM('ADVERTISER', 'ADMIN', 'WEBSITE_OWNER') NOT NULL,  -- 用户角色
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 创建时间
);

-- 创建广告活动表，存储广告投放活动信息
CREATE TABLE ad_campaigns (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ad_id BIGINT NOT NULL,                   -- 广告ID
    advertiser_id BIGINT NOT NULL,           -- 广告主ID
    start_time TIMESTAMP,                    -- 活动开始时间
    end_time TIMESTAMP,                      -- 活动结束时间
    daily_budget DECIMAL(10, 2) DEFAULT 0.00, -- 每日预算
    status ENUM('ACTIVE', 'PAUSED', 'ENDED') NOT NULL,  -- 活动状态
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 创建时间
);

-- 创建广告点击表，存储广告点击记录
CREATE TABLE ad_clicks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ad_id BIGINT NOT NULL,                   -- 广告ID
    user_id BIGINT,                          -- 用户ID
    click_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 点击时间
);

-- 创建广告展示表，存储广告展示记录
CREATE TABLE ad_impressions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ad_id BIGINT NOT NULL,                   -- 广告ID
    user_id BIGINT,                          -- 用户ID
    impression_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 展示时间
);
