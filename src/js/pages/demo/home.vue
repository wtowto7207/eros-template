<template>
    <div class="container" >
        <div class="status" :style="{'height': statusBarHeight + 'px'}"></div>
        <!-- <text>lottie动画</text> -->
        <!-- <text>{{status}}</text>
        <div class="button" @click="lottieAnimation" ></div> -->
        <!-- :style="{'height': lottieHeight + 'px'}" -->
        <!-- <lottie src="http://oxqog7f78.bkt.clouddn.com/json/gradient.json" class="lottie" loop=true ref="lottie" ></lottie> -->
        <!-- <div class="content">
            <text>fdfsfs</text>
            <text>fdfsfs</text>
            <text>fdfsfs</text>
        </div> -->
    </div>
</template>
<style scoped>
    .container{
        width: 750px;
    }
    .status {
        width: 750px;
        background-color: #000000;
    }
    .button{
        width: 100px;
        height:100px;
        background-color: aqua;
        border-radius: 20px;
    }
    .lottie{
        width: 750px;
        height: 1333px;
        background-color: aquamarine;
    }
    .content{
        position: absolute;
        top: 0;
        left: 0;
        width: 750px;
    }
</style>
<script>
import { Utils } from "weex-ui";
export default {
    data(){
        return{
            play:false,
            status:'未播放',
            statusBarHeight: weex.config.eros.statusBarHeight ? weex.config.eros.statusBarHeight : 40,
            lottieHeight: 1334
        }
    },
    created(){
        this.lottieHeight = Utils.env.getPageHeight();
    },
    methods:{
        lottieAnimation(e){
            var lottie = this.$refs.lottie;
            if (this.play == false) {
                this.play = true;
                this.status = '正在播放',
                lottie.play();
            }else{
                this.play = false;
                this.status = "已暂停播放";
                lottie.pause();
            }
        }
    }
}
</script>

