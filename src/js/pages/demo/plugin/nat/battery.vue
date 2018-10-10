<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="batteryInfo">
                <text class="desc">电池信息</text>
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
        batteryInfo(){
            var vm = this;
            Nat.battery.status((err,ret) => {
                vm.info = ret;
            })
        }
    }
}
</script>

