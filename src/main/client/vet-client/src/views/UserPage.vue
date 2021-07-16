<template>
  <Header />
  <UserPageNavBar @retrieve-clients="getClients"/>
      <div class="row" id="clients">
        <div v-if="clientsActive">
            <div class="row" v-for="client in clients" :key="client.id">
                <div class="row" id="text-container">
                    <div class="col-md-4" id="details">
                        <p class="text-md-start">
                            Name: {{client.name}} <br>
                            Diagnosis: {{client.diagnosis}}<br>
                            Owner: {{client.ownerName}}<br>
                            Owner's address: {{client.ownerAddress}}<br>
                            Owner's phone: {{client.ownerPhone}}<br>
                        </p>
                    </div>
                    <div class="col-md-4" id="btn-wrapper">
                        <button class="nav-link" id="expense-btn" @click="getExpenseDetails(client.id)">Show expenses <span class="sr-only"></span></button>
                    </div>
                    <div class="col-md-4" id="btn-wrapper">
                        <button class="nav-link" id="expense-btn" @click="getExpenseDetails(client.id)">Add expenses <span class="sr-only"></span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Header from '../components/Header.vue'
import UserPageNavBar from '../components/UserPageNavBar.vue'
import axios from 'axios'

export default {
  name: 'App',
  data() {
      return {
          clientsActive: false,
          clients: [],
          expensesActive: false,
          expenses: []
      }
  },
  methods: {
      getClients() {
            let that = this
            axios.get('http://localhost:8080/pet')
                .then(function (response) {
                    that.clients = response.data
                    that.clientsActive = true
                    that.expensesActive = false
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      getExpenseDetails(id) {
            axios.get('http://localhost:8080/pet/expenses/details/'+id)
                .then(function (response) {
                    console.log(response.data)
                    return response.data
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      addExpenseDetails(id, diag, price) {
            axios.get('http://localhost:8080/pet/expenses/'+id+'/'+diag+'/'+price)
                .then(function (response) {
                    return response.data
                })
                .catch(function (error) {
                    console.log(error);
                });
      }
  },
  components: {
    Header,
    UserPageNavBar
  }
}
</script>

<style>
    #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    }
    #home-img-container {
        border-radius: 10px;
        background-color: rgba(0,0,0,0.5);
    }
    #img-holder {
        margin: 1rem;
    }
    #home-img {
        border-radius: 10px;
        border: 5px solid #7541D3;
    }
    #background {
    background-color: #7541D3;
    }
    #text-container {
        background-color: rgba(0,0,0,0.5);
        color: whitesmoke;
        border-radius: 10px;
        padding-left: 1rem;
        margin-left: 0.5rem;
        margin-top: 1rem;
    }
    #clients {
        background-color: #BE41D3;
        height: 100%;
    }
    #expense-btn {
        color: whitesmoke;
        text-align: center;
        font-size: 1.5rem;
        border-color: 10px solis black;
        border-radius: 15px;
        background-color: #7541D3;
    }
    #btn-wrapper {
        margin-top: 2rem;
    }
    #details {
        margin-top: 1rem;
    }
</style>
