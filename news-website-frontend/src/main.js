import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import axios from 'axios';
import Antd from 'ant-design-vue'; // 引入 Ant Design Vue
// import 'ant-design-vue/es/style/index.css'; // 推荐的路径


const app = createApp(App);
app.config.globalProperties.$axios = axios; // 全局配置 axios
app.use(router);
app.use(Antd); // 注册 Ant Design Vue 组件库
app.mount('#app');
