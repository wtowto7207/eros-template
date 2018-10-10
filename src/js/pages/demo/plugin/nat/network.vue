<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="networkInfo">
                <text class="desc">网络信息</text>
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
        networkInfo(){
            var vm = this;
            Nat.network.status((err,ret) => {
                vm.info = ret;
            })
        }
    }
}
</script>

