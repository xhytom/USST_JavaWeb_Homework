<template>
  <div id="app">
    <!-- 顶部导航栏 -->
    <header>
      <nav class="navbar">
        <div class="logo">在线新闻网站</div>
        <ul class="nav-links">
          <li><router-link to="/">首页</router-link></li>
          <!-- <li><router-link to="/category">分类浏览</router-link></li>
          <li><router-link to="/search">搜索新闻</router-link></li> -->
        </ul>
      </nav>
    </header>

    <!-- 主体内容 -->
    <main>
      <!-- 路由出口 -->
      <router-view />
    </main>

    <!-- 底部信息 -->
    <footer>
      <p>&copy; 2024 在线新闻网站 | 技术支持: Vue 3 + Axios</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style scoped>
/* 样式部分 */

/* 全局样式 */
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background-color: #f9f9f9;
  color: #333;
}

/* 顶部导航栏样式 */
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #0078d4;
  color: #fff;
  padding: 1rem 2rem;
}

.logo {
  font-size: 1.5rem;
  font-weight: bold;
}

.nav-links {
  list-style: none;
  display: flex;
  gap: 1rem;
  margin: 0;
  padding: 0;
}

.nav-links li {
  display: inline;
}

.nav-links a {
  color: #fff;
  text-decoration: none;
  font-weight: bold;
}

.nav-links a:hover {
  text-decoration: underline;
}

/* 主体内容样式 */
main {
  padding: 2rem;
}

/* 底部样式 */
footer {
  background-color: #333;
  color: #fff;
  text-align: center;
  padding: 1rem;
  position: relative;
  bottom: 0;
  width: 100%;
}
</style>
