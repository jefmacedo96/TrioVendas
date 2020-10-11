<template>
  <div class="home">
    
    <Principal msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Principal from '@/components/Principal.vue'

export default {
  name: 'Home',
  components: {
    Principal
  }
}
</script>
