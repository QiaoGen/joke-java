<template>
    <h2 class="title">{{ name }}</h2>
</template>

<script>
export default {
    name:'App',
    data(){
        return{
            name:'组件中的张三'
        }
    }
}
</script>

<style scoped>
    .title{
        color:green
    }
</style>

// 加载Vue vue-loader vue-templete-compiler 