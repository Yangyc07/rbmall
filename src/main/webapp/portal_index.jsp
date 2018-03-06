<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/22
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>左右侧菜单</title>

    <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <style type="text/css">
        /*顶部登录*/
        .topBar{
            height: 31px;
            background-color: #F7F7F7;
            line-height: 31px;
        }
        .topBar a{
            color: #656565;
        }
        .topBar a:hover{
            color: red;
            text-decoration: none;
        }
        /*收藏*/
        .collect{
            float: left;
            position: relative;
            left: 115px;
            font-weight: bold;
        }
        /*登录、注册*/
        .login-register{
            /*float: right;*/
            position: relative;
            left: 840px;
        }
        /*logo导航     logo的位置、大小*/
        .logoBar{
            height: 85px;
            width: 150px;   /* 有logo时logo的像素    150x85*/
            /*background-color: #1D7AD9;*/
            background: yellow;
            margin-left: 100px;
            margin-top: 30px;
        }
        /*logo图片的css*/
        /*.logoBar img{
            margin-left: 100px;
        }*/

        /*注   logo位置修改时要同时改变#top、#bottom的left值*/
        /*#logo{
            width: 150px;
            height: 100px;
            background: yellow;
            margin-left: 100px;
        }*/
        /*搜索栏*/
        .top_bar{
            height: 150px;
            width: 1200px;
            margin: 0 auto;
            background: #0044CC;
        }
        #top{
            position: relative;
            /*left: 400px;*/    /*无logo时*/
            left: 100px;         /*有logo时*/
            top: 20px;
            /*background: green;*/
        }
        #top li{
            margin: 5px;
            padding: 5px;
            float: left;
            color:white;
        }
        #top li:hover{
            background: orange;
        }
        #top li a{
            color: white;
        }
        /*搜索*/
        #bottom{
            position: relative;
            top: 75px;
            /*left: -10px;  */     /*无logo时*/
            left: -310px;     /* 有logo时*/
        }
        #search_btn,#search_text{
            border: none;
            margin:10px;
            padding: 8px;
        }

        #search_text{
            width: 400px;
        }
        #search_btn{
            position: relative;
            left: -2px;
            width: 100px;
            background-color: #FF8C00;
            color: white;
        }
        #search_btn:active{
            background-color: orange;
        }
    </style>
    <style type="text/css">
        ul {
            margin: 0;
            padding: 0;
            list-style-type: none;
        }

        a {
            text-decoration: none;
        }
        p{
            font-size: 12px;
        }
        span{
            font-size: 14px;
        }
        /*中部*/
        .class_lf{
            width: 1200px;
            height: 400px;
            background-color: #F7F7F7;
            margin: 0 auto;
            margin-bottom: 15px;
        }
        /*左侧大框*/
        .containor{
            width: 650px;
            position: relative;
            margin-top: 15px;
            margin-left: 100px;
            /*margin-bottom: 15px;*/
            /*float: right;*/
        }

        /*左侧导航*/
        .nav_left {
            width: 150px;
            height: 400px;
            background: #1369C0;
            border-left: 1px solid #F5F6F6;
            border-top: 1px solid #F5F6F6;
            border-bottom: 1px solid #F5F6F6;
        }

        .nav_left ul {
            width: 100%;
            height: auto;
        }
        .nav_left ul li {
            height: 30px;
            line-height: 30px;
            text-align: left;
        }
        .nav_left ul li span {
            padding-left: 20px;
            height: 30px;
            line-height: 30px;
            display: block;
            background:#1369C0;
            color: #fff;
        }
        .nav_left ul li span:hover {
            color: #FF0036;
            background: #FFFFFF;
        }
        /*右侧内容*/
        .nav_right {
            width: 500px;
            height: 400px;
            position: absolute;
            margin-left: 151px;
            top: 0px;
            /*background: yellow;*/
            /*float: left;*/
        }
        .sub {
            position: relative;
            overflow: hidden;
            width: 100%;
            height: 398px;
            background: #FFFFFF;
            border-right: 1px solid #F5F6F6;
            border-top: 1px solid #F5F6F6;
            border-bottom: 1px solid #F5F6F6;
        }
        .sub dl {
            overflow: hidden;
            padding: 0px 0px 10px 0px;
        }
        .sub dt {
            width: 100px;
            float: left;
            display: block;
            position: relative;
            clear: left;
        }
        .sub dt a {
            font-size: 14px;
            color: #000;
            font-weight: bold;
            text-align: center;
            padding-left: 20px;
            text-decoration: none;
            cursor: pointer;
        }
        .sub dt i {
            width: 4px;
            right: 12px;
            top: 2px;
            font-size: 14px;
            position: absolute;
            font-style: normal;
        }
        .sub dd {
            width: 680px;
            float: left;
            display: block;
            position: relative;
            overflow: hidden;
            padding-right: 20px;
            border-bottom: 1px dashed #E3E3E3;
        }
        .sub dd a {
            font-size: 12px;
            float: left;
            color: #666;
            padding: 0 10px;
            margin: 4px 0px 10px 0px;
            text-decoration: none;
            cursor: pointer;
            border-left: 1px solid #E3E3E3;
        }
        .sub dd a:hover {
            color: #FF0036;
        }

        .hide {
            display: none;
        }
        .show {
            display: block;
        }

        /*中间内容*/
        .Mid_content{
            width:850px;
            height: 400px;
            position:relative ;
            margin-right: 99px;
            /*background: yellow;*/
        }
        .fl{
            float: left;
        }
        .fr{
            float: right;
        }
        .clear{
            clear: both;
        }


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
        body{
            overflow-x: hidden;
        }
    </style>

