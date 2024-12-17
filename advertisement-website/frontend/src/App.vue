<template>
  <div id="app">
    <header>
      <h1 id="webName">广告投放与管理系统</h1>
      <nav>
        <router-link to="/" class="nav-link">首页</router-link>
        <router-link to="/login" class="nav-link">登录</router-link>
        <router-link to="/advertiser" class="nav-link">广告主</router-link>
        <router-link to="/website-owner" class="nav-link">网站长</router-link>
        <router-link to="/admin" class="nav-link">管理员</router-link>
      </nav>
    </header>

    <main>
      <!-- 路由视图，显示不同的页面组件 -->
      <router-view></router-view>
    </main>

    <footer>
      <p>© 2024 广告投放与管理系统 | 版权所有</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style scoped>
/* 全局样式 */
#app {
  font-family: 'Arial', sans-serif;
  text-align: center;
}

header {
  background-color: #4CAF50;
  padding: 20px;
  color: white;
  display: flex;
}

nav {
  margin-top: 10px;
  display: flex;
  align-items: center
}

.nav-link {
  margin: 0 10px;
  color: white;
  text-decoration: none;
}

.nav-link:hover {
  text-decoration: underline;
}

footer {
  background-color: #f1f1f1;
  padding: 10px;
  margin-top: 50px;
}

#webName {
  margin-right: 100px;
}
</style>
