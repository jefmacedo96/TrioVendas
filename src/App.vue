<template>
<div id="app">
  <p>porraaaaaa</p>
 <!-- <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
  </div>
  <router-view/>-->
   <CustomerRegistration></CustomerRegistration>
</div> 
</template>

<script>
import CustomerRegistration from './components/CustomerRegistration.vue'

export default {
  name: "App",
  components:{
    CustomerRegistration
  },
  methods: {
    clique() {
    this.$router.push({ name: "About", params: { name: "Maria",id:"15" }
    }).catch(()=>{});
    },
 }
}
</script>
<style>

</style>
