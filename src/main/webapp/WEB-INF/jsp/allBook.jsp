<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 俊先生
  Date: 2020/7/4
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <!-Bootstrap美化界面-->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    <!--
    .pageshow {
        background-color: orage;
        float: right;
        line-height: 50px;
        margin-right: 100px;
    }
    -->
</style>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表-----显示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-info" href="/showAddBook">新增书籍</a>
                <a class="btn btn-info" href="/showBooks">显示书籍</a>
            </div>
            <div class="col-md-8 column">
                <form class="form-inline" action="/selectBook" method="post" style="float: right">
                    <span style="color: red;font-weight: bold">
                        ${error}
                    </span>
                    <input type="text" name="bookName" class="form-control" placeholder="请输入要查询的书籍名称">
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名字</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>

                <tbody>
                <c:forEach items="${list}" var="book">
                    <tr>
                        <td>${book.getBookID()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getBookCounts()}</td>
                        <td>${book.getDetail()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/showUpdateBook?id=${book.getBookID()}">
                                <span style="color: skyblue" class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更改
                            </a>
                            <a href="${pageContext.request.contextPath}/del/${book.getBookID()}">
                                <span style="color: red" class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 页码显示 -->
    <div class="pageshow">
        <span> 第${currPage }/${totalPage}页</span>&nbsp;&nbsp;
        <span>总记录数：${totalCount }&nbsp;&nbsp;每页显示:${pageSize}</span>&nbsp;&nbsp;
        <span>
            <c:if test="${currPage > 1}">
                <a href="${baseUri}/showBooks?page=1">[首页]</a>&nbsp;&nbsp;
                <a href="${baseUri}/showBooks?page=${currPage-1}">[上一页]</a>
                &nbsp;&nbsp;
            </c:if>
            <c:if test="${currPage < totalPage}">
                <a href="${baseUri}/showBooks?page=${currPage+1}">[下一页]</a>&nbsp;&nbsp;
                <a href="${baseUri}/showBooks?page=${totalPage}">[尾页]</a>&nbsp;&nbsp;
            </c:if>
        </span>
    </div>

</body>
</html>
