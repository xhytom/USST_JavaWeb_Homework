<template>
    <div class="advertiser">
      <h1>广告主管理页面</h1>
      <p>在这里你可以管理广告投放、查看广告效果、收益等。</p>
  
      <div class="ads-list">
        <h3>我的广告</h3>
        <!-- 假设有一个广告列表 -->
        <ul>
          <li v-for="ad in ads" :key="ad.id">
            <div>
              <img :src="ad.image" alt="广告图片" width="100">
              <h4>{{ ad.title }}</h4>
              <p>{{ ad.description }}</p>
              <a :href="ad.url" target="_blank">查看广告</a>
            </div>
          </li>
        </ul>
      </div>
  
      <button @click="addNewAd">添加新广告</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AdvertiserPage',
    data() {
      return {
        ads: [
          { id: 1, title: '广告1', description: '这是广告1', image: '/images/ad1.jpg', url: 'http://www.example.com' },
          { id: 2, title: '广告2', description: '这是广告2', image: '/images/ad2.jpg', url: 'http://www.example2.com' }
        ]
      };
    },
    methods: {
      addNewAd() {
        this.$router.push('/new-ad');
      }
    }
  };
  </script>
  
  <style scoped>
  .advertiser {
    text-align: center;
    margin-top: 20px;
  }
  
  .ads-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  
  .ads-list ul {
    list-style-type: none;
    padding: 0;
  }
  
  .ads-list li {
    margin: 10px;
    border: 1px solid #ddd;
    padding: 10px;
    max-width: 200px;
  }
  </style>
  