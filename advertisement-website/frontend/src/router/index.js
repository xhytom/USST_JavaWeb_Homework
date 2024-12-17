import { createRouter, createWebHistory } from 'vue-router';

// 引入页面组件
import HomePage from '../views/HomePage.vue';
import AdvertiserPage from '../views/AdvertiserPage.vue';
import WebsiteOwnerPage from '../views/WebsiteOwnerPage.vue';
import AdminPage from '../views/AdminPage.vue';
import LoginPage from '../views/LoginPage.vue';
import NotFoundPage from '../views/NotFoundPage.vue';

// 创建路由配置
const routes = [
  {
    path: '/',
    name: 'HomePage',
    component: HomePage,
  },
  {
    path: '/advertiser',
    name: 'AdvertiserPage',
    component: AdvertiserPage,
    meta: { requiresAuth: true, role: 'advertiser' },  // 需要认证和广告主角色
  },
  {
    path: '/website-owner',
    name: 'WebsiteOwnerPage',
    component: WebsiteOwnerPage,
    meta: { requiresAuth: true, role: 'website-owner' },  // 需要认证和网站长角色
  },
  {
    path: '/admin',
    name: 'AdminPage',
    component: AdminPage,
    meta: { requiresAuth: true, role: 'admin' },  // 需要认证和管理员角色
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage,  // 登录页面
  },
  {
    path: '/:catchAll(.*)',  // 处理 404 页面
    name: 'NotFoundPage',
    component: NotFoundPage,
  }
];

// 创建路由器实例
const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 路由守卫：检查是否需要登录，以及权限角色
router.beforeEach((to, from, next) => {
  const user = JSON.parse(localStorage.getItem('user')); // 假设用户信息存储在 localStorage
  const isAuthenticated = user && user.token;
  const userRole = user ? user.role : null;

  if (to.meta.requiresAuth && !isAuthenticated) {
    // 如果页面需要登录且未登录，跳转到登录页
    next({ name: 'LoginPage' });
  } else if (to.meta.role && to.meta.role !== userRole) {
    // 如果角色不匹配，跳转到首页或者其他错误页面
    next({ name: 'NotFoundPage' });
  } else {
    // 其他情况，正常访问
    next();
  }
});

export default router;
