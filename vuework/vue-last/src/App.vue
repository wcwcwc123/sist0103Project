<template>
  <FirstApp></FirstApp>
  <SecondApp></SecondApp>
  <ThirdApp></ThirdApp>
</template>

<script>
import FirstApp from './components/FirstApp.vue';
import SecondApp from './components/SecondApp.vue';
import ThirdApp from './components/ThirdApp.vue';

export default {
  name: 'App',
  components: {
    FirstApp,
    SecondApp,
    ThirdApp
}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
