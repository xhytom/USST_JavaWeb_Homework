<template>
    <div ref="container1" class="container1">{{ content }}</div>
    <input ref="username" type="text">
    <button @click="getElementHandle">button</button>
</template>

<script>

export default {
    data() {
        return {
            content:"内容"
        }
    },
    methods: {
        getElementHandle() {
            // innerHTML JS的原生属性
            console.log(this.$refs.container1.innerHTML = "111")
            console.log(this.$refs.username.value)
        }
    }
}
</script>