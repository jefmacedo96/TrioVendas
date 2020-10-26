<template>
    <div class="furniture">
       
        <br />
        <h2> Cadastro de Carros </h2> <br />
        <form>
        ID: <input type="text" name="" id="" v-model="id" required /><br /><br />
        Nome: <input type="text" name="" id="" v-model="nome" required /><br /><br />
        Descrição: <input type="text" name="" id="" v-model="descricao" required /><br /><br />
        Número de série: <input type="text" name="" id="" v-model="serie" required /><br /><br />
        Tipo de produto: <input type="text" name="" id="" v-model="tipo" required /><br /><br />
        Preço: <input type="number" name="" id="" v-model="preco" required /><br /><br />
        Quantidade: <input type="number" name="" id="" v-model="quantidade" required /><br /><br />
        File: <input type="file" id="file" ref="file" name="image" />
    <br />
    <br />
        </form>
                
        <button @click="postFurniture" >Cadastrar móvel</button><br><br>
        <button @click="fetchFurnitures" >Exibir Móveis Cadastrados</button><br><br>
        <button @click="putFurniture" >Alterar Móvel</button><br /><br />
        <button @click="deleteFurniture" >Deletar Móvel</button><br /><br /><br />

         <table border="1" align="center">
            <thead>
                <tr>
                    <td> ID </td>
                    <td> Nome </td>
                    <td> Descrição </td>
                    <td> Número de série </td>
                    <td> Tipo de produto </td>
                    <td> Preço </td>
                    <td> Quantidade </td>
                </tr>
            </thead>
            <tbody>
                <tr v-for="furniture in furnitures" :key="furniture.id">
                    <td>{{ furniture.id }}</td>
                    <td>{{ furniture.nome }}</td>
                    <td>{{ furniture.descricao }}</td>
                    <td>{{ furniture.serie }}</td>
                    <td>{{ furniture.tipo }}</td>
                    <td>{{ furniture.preco }}</td>
                    <td>{{ furniture.quantidade }}</td>
                </tr>
            </tbody>
        </table>

        <br/>
        <div id=getID>
            Buscar por ID: <input type="text" name="" id="" v-model="id2" required /><br /><br />
            <button @click="fetchFurnitureById" >Procurar Móvel Por ID </button><br /><br />
        
            <table border="1" align="center">
                <thead>
                    <tr>
                        <td> ID </td>
                    <td> Nome </td>
                    <td> Descrição </td>
                    <td> Número de série </td>
                    <td> Tipo de produto </td>
                    <td> Preço </td>
                    <td> Quantidade </td>
                    </tr>
                </thead>
                <tbody>
                    <tr >
                        <td>{{ furniture.id }}</td>
                        <td>{{ furniture.nome }}</td>
                        <td>{{ furniture.descricao }}</td>
                        <td>{{ furniture.serie }}</td>
                        <td>{{ furniture.tipo }}</td>
                        <td>{{ furniture.preco }}</td>
                        <td>{{ furniture.quantidade }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br /><br />

        <div id="getQuant">
            Quantidade de registros: <input type="number" name="" id="" v-model="quant"><br><br>
            <button @click="fetchFurnitureByQuant">Filtragem de registros por Quantidade</button><br><br><br>
        </div>
        <div id="getBrand">
            Digite a Série dos registros: <input type="text" name="" id="" v-model="serieget" /><br /><br />
            <button @click="fetchFurnitureBySerie">Filtragem de Registros por Série</button><br><br>
        </div>
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
#page {
    height: 100vh;
    width: 100vw;
    margin: 0 auto;
    box-sizing: border-box;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-items: center;
}


#fields form .field-input {
    margin: 24px 0;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-evenly;
}

.field-input > label{
    width: 136px;
}

.field-input > input {
    height: 32px;
    width: 420px;
    padding: 5px;

    text-align: center;
    border: #101010 3px solid;
}

.field-input > input:focus {
    border: #33c3f3 3px solid;
}

.field-input + #buttons {
    color: red;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}


#buttons {
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: center;
}



button {
    width: 300px;
    height: 50px;

    background-color: #e3e3e3;
    color: #333333;
    border-radius: 10px;
    opacity: 90%;
    
    font-size: 16px;
    text-transform: uppercase;
    cursor: pointer;

    transition: 0.2s;
    border: none;
}

button:active {
    background-color: #e0e0e0;
}


#results-table {
    margin: 32px 0;
}

table {
    min-width: 1100px;
    border: #616161 1px solid;
    border-collapse: collapse;
}


th {
    font-weight: 500;
}

ul, li {
    padding: 16px;
    min-width: 90px;
    min-height: 20px;
    border: #808080 1px solid;
    border-collapse: collapse;

    text-align: center;
}

</style>