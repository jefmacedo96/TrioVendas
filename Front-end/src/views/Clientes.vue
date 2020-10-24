<template>
  <div class="login">
 <div id="container">
        <header class="page-header">
            <div class="top-bar-container">
                <a href="login-funcionario.html">
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
                <div id="alinhamento">

                    <button @click="fetchUsers"><h3>Ver cadastros</h3></button>
                <div class="input-block">
                    <input type="text" name="" id="name" v-model="name" required="required" placeholder="Digite o Id do cliente"/>
                </div>
                    <button class="pesquisa" ><img src="/../assets/lupa.png" alt="lupa"><h3>Buscar</h3></button>
                </div>

                

                <br /><br />
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
    width: 30%;
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

.input-block input{
    width: 180px;
    margin: 3.2rem 20px 0px 100px ;
    margin-left: 100px ;
}

.input-block:focus-within::after{
    content: "";

    width: 170px;
    height: 2px;
    margin: 3.2rem 20px 0px 90px ;
    background: var(--color-primary-light);

    position: absolute;
    
    right: 1.6rem;
    bottom: 0px;
}

#alinhamento{
  display: flex;
    align-items: center;
    justify-content: center;
}

button img{
    position: absolute;
    cursor: pointer;
    width: 40px;
    height: 40px;
    margin-left: -55px;
    
}
.pesquisa{
 background: #787680cb; 
}
.pesquisa:hover{
  background: var(--color-text-base);
}
</style>