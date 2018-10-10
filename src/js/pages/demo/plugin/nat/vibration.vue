<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="vibrate">
                <text class="desc">振动</text>
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
        vibrate(){
            var vm = this;
            Nat.vibrate(2000);
            Nat.toast('振动中')
        }
    }
}
</script>

