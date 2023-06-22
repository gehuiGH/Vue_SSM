<template>
  <div class="wrapper" id="app" style="background-color:#e0edfb">
    <div class="card-form">
      <div class="card-list">
        <div class="card-item" v-bind:class="{ '-active': isCardFlipped }">
          <div class="card-item__side -front">
            <div
              class="card-item__focus"
              v-bind:class="{ '-active': focusElementStyle }"
              v-bind:style="focusElementStyle"
              ref="focusElement"
            ></div>

            <div class="card-item__cover">
                <!-- img -->

              <center><h1 class="title_hearder">GH博客(注册)</h1></center>
              <!--   //标题 -->
            </div>

            <div class="card-item__wrapper">
              <div class="card-item__top">

                <div class="card-item__holder">密码：</div>
                <div class="card-item__type">
                  <transition name="slide-fade-up"> </transition>
                </div>
              </div>
              <label
                for="password"
                class="card-item__number"
                ref="password"
              >
                <template v-if="getCardType === 'amex'">
                  <span v-for="(n, $index) in amexCardMask" :key="$index">
                    <transition name="slide-fade-up">
                      <div
                        class="card-item__numberItem"
                        v-if="
                          $index > 4 &&
                          $index < 14 &&
                          password.length > $index &&
                          n.trim() !== ''
                        "
                      >
                        *
                      </div>
                      <div
                        class="card-item__numberItem"
                        :class="{ '-active': n.trim() === '' }"
                        :key="$index"
                        v-else-if="password.length > $index"
                      >
                        {{ password[$index] }}
                      </div>
                      <div
                        class="card-item__numberItem"
                        :class="{ '-active': n.trim() === '' }"
                        v-else
                        :key="$index + 1"
                      >
                        {{ n }}
                      </div>
                    </transition>
                  </span>
                </template>

                <template v-else>
                  <span v-for="(n, $index) in otherCardMask" :key="$index">
                    <transition name="slide-fade-up">
                      <div
                        class="card-item__numberItem"
                        v-if="
                          $index > 4 &&
                          $index < 15 &&
                          password.length > $index &&
                          n.trim() !== ''
                        "
                      >
                        *
                      </div>
                      <div
                        class="card-item__numberItem"
                        :class="{ '-active': n.trim() === '' }"
                        :key="$index"
                        v-else-if="password.length > $index"
                      >
                        {{ password[$index] }}
                      </div>
                      <div
                        class="card-item__numberItem"
                        :class="{ '-active': n.trim() === '' }"
                        v-else
                        :key="$index + 1"
                      >
                        {{ n }}
                      </div>
                    </transition>
                  </span>
                </template>
              </label>
              <div class="card-item__content">
                <label for="username" class="card-item__info" ref="username">
                  <div class="card-item__holder">用户名：</div>
                  <transition name="slide-fade-up">
                    <div class="card-item__name" v-if="username.length" key="1">
                      <transition-group name="slide-fade-right">
                        <span
                          class="card-item__nameItem"
                          v-for="(n, $index) in username
                            .replace(/\s\s+/g, ' ')
                            .split(' ')"
                          :key="$index"
                          >{{ n }}</span
                        >
                      </transition-group>
                    </div>

                    <div class="card-item__name" v-else key="2">Full Name</div>
                  </transition>
                </label>
                <div class="card-item__date" ref="cardDate">
                  <label for="cardMonth" class="card-item__dateTitle"
                    >Expires</label
                  >
                  <label for="cardMonth" class="card-item__dateItem">
                    <transition name="slide-fade-up">
                      <span v-if="cardMonth" v-bind:key="cardMonth">{{
                        cardMonth
                      }}</span>
                      <span v-else key="2">MM</span>
                    </transition>
                  </label>
                  /
                  <label for="cardYear" class="card-item__dateItem">
                    <transition name="slide-fade-up">
                      <span v-if="cardYear" v-bind:key="cardYear">{{
                        String(cardYear).slice(2, 4)
                      }}</span>
                      <span v-else key="2">YY</span>
                    </transition>
                  </label>
                </div>
              </div>
            </div>
          </div>
          <div class="card-item__side -back">
            <div class="card-item__cover">
              <img
              
              />
            </div>
            <div class="card-item__band"></div>
            <div class="card-item__cvv">
              <div class="card-item__cvvTitle">手机号码(已进行隐私处理)</div>
              <div class="card-item__cvvBand">
                <span v-for="(n, $index) in phone" :key="$index"> * </span>
              </div>
              <div class="card-item__type">
                <img class="login_logo" src="../assets/login_logo.png"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="card-form__inner">
        <div class="card-input">
          <label for="password" class="card-input__label">密码：</label>
          <input
            type="text"
            id="password"
            class="card-input__input"
            v-mask="generatepasswordMask"
            v-model="password"
            v-on:focus="focusInput"
            v-on:blur="blurInput"
            data-ref="password"
            autocomplete="off"
          />
        </div>
        <div class="card-input">
          <label for="username" class="card-input__label">用户名:</label>
          <input
            type="text"
            id="username"
            class="card-input__input"
            v-model="username"
            v-on:focus="focusInput"
            v-on:blur="blurInput"
            data-ref="username"
            autocomplete="off"
          />
        </div>
        <div class="card-form__row">
          <div class="card-form__col">
            <div class="card-form__group">
              <label for="cardMonth" class="card-input__label"
                >出生年月</label
              >
              <select
                class="card-input__input -select"
                id="cardMonth"
                v-model="cardMonth"
                v-on:focus="focusInput"
                v-on:blur="blurInput"
                data-ref="cardDate"
              >
                <option value="" disabled selected>Month</option>
                <option
                  v-bind:value="n < 10 ? '0' + n : n"
                  v-for="n in 12"
                  v-bind:disabled="n < minCardMonth"
                  v-bind:key="n"
                >
                  {{ n < 10 ? "0" + n : n }}
                </option>
              </select>
              <select
                class="card-input__input -select"
                id="cardYear"
                v-model="cardYear"
                v-on:focus="focusInput"
                v-on:blur="blurInput"
                data-ref="cardDate"
              >
                <option value="" disabled selected>Year</option>
                <option
                  v-bind:value="$index + minCardYear"
                  v-for="(n, $index) in 12"
                  v-bind:key="n"
                >
                  {{ $index + minCardYear }}
                </option>
              </select>
            </div>
          </div>
          <div class="card-form__col -cvv">
            <div class="card-input">
              <label for="phone" class="card-input__label">电话号码：</label>
              <input
                type="text"
                class="card-input__input"
                id="phone"
                v-mask="'####'"
                maxlength="11"
                v-model="phone"
                v-on:focus="flipCard(true)"
                v-on:blur="flipCard(false)"
                autocomplete="off"
              />
            </div>
          </div>
        </div>

        <button class="card-form__button" @click="show">注册</button>
        <h5>已有账户？<router-link to="/login">登录</router-link></h5>
      </div>
    </div>

    
  </div>