</head>
<body>
<div class="">
    <div class="headerBar">
        <!--顶部导航-->
        <div class="topBar">
            <!--共用div-->
            <div class="comWidth">
                <!--收藏-->
                <div class="collect">
                    <a href="#" class="collection">收藏网页</a>
                </div>
                <!--登录、注册-->
                <div class="login-register">
                    欢迎来到该网页！<a href="#">[登录]</a><a href="#">[免费注册]</a>
                </div>
            </div>
        </div>
    </div>
    <!--导航条-->
    <div class="top_bar">
        <!--logo-->
        <div class="logoBar fl">
            <img src=""  id="logo"/>
        </div>
        <!--导航-->
        <div id="top">
            <ul>
                <li><a href="#">帐号</a></li>
                <li><a href="#">首页</a></li>
                <li><a href="#">购买历史</a></li>
                <li><a href="#">购物车</a></li>
                <li><a href="#">配件分类</a></li>
                <li><a href="#">客服</a></li>
            </ul>
        </div>
        <div id="bottom">
            <div class="search_box">
                <input type="search" name="search_text" id="search_text" value="" />
                <input type="button" name="search_btn" id="search_btn" value="搜索" />
            </div>
        </div>
    </div>
    <!--分类，当前归类-->
    <div class="classify">

    </div>
    <!--中部导航-->
    <div class="class_lf">
        <!--中间内容显示-->
        <div class="Mid_content fr">

        </div>
        <!--左侧菜单-->
        <div class="containor">
            <div class="nav_left">
                <ul>
                    <li data-id="1"> <span>发动机系统</span></li>
                    <li data-id="2"> <span>进排气系统</span></li>
                    <li data-id="3"> <span>点火系统 </span></li>
                    <li data-id="4"> <span>传动系统 </span></li>
                    <li data-id="5"> <span>制动系统 </span></li>
                    <li data-id="6"> <span>转向系统 </span></li>
                </ul>
            </div>
            <div class="nav_right">
                <div class="sub hide" data-id="1">
                    <dl>
                        <dt><a >发动机一 <i> &gt;</i></a> </dt>
                        <dd>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                        </dd>
                    </dl>
                </div>

                <div class="sub hide" data-id="2">
                    <dl>
                        <dt><a >车头 <i> &gt;</i></a> </dt>
                        <dd>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                        </dd>
                    </dl>

                </div>

                <div class="sub hide" data-id="3">
                    <dl>
                        <dt><a >车身 <i> &gt;</i></a> </dt>
                        <dd>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                        </dd>
                    </dl>

                </div>
                <div class="sub hide" data-id="4">
                    <dl>
                        <dt><a >油箱 <i> &gt;</i></a> </dt>
                        <dd>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>

                        </dd>
                    </dl>

                </div>
                <div class="sub hide" data-id="5">
                    <dl>
                        <dt><a >机身 <i> &gt;</i></a> </dt>
                        <dd>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                        </dd>
                    </dl>

                </div>
                <div class="sub hide" data-id="6">
                    <dl>
                        <dt><a >零件 <i> &gt;</i></a> </dt>
                        <dd>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                            <a>产品</a>
                        </dd>
                    </dl>

                </div>

            </div>
        </div>

    </div>

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
<!--菜单-->


<script type="text/javascript">
    $(function() {
        $('.containor').on('mouseenter', function() {
            $(".nav_right").removeClass('hide');
        }).on('mouseleave', function() {
            $(".nav_right").addClass('hide');
            $(".sub").addClass('hide');
        }).on('mouseenter', 'li', function(e) {
            var li_data = $(this).attr('data-id');
            $(".sub").addClass('hide');
            $('.sub[data-id="' + li_data + '"]').removeClass('hide');
        })
    })
</script>
</body>
</html>
