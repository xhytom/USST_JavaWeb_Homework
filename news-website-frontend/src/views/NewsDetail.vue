<template>
    <div v-if="article">
      <h1>{{ article.title }}</h1>
      <p><strong>类别：</strong>{{ article.category }}</p>
      <p><strong>描述：</strong>{{ article.description }}</p>
      <p><strong>内容：</strong>{{ article.content }}</p>
    </div>
    <div v-else>
      <p>加载中...</p>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        article: null,
      };
    },
    created() {
      this.fetchArticle();
    },
    methods: {
      async fetchArticle() {
        const { id } = this.$route.params; // 获取路由中的参数
        try {
          const response = await axios.get(`http://localhost:8080/api/news/${id}`); // 假设后端 API 返回单个新闻详情
          this.article = response.data;
        } catch (error) {
          console.error("加载新闻失败:", error);
        }
      },
    },
  };
  </script>
  