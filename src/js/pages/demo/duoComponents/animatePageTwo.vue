<template>
<div>
  <div class="status-bar" :style="{'height': statusBarHeight}"></div>
  <div class="app">
    <list class="page-list" ref="list">
      <cell>
        <slider class="slider-large" :index="selectId" @change="getIndex">
          <div class="frame" v-for="(img, index) in imageList" :key="index">
            <image class="image-large" resize="cover" :src="img.src"></image>
          </div>
        </slider>
      </cell>
      <cell>
        <div ref="content" class="slider-list">
          <div class="slider-list-item" style="backgroundColor:#ff0000"></div>
          <div class="slider-list-item" style="backgroundColor:#00ff00"></div>
          <div class="slider-list-item" style="backgroundColor:#0000ff"></div>
        </div>
      </cell>
    </list>
    <div class="slider-items" ref="slider">
          <div class="nav_wrapper_back">
            <div class="nav_wrapper" ref="title">
                <image class="nav_back" @click="back" src="https://gw.alicdn.com/tfs/TB1ufOrXTtYBeNjy1XdXXXXyVXa-128-128.png" />
                <text class="nav_title">Title</text>
            </div>
          </div>
          <div class="slider-back" ref="background">
          <wxc-ep-slider
                    ref="wxc-ep-slider"
                    :slider-id="sliderId"
                    :card-length="cardLength"
                    :card-s="cardSize"
                    :select-index="selectId"
                    @wxcEpSliderCurrentIndexSelected="wxcEpSliderCurrentIndexSelected">
                  <div v-for="(img,index) in imageList"
                      :key="index"
                      :slot="`card${index}_${sliderId}`"
                      :class="['slider',`slider${index}`]">
                      <image class="image" resize="cover" :src="img.src"></image>
                  </div>
          </wxc-ep-slider>
          </div>
      </div>
  </div>
</div>
</template>

<style scoped>
.app {
  flex: 1;
  justify-content: center;
  align-items: center;
  background-color: #E0E0E0;
}
.status-bar {
  width: 750px;
  background-color: #c3413d;
}
.image-large {
  width: 750px;
  height: 450px;
}
.slider-large {
  width: 750px;
  height: 450px;
}
.frame {
  width: 750px;
  height: 450px;
  position: relative;
}

.page-list{
  width: 750px;
  position: absolute;
  top: 100px;
  left: 0px;
  right: 0px;
  bottom: 0px;
}

.slider-items {
  width: 750px;
  position: absolute;
  top: 0;
}

.slider-back {
  background-color: #c3413d;
  opacity: 0;
}

.nav_wrapper_back{
  background-color: #c3413d;
}

.nav_wrapper {
  width: 750px;
  height: 100px;
  align-items: center;
  background-color: transparent;
  flex-direction: row;
}

.nav_title {
  font-size: 35px;
  font-weight: bold;
  margin-left: 250px;
  color: #ffffff;
}

.nav_back {
  width: 40px;
  margin-left: 20px;
  height: 40px;
}

.slider {
  width: 400px;
  height: 300px;
  background-color: #c3413d;
  align-items: center;
  justify-content: center;
  border-top-width: 2px;
  border-top-color: #ffc302;
  border-right-width: 2px;
  border-right-color: #ffc302;
  border-bottom-width: 2px;
  border-bottom-color: #ffc302;
  border-left-width: 2px;
  border-left-color: #ffc302;
  border-top-left-radius: 50px;
  border-top-right-radius: 50px;
  border-bottom-left-radius: 50px;
  border-bottom-right-radius: 50px;
  overflow: hidden;
}

.slider1 {
  background-color: #635147;
}

.slider2 {
  background-color: #ffc302;
}

.slider3 {
  background-color: #ff9090;
}

.slider4 {
  background-color: #546e7a;
}

.image {
  width: 400px;
  height: 300px;
}

.slider-list {
  width: 2250px;
  height: 2000px;
  /* background-color: #546e7a; */
  flex-direction: row;
  align-items: center;
}

.slider-list-item {
  width: 750px;
  height: 2000px;
}
</style>

<script>
import { WxcEpSlider } from "weex-ui";
const animation = weex.requireModule('animation');
export default {
  data() {
    return {
      statusBarHeight: weex.config.eros.statusBarHeight ? weex.config.eros.statusBarHeight : 40,
      sliderId: 1,
      cardLength: 5,
      selectId: 0,
      cardSize: {
        width: 400,
        height: 300,
        spacing: 0,
        scale: 0.8
      },
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
  created() {
    this.cardLength = this.imageList.length;
  },
  mounted(){
    var vm = this;
    var list = vm.$refs.list.ref;
    var slider = vm.$refs.slider.ref;
    var background = vm.$refs.background.ref;
    var title = vm.$refs.title.ref;
    vm.$bindingx.bind({
      eventType: 'scroll',
      anchor: list,
      props: [{
        element: background,
        property: 'opacity',
        expression: {
          origin: 'min(100,y)/100'
        }
      },
      {
        element: slider,
        property: 'transform.translateY',
        expression: {
          origin: 'y<100?0:(0-min(y-100,100))'
        }
      },
      {
        element: title,
        property: 'opacity',
        expression: {
          origin: '1-min(100,y)/100'
        }
      }]
    })
  },
  components: {
    WxcEpSlider
  },
  methods: {
    back(){
      this.$router.back();
    },
    getIndex(e) {
      //   console.log(JSON.stringify(e));
      var content = this.$refs.content;
      this.$refs["wxc-ep-slider"].manualSetPage(e.index);
      animation.transition(content,{
        styles: {
          transform: 'translateX(-'+ e.index*750 +'px)'
        },
        duration: 500,
        timingFunction: 'ease',
        delay: 0
      })
    },
    wxcEpSliderCurrentIndexSelected(e) {
      this.selectId = e.currentIndex;
      var content = this.$refs.content;
      animation.transition(content,{
        styles: {
          transform: 'translateX(-'+ e.currentIndex*750 +'px)'
        },
        duration: 500,
        timingFunction: 'ease',
        delay: 0
      })
      // const index = e.currentIndex;
      // console.log(index);
    }
  }
};
</script>