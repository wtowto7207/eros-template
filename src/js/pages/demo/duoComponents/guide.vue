<template>
  <div>
    <!-- <div class="status-bar" :style="{'height': statusBarHeight + 'px'}"></div> -->
    <slider class="slider" interval="3000" auto-play="false" infinite="false">
        <!-- v-for="(img,index) in imageList" :key="index" -->
      <div class="frame"  :style="{'height': sliderHeight + 'px'}" >
        <!-- <image class="image" resize="cover" :src="img.src"></image> -->
        <text>Hello</text>
        <div class="button" @click="backHome" >
            <text class="button-text">返回</text>
        </div>
      </div>
      <div class="frame"  :style="{'height': sliderHeight + 'px'}" >
        <!-- <image class="image" resize="cover" :src="img.src"></image> -->
        <text>Hell</text>
      </div>
    </slider>
    <!-- <div class="touch-bar" :style="{'height': touchBarHeight + 'px'}"></div> -->
  </div>
</template>

<style scoped>
.status-bar {
  width: 750;
  height: 40;
  background-color: #BBF61E;
}

.touch-bar {
  height: 68;
  width: 750;
  background-color: #1da1f2;
  position: fixed;
  left: 0;
  bottom: 0;
}

.image {
  width: 700px;
  height: 700px;
}
.slider {
  width: 750px;
  background-color: #272E31;
  justify-content: center;
  align-items: center;
}
.frame {
  width: 700px;
  position: relative;
  justify-content: center;
  align-items: center;
}
.button{
    width: 300px;
    height: 100px;
    justify-content: center;
    align-items: center;
    background-color: #BBF61E;
    /* background-image: linear-gradient(to bottom right,#20dc84,#f2d21d); */
    border-radius: 20px;
}
.button:active {
    background-color: rgb(130, 172, 16);
    /* background-image: linear-gradient(to bottom right, #099454,#b39a0a); */
}
.button-text {
    color: #ffffff;
    font-size: 48px;
}
</style>

<script>
import { Utils } from "weex-ui";
export default {
  data() {
    return {
      sliderHeight: 1334,
      statusBarHeight: weex.config.eros.statusBarHeight
        ? weex.config.eros.statusBarHeight
        : 40,
      touchBarHeight: weex.config.eros.touchBarHeight
        ? weex.config.eros.touchBarHeight
        : 0,
      imageList: [
        {
          src:
            "https://gd2.alicdn.com/bao/uploaded/i2/T14H1LFwBcXXXXXXXX_!!0-item_pic.jpg"
        },
        {
          src:
            "https://gd1.alicdn.com/bao/uploaded/i1/TB1PXJCJFXXXXciXFXXXXXXXXXX_!!0-item_pic.jpg"
        },
        {
          src:
            "https://gd3.alicdn.com/bao/uploaded/i3/TB1x6hYLXXXXXazXVXXXXXXXXXX_!!0-item_pic.jpg"
        }
      ]
    };
  },
  created(){
      var vm = this;
      vm.sliderHeight = Utils.env.getScreenHeight();
  },
  methods: {
      backHome() {
          this.$router.back();
      }
  }
};
</script>