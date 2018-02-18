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
                <li><a href="<%= request.getContextPath()%>/manage/part_base_info/list.do">配件基本信息管理</a></li>
                <li><a href="<%= request.getContextPath()%>/manage/auto_styling/list.do">车型信息管理</a></li>
                <li><a href="<%= request.getContextPath()%>/manage/part_auto_styling/list.do">配件车型信息管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="<%= request.getContextPath()%>/manage/producer/list.do">生产商信息管理</a></li>
                <li><a href="<%= request.getContextPath()%>/manage/rb_part_base_info/list.do">睿邦配件信息管理</a></li>
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
                    <form class="form-inline" method="post" action="<%= request.getContextPath()%>/manage/customer/search.do" name="searchForm" id="searchForm">
                        <div class="form-group">
                            <label for="exampleInputID2">ID</label>
                            <input type="text" class="form-control" id="exampleInputID2" name="customerId" placeholder="如：01">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName2">名称</label>
                            <input type="test" class="form-control" id="exampleInputName2" name="customerName" placeholder="如：张三">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                </div>
                <div class="col-xs-5">
                    <button class="btn btn-default" id="addCustomer" type="button">添加</button>
                    <button class="btn btn-default" type="button">删除</button>
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
                            <th>睿邦零件编号</th>
                            <th>零件号</th>
                            <th>零件品牌</th>
                            <th>生产商代码</th>
                            <th>图片文件夹地址</th>
                            <th>零件状态</th>
                            <th>备注</th>
                        </tr>

                        </thead>
                        <!--内容-->
                        <tbody id="content">
                        <c:forEach var="c" items="${pagenation.list}" varStatus="status">
                            <tr>
                                <td>
                                    <input type="checkbox" name="checkcno" id="checkcno" value="${c.rbPartID}" />
                                </td>
                                <td>${c.rbPartID}</td>
                                <td>${c.partModel}</td>
                                <td align="center">${c.partBrand}</td>
                                <td align="center">${c.producerID}</td>
                                <td align="center">${c.partImagesAddress}</td>
                                <td align="center">${c.partStatus}</td>
                                <td align="center">${c.rbPartBaseInfoRemark}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="container" id="pagenation" align="center">
                        <div class="pagination" >
                            <c:if test="${pagenation.pageCount >1}">
                                <a href="<%= request.getContextPath()%>${pagenation.queryUrl }pageNum=${pagenation.prev }">上一页</a>
                            </c:if>
                            <c:forEach  items="${pagenation.showPages}" var="showPages">
                                <a href="<%= request.getContextPath()%>${pagenation.queryUrl }pageNum=${showPages }">${showPages }</a>
                            </c:forEach>


                            <c:if test="${pagenation.pageCount >1 }">
                                <a href="<%= request.getContextPath()%>${pagenation.queryUrl }pageNum=${pagenation.next }">下一页</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/layer/3.1.0/layer.js"></script>
<script>

    var html = '<form class="am-form">\n' +
        '            <br>\n' +
        '            <label for="username">姓名:</label>\n' +
        '            <input type="text" name="name" id="name"/>\n' +
        '            <br>\n' +
        '            <label for="username">账号:</label>\n' +
        '            <input type="text" name="username" id="username"/>\n' +
        '            <br>\n' +
        '            <label for="password">密码:</label>\n' +
        '            <input type="password" name="password" id="password"/>\n' +
        '            <br>\n' +
        '            <label for="password">手机号:</label>\n' +
        '            <input type="text" id="phone"/>\n' +
        '            <br>\n' +
        '            <label for="password">找到密码问题:</label>\n' +
        '            <input type="text" id="question"/>\n' +
        '            <br>\n' +
        '            <label for="password">找到密码问题:</label>\n' +
        '            <input type="text"  id="answer"/>\n' +
        '        </form>'

    //弹出一个页面层
    $('#addCustomer').on('click', function(){
        layer.open({
            type: 1,
            btn:['添加'],
            yes: function (index,layero) {
                console.log(123);
                var name = $(layero).find("#name").val();
                console.log(name);

                var username = $(layero).find("#username").val();
                var password = $(layero).find("#password").val();
                var phone = $(layero).find("#phone").val();
                var question = $(layero).find("#question").val();
                var answer = $(layero).find("#answer").val();
                $.ajax({
                    url: "/customer/register.do",
                    data: {
                        customerName:name,
                        customerLoginName: username,
                        customerPassword: password,
                        customerPhone:phone,
                        customerPwdQuestion:question,
                        customerPwdAnswer:answer
                    },
                    success: function(data) {
                        //注册成功
                        if(data.status === 0) {
                            layer.msg('注册成功！');//保存成功提示
                        } else {
                            layer.msg("用户名已存在");
                        }
                        layer.closeAll('iframe');//关闭弹窗
                    }
                });
            },
            area: ['800px', '600px'],
            shadeClose: false, //点击遮罩关闭
            content: html
        });
    });
</script>


</body>
</html>





