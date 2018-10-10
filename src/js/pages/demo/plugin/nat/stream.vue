<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="stream">
                <text class="desc">网络请求</text>
            </div>
            <div class="content">
                <text>{{result}}</text>
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
                result:''
            }
        },
        methods: {
            stream() {
                // nat.toast('dfefe')
                nat.fetch('https://suggest.taobao.com/sug?q=htc',{
                    method: 'PUT',
                    type: 'json'
                }, (err, res) => {
                    if (err) {
                        nat.toast('[ERROR] ' + JSON.stringify(err))
                        return
                    }
                    this.result = res;
                    nat.toast(JSON.stringify(res))
                })
            }
        }
    }
</script>

