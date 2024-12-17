<template>
    <div class="home">
      <h1>欢迎来到广告投放与管理系统</h1>
      <p>这是首页，您可以选择登录后进行广告管理。</p>
      <router-link to="/login">
        <button class="login-button">登录</button>
      </router-link>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HomePage'
  };
  </script>
  
  <style scoped>
  .home {
    text-align: center;
    margin-top: 50px;
  }
  .login-button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    font-size: 16px;
  }
  </style>
  