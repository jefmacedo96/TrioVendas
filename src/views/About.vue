<template>
  <div class="about">
    <h1>{{name}} - {{id}}</h1>
    <h1>{{$route.params}}</h1>
    <h1>{{$route.params.name}}</h1>
    <h1>{{$route.query}}</h1>
    <h1>{{$route.query.cpf}}</h1>
  </div>
</template>

<script>
 export default {
 name: "About",
 props: ["name","id"],
 }
</script>