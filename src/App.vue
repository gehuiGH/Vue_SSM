
<template>
  <div>
    <DaoHang/>
    <test/>
    <router-view/>
  </div>
</template>

<script>
import { defineComponent } from 'vue'
import DaoHang from "./components/DaoHang.vue"


export default defineComponent({
  components: {
    DaoHang
  }
})
</script>
<style>

</style>