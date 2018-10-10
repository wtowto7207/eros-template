<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="deviceInfo">
                <text class="desc">设备信息</text>
            </div>
            <div class="content">
                <text>{{info}}</text>
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
            info:''
        }
    },
    methods:{
        deviceInfo(){
            var vm = this;
            Nat.device.info((err,ret) => {
                vm.info = ret;
            })
        }
    }
}
</script>

