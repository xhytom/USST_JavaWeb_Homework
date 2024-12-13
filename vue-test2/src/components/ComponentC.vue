<template>
    <input type="text" v-model="textBox1">
    <p> {{ msg }}</p>
</template>

<script>

import ComponentD from './ComponentD.vue';
    export default {
        data() {
            return {
                msg: "",
                textBox1: "",
            }
        },
        watch: {
            textBox1(newValue, oldValue) {
                this.msg = newValue;
            }
        },
        components: {
            ComponentD,
        },
        methods: {
            getDData(data) {
                this.msg = data
            }
        }
    }

</script>

<style>

</style>