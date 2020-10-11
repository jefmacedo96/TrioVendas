<template>
  <div class="login">
 <div id="container">
        <header class="page-header">
            <div class="top-bar-container">
                <a href="/">
                    <img src="/../assets/back.svg" alt="Voltar">
                </a>
                <img src="/../assets/logo.png" alt="Teixeira Móveis">
            </div>

            <div class="header-content">
                <strong>Esses são os nossos clientes cadastrados</strong>
                <p>Somente funcionários tem acesso a essas informações</p>
            </div>
        </header>
        <main>
          
            
            <fieldset>
                <legend>Clientes cadastrados</legend>
              
                <button @click="fetchUsers"><h3>Listar todos os clientes cadastrados</h3></button><br /><br />
                <p>{{ user }}</p><br /><br />
                
                <ul>
                <li v-for="user in users" :key="user.id">
                  <p>Nome: {{ user.name }}</p>
                  <p>Email: {{ user.email }}</p>
                  <p>CPF: {{ user.cpf }}</p>
                  <p>Telefone: {{ user.telefone }}</p>
                  <p>Senha: {{ user.senha }}</p>
                  <p>Endereço: {{ user.estado }}, {{ user.cidade }}, {{ user.complemento }}</p><br><br>
                </li>
              </ul>

            </fieldset>
        </main>
        
  </div>
  </div>
  
</template>

<script>
export default {
  name: "Users",
  data() {
    return {
      id: 0,
      login: "",
      senha: "",
      name: "",
      email: "",
      telefone: "",
      estado: "",
      cidade: "",
      complemento: "",
      confirmeSenha: "",
      user: {},
      users: [],
      baseURI: "http://localhost:8080/projeto1/api/users",
    };
  },

methods: {
    fetchUsers: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.users = result.data;
      });
    },
}
}
</script>

<style>
p{
    font-size: 1.9rem;
    color: var(--color-text-complement);
    }

 button {
    width: 100%;
    height: 5.6rem;
    background: var(--color-secondary);
    color: white;
    border: 0;
    border-radius: .8rem;
    cursor: pointer;
    font: 700 1.6rem Archivo;

    display: flex;
    align-items: center;
    justify-content: center;
    text-decoration: none;

    transition: 0.2s;
    margin-top: 3.2rem;  
}

button:hover {
    background: var(--color-secondary-dark);
}

h3{
  color:white
}
</style>