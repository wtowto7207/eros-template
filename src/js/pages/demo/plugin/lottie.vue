<template>
    <div class="container" >
        <!-- <text>lottie动画</text> -->
        <!-- <text>{{status}}</text>
        <div class="button" @click="lottieAnimation" ></div> -->
        <lottie src="http://wtowto7207.cn/lottie/finger_print.json" speed="0.5" class="lottie" @click="lottieAnimation" loop=true ref="lottie" ></lottie>
        <div class="content">
            <text>{{lottieJson}}</text>
        </div>
    </div>
</template>
<style scoped>
    .container{
        width: 750px;
        align-items: center;
        background-color: aqua;
    }
    .button{
        width: 100px;
        height:100px;
        background-color: aqua;
        border-radius: 20px;
    }
    .lottie{
        width: 500px;
        height: 500px;
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
            play:true,
            status:'未播放',
            lottieHeight: 1334,
            lottieJson: 'dss'
        }
    },
    created(){
        // this.lottieJson = 'http://oxqog7f78.bkt.clouddn.com/json/gradient.json';
        this.lottieHeight = Utils.env.getPageHeight();
    },
    eros: {
        appeared(){
            // this.$refs['lottie'].play();
            this.lottieAnimation();
        }
    },
    methods:{
        lottieAnimation(e){
            var lottie = this.$refs.lottie;
            if (this.play) {
                this.play = false;
                this.status = '正在播放',
                lottie.play();
                
            }else{
                this.play = true;
                this.status = "已暂停播放";
                lottie.pause();
            }
        }
    }
}
</script>

