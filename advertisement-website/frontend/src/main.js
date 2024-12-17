import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // 引入刚刚创建的路由配置

const app = createApp(App);

// 使用路由
app.use(router);

app.mount('#app');
