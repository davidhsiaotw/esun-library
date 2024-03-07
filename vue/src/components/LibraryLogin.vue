<template>
  <div class="login">
    <ul>
      <h2>Login</h2>

      <label for="phone">Phone Number </label>
      <input type="tel" id="phone" v-model="phone"><br />

      <label for="password">Password </label>
      <input type="password" id="password" v-model="password"><br />

      <a href="https://www.w3schools.com/">Register</a><br />

      <button type="submit" @click="login">Login</button>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'LibraryHome',
  data() {
    return {
      phone: "",
      password: ""
    }
  },
  methods: {
    async login() {
      if (!this.phone.match("[0-9]{10}")) {
        console.log("Phone number must be 10-digit")
        return
      }
      await axios.post("http://localhost:8080/api/users/login", {
        phone: this.phone,
        password: this.password
      }).then(() => {
        // TODO: navigate to Home
        console.log("Login Successfully")
      }).catch(() => {
        // TODO: show log in fail
        console.log("Login Failed");
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