</template>

<script>
import axios from 'axios'
export default {
  /*
See on github: https://github.com/muhammederdem/credit-card-form
*/

  name: "App",
  data() {
    return {
      currentCardBackground: Math.floor(Math.random() * 25 + 1), // just for fun :D
      username: "",    //用户名 
      password: "",
      cardMonth: "",
      cardYear: "",
      phone: "",
      minCardYear: new Date().getFullYear(),
      amexCardMask: "###############",
      otherCardMask: "#### #### #### ####",
      passwordTemp: "",
      isCardFlipped: false,
      focusElementStyle: null,
      isInputFocused: false,
    };
  },
  mounted() {
    this.passwordTemp = this.otherCardMask;
    document.getElementById("password").focus();
  },
  computed: {
    getCardType() {
      let number = this.password;
      let re = new RegExp("^4");
      if (number.match(re) != null) return "visa";

      re = new RegExp("^(34|37)");
      if (number.match(re) != null) return "amex";

      re = new RegExp("^5[1-5]");
      if (number.match(re) != null) return "mastercard";

      re = new RegExp("^6011");
      if (number.match(re) != null) return "discover";

      re = new RegExp("^9792");
      if (number.match(re) != null) return "troy";

      return "visa"; // default type
    },
    generatepasswordMask() {
      return this.getCardType === "amex"
        ? this.amexCardMask
        : this.otherCardMask;
    },
    minCardMonth() {
      if (this.cardYear === this.minCardYear) return new Date().getMonth() + 1;
      return 1;
    },
  },
  watch: {
    cardYear() {
      if (this.cardMonth < this.minCardMonth) {
        this.cardMonth = "";
      }
    },
  },
  methods: {
      show(){
      let aa = "-1";

      let dataone={
            "id" : "1",
            "username" : this.username,
            "password" : this.password,
            "phone" : this.phone
        }
        let set ={
          headers: {
            'Content-Type': 'application/json'
          }
        }
        console.log(dataone)
      //  axios.post("http://localhost:8080/Vue_SSM/users/insertdata",dataone,set).then((request)=>{
      //   console.log(request.data,"请求成功")
      //  },(error)=>{
      //   console.log("插入失败")
      //  }
      //  )
      axios.post("http://localhost:8080/Vue_SSM/users",dataone).then((request)=>{
        console.log(request.data)
      },(error)=>{
        console.log(error.message)
      })
      
      },
    flipCard(status) {
      this.isCardFlipped = status;
    },
    focusInput(e) {
      this.isInputFocused = true;
      let targetRef = e.target.dataset.ref;
      let target = this.$refs[targetRef];
      this.focusElementStyle = {
        width: `${target.offsetWidth}px`,
        height: `${target.offsetHeight}px`,
        transform: `translateX(${target.offsetLeft}px) translateY(${target.offsetTop}px)`,
      };
    },
    blurInput() {
      let vm = this;
      setTimeout(() => {
        if (!vm.isInputFocused) {
          vm.focusElementStyle = null;
        }
      }, 300);
      vm.isInputFocused = false;
    },
  },
};
</script>

<style lang="scss" src='../assets/conn.scss' scoped></style>  //引入外部文件
<style scoped>

</style>
