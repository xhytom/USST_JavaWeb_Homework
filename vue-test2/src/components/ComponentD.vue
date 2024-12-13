<template>
    <input type="text" v-model="textBox1">
</template>

<script>

export default {
    data() {
        return {

        }
    },
    watch: {
        textBox1(newValue, oldValue) {
            this.$emit("getDData", newValue)
        }
    }
}

</script>