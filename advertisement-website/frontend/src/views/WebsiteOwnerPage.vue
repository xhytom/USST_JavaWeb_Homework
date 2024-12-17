<template>
    <div class="website-owner">
      <h1>网站长管理页面</h1>
      <p>在这里你可以查看广告效果，获取广告投放的 API。</p>
  
      <div class="ad-stats">
        <h3>广告投放统计</h3>
        <!-- 假设有一个广告统计的展示 -->
        <ul>
          <li v-for="ad in ads" :key="ad.id">
            <h4>{{ ad.title }}</h4>
            <p>点击数: {{ ad.clicks }} 次</p>
            <p>展示数: {{ ad.impressions }} 次</p>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'WebsiteOwnerPage',
    data() {
      return {
        ads: [
          { id: 1, title: '广告1', clicks: 200, impressions: 1500 },
          { id: 2, title: '广告2', clicks: 300, impressions: 2500 }
        ]
      };
    }
  };
  </script>
  
  <style scoped>
  .website-owner {
    text-align: center;
    margin-top: 20px;
  }
  
  .ad-stats {
    padding: 10px;
  }
  
  .ad-stats ul {
    list-style-type: none;
    padding: 0;
  }
  
  .ad-stats li {
    margin: 10px 0;
    border: 1px solid #ddd;
    padding: 10px;
  }
  </style>
  