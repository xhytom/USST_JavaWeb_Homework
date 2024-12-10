<template>
    <h3>事件传参</h3>
    <p @click="getNameHandler(item, $event)" v-for="(item, index) in names" :key="index">{{ item   }}</p>
</template>

<script>

export default {
    data() {
        return {
            names:["A", "B", "C"]
        }
    },

    methods: {
        getNameHandler(msg, item) {
            console.log(msg)
            console.log(item.target.innerHTML);
            
        }
    }
}
</script>