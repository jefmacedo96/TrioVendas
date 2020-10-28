<template>
<div class="login">
 <div id="container">
    <header class="page-header">
      <div class="top-bar-container">
        <a href="loginFunc">
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

          <div class="input-block1">
            <input type="text" cpf="" id="cpf" v-model="cpf" required="required" placeholder="Digite o CPF"/>
          </div>

          <button @click="fetchUserByCpf" class="pesquisa" ><img src="/../assets/lupa.png" alt="lupa"><h3>Buscar</h3></button>
        </div> 

        <div id="alinhamento2">
          <div class="input-block2">
            <input type="number" quantidade="" id="quantidade" v-model="quantidade" required="required" placeholder="Digite a quantidade"/>
          </div>

          <button @click="fetchUserByQuantidade" class="pesquisa" ><img src="/../assets/filtro.ico" alt="filtro"><h3>Filtrar</h3></button>
                  
          <br>
          <br>
        </div>  

        <div id="alinhamento3">
          <div class="input-block3">
            <input type="number" quantidade="" id="id" v-model="id" required="required" placeholder="Digite o Id"/>
          </div>

          <button @click="deleteUserById" class="pesquisa1" ><img src="/../assets/lixeira.png" alt="remover"><h3>Remover</h3></button>
                  
          <br>
          <br>
        </div>   
      <li v-for="user in users" :key="user.id">
        <br>
        <p>Id: {{ user.id }}</p>
        <p>Nome: {{ user.nome }}</p>
        <p>Email: {{ user.email }}</p>
        <p>CPF: {{ user.cpf }}</p>
        <p>Telefone: {{ user.telefone }}</p>
        <p>Senha: {{ user.senha }}</p>
        <p>Endereço: {{ user.estado }}, {{ user.cidade }}, {{ user.complemento }}.</p>
        
        <br><br>
      </li>

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
      cpf: "",
      senha: "",
      nome: "",
      email: "",
      telefone: "",
      estado: "",
      cidade: "",
      complemento: "",
      confirmeSenha: "",
      quantidade:"",
      user: {},
      users: [],
      baseURI: "http://localhost:8080/api/users",
    };
  },

methods: {
    fetchUsers: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.users = result.data;
      });
    },
     fetchUserByCpf: function() {
      this.$http
        .get(this.baseURI + "/search?cpf=" + this.cpf)
        .then((result) => {
          this.users = result.data;
          console.log(result.data)
        })
        .catch(function(error) {
          console.log(error);
        });
    },
     fetchUserByQuantidade: function() {
      this.$http
        .get(this.baseURI + "/page?quantidade=" + this.quantidade)
        .then((result) => {
          this.users = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
     deleteUserById: function() {
      this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
        console.log(result.status);
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

.input-block1 input{
    height: 5.6rem;
    border-radius: 0.8rem;
    background: var(--color-input-background);
    border: 1px solid var(--color-line-in-write);
    outline: 0;
    padding: 0 1.6rem;
    font: 1.6rem Archivo;


    width: 180px;
    margin: 3.2rem 20px 0px 100px ;
    margin-left: 100px ;
}

.input-block2 input,
.input-block3 input{
    height: 5.6rem;
    border-radius: 0.8rem;
    background: var(--color-input-background);
    border: 1px solid var(--color-line-in-write);
    outline: 0;
    padding: 0 1.6rem;
    font: 1.6rem Archivo;


    width: 180px;
    margin: 3.2rem 20px 0px -100px ;
    margin-left: 250px ;
}

#alinhamento{
  display: flex;
    align-items: center;
    justify-content: center;
}

#alinhamento2,
#alinhamento3{
  display: flex;
    align-items: center;
    justify-content: center;
}

#alinhamento2 button img{
    position: absolute;
    cursor: pointer;
    width: 25px;
    height: 25px;
    margin-left: -55px;   
}

#alinhamento3 button img
{
    position: absolute;
    cursor: pointer;
    width: 25px;
    height: 25px;
    margin-left: -60px;   
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

.pesquisa1{
 background: #f80303; 
}

.pesquisa1:hover{
  background: #d80303; 
}
.page-header .header-content p {
    font-size: 1.9rem;
}

li{
  background:#f0f0f0e5;
  border-radius: 8px;
  margin: 10px 0px 0 0px;
  list-style-type: none;
}
li p{
   margin: 0px 100px 0 100px;
   color: var(--color-text-complement);
   font: 70 1.7rem Archivo;
}
</style>