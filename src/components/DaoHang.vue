 <template>
  
 <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    @select="handleSelect"
    size="large"
   
  >
  <el-menu-item>  <!--     logo居中标签   -->
    <div class="menu-item-content">
      <img class="dhlmg" src="../assets/login_logo.png" alt="your-image-alt-here">
    </div>
  </el-menu-item>
    <el-menu-item index="1">首页</el-menu-item>
    <el-sub-menu index="2">
      <template #title>项目管理</template>
      <el-menu-item index="2-1"><router-link to="news" style="color:white">新闻管理系统(ssm)</router-link></el-menu-item>
      <el-menu-item index="2-2">学生管理系统</el-menu-item>
      <el-menu-item index="2-3"><router-link to="/todolist" style="color:white">todolist编辑器</router-link></el-menu-item>
      <el-sub-menu index="2-4">
        <template #title>系统4</template>
        <el-menu-item index="2-4-1">item one</el-menu-item>
        <el-menu-item index="2-4-2">item two</el-menu-item>
        <el-menu-item index="2-4-3">item three</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-menu-item index="3"><router-link to="/login">登录</router-link></el-menu-item>
    <el-menu-item index="8"><router-link to="/regi">注册</router-link></el-menu-item>
   
  </el-menu>

</template>

<script lang="ts" setup>
import { ref } from 'vue'

const activeIndex = ref('1')
const activeIndex2 = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style scoped>
.menu-item-content {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
.dhlmg{
  width: 40%
}
</style>