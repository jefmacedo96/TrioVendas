import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/users/:name/post/:email/',
    name: 'Users',
    props: true,
    
    component: () => import( '../views/Users.vue')
  },
  {
    path: '/login',
    name: 'Login',
    props: true,
    
    component: () => import( '../views/Clientes.vue')
  },
  {
    path: '/furnitures',
    name: 'Furnitures',
    props: true,
    
    component: () => import( '../views/Furnitures.vue')
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
