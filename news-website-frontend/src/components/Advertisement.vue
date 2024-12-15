<template>
    <div id="base">
        <img id="pic" src="/public/images/advertisement.png" alt="image">
        <p id="advertisementText">广告位招租</p>
    </div>
</template>

<script>

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
</style>