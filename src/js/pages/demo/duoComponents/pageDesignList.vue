<template>
    <div class="wrap">
        <list class="list">
            <cell>
                <wxc-cell title="设计页A"
                    desc="设计页"
                    :has-arrow="true"
                    :has-top-border="true"
                    @wxcCellClicked="jump('pageDesign')">
                </wxc-cell>
            </cell>
            <cell>
                <wxc-cell title="设计页B"
                    desc="设计页"
                    :has-arrow="true"
                    :has-top-border="true"
                    @wxcCellClicked="jump('pageDesignB')">
                </wxc-cell>
            </cell>
            <cell>
                <wxc-cell title="设计页C"
                    desc="设计页"
                    :has-arrow="true"
                    :has-top-border="true"
                    @wxcCellClicked="jump('pageDesignC')">
                </wxc-cell>
            </cell>
        </list>
    </div>
</template>
<style scoped>
    .list {
        width: 750px;
    }
</style>
<script>
import { WxcCell } from 'weex-ui'
export default {
    components: { WxcCell },
    methods: {
        jump(name) {
            this.$router.open({
                name: `duo.${name}`,
                gesBack: false
            })
        },
        showMask () {
            this.$event.emit('popBmMask')
        }
    }
}
</script>

