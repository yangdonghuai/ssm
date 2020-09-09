<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap-table.min.css">
</head>
<body>
<table id="tab"></table>

<script src="static/jquery-3.5.1.min.js"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="static/bootstrap-table.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.3/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
    $(function (){
        init()
    })

    function init() {
        $('#tab').bootstrapTable({
            url: 'main',         //请求后台的URL（*）
            contentType : "application/x-www-form-urlencoded",
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams:queryParam,
            responseHandler:responseHandler,
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize:3,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '编号'
            }, {
                field: 'userId',
                title: '用户名'
            }, {
                field: 'userPwd',
                title: '密码'
            }]
        })
        function queryParam(params) {
            var param = {
                limit: this.limit, // 页面大小
                offset: this.offset, // 页码
                pageNumber: this.pageNumber,
                pageSize: this.pageSize,
            };
            return param;
        }
        function responseHandler(res) {
            console.log(res)
            if (res) {
                return {
                    "rows" : res.obj.list,
                    "total" : res.obj.total
                };
            } else {
                return {
                    "rows" : [],
                    "total" : 0
                };
            }
        }
    }
</script>

<form method="post" action="addUser">
    id:<input type="text" name="id">
    userId:<input type="text" name="userId">
    userPwd:<input type="text" name="userPwd">
    <input type="submit" value="增加">
</form>

<form method="post" action="updUser">
    id:<input type="text" name="id">
    userId:<input type="text" name="userId">
    userPwd:<input type="text" name="userPwd">
    <input type="submit" value="修改">
</form>

<form method="post" action="delUser">
    id:<input type="text" name="id">
    <input type="submit" value="删除">
</form>

</body>
</html>
