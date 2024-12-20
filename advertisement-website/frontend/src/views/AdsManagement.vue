<template>
    <div>
      <h1>广告管理</h1>
      <button @click="fetchAds">获取广告列表</button>
      <ul>
        <li v-for="ad in ads" :key="ad.id">
          {{ ad.title }} - 点击: {{ ad.clickCount }}
          <button @click="deleteAd(ad.id)">删除</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        ads: []
      };
    },
    methods: {
      async fetchAds() {
        try {
          const response = await axios.get('/ads');  // 获取广告列表
          this.ads = response;
        } catch (error) {
          console.error('获取广告列表失败:', error);
        }
      },
      async deleteAd(id) {
        try {
          await axios.delete(`/ads/${id}`);  // 删除广告
          this.fetchAds();  // 刷新广告列表
        } catch (error) {
          console.error('删除广告失败:', error);
        }
      }
    }
  };
  </script>
  