<template>
    <div class="wrap">
        <div class="card-body" @click="loop">
            <div class="card-num">
                <text class="card-num-text text-common">49</text>
                <div class="card-num-circle">
                    <div class="card-num-inner-circle"></div>
                </div>                
            </div>
            <text class="card-week text-common">TUESDAY</text>
            <text class="card-day text-common">2-0-1-7/0-9/2-6</text>
            <text class="card-city text-common">CHANGSHA</text>
        </div>
        <div class="top-circle" ref="top"></div>
        <div class="left-circle"></div>
    </div>
</template>
<style scoped>
    .wrap {
        align-items: center;
        justify-content: center;
        position: relative;
    }

    .top-circle {
        width: 100px;
        height: 100px;
        border-top-left-radius: 50px;
        border-top-right-radius: 50px;
        border-bottom-left-radius: 50px;
        border-bottom-right-radius: 50px;
        background-image: linear-gradient(to bottom, #D1F22E,#00F6A1);
        position: absolute;
        top: 240px;
        left: 350px;
        box-shadow: 0 10px 5px rgb(8, 230, 152);
    }

    .left-circle {
        width: 70px;
        height: 70px;
        border-top-left-radius: 50px;
        border-top-right-radius: 50px;
        border-bottom-left-radius: 50px;
        border-bottom-right-radius: 50px;
        background-image: linear-gradient(to bottom, #D1F22E,#00F6A1);
        position: absolute;
        top: 800px;
        left: 100px;
        box-shadow: 0 20px 10px rgba(8, 230, 152,0.5);
    }

    .card-body {
        width: 500px;
        height: 750px;
        border-top-left-radius: 50px;
        border-top-right-radius: 50px;
        border-bottom-left-radius: 50px;
        border-bottom-right-radius: 50px;
        background-image: linear-gradient(to bottom,#00F6A7,#07F4EA);
        padding-left: 50px;
        padding-top: 40px;
        padding-right: 50px;
        padding-bottom: 50px;
    }

    .text-common {
        color: #ffffff;
    }

    .card-num {
        flex-direction: row;
        align-items: flex-start;
    }

    .card-num-text {
        font-size: 150px;
        line-height: 150px;
        font-weight: bold;
    }

    .card-num-circle {
        width: 50px;
        height: 50px;
        border-top-left-radius: 50px;
        border-top-right-radius: 50px;
        border-bottom-left-radius: 50px;
        border-bottom-right-radius: 50px;
        background-image: linear-gradient(to bottom, #D1F22E,#00F6A1);
        box-shadow: 0 10px 5px rgba(8, 230, 152,0.5);
        align-items: center;
        justify-content: center;
        margin-top: 25px;
    }

    .card-num-inner-circle {
        width: 30px;
        height: 30px;
        border-top-left-radius: 50px;
        border-top-right-radius: 50px;
        border-bottom-left-radius: 50px;
        border-bottom-right-radius: 50px;
        border-top-width: 5px;
        border-right-width: 5px;
        border-bottom-width: 5px;
        border-left-width: 5px;
        border-top-color: #ffffff;
        border-right-color: #ffffff;
        border-bottom-color: #ffffff;
        border-left-color: #ffffff;
    }

    .card-week {
        font-size: 36px;
        line-height: 36px;
        margin-top: 10px;
    }

    .card-day {
        font-size: 32px;
        line-height: 32px;
        font-weight: bold;
        margin-top: 15px;
    }

    .card-city {
        position: absolute;
        bottom: 50px;
        left: 50px;
        font-size: 42px;
        line-height: 42px;
        font-weight: bold;
    }
</style>
<script>
const animation = weex.requireModule('animation');
var move;
export default {
    data(){
        return{
            isMove: false
        }
    },
    mounted(){
        // setTimeout(this.move(),600);
    },
    methods:{
        move(){
            var vm = this;
            var top = vm.$refs.top;
            // vm.$notice.toast({
            //     message: 'dsfs'
            // })
            if (vm.isMove) {
                vm.isMove = false;
                move = -100;
            }else {
                vm.isMove = true;
                move = 100;
            }
            animation.transition(top,{
                styles: {
                    transform: 'translateX('+ move +'px)'
                },
                duration: 1000,
                timingFunction: 'ease'
            })
        },
        loop(){
            setInterval(this.move(),1000);
        }
    }
}
</script>
