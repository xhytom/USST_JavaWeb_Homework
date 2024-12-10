<template>
    <p :style="{color:activeColor, fontSize:fontSize + 'px'}">Style绑定1</p>
    <p :style="styleObject">Style绑定2</p>
    <p :style="[styleObject, styleObject2]">Style绑定3</p>
</template>

<script>
export default {
    data() {
        return {
            activeColor: 'green',
            fontSize: 40,
            styleObject: {
                color: 'red',
                fontSize: '30px'
            },

            styleObject2: {
                fontStyle: 'italic'
            }
        }
    }
}

</script>

<style>
.text001 {
    font-style: italic;
}
</style>