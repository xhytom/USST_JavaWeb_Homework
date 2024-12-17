<template>
    <div class="not-found">
      <h1>404 - 页面未找到</h1>
      <p>抱歉，您访问的页面不存在。</p>
      <router-link to="/">
        <button>返回首页</button>
      </router-link>
    </div>
  </template>
  
  <script>
  export default {
    name: 'NotFoundPage'
  };
  </script>
  
  <style scoped>
  .not-found {
    text-align: center;
    margin-top: 50px;
  }
  </style>
  