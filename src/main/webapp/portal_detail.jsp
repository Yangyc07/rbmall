<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : portal_details
    Created on : 2018-3-10, 9:29:33
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品详情页</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<style type="text/css">
    /*公共部分*/
    .fl{
        float: left;
    }
    .fr{
        float: right;
    }
    .clear{
        clear: both;
    }
    .mid{
        margin: 0 auto;   /* 居中对齐*/
    }
    .bolder{
        font-weight: bolder;
    }
    a{
        text-decoration: none;
        color: gray;
        font-size: 14px;
    }
    a:hover{
        color: red;
    }
    body{
        background: #F5F6F6;
    }
    /*顶部内容*/
    .topBar{
        width: 1200px;
        height: 28px;
        background: #CFD2D6;
        text-align: center;
    }
    .totop{
        margin-top: 5px;
        height: inherit;
    }
    .collect{
        width: 100px;
        height: inherit;
        /*background: yellow;*/
        margin-left: 20px;
    }
    .login_register{
        width: auto;
        margin-right: 20px;
        height: inherit;
        /*background: red;*/
    }
    /*导航栏*/
    .topNav{
        width: 1200px;
        height: 120px;
        /*margin-top: 5px;*/
        background: blue;
    }
    .logoBar{
        width: 100px;
        height: 100px;
        background: red;
        margin: 10px 0px 20px 10px;
    }
    /*搜索*/
    .search_box{
        width: 602px;
        height: 42px;
        margin: 40px 0px 0px 220px;
        background: yellow;
        border: 1px solid orange;
    }
    /*搜索公共部分*/
    .s_com{
        height: 40px;
        outline: none;
        border: none;
        border: 1px solid orange;
    }
    #search_text{
        width: 500px;
        font-size: 16px;
        line-height: 20px;
    }
    #search_btn{
        width: 100px;
        background: orange;
        color: white;
        font-size: 20px;
        /*margin: 0;*/
    }
    #search_btn:active{
        background: darkorange;
    }
    /*中间内容*/
    .mid_content{
        width: 1200px;
        height: 400px;
        margin: 10px 0px;
        border: 1px solid #cccccc;
        /*background: yellow;*/
    }
    .mid_com{
        height: 400px;
    }
    .lunbo_img{
        width: 400px;

        /*background: yellow;*/
    }
    .lunbo_img img{
        min-width: 400px;
        min-height: 380px;
        max-width: 400px;
        max-height: 380px;
    }
    .details{
        margin-left: 5px;
        border-left: 1px solid #CCCCCC;
        /*background: red;*/
        width: 500px;
    }
    .s_f{
        margin-left: 20px;
    }
    /*商品详情介绍*/
    .introduce{
        margin-top: 20px;
        margin-bottom: 20px;
        height: 150px;
        /*background: yellow;*/
        word-break:break-all;
        width:400px;
    }
    .price{
        height: 50px;
        /*background: red;*/
        margin-bottom: 20px;
    }
    #c_price{
        color: red;
        font-size: 28px;
    }
    .number{
        height: 50px;
        margin-bottom: 10px;
    }
    .num{
        width: 50px;
    }
    .shop_car{
        height: 50px;
        /*background: orange;*/
    }
    #ShoppingCart{
        width: 160px;
        height: 50px;
        font-size: 20px;
        border: none;
        outline: none;
        color: white;
        background: orange;
    }
    #ShoppingCart:active{
        background: darkorange;
    }
    /*底部导航--备案*/
    .footer{
        background-color: #D4D4D4;
        height: 200px;
        width: 1200px;
        clear: both;
    }
    .bottomcontent{
        padding-top: 50px;
        text-align: center;
        line-height: 24px;
    }
    .bottomcontent img{
        margin-left: 10px;
    }
</style>
<div class="container">
    <!--顶部收藏-->
    <div class="topBar mid">
        <div class="fl">
            <div class="collect totop">
                <a href="#" class="collection bolder">收藏网页</a>
            </div>
        </div>
        <div class="fr">
            <div class="login_register totop">
                欢迎来到该网页！<a href="#">[登录]</a><a href="#">[免费注册]</a>
            </div>
        </div>
    </div>
    、<!--顶部导航-->
    <div class="topNav">
        <div class="logoBar fl">

        </div>
        <div class="search_box fl">
            <input type="search" name="search_text" id="search_text" class="fl s_com" value="" />
            <input type="button" name="search_btn" id="search_btn" class="fr s_com" value="搜    索" />
        </div>
    </div>
    <!--中间内容-->
    <div class="mid_content">
        <div class="mid_box">
            <!--左侧轮播图-->
            <div class="lunbo_img  mid_com fl">
                <!--轮播-->
                <div class="carousel slide" data-ride='carousel' id="mycarousel">
                    <ul class="carousel-indicators">
                        <li data-target = "#mycarousel" data-slide-to = "0" class="active"></li>
                        <li data-target = "#mycarousel" data-slide-to = "1" ></li>
                        <li data-target = "#mycarousel" data-slide-to = "2" ></li>
                        <li data-target = "#mycarousel" data-slide-to = "3" ></li>
                    </ul>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="../img/1.jpg" />
                            <div class="carousel-caption">
                                <p>第一幅图片</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/57b1OOOPICa4.jpg" />
                            <div class="carousel-caption">
                                <p>第二幅图片</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/75D58PICRPz.jpg"/>
                            <div class="carousel-caption">
                                <p>第三幅图片</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/t018b0e2cabb30668cf.png"/>
                            <div class="carousel-caption">
                                <p>第四幅图片</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--右侧商品详情介绍-->
            <div class="details mid_com fl">
                <div class="s_f">
                    <div class="introduce">
                        <h3>${baseInfoDetail.partSubtitle}</h3>
                    </div>
                    <!--价格-->
                    <div class="price">
                        <label>￥</label><span id="c_price" class="bolder">${baseInfoDetail.ordinaryPrice}</span>
                    </div>
                    <!--数量-->
                    <div class="number">
                        已选<input type="text" class="num" />件
                        <span class="">
			    					限购9件
			    				</span>
                    </div>
                    <!--购物车-->
                    <div class="shop_car">
                        <input type="button" id="ShoppingCart" value="加入购物车"  class="bolder"/>
                    </div>
                </div>
                <!--详细介绍-->
            </div>
        </div>
    </div>
    <!--底部链接-->
    <div class="footer">
        <div class="bottomcontent">
            <p>
                <a href="#">网站简介</a><i>|</i>
                <a href="#">网站公告</a><i>|</i>
                <a href="#">招纳贤士</a><i>|</i>
                <a href="#">联系我们</a><i>|</i>
                客服热线：400-675-1234
            </p>
            <p>
                Copyright © 2016 - 2018 xx版权所有&nbsp;&nbsp;&nbsp;
                京ICP备09037834号&nbsp;&nbsp;&nbsp;
                京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;
                某市公安局XX分局备案编号：123456789123
            </p>
            <p class="web">
                <a href="#"><img src="shopclass/webLogo.jpg" alt="logo"></a>
                <a href="#"><img src="shopclass/webLogo.jpg" alt="logo"></a>
                <a href="#"><img src="shopclass/webLogo.jpg" alt="logo"></a>
                <a href="#"><img src="shopclass/webLogo.jpg" alt="logo"></a>
            </p>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $('.carousel').carousel({
// 		'interval':'2000',       定时自动播放
    });
    $('.num').click(function(){
        index=$(this).index('.num');
        $('.carousel').carousel(index);
    });
</script>
</html>
