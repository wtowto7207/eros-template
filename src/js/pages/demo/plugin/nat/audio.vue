<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="play">
                <text class="desc">播放音频</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="pause">
                <text class="desc">暂停音频</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="stop">
                <text class="desc">停止音频</text>
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
            nat.audio.play('http://cdn.instapp.io/nat/samples/audio.mp3', () => {
                this.$notice.toast({
                    message:'播放成功'
                })
            })
        },
        pause(){
            nat.audio.pause(() => {
                this.$notice.toast({
                    message:'暂停成功'
                })
            })
        },
        stop(){
            nat.audio.stop(() => {
                this.$notice.toast({
                    message:'停止成功'
                })
            })
        }
    }
}
</script>

