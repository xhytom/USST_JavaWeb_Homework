<template>
    <div id="base">
        <!-- <img id="pic" src="/public/images/advertisement.png" alt="image">
        <p :id="advertisementText">广告位招租</p> -->
        <div v-if="ad">
            <h2 class="adTitle">{{ ad.title }}</h2>
            <!-- 显示广告图片 -->
            <img id="pic" :src="ad.imageUrl" alt="广告图片" />
            <p class="adDesc">{{ ad.description }}</p>
        </div>
        <div v-else>
            <p>加载广告...</p>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';

export default {
  data() {
    return {
      ad: null,  // 存储广告数据
    };
  },
  mounted() {
    // 请求广告数据
    axios.get('http://localhost:8080/api/advertisement/getAdvertisement')
      .then((response) => {
        this.ad = response.data;  // 设置广告数据
      })
      .catch((error) => {
        console.error("加载广告失败", error);
      });
  },
};
</script>

<style>
#pic {
    width: 100%;  /* 图片宽度为容器 A 宽度的 100% */
    height: auto; 
}
#base {
    width: 500px;  /* 容器 A 宽度 500px */
    height: 300px; /* 容器 A 高度 300px */
    border: 1px solid #ccc;  /* 可选，方便查看容器 */
    align-items: center;
    display: flex;
    justify-content: center;
}
#advertisementText {
    text-align: center;
    color: blue;
    font-size:30px;
}
.adTitle {
    text-align: center;
    color: red;
    font-size:30px;
}

.adDesc {
    text-align: center;
    color: blue;
    font-size:30px;
}
</style>