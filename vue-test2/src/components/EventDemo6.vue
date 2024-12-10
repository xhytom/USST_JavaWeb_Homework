<template>
    <h3>事件修饰符</h3>
    <a @click.prevent="clickHandle" href="https://www.baidu.com">百度</a>
    <div @click="clickDiv">
        <p @click="clickP">测试冒泡</p>
    </div>
</template>

<script>

export default {
    data() {
        return {
            names:["A", "B", "C"]
        }
    },

    methods: {
        clickHandle(e) {
            // e.preventDefault();
            console.log("点击");
            
        },

        clickDiv(e) {
            console.log("Div");
            
        },

        clickP(e) {
            // e.stopPropagation();
            console.log("P");
        }
    }
}
</script>