<template>
  <div ref="test" >
    <gcanvas ref="canvas_holder" style="width:750px;height:750px;background-color:rgba(255,0,0,1)" ></gcanvas>
  </div>
</template>
<script>
const gcanvas = weex.requireModule('gcanvas');
import { enable, GBridge, Image as GImage } from "weex-gcanvas";
module.exports = {
  mounted() {
    var ref = this.$refs.canvas_holder;
    // gcanvas.enbale(ref);
    // var gcanvas = enable(ref);
    var ctx = gcanvas.init(ref).getContext('2d');
    ctx.drawText("Hello");
  }
}
</script>
