<template>
    <h3> 侦听器 </h3>
    <p>{{ message }}</p>
    <button @click="updateHandle">修改</button>

    <Textarea>{{ inputMessage }}</Textarea>
</template>

<script>


export default {
    data() {
        return {
            message: "Hello",
            inputMessage: "请输入"
        }
    },
    methods: {
        updateHandle() {
            this.message = "World"
        }
    },
    watch: {
        message(newValue, oldValue) {
            console.log(oldValue);
            console.log(newValue);
        },
        inputMessage(newValue, oldValue) {
            console.log(newValue, oldValue);
            
        }
    }
}

</script>

