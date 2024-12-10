<template>
    <h3> 条件渲染 </h3>
    <div v-if="flag"> 你能看见我吗</div>
    <div v-else> 你不能看见我</div>
</template>

<script>

export default {
    data() {
        return {
            flag: false
        }
    }
}

</script>