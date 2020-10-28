<template>
    <div class="furniture">

    <header class="page-header">
        <div class="top-bar-container">
        <a href="loginFunc">
            <img src="/assets/back.svg" alt="Voltar">
        </a>
        <img src="/assets/logo.png" alt="Teixeira Móveis">
        </div>

        <div class="header-content">
        <strong>Vamos inserir novos móveis</strong>
        <p>O primeiro passo, é preencher esse formulário de inscrição</p>
        </div>
    </header>
       <main>
            <form action="" id="create-registration" onsubmit= "return validaCadastro()">
            <fieldset>
                <legend>Insira os dados do produto</legend>
                    <div class="input-block">
                        <label id="legenda" for="nome">Nome do produto</label>
                        <input type="text" name="" id="" v-model="nome" required />
                        <span class='msg-erro msg-nome'></span>
                    </div>
                    <div class="input-block">
                        <label id="legenda" for="numero">Número de série</label>
                        <input type="text" name="" id="" v-model="serie" required />
                    </div>
                    <div class="input-block">
                        <label id="legenda" for="descricao">Descrição</label>
                        <input type="text" name="" id="" v-model="descricao" required />
                    </div>
					<div class="input-block">
                        <label id="legenda" for="codigo">Código </label>
                        <input name="codigo" id="codigo" type="number" required="required">
                    </div>
					<div class="input-block">
                        <label id="legenda" for="imagem">Imagem <small>(selecione um arquivo)</small></label>
                    </div>
                        <br>
                        <br><input  type="file" id="file" ref="file" name="image" />
            </fieldset>

            <fieldset>
                <legend>Informe o tipo de produto</legend>
                <div class="input-block">
                    <label id="legenda" for="subject">Tipo</label>
                    <input type="text" name="" id="" v-model="tipo" required />
                </div>
            </fieldset>

            <fieldset>
                <legend>Estamos quase lá</legend>
                    <div class="input-block" id="input-block3" >
                        <label id="legenda" for="valor">Digite o preço <small>(R$)</small></label>
                        <input type="number" name="" id="" v-model="preco" required />
                    </div>
            </fieldset>
            </form>
            <footer>
                <p>
                    <img src="assets/warning.svg" alt="Aviso importante">
                    Importante!
                    <br>
                    Preencha todos os dados
                </p>
                <button @click="postFurniture" form="create-registration">Inserir</button>
            </footer>
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
            baseURI: "http://localhost:8080/api/furnitures"
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
                quantidade: this.quantidade
            }).then((result) => {
                console.log(result);
                this.furniture = result.data;
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
                quantidade: this.quantidade
            }).then((result) => {
                console.log(result);
                this.furniture = result.data;
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
#legenda{
    font: 500 1.6rem Poppins; 
    font-weight: 500;
    font-family: Poppins;
    font-size: 1.6rem;
    color: var(--color-text-base);
}

</style>