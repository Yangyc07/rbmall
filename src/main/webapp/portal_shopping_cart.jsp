<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
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
    .search_box{
        position: relative;
        top: -20px;
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
    /*中间内容*/
    .mid_content{
        width: 1200px;
        height: 400px;
        margin: 10px 0px;
        border: 1px solid #cccccc;
    }
    .table_box{
        width: 1000px;
        margin: 0 auto;
        margin-top: 10px;
    }
    .bgcolor{
        background: #EFEFEF;
    }
    td,th{
        text-align: center;
        overflow: hidden;
        text-overflow: ellipsis;
        /*white-space: nowrap;*/
    }
    .Carts_info{
        width: 250px;
    }
    /*商品图片大小*/
    .img_introd{
        width: 50px;
        height: 50px;
        min-height: 50px;
        min-width: 50px;
        max-height: 50px;
        max-width: 50px;
    }
    .list_word{
        width: 130px;
        height: 50px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        margin-left: 15px;
    }
    /*商品编号*/
    .info_btn{
        width: 60px;
        border: none;
        background: none;
    }
    .amount_box a{
        padding: 5px 8px;
        background: #F0F0F0;
    }
    .amount_box a:hover{
        background: lightgray;
    }
    /*输入数据*/
    .sum{
        width: 50px;
    }
    /*结算*/
    .pay_box{
        width: 1200px;
        height: 50px;
        margin: 10px 0px 10px 0px;
        border: 1px solid #ccc;
    }
    .end_box{
        margin-left: 20px;
        width: 200px;
        height: 20px;
        margin-top: 10px;
    }
    .check{
        margin-left: 110px;
        margin-top: 10px;
    }
    .btn{
        width: 100px;
    }
    .Carts_price,.Carts_sum{
        width: 100px;
    }
    .price{
        color: red;
        font-weight: bolder;
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
    <!--中间内容-->
    <div class="mid_content">
        <div class="table_box">
            <table class="table table-hover table-bordered">
                <!--<caption>悬停表格布局</caption>-->
                <thead class="bgcolor">
                <tr>
                    <th>状态</th>
                    <th>商品编号</th>
                    <th>商品描述</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>总价</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <!--是否选中-->
                    <td class="Carts_check">
                        <input type="checkbox" name="item" id="checkbox_1" class="son_check" value="1"/>
                        <label for=" checkbox_1"></label>
                    </td>
                    <!--商品id-->
                    <td class="Carts_id">
                        <div class="list_bianhao">
                            <input type="text" value="123" id="proId" class="info_btn"/>
                        </div>
                    </td>
                    <!--商品描述-->
                    <td class="Carts_info">
                        <div class="list_text">
                            <div class="list_img fl">
                                <a href="#"><img src="" class="img_introd"/></a>
                            </div>
                            <div class="list_word fl">
                                <a href="#">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a>
                            </div>
                        </div>
                    </td>
                    <!--商品价格-->
                    <td class="Carts_price">
                        ￥<span class="price">180</span>
                    </td>
                    <!--商品数量-->
                    <td class="Carts_amount">
                        <div class="amount_box">
                            <a href="javascript:;" class="reduce">-</a>
                            <input type="text" value="1" class="sum">
                            <a href="javascript:;" class="plus">+</a>
                        </div>
                    </td>
                    <!--商品总价-->
                    <td class="Carts_sum">
                        ￥<span class="sum_price">180</span>
                    </td>
                    <!--商品操作-->
                    <td class="Carts_op">
                        <p class="del">
                            <a  class="delBtn">移除商品</a>
                        </p>
                    </td>
                </tr>

                <tr>
                    <!--是否选中-->
                    <td class="Carts_check">
                        <input type="checkbox" name="item" id="checkbox_2" class="son_check" value="2"/>
                        <label for=" checkbox_2"></label>
                    </td>
                    <!--商品id-->
                    <td class="Carts_id">
                        <div class="list_bianhao">
                            <input type="text" value="123" id="proId" class="info_btn"/>
                        </div>
                    </td>
                    <!--商品描述-->
                    <td class="Carts_info">
                        <div class="list_text">
                            <div class="list_img fl">
                                <a href="#"><img src="" class="img_introd"/></a>
                            </div>
                            <div class="list_word fl">
                                <a href="#">夏季男士迷彩无袖T恤圆领潮流韩版修身男装背心青年时尚打底衫男</a>
                            </div>
                        </div>
                    </td>
                    <!--商品价格-->
                    <td class="Carts_price">
                        ￥ <span class="price">180</span>
                    </td>
                    <!--商品数量-->
                    <td class="Carts_amount">
                        <div class="amount_box">
                            <a href="javascript:;" class="reduce">-</a>
                            <input type="text" value="1" class="sum">
                            <a href="javascript:;" class="plus">+</a>
                        </div>
                    </td>
                    <!--商品总价-->
                    <td class="Carts_sum">
                        ￥<span class="sum_price">180</span>
                    </td>
                    <!--商品操作-->
                    <td class="Carts_op">
                        <p class="del"><a class="delBtn">移除商品</a></p>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="pay_box">
        <div class="fl check" id="allseclect">
            <input type="checkbox" name="checkElments" id="select_all" value=""/>
            <label for="">&nbsp;&nbsp;全选</label>
        </div>
        <div class="fr  end_box">
            <button id="pay" class="btn btn-sm">结 &nbsp;&nbsp;&nbsp;算</button>
        </div>
        <div class="fr  end_box">
            <span>总计：<i>￥</i></span><span id="all">0</span>
        </div>
    </div>
    <style type="text/css">

    </style>
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
    //===========================全选============================
    var checked_all=document.getElementById("select_all");
    checked_all.onclick=function(){
        var all=document.getElementById("all");    //总计一栏
        var checkItems=document.getElementsByName("item");
        if(checked_all.checked){
            for(var i=0;i<checkItems.length;i++){
                checkItems[i].checked="checked";
            }
            //计算总价
            totalMoney();
        }else{
            for(var i=0;i<checkItems.length;i++){
                checkItems[i].checked=null;
            }
            all.textContent="0";
        }
    }
    //==================单个或多个商品是否选择关系 =====================

    function AdditemClickEvent(){
        var checkItems=document.getElementsByName("item");
        var all=document.getElementById("all");    //总计一栏
        var checked_all=document.getElementById("select_all");   //全选
        var num=0;    //用于统计有多少个checkbox被选中
        var len=checkItems.length;
        for(var i=0;i<checkItems.length;i++)
        {
            checkItems[i].onclick=function()
            {
//	        	中间一律用this表示本单元
                if (this.checked&&num!=-1) {
                    num++;
                    if (num==len) {
                        checked_all.checked="checked";
                    }
                    totalMoney();
                } else{
                    num--;
                    if(num==0||num!=len){
                        checked_all.checked=null;
                        all.textContent="0";
                    }
                    totalMoney();
                }
            }
        }
        totalMoney();
    }
    AdditemClickEvent();
    //======================商品数量   加   减控制器                       改变总价一栏的值=====================
    //减
    function  AddreduceClickEvent(){
        var reduceItems=document.getElementsByClassName("reduce");
        for (var i=0;i<reduceItems.length;i++) {
            reduceItems[i].onclick=function(){
                //添加事件处理方法
                var check=this.parentNode.parentNode.parentNode.firstElementChild.firstElementChild;
                //点击时改变      对应input内容
                var result=0;
                var price=this.parentNode.parentNode.previousElementSibling.firstElementChild.textContent;  //获取单价
                var numString=this.nextElementSibling.value;   //获取下一个input里面的value值
                var num=parseInt(numString);
                num=num-1;
                //改变input里面的内容为num；    num最小为1，不能低于这个数
                if(num>=1){
                    this.nextElementSibling.value=num.toString();
                    result=parseInt(price)*num;
                    var sum=this.parentNode.parentNode.nextElementSibling.firstElementChild;
                    sum.textContent=result.toString();
                }else{
                    this.nextElementSibling.value="1";
                }
                //当被选中时，计算总价并给总计
                if(check.checked){
                    totalMoney();
                }
            }
        }
    }
    //加
    function  AddplusClickEvent(){
        var plusItems=document.getElementsByClassName("plus");
        for (var i=0;i<plusItems.length;i++) {
            plusItems[i].onclick=function(){
                var check=this.parentNode.parentNode.parentNode.firstElementChild.firstElementChild;
                //点击时改变      对应input内容
                var result=0;
                var price=this.parentNode.parentNode.previousElementSibling.firstElementChild.textContent;  //获取单价
                var numString=this.previousElementSibling.value;   //获取下一个input里面的value值
                var num=parseInt(numString);
                num=num+1;
                //改变input里面的内容为num；     假设最大值为100  超过这个值后不能继续加了
                if(num>=100){
                    this.previousElementSibling.value="100";
                }else{
                    this.previousElementSibling.value=num.toString();
                    result=parseInt(price)*num;
                    var sum=this.parentNode.parentNode.nextElementSibling.firstElementChild;
                    sum.textContent=result.toString();
                }
                if(check.checked){
                    totalMoney();
                }
            }
        }
    }
    // 文本框输入验证数据
    function  AddinputBox(){
        var inputElements=document.getElementsByClassName("sum");
        for(var i=0;i<inputElements.length;i++){
            inputElements[i].onblur=function(){
                var check=this.parentNode.parentNode.parentNode.firstElementChild.firstElementChild;

// 	    		输入的数据只能为整数
                var result=0;
                var price=this.parentNode.parentNode.previousElementSibling.firstElementChild.textContent;  //获取单价
                var inp=parseInt(this.value);
                result=parseInt(price)*inp;
                var sum=this.parentNode.parentNode.nextElementSibling.firstElementChild;
                sum.textContent=result.toString();
                if(check.checked){
                    totalMoney();
                }
            }

        }
    }
    //减法监听
    AddreduceClickEvent();
    //   加法监听
    AddplusClickEvent();
    //
    AddinputBox();
    //===========================总计============================
    function totalMoney(){
//   获取总计一栏的内容值
        var all=document.getElementById("all");    //总计一栏
        var checkItems=document.getElementsByName("item");
        var prices=document.getElementsByClassName("sum_price");
        var total=0;   // 总计显示的内容
        for(var i=0;i<checkItems.length;i++){
            if(checkItems[i].checked){
                //取到这一栏的总价一栏的值
                var sum=parseInt(prices[i].textContent);
                //将这个结果计入到total中
                total=total+sum;
                //给总计一栏写入最终结果
                all.textContent=total.toString();
            }
        }
    }
</script>
</html>