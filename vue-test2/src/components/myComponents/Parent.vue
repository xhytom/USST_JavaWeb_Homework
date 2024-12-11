<template>
    <h3>Parent</h3>
    <input type="text" v-model="message">
    <Child :title="message" :age="age" :names="names" :userInfo="userInfo"/>
</template>

<script>

import Child from './Child.vue';

export default {

    components: {
        Child,
    },
    data() {
        return {
            message: "Parent数据!",
            age: 20,
            names:["A", "B", "C"],

            userInfo: {
                name: "A",
                age: 20,

            }
        }
    }
}

</script>

<style>

</style>