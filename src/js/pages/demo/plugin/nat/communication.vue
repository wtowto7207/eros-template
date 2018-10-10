<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="call">
                <text class="desc">拨打电话</text>
            </div>
            <div class="content">
                <text>接听号码：{{callNum}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="sms">
                <text class="desc">发短信</text>
            </div>
            <div class="content">
                <text>接收号码：{{smsNum}}</text>
                <text>短信内容：{{smsContent}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="email">
                <text class="desc">发邮件</text>
            </div>
            <div class="content">
                <text>接收邮箱：{{emailNum}}</text>
                <text>邮件内容：{{emailContent}}</text>
            </div>
        </div>
    
    </div>
</template>

<style scoped src="./base.css">
   
</style>

<script>
    import nat from "natjs";
    export default {
        data(){
            return{
                callNum:'10010',
                smsNum:'10010',
                smsContent:'这是一条测试短信',
                emailNum:'10010@qq.com',
                emailSubject:'这是邮件标题',
                emailContent:'这是一条测试邮件'
            }
        },
        methods: {
            call() {
                nat.call(this.callNum)
            },
            sms(){
                nat.sms([this.smsNum],this.smsContent,() => {
                    this.$notice.toast({
                        message:this.smsContent
                    })
                })
            },
            email(){
                nat.mail([this.emailNum],{
                    subject:this.emailSubject,
                    body:this.emailContent
                }, () => {
                    this.$notice.toast({
                        message:this.emailContent
                    })
                })
            }
        }
    }
</script>

