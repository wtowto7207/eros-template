<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="play">
                <text class="desc">开始录音</text>
            </div>
            <div class="content">
                <text>{{startStatu}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="pause">
                <text class="desc">暂停录音</text>
            </div>
            <div class="content">
                <text>{{pauseStatu}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="stop">
                <text class="desc">停止录音</text>
            </div>
            <div class="content">
                <text>{{stopStatu}}</text>
            </div>
        </div>
    </div>
</template>
<style scoped src="./base.css">
</style>
<script>
import nat from "natjs";
export default {
    data(){
        return{
            startStatu:'未开始',
            pauseStatu:'未暂停',
            stopStatu:'未停止'
        }
    },
    methods:{
        play(){
            var vm = this;
            nat.recorder.start({
                channel:'mono'
            },() => {
                vm.startStatu = '已开始录音'
            })
        },
        pause(){
            var vm = this;
            nat.recorder.pause(() => {
                vm.pauseStatu = '已暂停录音'
            })
        },
        stop(){
            var vm = this;
            nat.recorder.stop((err,ret) => {
                vm.stopStatu = ret.path;
            })
        }
    }
}
</script>

