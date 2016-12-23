<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>404</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link type="text/css" rel="stylesheet" href="static/home/css/bootstrap.min.css"/>
    <title>Document</title>
    <style>
        img {
            margin:0 auto;
            display:block;
        }
    </style>
</head>
<body>
<div class="container">
    <img src="static/home/imgs/404.jpg"/>
    <div class="btn btn-primary btn-block" onclick="history.back()">返回</div>
</div>

</body>
</html>
