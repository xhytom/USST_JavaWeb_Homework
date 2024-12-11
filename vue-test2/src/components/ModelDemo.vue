<template>
    <h3>表单输入绑定</h3>
    <form>
        <input type="text" v-model.lazy="message">
        <p>{{ message }}</p>
        <input type="checkbox" id="checkbox1" v-model="checked">
        <p>{{ checked ? 'yes' : 'no' }}</p>
    </form> 

</template>

<script>

export default {
    data() {
        return {
            message:"",
            checked:1
        }
    }
}

</script>