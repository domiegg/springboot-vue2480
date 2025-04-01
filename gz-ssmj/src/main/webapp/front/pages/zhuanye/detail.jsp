<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>

<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<body>

<div id="app">

    <div class="data-detail">
        <div class="data-detail-breadcrumb">
					<span class="layui-breadcrumb">
						<a href="../home/home.jsp">首页</a>
						<a><cite>{{title}}</cite></a>
					</span>


        </div>
        <div class="layui-row">
            <div class="layui-col-md5">
                <div class="layui-carousel" id="swiper">
                    <div carousel-item id="swiper-item">
                        <div v-for="(item,index) in swiperList" v-bind:key="index">
                            <img class="swiper-item" :src="item.img">
                        </div>
                    </div>
                </div>


            </div>
            <div class="layui-col-md7" style="padding-left: 20px;">
                <h1 class="title">{{title}}</h1>

                <div class="detail-item">
                    <span>就业前景：</span>
                    <span class="desc">
								{{detail.prospects}}
							</span>
                </div>

                <div class="detail-item">
                    <span>培养目标：</span>
                    <span class="desc">
								{{detail.aobjective}}
							</span>
                </div>

                <div class="detail-item">


                </div>

                <div class="detail-item" style="text-align: right;">


                <button @click="onAcrossTap(detail.id)" type="button"
                        class="layui-btn">
                    专业报名
                </button>


                </div>
            </div>
        </div>


        <div class="layui-row">
            <div class="layui-tab layui-tab-card">

                <ul class="layui-tab-title">

                    <li class="layui-this">个人介绍</li>

                </ul>

                <div class="layui-tab-content">

                    <div class="layui-tab-item layui-show">
                        <div v-html="detail.noticeContent"></div>
                    </div>


                </div>
            </div>
        </div>
    </div>

</div>


<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 组件配置信息 -->
<script src="../../js/config.js"></script>
<!-- 扩展插件配置信息 -->
<script src="../../modules/config.js"></script>
<!-- 工具方法 -->
<script src="../../js/utils.js"></script>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [],
            // 数据详情
            detail: {
                id: 0
            },
            // 商品标题
            title: '',
            // 倒计时
            count: 0,
            // 加入购物车数量
            buynumber: 1,
            // 当前详情页表
            detailTable: 'zhuanye',
            // 评价列表
            dataList: [],
            // 选座座位列表
            numberList: []
        },
        // 倒计时效果
        computed: {
            SecondToDate: function () {
                var time = this.count;
                if (null != time && "" != time) {
                    if (time > 60 && time < 60 * 60) {
                        time =
                            parseInt(time / 60.0) +
                            "分钟" +
                            parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
                            "秒";
                    } else if (time >= 60 * 60 && time < 60 * 60 * 24) {
                        time =
                            parseInt(time / 3600.0) +
                            "小时" +
                            parseInt(
                                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                            ) +
                            "分钟" +
                            parseInt(
                                (parseFloat(
                                    (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    ) -
                                    parseInt(
                                        (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    )) *
                                60
                            ) +
                            "秒";
                    } else if (time >= 60 * 60 * 24) {
                        time =
                            parseInt(time / 3600.0 / 24) +
                            "天" +
                            parseInt(
                                (parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
                                24
                            ) +
                            "小时" +
                            parseInt(
                                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                            ) +
                            "分钟" +
                            parseInt(
                                (parseFloat(
                                    (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    ) -
                                    parseInt(
                                        (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    )) *
                                60
                            ) +
                            "秒";
                    } else {
                        time = parseInt(time) + "秒";
                    }
                }
                return time;
            }
        },
        //  清除定时器
        destroyed: function () {
            window.clearInterval(this.inter);
        },
        methods: {
            jump(url) {
                jump(url)
            },
            isAuth(tablename, button) {
                return isFrontAuth(tablename, button)
            },
            // 倒计时初始化
            countDown() {
                let reversetime = new Date(this.detail.reversetime).getTime()
                let now = new Date().getTime();
                let count = reversetime - now;
                if (count > 0) {
                    this.count = count / 1000
                    var _this = this;
                    this.inter = window.setInterval(function () {
                        _this.count = _this.count - 1;
                        if (_this.count < 0) {
                            window.clearInterval(_this.inter);
                            layer.msg("活动已结束", {
                                time: 2000,
                                icon: 5
                            })
                        }
                    }, 1000);
                }
            },

            // 下载文件
            downFile(url) {
                var download = $("#download");
                download.append(
                    "<a id=\"down\" href=\"aaaa.txt\" target=\"_blank\" download=\"aaaa.txt\" style=\"display:none\">下载该文件</a>");
                console.log(download);
                $("#down")[0].click();
            },
            // 跨表
            onAcrossTap(id) {
                var mymessage = confirm("真的要报名吗？");
                if (mymessage == true) {
                    layui.http.request('baoming/apply?id='+id, 'POST', {}, (res) => {
                        if(res.code == 0 ){
                            alert('成功报名🎊');
                        }
                 });
                } else {
                    alert("已取消操作");
                }
            },




        }
    })

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var laypage = layui.laypage;

        var limit = 10;

        // 数据ID
        var id = http.getParam('id');
        vue.detail.id = id;

        // 商品信息
        http.request(`${vue.detailTable}/info/` + id, 'get', {}, function (res) {
            // 详情信息
            vue.detail = res.data
            vue.title = vue.detail.name;
            // 轮播图片
            vue.swiperList = vue.detail.zyPhoto ? vue.detail.zyPhoto.split(",") : [];
            var swiperItemHtml = '';
            for (let item of vue.swiperList) {
                swiperItemHtml +=
                    '<div>' +
                    '<img class="swiper-item" src="' + item + '">' +
                    '</div>';
            }
            jquery('#swiper-item').html(swiperItemHtml);
            // 轮播图
            carousel.render({
                elem: '#swiper',
                width: swiper.width, height: swiper.height,
                arrow: swiper.arrow,
                anim: swiper.anim,
                interval: swiper.interval,
                indicator: swiper.indicator
            });


        });


    });
</script>
</body>
</html>
