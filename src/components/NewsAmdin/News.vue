<template>
  <div>
    <img class="hreaderimg" src="../../assets/background01/newad.jpg"/>
  </div>
  <center><h2 >新闻管理系统</h2></center>
<div class="inputone">   <!--   表单  -->
    <el-input v-model="input" placeholder="id号" style="width:200px"/>
    <el-input v-model="input2" placeholder="作者" style="width:200px"/>
    <el-button type="primary">查询</el-button>
    <!-- 点击添加弹出输入框 -->
    <el-button text @click="form.dialogFormVisible = true">
    添加新闻
  </el-button>

  <el-dialog v-model="form.dialogFormVisible" title="添加新闻信息">
    <el-form :model="form">
      <el-form-item label="作者" :label-width="formLabelWidth">
        <el-input v-model="form.auther" autocomplete="off" />
      </el-form-item>
      <el-form-item label="内容" :label-width="formLabelWidth">
        <el-input v-model="form.conter" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="form.dialogFormVisible = false">提交</el-button>
        <el-button type="primary" @click="form.dialogFormVisible = false">
          取消
        </el-button>
      </span>
    </template>
  </el-dialog>
  <!-- ----------------------添加输入框------------------------------------- -->
    </div>


  <div style="margin: 0 auto; width: 60%;">
  <el-table height="70%"  class="table" :data="tableData" style="width: 100%">
    <el-table-column fixed prop="date" label="Date" width="250" />
    <el-table-column prop="id" label="id" width="250" />
    <el-table-column prop="state" label="auther" width="250" />
    
    <el-table-column fixed="right" label="Operations" width="250">
      <template #default>
        <el-button link type="primary" size="small" @click="handleClick"
          >删除</el-button>
        <el-button link type="primary" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table></div>
</template>


<script>
import axios from "axios"
import { onMounted, ref } from "vue"



export default({
   data(){
    return{
        input:"",
        input2:"",
     tableData : [
  {
    id:1,
    date: '2016-05-03',
    name: 'Tom',
    state: 'California',
    city: 'Los Angeles',
    address: 'No. 189, Grove St, Los Angeles',
    zip: 'CA 90036',
    tag: 'Home',
  },
 
],

    form:{
        auther:"",
        conter:"",
        dialogFormVisible : false,
        dialogTableVisible : false ,
        formLabelWidth :'140px'
    }
    }
   },


  setup(){
    let dateAll = ref(null)

    async function Getdata(){
     dateAll =   await axios.get("http://localhost:8080/Vue_SSM/news/dataAll")
      .then(
        (request)=>{
        return request.data;
      },(error)=>{
        console.log(error.message)
      })
    }
    onMounted(()=>{
      Getdata()
      console.log("123123",dateAll)
    })
  }
  })
</script>


<style scoped>

.hreaderimg{
    width: 100%;
    height: 250px;
}
.table{
    size: large ;
}
.inputone{
    margin-left:30%;
}
</style>





