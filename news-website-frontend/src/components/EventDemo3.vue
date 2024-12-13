<template>
    <h3>内联事件处理器</h3>
    <button @click="addCount">Add</button>
    <p> {{ count }} </p> 
</template>

<script>

export default {
    data() {
        return {
            count: 0
        }
    },

    methods: {
        addCount(e) {
            this.count++
            console.log(e.target.innerHTML = "Add" + this.count)
        }
    }
}
</script>