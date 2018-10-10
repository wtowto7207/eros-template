<template>
    <div class="container">
        <div class="button" @click="getMacAddress" ></div>
        <text>手机MAC：{{mac}}</text>
        <div class="button" @click="getIPAddress" ></div>
        <text>手机IP：{{ip}}</text>
        <div class="button" @click="getRouterMac" ></div>
        <text>路由器IP：{{routerMac}}</text>
    </div>
</template>
<style scoped>
    .container{
        width: 750px;
        align-items: center;
    }

    .button{
        width: 100px;
        height: 100px;
        background-color: aqua;
        border-radius: 20px;
    }
</style>
<script>
// var mac = weex.requireModule('routerMac');
var mac = weex.requireModule('wifi');
export default {
    data(){
        return{
            mac:'',
            ip:'',
            routerMac:''
        }
    },
    methods:{
        getMacAddress(){
            this.mac = mac.getGatewayIP();
        },
        getIPAddress(){
            // mac.getIpAddress((ret) => {
            //     this.ip = ret
            // })
            this.ip = this.$tools.networkStatus();
        },
        getRouterMac(){
            mac.getConnectedWifiMacAddress((ret) => {
                this.routerMac = ret
            })
        }
    }
}
</script>


