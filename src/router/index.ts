import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import login from '../components/login.vue'
import regi from '../components/regi.vue'
import index from '../components/index.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'index',
    component: index
  },
  {
    path: '/regi',
    name: 'regi',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component:regi
  },
  {
    path:'/login',
    component:login
  },
  {
    path:'/news',
    component:()=>import("../components/NewsAmdin/News.vue")
  },{
    path:"/todolist",
    component:()=>import("../components/TodoList/todolist.vue")
  },{
    path:'/Echarts',
    component:()=>import("../components/Echarts_data/Echarts分析.vue")
  }
 
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
