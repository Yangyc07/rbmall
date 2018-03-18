<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp"%>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>左右侧菜单</title>
    <!--<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.css" rel="stylesheet">-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">

    <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <!--<script src="https://cdn.bootcss.com/jquery/1.9.1/jquery.js"></script>-->
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!--<jsp:include page="common/head.jsp"/>-->
    <style type="text/css">
        .container{
            position: relative;
            right: 30px;
        }
        /*顶部登录*/
        .topBar{
            width: 1200px;
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
            left: 25px;
            font-weight: bold;
        }
        /*登录、注册*/
        .login-register{
            float: right;
            position: relative;
            right: 20px;
        }
        /*logo导航     logo的位置、大小*/
        .logoBar{
            height: 85px;
            width: 150px;   /* 有logo时logo的像素    150x85*/
            background: yellow;
            margin-left: 40px;
            margin-top: 30px;
        }
        /*搜索栏*/
        .top_bar{
            height: 150px;
            width: 1200px;
            margin: 0 auto;
            background: #3399cc;
        }
        #top{
            position: relative;
            left: 185px;         /*有logo时*/
            top: 20px;
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
            left: -200px;
            top: 75px;
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
            height: initial;
            margin: 0 auto;
            margin-bottom: 15px;
        }
        /*左侧大框*/
        .containor{
            width:150px;
            position: relative;
            margin-top: 15px;
        }
        /*左侧导航*/
        .nav_left {
            width: 150px;
            height: 400px;
            background: #3399cc;
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
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        .nav_left ul li span {
            padding-left: 20px;
            height: 30px;
            line-height: 30px;
            display: block;
            background:#3399cc;
            color: #fff;
        }
        .nav_left ul li span:hover {
            color: #FF0036;
            background: #FFFFFF;
        }
        /*右侧内容*/
        .nav_right {
            width: 750px;
            height: initial;
            position: absolute;
            margin-left: 150px;
            top: 0px;
        }
        .sub {
            position: relative;
            overflow: hidden;
            width: 100%;
            height: 610px;
            background: #FFFFFF;
            border-right: 1px solid #F5F6F6;
            border-top: 1px solid #F5F6F6;
            border-bottom: 1px solid #F5F6F6;
        }
        .sub dl {
            overflow: hidden;
            padding: 0px 0px 10px 0px;
            margin-left: 15px;
        }
        .sub dt {
            width: 130px;
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
            margin-bottom: 5px;
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
            border-right: 1px solid #E3E3E3;
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
            width: 1000px;
            height: initial;
            margin-bottom: 50px;
            position:relative ;
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
        /*中间内容--------品牌导航*/

        #Brand{
            width: 1000px;
            margin-bottom: 50px;
        }
        #Car_Brand ul,#Type_Brand{
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        #Car_Brand li,#Type_Brand li{
            float: left;
            line-height: 28px;
            width: 110px;
            text-align: center;
        }
        /*品牌分类名*/
        .nav_tip{
            width: 100px;
            height: 28px;
            padding-left: 20px;
            padding-top: 3px;
        }
        #Car_Brand li,#Type_Brand li,.nav_tip,.btn_show{
            font-size: 10px;
            margin-top: 2px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
        /*品牌总框*/
        #Car_Brand,#Type_Brand{
            width: 1000px;
            height: 35px;
            clear: both;
            border:1px solid lightgray;
        }
        /*品牌具体内容*/
        .car_content,.type_content{
            width: 800px;
            height: 28px;
        }
        .btn_show{
            width: 50px;
            height: 28px;
            font-size: 10px;
            border: none;
            background: #F0F0F0;
        }
        .morebtn{
            margin-right: 20px;
        }
        /*产品信息-----图片-介绍-价格*/
        #product{
            height: initial;
            clear: both;
        }
        /*产品介绍*/
        .photo,.deceration,.price,.companyAdd,.communication{
            width: 199px;
            height: 100px;
            text-align: center;
            word-break:break-all;
        }
        #Product ul li{
            width: 1000px;
            height: 100px;
            border-bottom:1px solid lightgray;
            margin-top: 15px;
        }

        .price,.companyAdd,.communication{
            padding-top: 20px;
            padding-left: 10px;
        }
        .price{
            color: red;
            font-weight: bolder;
            font-size: 20px;
            padding-top:15px ;

        }
        .photo{
            text-align: left;
        }
        .photo img{
            max-height:100px;
            max-width: 100px;
            vertical-align:middle;
            /*处理图片底部框*/
            border-bottom:1px solid lightgray ;
        }
        .deceration{
            padding-top: 10px;
        }

        /*底部导航、备案*/
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
            /*overflow-x: hidden;*/
        }
    </style>

