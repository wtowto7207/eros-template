// 这里的后缀都是 .js 因为打包出来的都是js文件，而不是.vue文件，我们要告诉客户端跳转那个js

//  这里的路径和dev.json路径的区别
//  pages里面配置的是路由跳转的地址，也就是dev生成的 dist文件夹下的js bundle路径 从dist/js开始
//  dev.json 的 exports 需要打包的js地址，填入src的需要被打包成js bundle的地址   从src开始

export default {
    'home': {
        url: '/pages/demo/home.js'
    },
    'demo': {
        title: 'weex-eros demo',
        url: '/pages/demo/index.js'
    },
    'demo.lifecycle': {
        title: '生命周期',
        url: '/pages/demo/lifecycle/index.js'
    },
    'demo.assets': {
        title: '本地资源',
        url: '/pages/demo/assets/index.js'
    },
    'demo.globalAttr': {
        title: '全局属性',
        url: '/pages/demo/globalAttr/index.js'
    },
    'demo.inputExtend': {
        title: '文本框扩展',
        url: '/pages/demo/inputExtend/index.js'
    },
    'demo.refresh': {
        title: '下拉刷新',
        url: '/pages/demo/refresh/index.js'
    },
    'demo.storage': {
        title: '本地化存储',
        url: '/pages/demo/storage/index.js'
    },
    'demo.router': {
        title: '路由',
        url: '/pages/demo/router/index.js'
    },
    'demo.event.a': {
        title: '发布订阅-a页面',
        url: '/pages/demo/event/a.js'
    },
    'demo.event.b': {
        title: '发布订阅-b页面',
        url: '/pages/demo/event/b.js'
    },
    'demo.notice': {
        title: '弹窗通知',
        url: '/pages/demo/notice/index.js'
    },
    'demo.font': {
        title: '字体',
        url: '/pages/demo/font/index.js'
    },
    // 'demo.coms': {
    //     title: '联系功能',
    //     url: '/pages/demo/coms/index.js'
    // },
    'demo.image': {
        title: '图片',
        url: '/pages/demo/image/index.js'
    },
    'demo.bmchart': {
        title: '图表',
        url: '/pages/demo/bmchart/index.js'
    },
    'demo.bmrichtext': {
        title: '富文本',
        url: '/pages/demo/bmrichtext/index.js'
    },
    'demo.bmcalendar': {
        title: '日期',
        url: '/pages/demo/bmcalendar/index.js'
    },
    'demo.other.waterfall': {
        title: 'weex 瀑布流',
        url: '/pages/demo/other/waterfall.js'
    },
    'demo.other.bindingx': {
        title: 'bindingX',
        url: '/pages/demo/other/bindingx.js'
    },
    'demo.other.weex-ui': {
        title: 'weex-ui',
        url: '/pages/demo/other/weexui.js'
    },
    'demo.other.bui': {
        title: 'bui',
        url: '/pages/demo/other/bui.js'
    },
    'plugin.lottie':{
        title: 'lottie',
        url:'/pages/demo/plugin/lottie.js'
    },
    'plugin.router':{
        title:'路由器相关',
        url:'/pages/demo/plugin/router.js'
    },
    'plugin.nat':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/index.js'
    },
    'plugin.nat.communication':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/communication.js'
    },
    'plugin.nat.image':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/image.js'
    },
    'plugin.nat.audio':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/audio.js'
    },
    'plugin.nat.video':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/video.js'
    },
    'plugin.nat.camera':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/camera.js'
    },
    'plugin.nat.recorder':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/recorder.js'
    },
    'plugin.nat.modal':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/modal.js'
    },
    'plugin.nat.stream':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/stream.js'
    },
    'plugin.nat.transfer':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/transfer.js'
    },
    'plugin.nat.geo':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/geo.js'
    },
    'plugin.nat.accelerometer':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/accelerometer.js'
    },
    'plugin.nat.compass':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/compass.js'
    },
    'plugin.nat.info':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/info.js'
    },
    'plugin.nat.network':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/network.js'
    },
    'plugin.nat.vibration':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/vibration.js'
    },
    'plugin.nat.screen':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/screen.js'
    },
    'plugin.nat.volume':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/volume.js'
    },
    'plugin.nat.battery':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/battery.js'
    },
    'plugin.nat.alipay':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/alipay.js'
    },
    'plugin.nat.wechat':{
        title:'Nat',
        url:'/pages/demo/plugin/nat/wechat.js'
    },
    'plugin.gcanvas':{
        title:'Nat',
        url:'/pages/demo/plugin/gcanvas.js'
    },
    'duo.guide':{
        url: '/pages/demo/duoComponents/guide.js'
    },
    'duo.animateList':{
        url: '/pages/demo/duoComponents/animatePageTwo.js'
    },
    'duo.pageDesign':{
        title: 'pageDesign',
        url: '/pages/demo/duoComponents/pageDesign.js'
    },
    'duo.pageDesignList':{
        title: 'pageDesign',
        url: '/pages/demo/duoComponents/pageDesignList.js'
    },
    'duo.pageDesignB':{
        title: 'pageDesign',
        url: '/pages/demo/duoComponents/pageDesignB.js'
    },
    'duo.pageDesignC':{
        url: '/pages/demo/duoComponents/pageDesignC.js'
    }
}