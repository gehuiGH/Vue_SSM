<template>
<div class="back">

  <div class="alldiv" style="background:red">
    <div>

      <div class="fixed-header">
      
        <div class="container">
        
          <div class="top-menu">
            <div id="Bork">
            <h2 class="zt">
              <font size="170px">个人博客</font>
            </h2>
            </div>
            <!-- <div id="Bork2">
            <audio
             class="yinyue2" src="../assets/index/audio（音频）/逆时针向 - 暖冬.mp3"  controls align="left" autoplay loop>页面不支持播放哦
            </audio>
            </div> -->
            <div class="header-banner" id="head">
              <div class="slider">
                <div class="callbacks_container">
                  <ul class="rslides" id="slider">
                    <li>
                      <div class="page-content">
                    <div v-for="(card, index) in cards" :key="index" class="card">
                      <div class="content">
                        <h2 class="title">{{ card.title }}</h2>
                        <p class="copy">{{ card.copy }}</p>
                        <button class="btn" @click="this.$router.push(card.path)">{{ card.button }}</button>
                      </div>
                    </div>
                  </div>

                      <div class="logo">

                      </div>
                      <a href="#">
                        <font size="15px"></font>
                      </a>
                      <div class="banner">

                        <br />
                        <br />
                        <p class="dier" style="margin-top:100px">
                          <font size="45">come on 设计精彩人生</font>
                        </p>
                        
                      </div>
                    </li>

                  </ul>
                </div>


              </div>
              
            </div>
          </div>
        </div>
              <footer class="footer">
                <li> Copyright [2021-现在] [GH/GH] All rights Reserved@版权所有</li>
              </footer>
      </div>

    </div>
  </div>
  </div>
</template>

<script>


export default {
  data() {
    return {
      cards: [
        {
          title: '新闻管理系统',
          copy:
            'Check out all of these gorgeous mountain trips with beautiful views of, you guessed it, the mountains',
          button: '新闻管理系统',
          path:"/news"
        },
        {
          title: '用户管理系统',
          copy: 'Plan your next beach trip with these fabulous destinations',
          button: '用户管理系统',
           path:"#"
        },
        {
          title: 'Todolist',
          copy: "It's the desert you've always dreamed of",
          button: 'Todolist编辑器',
           path:"/todolist"
        },
        {
          title: '数据分析(Echarts)',
          copy: 'Seriously, straight up, just blast off into outer space today',
          button: '数据分析(Echarts)',
           path:"/#"
        },
      ],
    };
  },
};


</script>

<style lang="scss" scoped src="../assets/index.scss"></style>
<style src="../assets/css样式/style.css"></style>
<style scoped>



.container {
  height: 100vh; /* 将高度设置为视口高度 */
  width: 100vw; /* 将宽度设置为视口宽度 */
}
.tx {
  width: 200px;
  opacity: 0.6;
}

.yinyue {
  align: left;
  width: 300px;
  height: 30px;
  border: 1px solid gerrn;
  background: rgba(255, 255, 255, 0.3)
}

.yinyue2 {
  opacity: 0.3;
}
#Bork{
  display: inline-block;
  
}
#Bork2{
  display: inline-block;
  left: 0%;
}
.footer {
  border: 1px solid white;
  width: 100%;
  height: 20px;
  background: rgba(255, 255, 255, 0.3);
}
</style>