<template>
  <div id="reapp">
    <button>aqui</button>

<ul>
      <li v-for="user in CustomerRegistration" :key="user.id">
        <h4>{{ user.id }}</h4>
        <p>{{ user.name }}</p>
        <p>{{ user.email }}</p>
        <p>{{ user.login }}</p>
        <p>{{ user.telefone }}</p>
        <p>{{ user.password }}</p>
        <p>{{ user.confirmeSenha }}</p>
      </li>
    </ul>

</div>

</template>

<script>
export default {
  name: "CustomerRegistration",
  data() {
    return {
      id: 0,
      login: "",
      password: "",
      name: "",
      email: "",
      telefone: "",
      confirmeSenha: "",
      user: {},
      CustomerRegistration: [],
      baseURI: "http://localhost:8080/projeto1/api/CustomerRegistration",
    };
  },
  methods: {
    fetchUsers: function() {

      this.$http.get(this.baseURI).then((result) => {
        this.CustomerRegistration = result.data;
      });
    },
    fetchUserById: function() {
      this.$http
        .get(this.baseURI + "/" + this.id)
        .then((result) => {
          this.user = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    fetchUserByLogin: function() {
      this.$http
        .get(this.baseURI + "/" +"?login="+ this.login)
        .then((result) => {
          this.user = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    postUser: function() {
      this.$http
        .post(this.baseURI, {
          name: this.name,
          email: this.email,
          login: this.login,
          telefone: this.telefone,
          password: this.password,
          confirmeSenha: this.confirmeSenha,
        })
        .then((result) => {
          console.log(result);
          this.user = result.data;
        });
    },
    putUser: function() {
      this.$http
        .put(this.baseURI + "/" + this.id, {
          login: this.login,
          password: this.password,
        })
        .then((result) => {
          console.log(result);
          this.user = result.data;
        });
    },
    deleteUserById: function() {
      this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
        console.log(result.status);
      });
    },
  },
};
</script>
