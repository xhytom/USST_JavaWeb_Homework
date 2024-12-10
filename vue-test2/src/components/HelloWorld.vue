<template>
  <div :id = "msg_id">{{ msg }}</div>
  <button :disabled = "isButtonDisabled"> button</button>
  <div v-bind="obj_1">123</div>
</template>

<script>

export default {
  data() {
    return {
      msg: "Hello, world!",
      msg_id: "msg001",
      isButtonDisabled:false,
      obj_1: {
        id: "msg001"
      }
    }
  }
}

</script>

<style>

#msg001 {
  color: red;
  font-size: 30px;
}

#msg002 {
  color: red;
  font-size: 30px;
}

</style>