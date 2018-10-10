<template>
    <div class="container">
        <scroller style="width:750px">
            <div class="wrap">
                <div class="button" @click="pick">
                    <text class="desc">选择文件</text>
                </div>
                <div class="content">
                    <text>{{pickInfo}}</text>
                </div>
            </div>
            <div class="wrap">
                <div class="button" @click="download">
                    <text class="desc">下载</text>
                </div>
                <div class="content">
                    <text>{{downloadInfo}}</text>
                </div>
            </div>
            <div class="wrap">
                <div class="button" @click="upload">
                    <text class="desc">上传</text>
                </div>
                <div class="content">
                    <text>{{uploadInfo}}</text>
                </div>
            </div>
        </scroller>
    </div>
</template>

<style scoped src="./base.css">
    
</style>

<script>
    import nat from "natjs";
    export default {
        data() {
            return {
                filePath: null,
                url: 'http://120.26.129.194:3600/',
                uploadInfo: '',
                downloadInfo: '',
                pickInfo: ''
            }
        },
        methods: {
            download() {
                nat.download('http://cdn.instapp.io/nat/samples/audio.mp3', {
                        headers: {
                            'x-app': 'nat/0.0.8',
                            'x-sign': 'bfbbf4c1f087d972'
                        },
                        target: '/instapp/nat/download'
                    }, {
                        onProgress: (p) => {
                            nat.toast('Progressing: ' + p)
                        }
                    }).then((res) => {
                        nat.alert(JSON.stringify(res));
                        this.downloadInfo = JSON.stringify(res);
                    })
                    .catch((e) => {
                        nat.toast('[ERROR] ' + JSON.stringify(e))
                    })
            },
            upload() {
                if (!this.filePath) {
                    nat.toast('Please pick file first :)')
                    return
                }
                for (let i = 0; i < this.filePath.length; i++) {
                    nat.upload(this.url, {
                        path: this.filePath[i],
                        formData: {
                            framework: 'nat'
                        },
                        headers: {
                            'nat-version': '0.0.1'
                        }
                    }, {
                        onProgress: (p) => {
                            nat.toast('Progressing: ' + p)
                        }
                    }, (err, res) => {
                        if (err) {
                            nat.toast('[ERROR] ' + JSON.stringify(err))
                            return
                        }
                        nat.toast(JSON.stringify(res));
                        this.uploadInfo = JSON.stringify(res)
                    })
    
                }
    
            },
            pick() {
                var vm = this;
                vm.$image.pick({
                    maxCount: 9
                }).then(resData => {
                    vm.filePath = resData;
                    vm.pickInfo = JSON.stringify(resData);
                }, error => {
                    nat.toast(error)
                })
                // nat.image.pick({
                //     showCamera: true
                // }, (err, ret) => {
                //     if (err) {
                //         nat.toast('[ERROR] ' + JSON.stringify(err))
                //         return
                //     }
                //     nat.toast(JSON.stringify(ret))
                //     this.filePath = ret.paths[0]
                // })
            }
    
        }
    }
</script>

