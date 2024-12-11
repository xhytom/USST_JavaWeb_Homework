<template>
    <h3>ComponentB</h3>
    <p>{{ title }}</p>
    <p>{{ age }}</p>
    <p v-for="(item,index) in names" :key="index">{{ item }}</p>
</template>


<script>

export default {
    data() {
        return {
            
        }
    },
    props:{
        title:{
            type:String, 
            required: true,
        },
        age: {
            type: Number,
            default: 0,
        },
        names: {
            type: Array,
            default: ["空"]
        }
    }
}

</script>