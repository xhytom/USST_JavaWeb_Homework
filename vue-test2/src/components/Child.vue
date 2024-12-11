<template>
    <h3>子组件事件</h3>
    <button @click="clickEventHandle">传递数据</button>
</template>

<script>

export default {
    data() {
        return {

        }
    },
    methods: {
        clickEventHandle() {
            // console.log("hahaha");
            this.$emit("someEvent", "123")
        }
    },  
}

</script>