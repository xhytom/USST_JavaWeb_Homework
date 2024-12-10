<template>
    <h3> Key属性添加到v-for中</h3>
    <p v-for="(item) in names" :key="index">{{ item }}</p>
</template>

<script>

export default {
    data() {
        return {
            names: ["A", "B", "C"]
        }
    }
}

</script>
