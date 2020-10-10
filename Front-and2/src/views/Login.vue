<template>
  <div class="login">
    <h1>Hi lorena</h1>
    <h3>Operações com os clientes:</h3><br /><br />
    <button @click="fetchUsers">Listar todos os clientes cadastrados</button><br /><br />
    <button @click="postUser">Inserir clientes</button><br /><br />
    
    <p>{{ user }}</p><br /><br />
    <ul>
      <li v-for="user in users" :key="user.id">
        <h4>{{ user.id }}</h4>
        <p>{{ user.name }}</p>
        <p>{{ user.email }}</p>
        <p>{{ user.login }}</p>
        <p>{{ user.telefone }}</p>
        <p>{{ user.password }}</p>
        <p>{{ user.confirmeSenha }}</p>
        <p>{{ user.complemento }}</p>
      </li>
    </ul>
  </div>
  
</template>
