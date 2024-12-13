<template>
    <h3> 列表渲染 </h3>
    <p v-for = "name in names">{{ name }} </p>

    <div v-for="(item, index) in results">
        <p>{{ index }}</p>
        <div v-for="value in item"> {{value}}</div>
    </div>

</template>

<script>

export default {
    data() {
        return {
            names: ["张三", "李四", "王五"],
            results: [
                {
                    "id": 1,
                    "name": "张三",
                    "age": "1"
                }, {
                    "id": 2,
                    "name": "李四",
                    "age": "2"
                }, {
                    "id": 3,
                    "name": "王五",
                    "age": "3"
                },
            ]
        }
    }
}

</script>