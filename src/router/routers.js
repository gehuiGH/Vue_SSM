import {createRouter,createWebHistory} from 'vue-router'
import login from '../components/login'
import regi from '../components/regi'
export default new createRouter({
    history:createWebHistory(),
    routes:[{
        path:"/login",
        component:login
    },
    {
        path:"/regi",
        component:regi
    }]

})