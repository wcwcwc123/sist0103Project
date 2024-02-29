<template>
    <div>
        <h1 class="alert">second app</h1>

        <h2>{{ num }}</h2>
        <button @click="countIncre">증가</button>

        <h2>{{ message }}</h2>
        <button @click="msgIncre">메세지 증가</button>
    </div>
</template>

<script>
import { ref } from 'vue';

export default {
    setup () {

        const num = ref(0);
        const countIncre = ()=>{
            num.value++;
        }

        const message = ref("안녕 뷰 재밌냐?");

        const msgIncre = ()=>{
            message.value = message.value+"?";

        }

        

        return {
            num,
            countIncre,
            message,
            msgIncre
        }
    }
}
</script>

<style lang="scss" scoped>

</style>