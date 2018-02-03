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
            <a class="navbar-brand" href="#">某管理系统</a>
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
                <li><a href="#">配件分类管理</a></li>
                <li><a href="#">配件基本信息管理</a></li>
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
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
                <div class="col-xs-7">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="exampleInputName2">ID</label>
                            <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">名称</label>
                            <input type="test" class="form-control" id="exampleInputEmail2" placeholder="如：张三">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                </div>
                <div class="col-xs-5">
                    <input class="btn btn-default" type="button" value="添加">
                    <input class="btn btn-default" type="submit" value="删除">
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-10">
                    <table class="table table-hover table-bordered table-striped table-condensed">

                        <thead>
                        <!--表头-->
                        <tr>
                            <th>选择</th>
                            <th>客户ID</th>
                            <th>省</th>
                            <th>市</th>
                            <th>县区</th>
                            <th>街道</th>
                            <th>详细地址</th>
                            <th>邮编</th>
                            <th>收货人姓名</th>
                            <th>手机号码</th>
                            <th>座机号码</th>
                            <th>缺省地址标志</th>
                            <th>客户收货地址备注</th>
                        </tr>

                        </thead>
                        <!--内容-->
                        <tbody id="content">
                        <c:forEach var="c" items="${pagenation.list}" varStatus="status">
                            <tr>
                                <td>
                                    <input type="checkbox" name="checkcno" id="checkcno" value="${c.customerID}" />
                                </td>
                                <td>${c.customerID}</td>
                                <td>${c.receiverProvince}</td>
                                <td align="center">${c.receiverCity}</td>
                                <td align="center">${c.receiverDistrict}</td>
                                <td align="center">${c.receiverStreet}</td>
                                <td align="center">${c.receiverDetailedAddress}</td>
                                <td align="center">${c.receiverPostCode}</td>
                                <td align="center">${c.receiverName}</td>
                                <td align="center">${c.receiverMobilePhone}</td>
                                <td align="center">${c.receiverTelePhone}</td>
                                <td align="center">${c.receiverAddressFlag}</td>
                                <td align="center">${c.customerReceivingAddressRemark}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="container" id="pagenation" align="center">
                        <div class="pagination" >
                            <c:if test="${pagenation.pageCount >1}">
                                <a href="<%= request.getContextPath()%>/manage/receiver_address/list.dopageNum=${pagenation.prev }">上一页</a>
                            </c:if>
                            <c:forEach  items="${pagenation.showPages}" var="showPages">
                                <a href="<%= request.getContextPath()%>/manage/receiver_address/list.dopageNum=${showPages }">${showPages }</a>
                            </c:forEach>


                            <c:if test="${pagenation.pageCount >1 }">
                                <a href="<%= request.getContextPath()%>/manage/receiver_address/list.dopageNum=${pagenation.next }">下一页</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>




