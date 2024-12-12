import axios from 'axios';

// 获取新闻列表
export const getNewsList = (query = '') => {
  return axios.get(`http://localhost:8080/api/news/search`, {
    params: { query },
  });
};
