import { createApp } from 'vue'
import App from './App.vue'
import routers  from './router/routers'
createApp(App).use(routers).mount('#app')
