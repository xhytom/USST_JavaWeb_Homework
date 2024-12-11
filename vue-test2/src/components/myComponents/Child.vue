<template>
    <h3>Child</h3>
    <p>{{ title }}</p>
    <p>{{ age }}</p>

    <ul>
        <li v-for="(name,index) in names" :key="index">{{ name }}</li>
    </ul>

    <p>{{ userInfo.name }}{{ userInfo.age }}</p>
</template>

<script>

export default {

    data() {
        return {
            
        }
    }, 
    props:['title', 'age', "names", 'userInfo']
}

</script>

<style>

</style>