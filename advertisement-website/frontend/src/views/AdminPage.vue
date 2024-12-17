<template>
    <div class="admin">
      <h1>管理员管理页面</h1>
      <p>在这里你可以管理所有广告、用户等。</p>
  
      <div class="admin-actions">
        <button @click="manageAds">管理广告</button>
        <button @click="manageUsers">管理用户</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AdminPage',
    methods: {
      manageAds() {
        this.$router.push('/admin/manage-ads');
      },
      manageUsers() {
        this.$router.push('/admin/manage-users');
      }
    }
  };
  </script>
  
  <style scoped>
  .admin {
    text-align: center;
    margin-top: 20px;
  }
  
  .admin-actions button {
    margin: 10px;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
  
  .admin-actions button:hover {
    background-color: #45a049;
  }
  </style>
  