</head>
<body>
<div class="container">

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
                    <li><a id="ShoppingCart">购物车</a></li>
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
                <!--品牌-->
                <!--车型品牌-->
                <div id="Brand">
                    <div id="Car_Brand">
                        <div class="fl">
                            <div class="nav_tip fl">
                                车型品牌
                            </div>
                            <div class="car_content fr">
                                <!--默认的部分-->
                                <ul>
                                    <li><a href="#">中国重汽</a></li>
                                    <li><a href="#">东风</a></li>
                                    <li><a href="#">陕汽重卡</a></li>
                                    <li><a href="#">北汽福田</a></li>
                                    <li><a href="#">一汽解放</a></li>
                                    <li><a href="#">北奔</a></li>
                                    <li><a href="#">工程机械品牌</a></li>
                                </ul>
                                <!--隐藏的部分、、、可拼接的部分-->
                                <ul id="ulitem_1">
                                    <li class="hide"><a href="#">中国重汽</a></li>
                                    <li class="hide"><a href="#">东风</a></li>
                                    <li class="hide"><a href="#">陕汽重卡</a></li>
                                    <li class="hide"><a href="#">北汽福田</a></li>
                                    <li class="hide"><a href="#">一汽解放</a></li>
                                    <li class="hide"><a href="#">北奔</a></li>
                                    <li class="hide"><a href="#">工程机械品牌</a></li>


                                </ul>
                            </div>
                        </div>
                        <div class="morebtn fr">
                            <button class="btn_show" id="my_btn">更多</button>
                        </div>
                    </div>
                    <div id="Type_Brand">
                        <div class="fl">
                            <div class="nav_tip fl">
                                机型品牌
                            </div>
                            <div class="type_content fr">
                                <ul>
                                    <li><a href="#">中国重汽发动机</a></li>
                                    <li><a href="#">东风康明斯</a></li>
                                    <li><a href="#">锡柴发动机</a></li>
                                    <li><a href="#">玉柴发动机</a></li>
                                    <li><a href="#">大柴发动机</a></li>
                                    <li><a href="#">西安康明斯</a></li>
                                    <li><a href="#">重庆康明斯</a></li>

                                </ul>
                                <ul id="ulitem_2">
                                    <li class="hide"><a href="#">中国重汽发动机</a></li>
                                    <li class="hide"><a href="#">东风康明斯</a></li>
                                    <li class="hide"><a href="#">锡柴发动机</a></li>
                                    <li class="hide"><a href="#">玉柴发动机</a></li>
                                    <li class="hide"><a href="#">大柴发动机</a></li>
                                    <li class="hide"><a href="#">西安康明斯</a></li>
                                    <li class="hide"><a href="#">重庆康明斯</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="morebtn fr">
                            <!--<input type="button" name="my_btn" id="my_btn" value="更多" class="btn_show" />-->
                            <button class="btn_show" id="my_btn_2">更多</button>
                        </div>
                    </div>
                </div>
                <div id="Product">
                    <ul>
                        <c:forEach var="c" items="${pagenation.list}" varStatus="status">
                            <li>
                                <div class="photo fl">
                                    <img src="http://localhost:9090/b8c91581-9d89-4f00-9f71-46934dc3e82f.jpg" alt="产品图片"/>
                                </div>
                                <div class="deceration fl">
                                    <p>${c.partName}  ${partSubtitle}</p>
                                </div>
                                <div class="price fl">
                                        ${c.ordinaryPrice}
                                </div>
                                <div class="communication fl">
                                    <a href="<%= request.getContextPath()%>/customer/baseInfo/detail.do?rbPartID=${c.rbPartID}">详情</a>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>

                </div>
            </div>
            <!--左侧菜单-->
            <div class="containor">
                <div class="nav_left">
                    <ul>
                        <li data-id="1"> <span><a href="<%= request.getContextPath()%>/customer/baseInfo/category/list.do?partCategoryName=空气滤清器">发动机系统</a></span></li>
                        <li data-id="2"> <span>进排气系统</span></li>
                        <li data-id="3"> <span>点火系统 </span></li>
                        <li data-id="4"> <span>传动系统 </span></li>
                        <li data-id="5"> <span>制动系统 </span></li>
                        <li data-id="6"> <span>转向系统 </span></li>
                        <li data-id="7"> <span>电商 </span></li>
                        <li data-id="8"> <span>车身及驾驶 </span></li>
                        <li data-id="9"> <span>美容养护 </span></li>
                    </ul>
                </div>
                <div class="nav_right">
                    <div class="sub hide" data-id="1">
                        <dl>
                            <dt><a >机体组 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>发动机总成</a>
                                <a>发动机悬置</a>
                                <a>汽缸盖</a>
                                <a>汽缸垫</a>
                                <a>汽缸套</a>
                                <a>齿轮室组</a>
                                <a>汽缸套</a>
                                <a>齿轮室组</a>
                                <a>匹配套</a>
                                <a>发动机修理包</a>
                                <a>其他发动机附件</a>
                            </dd>
                        </dl>
                        <dl>
                            <dt><a >曲柄连杠机构 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>活塞</a>
                                <a>活塞环</a>
                                <a>活塞销</a>
                                <a>连杆</a>
                                <a>连杆瓦</a>
                                <a>连杆轴承</a>
                                <a>连杆螺栓</a>
                                <a>连杆螺母</a>
                                <a>飞轮</a>
                                <a>飞轮螺栓</a>
                                <a>飞轮壳</a>
                                <a>曲轴</a>
                                <a>曲轴皮带轮</a>
                                <a>扭振减震器</a>
                            </dd>
                        </dl>

                        <dl>
                            <dt><a >配气系统 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>气门</a>
                                <a>气门锁夹</a>
                                <a>气门导管</a>
                                <a>气门油封</a>
                                <a>气门弹簧</a>
                                <a>气门调整螺栓</a>
                                <a>凸轮轴</a>
                                <a>凸轮轴衬套</a>
                                <a>挺柱</a>
                                <a>张紧轮</a>
                                <a>摇臂</a>
                            </dd>
                        </dl>

                        <dl>
                            <dt><a >冷却系 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>风扇组</a>
                                <a>散热器</a>
                                <a>节温器</a>
                                <a>水</a>
                                <a>冷却系附件</a>
                                <a>气门调整螺栓</a>
                            </dd>
                        </dl>

                        <dl>
                            <dt><a >冷却系 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>风扇组</a>
                                <a>散热器</a>
                                <a>节温器</a>
                                <a>水</a>
                                <a>冷却系附件</a>
                                <a>气门调整螺栓</a>
                            </dd>
                        </dl>

                        <dl>
                            <dt><a >汽车传送带 <i> &gt;</i></a> </dt>
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
                            <dt><a >进气系统 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>空气滤清器</a>
                                <a>空气滤清器壳</a>
                                <a>滤芯</a>
                                <a>空气预滤器</a>
                                <a>进气门</a>
                                <a>进气管</a>
                                <a>进气垫</a>
                                <a>进气门座圈</a>
                                <a>进气歧管</a>
                                <a>节气门</a>
                                <a>进气分配器</a>
                                <a>中冷器</a>
                                <a>中冷器进气管</a>
                                <a>进气管盖罩</a>
                                <a>止回阀</a>
                                <a>引气管</a>
                                <a>进气通道</a>
                                <a>进气过渡管</a>
                            </dd>
                        </dl>
                        <dl>
                            <dt><a >排气系统 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>排气门</a>
                                <a>排气门座垫</a>
                                <a>排气歧管</a>
                                <a>排气歧管垫</a>
                                <a>消声器</a>
                                <a>三元催化器</a>
                                <a>排气管</a>
                                <a>排气管接口垫</a>
                                <a>排气管螺栓</a>
                            </dd>
                        </dl>

                    </div>

                    <div class="sub hide" data-id="3">
                        <dl>
                            <dt><a >供油系统 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>喷油器</a>
                                <a>喷油泵</a>
                                <a>输油泵</a>
                                <a>汽油泵</a>
                                <a>化油器</a>
                                <a>油水分离器</a>
                                <a>汽油分离器</a>
                                <a>调速器</a>
                                <a>汽油滤清器</a>
                                <a>柴油滤清器</a>
                                <a>压力补偿器</a>
                            </dd>
                        </dl>
                        <dl>
                            <dt><a >点火系 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>点火开关</a>
                                <a>点火线圈</a>
                                <a>分电器</a>
                                <a>火花塞</a>
                                <a>阻尼电阻</a>
                                <a>搭铁线</a>
                                <a>高压导线</a>
                                <a>高压点火线</a>
                                <a>点火信号发生器</a>
                                <a>微机控制器</a>
                                <a>全负荷开关</a>
                            </dd>
                        </dl>

                        <dl>
                            <dt><a >起动系 <i> &gt;</i></a> </dt>
                            <dd>
                                <a>蓄电池</a>
                                <a>蓄电池托架</a>
                                <a>蓄电池盖</a>
                                <a>发电机</a>
                                <a>发电机支架</a>
                                <a>发电机线束</a>
                                <a>发电机涨紧轮</a>
                                <a>起动机</a>
                                <a>起动机支架</a>
                                <a>起动机继电器</a>
                                <a>电压调节器</a>
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
</div>
<script type="text/javascript">
    //      	左侧分类显示控制
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
    //       更多---按钮控制
    //点击实现显示与因隐藏的交互
    //第一个点击按钮的计数
    var dum1 = 0;
    $("#my_btn").click(function() {
        dum1 = dum1 + 1;

        if (dum1 % 2 != 0) {
            var lilen = $("#ulitem_1").children().length;
            var consult = Math.floor(lilen / 7);  //向下取整    得到商
            var remainder = lilen % 7; //取余
            var h = (consult + 1) * 35;
            $("#Car_Brand").height(h);
            $("#ulitem_1").children().removeClass("hide");
            $("#my_btn").text("隐藏");
        }
        else {
            var h = 35;
            $("#Car_Brand").height(h);
            $("#ulitem_1").children().addClass("hide");
            $("#my_btn").text("更多");
        }
    });
    //第二个点击按钮的计数
    var dum2 = 0;
    $("#my_btn_2").click(function() {
        dum2 = dum2 + 1;
        if (dum2 % 2 != 0) {
            var lilen = $("#ulitem_2").children().length;
            var consult = Math.floor(lilen / 7);  //向下取整    得到商
            var remainder = lilen % 7; //取余
            var h = (consult + 1) * 35;
            $("#Type_Brand").height(h);
            $("#ulitem_2").children().removeClass("hide");
            $("#my_btn_2").text("隐藏");
        }
        else {
            var h = 35;
            $("#Type_Brand").height(h);
            $("#ulitem_2").children().addClass("hide");
            $("#my_btn_2").text("更多");
        }
    });
</script>

<script>
    $("#ShoppingCart").click(function () {
        $.ajax({
            type: "post",
            url: "<%=path%>/customer/check.do",
            success: function (data) {
                if (data.status === 0 ) {
                    window.location.href="<%=path%>/customer/shopping_cart/show.do";
                } else  {
                    alert("请登录");
                }
            }
        });
    });
</script>



</body>
</html>
