<template>
  <Header />
  <NavBar />
  <div class="row" id="background">
    <div class="row justify-content-center" id="home-img-container">
      <div class="col-md-8" id="img-holder">
          <img class="img-fluid" src="./assets/cat.jpg" id="home-img">
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import NavBar from './components/NavBar.vue'

export default {
  name: 'App',
  components: {
    Header,
    NavBar
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
</style>
