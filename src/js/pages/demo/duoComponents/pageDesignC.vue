<template>
    <div class="wrap">
        <div ref="wrap" :class="['action-wrap',isAction?'action':'']" @click="open">
            <text ref="time" class="action-top">62:55</text>
            <div class="action-mid">
                <div class="team-left">
                    <image ref="imageLeft" class="team-logo" src="bmlocal://assets/demo.jpg" ></image>
                    <text ref="nameLeft" class="team-name">France</text>
                </div>
                <text ref="goal" class="goal">1-0</text>
                <div class="team-right">
                    <image ref="imageRight" class="team-logo" src="bmlocal://assets/demo.jpg" ></image>
                    <text ref="nameRight" class="team-name">Uruguay</text>
                </div>
            </div>
            <div ref="button" class="action-bottom" @click="action">
                <text class="button-name">Live</text>
            </div>
        </div>
    </div>
</template>
<script>
const animation = weex.requireModule('animation');
export default {
    data(){
        return {
            isAction: false
        }
    },
    methods:{
        open(){
            var vm = this;
            var wrap = vm.$refs.wrap;
            var time = vm.$refs.time;
            var imageLeft = vm.$refs.imageLeft;
            var nameLeft = vm.$refs.nameLeft;
            var goal = vm.$refs.goal;
            var imageRight = vm.$refs.imageRight;
            var nameRight = vm.$refs.nameRight;
            var button = vm.$refs.button;
            vm.isAction = false;
            animation.transition(button,{
                styles:{
                    opacity: '1',
                    transform: 'translateY(0px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(time,{
                styles:{
                    transform: 'translateY(0px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(goal,{
                styles:{
                    transform: 'translateY(0px) scale(1)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(imageLeft,{
                styles:{
                    transform: 'translate(0px,0px) scale(1)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(imageRight,{
                styles:{
                    transform: 'translate(0px,0px) scale(1)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(nameLeft,{
                styles:{
                    transform: 'translate(0px,0px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(nameRight,{
                styles:{
                    transform: 'translate(0px,0px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
        },
        action(){
            var vm = this;
            var wrap = vm.$refs.wrap;
            var time = vm.$refs.time;
            var imageLeft = vm.$refs.imageLeft;
            var nameLeft = vm.$refs.nameLeft;
            var goal = vm.$refs.goal;
            var imageRight = vm.$refs.imageRight;
            var nameRight = vm.$refs.nameRight;
            var button = vm.$refs.button;
            vm.isAction = true;
            animation.transition(button,{
                styles:{
                    opacity: '0',
                    transform: 'translateY(50px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(time,{
                styles:{
                    transform: 'translateY(40px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(goal,{
                styles:{
                    transform: 'translateY(40px) scale(0.7)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(imageLeft,{
                styles:{
                    transform: 'translate(-50px,50px) scale(0.5)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(imageRight,{
                styles:{
                    transform: 'translate(50px,50px) scale(0.5)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(nameLeft,{
                styles:{
                    transform: 'translate(80px,-50px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
            animation.transition(nameRight,{
                styles:{
                    transform: 'translate(-80px,-50px)'
                },
                duration: 500,
                timingFunction: 'ease'
            })
        }
    }
}
</script>
<style scoped>
    .wrap {
        align-items: center;
        justify-content: center;
    }
    .action-wrap {
        width: 750px;
        height: 500px;
        align-items: center;
        justify-content: space-around;
        background-color: blueviolet;
        left: 0;
        bottom: 0;

        transition-property: height,bottom;
        transition-duration: 500;
        transition-delay: 0;
        transition-timing-function: ease;
    }
    .action {
        height: 200px;
        bottom: 0;
    }
    .action-top {
        color: aliceblue;
    }
    .action-mid {
        width: 750px;
        /* height: 300px; */
        flex-direction: row;
        align-items: center;
        justify-content: space-around;
    }
    .team-left {
        width: 200px;
        align-items: center;
        justify-content: center;
    }
    .team-right {
        width: 200px;
        align-items: center;
        justify-content: center;
    }
    .team-logo {
        width: 150px;
        height: 150px;
        border-top-left-radius: 125px;
        border-top-right-radius: 125px;
        border-bottom-left-radius: 125px;
        border-bottom-right-radius: 125px;
    }
    .team-name {
        font-size: 36px;
        color: aliceblue;
    }
    .goal {
        color: aliceblue;
        font-size: 120px;
    }
    .action-bottom {
        width: 300px;
        height: 50px;
        border-top-left-radius: 25px;
        border-top-right-radius: 25px;
        border-bottom-left-radius: 25px;
        border-bottom-right-radius: 25px;
        background-color: blue;
        align-items: center;
        justify-content: center;
        margin-bottom: 30px;
    }
    .button-name {
        color: aliceblue;
    }
</style>
