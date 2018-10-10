<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="pay">
                <text class="desc">alipay</text>
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
            info:'待完善信息'
        }
    },
    methods:{
        pay(){
            var vm = this;
            Nat.alipay.pay({
                info:{},
                scheme: ''
            },(err,ret) => {
                if(err){
                    Nat.toast('[ERROR]' + JSON.stringify(err))
                    return
                }
                Nat.toast(JSON.stringify(ret))
            })
        }
    }
}
</script>

