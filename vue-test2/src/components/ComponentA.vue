<template>
    <h3>ComponentA</h3>
    <p>父元素:{{ message }}</p>
    <ComponentB title="111" :onEvent="dataFn"/>
    
</template>

<script>

import ComponentB from './ComponentB.vue';
export default {
    data() {
        return {
            message:""
        }
    },
    components: {
        ComponentB,
    },
    methods: {
        dataFn(data) {
            // console.log(data)
            this.message = data
        }
    }
}

</script>