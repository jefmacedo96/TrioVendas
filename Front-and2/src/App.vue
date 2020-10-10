<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
//import Users from './views/Users.vue'
//import About from './views/About.vue'

export default {
  name: "App",
  components:{
    //About,
    //Users
  },
  /*methods: {
    clique() {
    this.$router.push({ name: "Users", params: { name: "Maria",id:"15" }
    }).catch(()=>{});
    },
 }*/
}
</script>

<style>
</style>
