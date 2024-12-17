<template>
    <div class="login">
      <h1>登录</h1>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="username">用户名</label>
          <input type="text" id="username" v-model="username" required />
        </div>
        <div class="form-group">
          <label for="password">密码</label>
          <input type="password" id="password" v-model="password" required />
        </div>
        <button type="submit">登录</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: 'LoginPage',
    data() {
      return {
        username: '',
        password: ''
      };
    },
    methods: {
      login() {
        // 在这里可以执行登录验证操作
        console.log('登录中...', this.username, this.password);
        // 假设登录成功
        localStorage.setItem('user', JSON.stringify({ username: this.username, role: 'advertiser' }));
        this.$router.push('/');
      }
    }
  };
  </script>
  
  <style scoped>
  .login {
    text-align: center;
    margin-top: 50px;
  }
  
  .form-group {
    margin: 10px;
  }
  
  input {
    padding: 10px;
    margin-top: 5px;
    width: 200px;
  }
  </style>
  