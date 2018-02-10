<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <jsp:include page="common/head.jsp"/>
    <style>
        body {
            padding-top: 50px;
            padding-bottom: 40px;
            color: #5a5a5a;
        }

        /* 下面是左侧导航栏的代码 */
        .sidebar {
            position: fixed;
            top: 51px;
            bottom: 0;
            left: 0;
            z-index: 1000;
            display: block;
            padding: 20px;
            overflow-x: hidden;
            overflow-y: auto;
            background-color: #ddd;
            border-right: 1px solid #eee;
        }

        .nav-sidebar {
            margin-right: -21px;
            margin-bottom: 20px;
            margin-left: -20px;
        }

        .nav-sidebar > li > a {
            padding-right: 20px;
            padding-left: 20px;
        }

        .nav-sidebar > .active > a,
        .nav-sidebar > .active > a:hover,
        .nav-sidebar > .active > a:focus {
            color: #fff;
            background-color: #428bca;
        }
        已久

        .main {
            padding: 20px;
        }

        .main .page-header {
            margin-top: 0;
        }
    </style>
</head>

<body>
<!--下面是顶部导航栏的代码-->
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">睿邦管理系统</a>
        </div>
    </div>
</nav>

<!—自适应布局-->
<div class="container-fluid">
    <div class="row">
        <!—左侧导航栏-->
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">首页</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="<%= request.getContextPath()%>/manage/part_category/list.do">配件分类管理</a></li>
                <li><a href="#">配件基本信息管理</a></li>
                <li><a href="<%= request.getContextPath()%>/manage/auto_styling/list.do">车型信息管理</a></li>
                <li><a href="#">配件车型信息管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="#">生产商信息管理</a></li>
                <li><a href="#">睿邦配件信息管理</a></li>
                <li><a href="#">配件入库管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="#">配件价格管理</a></li>
                <li><a href="#">客户状态管理</a></li>
                <li><a href="#">客户订单管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="<%= request.getContextPath()%>/manage/customer/list.do">客户基本信息管理</a></li>
                <li><a href="<%= request.getContextPath()%>/manage/receiver_address/list.do">客户收货地址管理</a></li>
            </ul>
        </div>
        <!—右侧管理控制台-->
    </div>
</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>




