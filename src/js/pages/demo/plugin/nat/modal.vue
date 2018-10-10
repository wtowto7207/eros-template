<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="natAlert">
                <text class="desc">警示框</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="natConfirm">
                <text class="desc">确认框</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="natPrompt">
                <text class="desc">对话框</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="natToast">
                <text class="desc">吐司条</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="natActionSheet">
                <text class="desc">actionSheet</text>
            </div>
            <div class="content">
                <text></text>
            </div>
        </div>
    </div>
</template>

<style scoped src="./base.css">
    
</style>

<script>
    import nat from "natjs";
    export default {
        methods: {
            natAlert() {
                nat.alert({
                    title: 'title',
                    message: 'alert',
                    okButton: '确定'
                }, (err, ret) => {
                    nat.toast('确定')
                })
            },
            natConfirm() {
                nat.confirm({
                    title: 'Title',
                    message: 'Are you okay?',
                    okButton: 'I\'m OK',
                    cancelButton: 'Not OK'
                }, (err, ret) => {
                    nat.toast(ret ? 'confirmed' : 'canceled')
                })
            },
            natPrompt() {
                nat.prompt({
                    title: 'Title',
                    message: 'Are you feeling lucky?',
                    text: 'sure',
                    okButton: 'Yep',
                    cancelButton: 'Ignore'
                }, (err, ret) => {
                    nat.toast((ret.result) ? ret.data : 'canceled')
                })
            },
            natToast() {
                nat.toast({
                    message: 'What\'s up up',
                    duration: 5000,
                    position: 'top'
                })
            },
            natActionSheet(){
                nat.actionSheet.show({
                    title:'title',
                    options:[
                       '第一项',
                       '第二项',
                       '第三项'
                    ]
                },(err,ret) => {
                    nat.toast(JSON.stringify(ret))
                })
            }
        }
    }
</script>

