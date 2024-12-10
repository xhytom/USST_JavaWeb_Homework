<template>
    <h3>{{ user1.name }}</h3>
    <p> {{ user1Content }} </p>
    <p>{{ user1Content1() }}</p>
</template>  

<script>

export default {
    data() {
        return {
            user1: {
                name:"张三",
                content:["A", "B", "C"]
            }
        }
    },
    computed:{
        user1Content() {
            return this.user1.content.length > 0 ? "Yes" : "No"
        }
    },
    methods: {
        user1Content1() {
            return this.user1.content.length > 0 ? "Yes" : "No"
        }
    }
}

</script>