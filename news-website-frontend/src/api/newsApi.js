// api/newsApi.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/news';

// 获取新闻分类
export const getNewsCategories = () => {
  return axios.get(`${API_BASE_URL}/categories`);
};

// 根据类别获取新闻
export const getNewsByCategory = (categoryId) => {
  return axios.get(`${API_BASE_URL}/category/${categoryId}`);
};

// api/newsApi.js

// 根据关键词搜索新闻
export const searchNewsByKeyword = (keyword) => {
    return axios.get(`http://localhost:8080/api/news/search`, {
      params: { query: keyword }
    });
  };
  