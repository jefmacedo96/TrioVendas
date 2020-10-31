<template>
    <div class="furniture">
    <header class="page-header">
      <div class="top-bar-container">
        <a href="loginFunc">
          <img src="/../assets/back.svg" alt="Voltar">
        </a>
        <img src="/../assets/logo.png" alt="Teixeira Móveis">
      </div>

      <div class="header-content">
        <strong>Esses são os nossos móveis cadastrados</strong>
        <p>Somente funcionários tem acesso a essas informações</p>
      </div>
    </header>

    <main>        
    <fieldset>
      <legend>Móveis cadastrados</legend>
        <div id="alinhamento">
          <button @click="fetchFurnitures"><h3>Ver móveis cadastros</h3></button>
          <div class="input-block1">
            <input type="text" v-model="serieget" required="required" placeholder="Digite a série"/>
          </div>

          <button  @click="fetchFurnitureBySerie" class="pesquisa" ><img src="/../assets/lupa.png" alt="lupa"><h3>Buscar</h3></button>
        </div> 

        <div id="alinhamento2">
          <div class="input-block2">
            <input type="number"  v-model="quant" required="required" placeholder="Digite a quantidade"/>
          </div>

          <button @click="fetchFurnitureByQuant" class="pesquisa" ><img src="/../assets/filtro.ico" alt="filtro"><h3>Filtrar</h3></button>
                  
          <br>
          <br>
        </div>  

        <div id="alinhamento3">
          <div class="input-block3">
            <input type="number"  v-model="id" required="required" placeholder="Digite o Id"/>
          </div>

          <button @click="deleteFurniture" class="pesquisa1" ><img src="/../assets/lixeira.png" alt="remover"><h3>Remover</h3></button>
                  
          
        </div> <br><br>  
      <li v-for="furniture in furnitures" :key="furniture.id">
        <br>

        
        <p>Id: {{ furniture.id }}</p>
        <p>Nome: {{ furniture.nome }}</p>
        <p>Descrição: {{ furniture.descricao}}</p>
        <p>Número de série: {{ furniture.serie }}</p>
        <p>Tipo de produto: {{ furniture.tipo }}</p>
        <p>Preço: {{ furniture.preco }}</p><br/>
        <p><img :src="'/uploads/furniture/'+furniture.id+'.png'" width="300"/></p>
        
        <br><br>
      </li>

    </fieldset>
    </main>
</div>    
</template>

<script>
export default {
    name: "Funitures",
    data() {
        return {
            file: null,
            id: 0,
            id2: 0,
            nome: "",
            descricao: "",
            serie: "",
            tipo: "",
            preco: "",
            quantidade: "",
            serieget:"",
            quant: "",
            furniture: {},
            furnitures: [],
            baseURI: "http://localhost:8080/api/furnitures",
            baseUploadURI: "http://localhost:8080/upload"
        };
    },
    methods: {

        handleFileUpload(id) {
        this.file = this.$refs.file.files[0];
    
        let form = new FormData();
        form.append("resource", "furniture");
        form.append("id", id);
        form.append("file", this.file);
    
        this.$http
            .post(this.baseUploadURI, form, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
            })
            .then((result) => {
            console.log(result);
            });
        },

        fetchFurnitures: function() {
            this.$http.get(this.baseURI).then((result) => {
                this.furnitures = result.data;
                alert("Buscando todos os registros")
            });
        },

        fetchFurnitureById: function() {
            this.$http.get(this.baseURI + "/" + this.id2).then((result) => {
                this.furniture = result.data;
                alert("Registro por ID")
            }).catch(function (error) {
                console.log(error);
            });
        },

        fetchFurnitureBySerie: function() {
            this.$http.get(this.baseURI + "/search?serie=" + this.serieget).then((result) => {
                this.furnitures = result.data;
                alert("Registros por Serie")
            }).catch(function (error) {
                console.log(error);
            });
        },

        fetchFurnitureByQuant: function() {
            this.$http.get(this.baseURI + "/quant?quant=" + this.quant).then((result) => {
                this.furnitures = result.data;
                alert("Registros por Quantidade")
            }).catch(function (error) {
                console.log(error);
            });
        },

        postFurniture: function() {
            this.$http.post(this.baseURI, {
                nome: this.nome,
                descricao: this.descricao,
                serie: this.serie,
                tipo: this.tipo,
                preco: this.preco,
                quantidade: this.quantidade,
            }).then((result) => {
                console.log(result);
                this.furniture = result.data;
                this.handleFileUpload(this.furniture.id);
                alert("Cadastro Realizado!")
            });
        },

        putFurniture: function() {
            this.$http.put(this.baseURI + "/" + this.id, {
                nome: this.nome,
                descricao: this.descricao,
                serie: this.serie,
                tipo: this.tipo,
                preco: this.preco,
                quantidade: this.quantidade,
            }).then((result) => {
                console.log(result);
                this.furniture = result.data;
                this.handleFileUpload(this.furniture.id);
                alert("Registro Atualizado!")
            });
        },

        deleteFurniture: function() {
            this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
                console.log(result);
                this.furniture = result.data;
                alert("Registro Deletado!")
            }).catch(function (error) {
                console.log(error);
            });
        },
    },
};
</script>

<style>

</style>