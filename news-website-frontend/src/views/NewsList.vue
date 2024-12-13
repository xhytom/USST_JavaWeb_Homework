<template>
  <div>
    <h1>新闻列表</h1>
    <NewsSearch @search="handleSearch" />
    <div v-if="news.length">
      <ul>
        <li v-for="article in news" :key="article.id">
          <div>
            <h2 style="display: flex;">
              <!-- 使用 router-link 进行跳转 -->
              <router-link :to="'/news/' + article.id">{{ article.title }}</router-link>
              <p class="articleCategory">{{ article.category }}</p>
            </h2>
            <p>{{ article.description }}</p>
          </div>
          <hr>
        </li>
      </ul>
    </div>
    <div v-else>
      <p>暂无新闻</p>
    </div>
  </div>
</template>
  
<script>
  import NewsSearch from '@/components/NewsSearch.vue';
  import axios from 'axios';
  
  export default {
    components: {
      NewsSearch,
    },
    data() {
      return {
        news: [], // 存储新闻数据
      };
    },
    methods: {
      async handleSearch(query) {
        try {
          const response = await axios.get(`http://localhost:8080/api/news/search`, {
            params: { query },
          });
          this.news = response.data; // 更新新闻数据
        } catch (error) {
          console.error("搜索失败:", error);
        }
      },
    },
    created() {
      // 初始加载所有新闻
      this.handleSearch('');
    },
  };
</script>
  
<style scoped>
  ul {
    list-style-type: none;
  }
  
  li {
    margin-bottom: 20px;
  }
  
  h2 {
    font-size: 20px;
    font-weight: bold;
  }
  
  p {
    color: #666;
  }

.articleCategory {
  font-size: 16px;
  text-align: right;
}

</style>
  
