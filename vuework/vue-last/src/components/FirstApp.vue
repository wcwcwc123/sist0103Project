<template>
    <div>
        <h2>반응형 메세지</h2>
        <h3>{{ reactiveMessage }}</h3>
        <h2>일반메시지</h2>
        <h3>{{ normalMessage }}</h3>
    </div>
</template>

<script>
import { ref } from 'vue';
export default {
    setup () {

        const reactiveMessage = ref("Hello REACTIVE");

        const normalMessage = 'Normal Message';
        

        return {
            reactiveMessage,
            normalMessage
        }
    }
}
</script>

<style lang="scss" scoped>

</style>