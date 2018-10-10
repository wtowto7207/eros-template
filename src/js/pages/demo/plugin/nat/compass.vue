<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="getCompass">
                <text class="desc">获取当前方位角</text>
            </div>
            <div class="content">
                <text>{{compass}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click=" watchCompass">
                <text class="desc"> 监听方位角</text>
            </div>
            <div class="content">
                <text>{{result}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click=" clearCompass">
                <text class="desc"> 取消监听方位角</text>
            </div>
            <div class="content">
                <text>{{clear}}</text>
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
            compass:'暂无方位角信息',
            result:'',
            clear:'暂未取消监听'
        }
    },
    methods:{
        getCompass(){
            var vm = this;
            Nat.compass.get((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
                }
                vm.compass = JSON.stringify(ret);
				Nat.toast(JSON.stringify(ret, null, 2))
			})
        },
        watchCompass(){
            var vm = this;
            let times = 0
			Nat.compass.watch((err, ret) => {
				times++
				if (err) {
					Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					return
				}
                this.result = JSON.stringify(ret);
			})
        },
        clearCompass(){
            Nat.compass.clearWatch((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
                }
                this.clear = '已取消监听';
				Nat.toast('cleared');
			})
        }
    }
}
</script>

