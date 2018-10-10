<template>
    <cell>
        <eros-header title="Duo组件"></eros-header>
        <wxc-cell title="引导页"
            desc="用于引导用户了解软件特色"
            :has-arrow="true"
            :has-top-border="true"
            @wxcCellClicked="jump('guide')">
        </wxc-cell>
        <!-- <wxc-cell title="富文本"
            desc="bmrichtext."
            :has-arrow="true"
            :has-top-border="true"
            @wxcCellClicked="jump('bmrichtext')">
        </wxc-cell>
        <wxc-cell title="日历"
            desc="bmcalendar."
            :has-arrow="true"
            :has-top-border="true"
            @wxcCellClicked="jump('bmcalendar')">
        </wxc-cell>
        <wxc-cell title="弹窗"
            desc="bmpop、bmmask."
            :has-arrow="true"
            :has-top-border="true"
            @wxcCellClicked="showMask">
        </wxc-cell> -->
    </cell>
</template>
<script>
import { WxcCell } from 'weex-ui'
import ErosHeader from './header'
export default {
    components: { WxcCell, ErosHeader },
    methods: {
        jump(name) {
            this.$router.open({
                name: `duo.${name}`
            })
        },
        showMask () {
            this.$event.emit('popBmMask')
        }
    }
}
</script>

