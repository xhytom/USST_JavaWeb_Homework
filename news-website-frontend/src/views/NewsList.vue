<template>
  <div>
    <div id="headerTitle">
      <h1>新闻列表</h1>
      <NewsSearch @search="handleSearch" />
    </div>
    <div id="bodyContainer">
      <Advertisement id="advertisement1">advertisement1</Advertisement>
      <div id="mainNews">
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
          
          <!-- 分页控件 -->
          <div id="pageSelector">
            <a-pagination
              v-model:current="currentPage"
              :total="totalNews"
              :pageSize="pageSize"
              show-quick-jumper
              @change="handlePageChange"
            />
          </div>
        </div>
        
        <div v-else>
          <p>暂无新闻</p>
        </div>
      </div>
      <Advertisement id="advertisement2">advertisement2</Advertisement>
    </div>
  </div>
</template>

<script>
import NewsSearch from '@/components/NewsSearch.vue';
import axios from 'axios';
import Advertisement from '../components/Advertisement.vue'

export default {
  components: {
    NewsSearch,
    Advertisement,
  },
  data() {
    return {
      news: [],           // 存储新闻数据
      totalNews: 0,       // 总新闻数量
      currentPage: 1,     // 当前页数
      pageSize: 5,       // 每页显示的新闻数量
      query: "",
    };
  },
  methods: {
    // 搜索新闻
    async handleSearch(query) {
      try {
        const response = await axios.get('http://localhost:8080/api/news/search', {
          params: {
            query,             // 搜索关键词
            currentPage: this.currentPage,
            pageSize: this.pageSize // 每页显示的新闻条数
          }
        });

        // 检查返回数据的结构是否正确
        if (response.data && Array.isArray(response.data.content)) {
          this.news = response.data.content;
          this.totalNews = response.data.totalElements;
          this.totalPages = response.data.totalPages;
          this.currentPage = response.data.currentPage;
          this.pageSize = response.data.pageSize;
        } else {
          this.news = [];
        }
      } catch (error) {
        console.error('搜索失败:', error.response ? error.response.data : error.message);
        this.news = [];
      }
    }

    ,

    // 处理分页变化
    handlePageChange(page) {
      this.currentPage = page;
      this.handleSearch(''); // 搜索时会根据当前页数重新加载数据
    },
  },
  created() {
    // 初始加载所有新闻
    this.currentPage = 1;
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
#pageSelector {
  display: flex;
  justify-content: center;
}
#mainNews {
  /* display: flex; */
  /* justify-content: center; */
  width: 60%;
}

#bodyContainer {
  display: flex;
  justify-content: center;
  gap: 20px;
}

#headerTitle {
  display: flex; /* 使子元素水平排列 */
  justify-content: center; /* 默认情况下将子元素排列到容器的左侧 */
}
</style>


