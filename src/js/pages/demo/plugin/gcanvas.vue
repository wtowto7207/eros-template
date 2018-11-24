<template>
    <div ref="test" style="background-color: #1ba1e2">
  <!-- @touchstart="touchstart" @touchmove="touchmove" @touchend="touchend" -->
        <gcanvas ref="gcanvess" style="width: 750px;height: 750px;background-color:#00ff00" @touchstart="touchstart" @touchmove="touchmove" @touchend="touchend"></gcanvas>
        <!-- <image ref="image" src="https://gw.alicdn.com/tfs/TB1KwRTlh6I8KJjy0FgXXXXzVXa-225-75.png" style="width:100px;height:100px" ></image> -->
        <div class="button" @click="drawRect">
          <text class="button-title">绘制长方形</text>
        </div>
        <div class="button-change-color" @click="changePanColor">
          <text class="button-title">改变画笔颜色为红色</text>
        </div>
    </div>
</template>
<style type="text/css" scoped>
.button {
  position: absolute;
  left: 100px;
  bottom: 50px;
  width: 200px;
  height: 100px;
  background-color: #1ba1e2;
  align-items: center;
  justify-content: center;
}
.button-change-color {
  position: absolute;
  right: 100px;
  bottom: 50px;
  width: 200px;
  height: 100px;
  background-color: #ff0000;
  align-items: center;
  justify-content: center;
}
</style>
<script>
var libGCanvas = require("weex-gcanvas");
var modal = weex.requireModule("modal");
var EnvImage = require("weex-gcanvas/gcanvasimage.js");

function startDraw(ctx) {
  var img = new EnvImage();
  img.src =
    "https://gw.alicdn.com/tfs/TB1KwRTlh6I8KJjy0FgXXXXzVXa-225-75.png";
  // img.addEventListener('load',);
  function draw(){
    console.log('img:' + JSON.stringify(img))
    if (img.complete) {
      ctx.drawImage(img,100,100)
      clearInterval(i);
    }
  }
  var i = setInterval(draw,16);
  
}
module.exports = {
  data: {
    startX: 0,
    startY: 0,
    currentX: 0,
    currentY: 0,
    context: {},
    canvasObj: {},
    padColor: "yellow"
  },
  methods: {
    drawRect() {
      this.context.fillStyle = "blue";
      this.context.fillRect(300, 500, 200, 100);
    },
    changePanColor() {
      this.padColor = "red";
    },
    touchstart(event) {
      this.startX = event.changedTouches[0].pageX;
      this.startY = event.changedTouches[0].pageY;
      this.context.strokeStyle = this.padColor; //设置线的颜色状态
      this.context.lineWidth = 2; //设置线宽状态
    },
    touchmove(event) {
      this.currentX = event.changedTouches[0].pageX;
      this.currentY = event.changedTouches[0].pageY; //进行绘制
      this.context.moveTo(this.startX, this.startY);
      this.context.lineTo(this.currentX, this.currentY);
      this.context.stroke();
      this.startX = event.changedTouches[0].pageX;
      this.startY = event.changedTouches[0].pageY;
    },
    touchend(event) {
      // this.$notice.toast({
      //   message: '画完了'
      // })
    }
  },
  mounted: function() {
    var self = this; /*获取元素引用*/ //以下是核心代代码，需在合适的时机调用，我这里在自己定义的界面加载完成的全局事件中调用了
    var size = {width:750,height:750};
    var ref = self.$refs.gcanvess; /*通过元素引用获取canvas对象*/
    self.canvasObj = libGCanvas.start(
      ref
    ); /*获取绘图所需的上下文，目前不支持3d*/
    self.context = self.canvasObj.getContext("2d");
    // startDraw(self.context);
    /*设置字体大小*/
    // self.context.font = "56px"; /*在指定位置绘制文字*/
    // self.context.strokeText("Hello Word", 200, 100); /*指定绘制图形的线的宽度*/
    // self.context.lineWidth = 10; /*在指定位置绘制矩形*/
    // self.context.fillStyle = '#ff0000';
    // self.context.fillRect(200, 200, 200, 90); /*绘制三角形*/
    // self.context.beginPath();
    // self.context.moveTo(20, 20);
    // self.context.lineTo(20, 100);
    // self.context.lineTo(70, 100);
    // self.context.closePath();
    // self.context.stroke();
    // 画个笑脸
    self.context.fillStyle = "#0fff0f";
    self.context.arc(75,75,50,0,Math.PI*2, true);
    self.context.moveTo(110,75);
    self.context.arc(75,75,35,0,Math.PI, false);
    self.context.moveTo(65,65);
    self.context.arc(60,65,5,0,Math.PI*2,true);
    self.context.moveTo(95,65);
    self.context.arc(90,65,5,0,Math.PI*2,true);
    self.context.stroke();
  }
};
</script>