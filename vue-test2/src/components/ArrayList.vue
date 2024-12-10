<template>
    <h3> 数组变化侦听 </h3>
    <button @click="addListHandle"> 添加数据 </button>
    <ul>
        <li v-for="(item, index) in names" :key="index"> {{ item }} </li>
    </ul>

    <button @click="concatHandler">合并数组</button>
    <h3> 数组1</h3>
    <p v-for="(x,index) in nums1" :key="index"> {{ x }}</p>
    
    <h3> 数组2</h3>
    <p v-for="(x,index) in nums2" :key="index"> {{ x }}</p>

</template>

<script>

export default {
    data() {
        return {
            names:["A", "B", "C"],
            nums1:[1, 2, 3, 4, 5],
            nums2:[6, 7, 8, 9]
        }
    }, 
    methods: {
        addListHandle( ) {
            // this.names.push("D")
            this.names = this.names.concat(["D"])
            console.log(this.names);
            
        },
        concatHandler() {
            this.nums1 = this.nums1.concat(this.nums2)
        }
    }
}

</script>