<template>
    <div class="container">
        <div class="wrap">
            <!-- <video class="video-wrap" src="http://cdn.instapp.io/nat/samples/video.mp4"></video> -->
        </div>
        <div class="wrap">
            <div class="button" @click="play">
                <text class="desc">播放视频</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="pause">
                <text class="desc">暂停视频</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="stop">
                <text class="desc">停止视频</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
    </div>
</template>
<style scoped src="./base.css">
    
</style>
<script>
import nat from "natjs";
export default {
    methods:{
        play(){
            nat.video.play('http://cdn.instapp.io/nat/samples/video.mp4',() => {
                this.$notice.toast({
                    message:'播放成功'
                })
            })
        },
        pause(){
            nat.video.pause(() => {
                this.$notice.toast({
                    message:'暂停成功'
                })
            })
        },
        stop(){
            nat.video.stop(() => {
                this.$notice.toast({
                    message:'停止成功'
                })
            })
        }
    }
}
</script>

