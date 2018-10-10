<template>
    <div class="container">
        <div class="wrap">
            <div class="button" @click="pickImg">
                <text class="desc">选取图片</text>
            </div>
            <div class="content">
                <text>有问题</text>
                <text>{{imgPath}}</text>
                <!-- <text v-for="(item,index) in imgPath" :key="index" >{{item}}</text> -->
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="previewImg">
                <text class="desc">图片预览</text>
            </div>
            <div class="content">
                <text>暂有问题</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="infoImg">
                <text class="desc">查看图片信息</text>
            </div>
            <div class="content">
                <text>{{imgInfo}}</text>
            </div>
        </div>
        <div class="wrap">
            <div class="button" @click="exifImg">
                <text class="desc">查看图片EXIF信息</text>
            </div>
            <div class="content">
                <text>{{imgEXIF}}</text>
            </div>
        </div>
    </div>
</template>

<style scoped src="./base.css">
    
</style>

<script>
    import nat from "natjs";
    export default {
        data() {
            return {
                imgPath: '',
                imgInfo: '',
                imgEXIF: ''
            }
        },
        methods: {
            pickImg() {
                var vm = this;
                nat.image.pick({
                    limit: 3,
                    showCamera: true
                }, (err, ret) => {
                    vm.imgPath = JSON.stringify(err);
                })
            },
            previewImg() {
                nat.image.preview([
				'http://cdn.instapp.io/nat/samples/bnw.jpeg',
				'http://cdn.instapp.io/nat/samples/fibonacci.jpeg',
			].concat(this.path))
            },
            infoImg() {
                nat.image.info('http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=041e9e287acf3bc7fc0dc5afb969d0d4/9e3df8dcd100baa1ae06259e4d10b912c8fc2ee8.jpg', (err, ret) => {
                    this.imgInfo = ret
                })
            },
            exifImg() {
                nat.image.exif('http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=041e9e287acf3bc7fc0dc5afb969d0d4/9e3df8dcd100baa1ae06259e4d10b912c8fc2ee8.jpg', (err, ret) => {
                    this.imgEXIF = ret
                })
            }
        }
    }
</script>

