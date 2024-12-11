<template>
    <h3>Slots再续集</h3>
    <slot name="slot1" :msg="childMessage"></slot>
    <hr>
    <slot name="slot2" :demo="msg2"></slot>

</template>

<script>

export default {
    data() {
        return {
            childMessage:"子组件元素",
            msg2: "msg2"
        }   
    }
}

</script>