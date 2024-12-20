<template>
    <div>
      <h1>用户管理</h1>
      <button @click="fetchUsers">获取用户列表</button>
      <ul>
        <li v-for="user in users" :key="user.id">
          {{ user.username }} - 角色: {{ user.role }}
          <button @click="deleteUser(user.id)">删除</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        users: []
      };
    },
    methods: {
      async fetchUsers() {
        try {
          const response = await axios.get('/users');  // 获取用户列表
          this.users = response;
        } catch (error) {
          console.error('获取用户列表失败:', error);
        }
      },
      async deleteUser(id) {
        try {
          await axios.delete(`/users/${id}`);  // 删除用户
          this.fetchUsers();  // 刷新用户列表
        } catch (error) {
          console.error('删除用户失败:', error);
        }
      }
    }
  };
  </script>
  