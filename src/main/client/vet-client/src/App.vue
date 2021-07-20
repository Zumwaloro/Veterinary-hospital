<template>
  <Header />
  <router-view />
</template>

<script>
import Header from './components/Header.vue'

export default {
  name: 'LogIn',
  components: {
    Header,
  }
}
</script>