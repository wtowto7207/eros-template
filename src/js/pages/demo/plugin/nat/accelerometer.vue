<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="getAccelerometer">
                <text class="desc">获取当前加速度</text>
            </div>
            <div class="content">
                <text>{{accelerometer}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click=" watchAccelerometer">
                <text class="desc"> 监听加速度</text>
            </div>
            <div class="content">
                <text>{{result}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click=" clearAccelerometer">
                <text class="desc"> 取消监听加速度</text>
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
            accelerometer:'暂无定位信息',
            result:'',
            clear:'未取消监听'
        }
    },
    methods:{
        getAccelerometer(){
            var vm = this;
            Nat.accelerometer.get((err, ret) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
                }
                vm.accelerometer = JSON.stringify(ret);
				Nat.toast(JSON.stringify(ret, null, 2))
			})
        },
        watchAccelerometer(){
            var vm = this;
            let times = 0
			Nat.accelerometer.watch((err, ret) => {
				times++
				if (err) {
					Nat.toast('[ERROR] TIMES: ' + times + '\n' + JSON.stringify(err))
					return
				}
                this.result = 'TIMES: ' + times + '\n\nx: ' + ret.x + '\ny: ' + ret.y + '\nz: ' + ret.z;
			})
        },
        clearAccelerometer(){
            Nat.accelerometer.clearWatch((err) => {
				if (err) {
					Nat.toast('[ERROR] ' + JSON.stringify(err))
					return
				}
                Nat.toast('cleared');
                this.clear = '已取消监听'
			})
        }
    }
}
</script>

