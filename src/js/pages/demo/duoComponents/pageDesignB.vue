<template>
    <div class="wrap">
        <div class="circle-left">
             <text class="text">Marker</text>
        </div>
        <div class="circle-right">
            <text class="text-right">你好</text>
        </div>
    </div>
</template>
<style scoped>
    .wrap {
        align-items: center;
        justify-content: center;
        overflow: hidden;
    }

    .text {
        font-size: 90px;
        font-family: MarkerFeltWide;
        margin-right: 100px;
        margin-top: 200px;
    }
    .text-right {
        font-size: 90px;
        margin-left: 180px;
        margin-top: 200px;
    }

    .circle-left {
        width: 700px;
        height: 700px;
        border-top-left-radius: 350px;
        border-top-right-radius: 350px;
        border-bottom-left-radius: 350px;
        border-bottom-right-radius: 350px;
        background-color: #ffffff;
        box-shadow: 0 0 50px rgba(0,0,0,0.5);
        position: absolute;
        top: -300px;
        left: -300px;
        align-items: flex-end;
        justify-content: center;
    }

    .circle-right {
        width: 700px;
        height: 700px;
        border-top-left-radius: 350px;
        border-top-right-radius: 350px;
        border-bottom-left-radius: 350px;
        border-bottom-right-radius: 350px;
        background-color: #ffffff;
        box-shadow: 0 0 50px rgba(0,0,0,0.5);
        position: absolute;
        bottom: -300px;
        right: -300px;
    }
</style>
<script>
const dom = weex.requireModule('dom');
export default {
    data(){
        return{

        }
    },
    beforeCreate(){
        dom.addRule('fontFace',{
            'fontFamily': 'MarkerFeltWide',
            'src': "url('bmlocal://iconfont/MarkerFeltWide.ttf')"
        })
    }
}
</script>
