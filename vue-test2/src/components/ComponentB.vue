<template>
    <h3>ComponentB</h3>
    <p>{{ onEvent('abc') }}</p>
    <!-- <p> {{ title }}</p> -->
    <!-- <p>{{ message }}</p> -->
</template>

<script>

export default {
    data() {
        return {
            title:"",
        }
    },
    props: {
        title:String,
        onEvent:Function
    }
}

</script>