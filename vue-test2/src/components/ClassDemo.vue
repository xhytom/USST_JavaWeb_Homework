<template>
    <p :class="classObject">Class样式绑定</p>
    <p :class="[classA, classB]">样式绑定2</p>
</template>

<script>



export default {
    data() {
        return {
            isActive: true,
            hasError: true,
            classObject: {
                'active': true,
                'text-danger': true
            },
            classA: "active",
            classB: "text-danger"
        }
    }

}
</script>   

<style>

.active {
    color: red;
    font-size: 30px;
}

.text-danger {
    font-style: italic;
}

</style>