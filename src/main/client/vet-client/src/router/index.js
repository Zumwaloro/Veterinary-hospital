import {createRouter, createWebHistory} from 'vue-router';
import UserPage from '../views/UserPage.vue';

const routes = [
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