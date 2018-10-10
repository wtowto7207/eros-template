// appBoard，mediator 不建议进行修改 如果修改了 也请对应修改
module.exports = {
    'eslint': false,
    'webpackWarnings': false,
    'exports': [
        // appBoard
        'js/config/index.js',
        // mediator
        'js/mediator/index.vue',
        // test
        'js/pages/demo/home.vue',
        // home
        'js/pages/demo/index.vue',
        'js/pages/demo/lifecycle/index.vue',
        'js/pages/demo/assets/index.vue',
        'js/pages/demo/globalAttr/index.vue',
        'js/pages/demo/inputExtend/index.vue',
        'js/pages/demo/refresh/index.vue',
        'js/pages/demo/storage/index.vue',
        'js/pages/demo/router/index.vue',
        'js/pages/demo/router/tabbarItem1.vue',
        'js/pages/demo/router/tabbarItem2.vue',
        'js/pages/demo/router/tabbarItem3.vue',
        'js/pages/demo/event/a.vue',
        'js/pages/demo/event/b.vue',
        'js/pages/demo/notice/index.vue',
        'js/pages/demo/font/index.vue',
        'js/pages/demo/image/index.vue',
        'js/pages/demo/bmchart/index.vue',
        'js/pages/demo/bmrichtext/index.vue',
        'js/pages/demo/bmcalendar/index.vue',
        'js/pages/demo/other/bindingx.vue',
        'js/pages/demo/other/weexui.vue',
        'js/pages/demo/other/bui.vue',
        // duo components
        'js/pages/demo/duoComponents/guide.vue',
        //plugin
        'js/pages/demo/plugin/lottie.vue',
        'js/pages/demo/plugin/router.vue',
        //nat plugins
        'js/pages/demo/plugin/nat/index.vue',
        'js/pages/demo/plugin/nat/communication.vue',
        'js/pages/demo/plugin/nat/image.vue',
        'js/pages/demo/plugin/nat/audio.vue',
        'js/pages/demo/plugin/nat/video.vue',
        'js/pages/demo/plugin/nat/camera.vue',
        'js/pages/demo/plugin/nat/recorder.vue',
        'js/pages/demo/plugin/nat/modal.vue',
        'js/pages/demo/plugin/nat/stream.vue',
        'js/pages/demo/plugin/nat/transfer.vue',
        'js/pages/demo/plugin/nat/geo.vue',
        'js/pages/demo/plugin/nat/accelerometer.vue',
        'js/pages/demo/plugin/nat/compass.vue',
        'js/pages/demo/plugin/nat/info.vue',
        'js/pages/demo/plugin/nat/network.vue',
        'js/pages/demo/plugin/nat/vibration.vue',
        'js/pages/demo/plugin/nat/screen.vue',
        'js/pages/demo/plugin/nat/volume.vue',
        'js/pages/demo/plugin/nat/battery.vue',
        'js/pages/demo/plugin/nat/alipay.vue',
        'js/pages/demo/plugin/nat/wechat.vue',
        // gcanvas
        'js/pages/demo/plugin/gcanvas.vue'
    ],
    'alias': {
        'Components': 'js/components',
        'Common': 'js/common',
        'Config': 'js/config',
        'Widget': 'js/widget',
        'Pages': 'js/pages',
        'Utils': 'js/utils'
    },
    'diff': {
        'pwd': '/Users/yangmingzhe/Work/opensource/eros-diff-folder',
        'proxy': 'https://app.weex-eros.com/source'
    },
    'server': {
        'path': './',
        'port': 8889
    },
    'mockServer': {
        'port': 52077,
        'mockDir': './dist/mock'
    },
    'socketServer': {
        'port': 8890,
        'switch': true
    }
}