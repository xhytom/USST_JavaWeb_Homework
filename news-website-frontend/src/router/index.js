import { createRouter, createWebHistory } from 'vue-router';
import NewsList from '@/views/NewsList.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: NewsList,
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
