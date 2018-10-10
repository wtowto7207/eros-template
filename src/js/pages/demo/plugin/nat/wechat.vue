<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="wechat">
                <text class="desc">wechat</text>
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
            info:'待完善'
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

