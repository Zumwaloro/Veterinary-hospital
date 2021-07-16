import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import { createApp } from 'vue'
//import App from './App.vue'
import UserPage from './views/UserPage.vue'
import router from './router'

createApp(UserPage)
    .use(router)
    .mount('#app')
