<template>
    <div class="news-search">
      <input
        v-model="searchQuery"
        @keyup.enter="onSearch"
        type="text"
        placeholder="请输入新闻标题或关键词..."
        class="search-input"
      />
      <button @click="onSearch" class="search-button">搜索</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        searchQuery: "", // 用户输入的搜索内容
      };
    },
    methods: {
      onSearch() {
        this.$emit("search", this.searchQuery); // 触发搜索事件并传递搜索内容
      },
    },
  };
  </script>
  
  <style scoped>
  .news-search {
    display: flex;
    justify-content: center;
    margin: 20px;
  }
  
  .search-input {
    padding: 10px;
    font-size: 16px;
    width: 300px;
  }
  
  .search-button {
    padding: 10px 20px;
    font-size: 16px;
    margin-left: 10px;
    cursor: pointer;
  }
  </style>
  