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

<body>
    <div class="container">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="/addBook" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="bookName" class="col-sm-2 control-label">书籍名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="bookName" placeholder="bookName" required>
            </div>
        </div>
        <div class="form-group">
            <label for="bookCounts" class="col-sm-2 control-label">书籍数量</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="bookCounts" name="bookCounts" placeholder="bookCounts" required>
            </div>
        </div>
        <div class="form-group">
            <label for="detail" class="col-sm-2 control-label">书籍描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="detail" name="detail" placeholder="detail" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">新增</button>
            </div>
        </div>
    </form>
</body>
</html>
