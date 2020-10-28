import Vue from 'vue'
import VueRouter from 'vue-router'
import Principal from '../views/Principal.vue'
import Produtos from '../views/Produtos.vue'
import CadUser from '../components/CadUser.vue'
import Clientes from '../components/Clientes.vue'
import Login from '../components/Login.vue'
import LoginFunc from '../components/LoginFunc.vue'
import AddCarrinho from '../components/AddCarrinho.vue'
import Furnitures from '../components/Furnitures.vue'
import Stock from '../components/Stock.vue'
import UpdateCliente from '../components/UpdateCliente.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Principal',
    component: Principal
  },
  {
    path: '/produtos',
    name: 'Produtos',
    component: Produtos
  },
  {
    path: '/carrinho',
    name: 'AddCarrinho',
    component: AddCarrinho
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/loginFunc',
    name: 'LoginFunc',
    component: LoginFunc
  },
  {
    path: '/cadastrarUsuario',
    name: 'CadUser',
    component: CadUser
  },
  {
    path: '/clientes',
    name: 'Clientes',
    component: Clientes
  },
  {
    path: '/furnitures',
    name: 'Furnitures',
    component: Furnitures
  },
  {
    path: '/stock',
    name: 'Stock',
    component: Stock
  },
  {
    path: '/updateCliente',
    name: 'UpdateCliente',
    component: UpdateCliente
  },
  {
    path: '*', redirect: '/' }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
