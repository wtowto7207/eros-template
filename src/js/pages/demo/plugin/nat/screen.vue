<template>
    <div class="container">
        <scroller style="width:750px" >
            <div class="wrap">
                <div class="button" @click="screenInfo">
                    <text class="desc">屏幕信息</text>
                </div>
                <div class="content">
                    <text>{{info}}</text>
                </div>
            </div>
            <div class="wrap">
                <div class="button" @click="brightnessInfo">
                    <text class="desc">获取屏幕亮度信息</text>
                </div>
                <div class="content">
                    <text>{{brightness}}</text>
                </div>
            </div>
            <div class="wrap">
                <div class="button" @click="setBrightness">
                    <text class="desc">设置屏幕亮度信息</text>
                </div>
                <div class="content">
                    <text>{{brightnessSet}}</text>
                </div>
            </div>
            <div class="wrap">
                <div class="button" @click="getOrientation">
                    <text class="desc">获取屏幕方向状态</text>
                </div>
                <div class="content">
                    <text>{{orientation}}</text>
                </div>
            </div>
        </scroller>
    </div>
</template>

<style scoped src="./base.css">
    
</style>

<script>
    import Nat from "natjs";
    export default {
        data() {
            return {
                info: '',
                brightness: '',
                brightnessSet: '暂有问题',
                orientation: ''
            }
        },
        methods: {
            screenInfo() {
                var vm = this;
                Nat.screen.info((err, ret) => {
                    vm.info = ret;
                })
            },
            brightnessInfo() {
                var vm = this;
                Nat.screen.brightness.get((err, ret) => {
                    vm.brightness = ret;
                })
            },
            setBrightness() {
                var vm = this;
                Nat.screen.brightness.set(1, (err, ret) => {
                    vm.brightnessSet = ret;
                })
            },
            getOrientation() {
                var vm = this;
                Nat.screen.orientation.status((err, ret) => {
                    vm.orientation = ret;
                })
            }
        }
    }
</script>

