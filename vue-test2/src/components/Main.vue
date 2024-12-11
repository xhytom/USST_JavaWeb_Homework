<template>
    <h3>主页面：{{ searchMessage }}</h3>
    <SearchComponent @searchEvent="getSearch"/>
</template>

<script>
import SearchComponent from './SearchComponent.vue';

export default {
    data() {
        return {
            searchMessage: ""
        }
    },
    components: {
        SearchComponent,
    },
    methods: {
        getSearch(data) {
            this.searchMessage = data;
        }
    }
}

</script>