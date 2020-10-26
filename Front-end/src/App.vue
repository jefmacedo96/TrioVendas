<template>
  <div id="app">
    <div id="nav"></div>
    <router-view/>
  </div>
</template>

<script>
//import Users from './views/Users.vue'
//import About from './views/About.vue'
import Principal from './views/Principal.vue';
import Produtos from './views/Produtos.vue';

import CadUser from '@/components/CadUser.vue';
import Clientes from '@/components/Clientes.vue';
import Login from '@/components/Login.vue';
import LoginFunc from '@/components/LoginFunc.vue'
import AddCarrinho from '@/components/AddCarrinho.vue'

export default {
  name: "App",
  components:{
    Principal,
    CadUser,
    Clientes,
    Login,
    LoginFunc,
    Produtos,
    AddCarrinho
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
