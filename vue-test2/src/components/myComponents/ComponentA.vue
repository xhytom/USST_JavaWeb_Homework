<template>
    <h3>ComponentA</h3>
    <ComponentB :title="title" :names="names"/>
</template>


<script>

import ComponentB from './ComponentB.vue';

export default {
    data() {
        return {
            title: 20,
            names: ['A', 'B', 'C']
        }
    },
    components: {
        ComponentB,
    }
}

</script>