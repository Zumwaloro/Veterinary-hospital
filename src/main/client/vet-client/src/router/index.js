import {createRouter, createWebHistory} from 'vue-router';
import UserPage from '../views/UserPage.vue';
import LogIn from '../views/LogIn.vue'

const routes = [
    {
        path: '/',
        name: 'LogIn',
        component: LogIn
    },
    {
        path: '/user',
        name: 'UserPage',
        component: UserPage
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router