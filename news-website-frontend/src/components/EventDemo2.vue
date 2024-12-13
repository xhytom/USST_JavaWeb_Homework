<template>
    <h3>内联事件处理器</h3>
    <button @dblclick="addCount">Add</button>
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
        addCount() {
            this.count++
        }
    }
}
</script>