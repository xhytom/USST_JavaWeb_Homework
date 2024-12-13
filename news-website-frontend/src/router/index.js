import { createRouter, createWebHistory } from 'vue-router';
import NewsList from '@/views/NewsList.vue';
import NewsDetail from'@/views/NewsDetail.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: NewsList,
  },
  {
    path: '/news/:id',
    name: 'NewsDetail',
    component: NewsDetail, // 新闻详情
    props: true, // 传递路由参数
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
