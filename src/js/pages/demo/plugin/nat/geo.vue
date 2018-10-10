<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="getLocation">
                <text class="desc">获取当前定位</text>
            </div>
            <div class="content">
                <text>{{location}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click=" watchLocation">
                <text class="desc"> 监听定位</text>
            </div>
            <div class="content">
                <text>{{result}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click=" clearLocation">
                <text class="desc"> 取消监听定位</text>
            </div>
            <div class="content">
                <text>待测试</text>
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
            location:'暂无定位信息',
            result:''
        }
    },
    methods:{
        getLocation(){
            var vm = this;
            Nat.geolocation.get((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
                }
                vm.location = JSON.stringify(ret);
				Nat.toast(JSON.stringify(ret, null, 2))
			})
        },
        watchLocation(){
            var vm = this;
            let times = 0
			Nat.geolocation.watch((err, ret) => {
				times++
				if (err) {
					Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					return
				}
                this.result = JSON.stringify(ret);
			})
        },
        clearLocation(){
            Nat.geolocation.clearWatch((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}
				Nat.toast('cleared')
			})
        }
    }
}
</script>

