<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="getVolume">
                <text class="desc">获取音量</text>
            </div>
            <div class="content">
                <text>{{info}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="setVolume">
                <text class="desc">设置音量</text>
            </div>
            <div class="content">
                <text>{{setInfo}}</text>
            </div>
        </div>
    </div>
</template>
<style scoped src="./base.css" >
</style>
<script>
import Nat from "natjs";
export default {
    data(){
        return{
            info:'',
            setInfo:''
        }
    },
    methods:{
        getVolume(){
            var vm = this;
            Nat.volume.get((err,ret) => {
                vm.info = ret;
            })
        },
        setVolume(){
            var vm = this;
            Nat.volume.set(1,(err,ret) => {
                vm.setInfo = ret;
            })
        }
    }
}
</script>

