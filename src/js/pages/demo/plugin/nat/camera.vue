<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="photo">
                <text class="desc">拍照</text>
            </div>
            <div class="content">
                <text>暂有问题</text>
                <text>{{photoes}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="video">
                <text class="desc">录像</text>
            </div>
            <div class="content">
                <text>暂有问题</text>
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
            photoes:''
        }
    },
    methods:{
        photo(){
            var vm = this;
            nat.camera.captureImage({}, (err,ret) => {
                if(err){
                    nat.toast('[error]' + JSON.stringify(err));
                    return
                }
                nat.toast(JSON.stringify(ret,null,2))
                vm.photoes = ret.path;
            })
        },
        video(){
            nat.camera.captureVideo({},(err,ret) => {
                this.$notice.toast({
                    message:'录像'
                })
            })
        }
    }
}
</script>

