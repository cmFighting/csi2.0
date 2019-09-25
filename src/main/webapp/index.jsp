<%--
  Created by IntelliJ IDEA.
  User: cmFighting
  Date: 2019/9/9
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CSI员工之家接口文档</h1>
<h2>云南大学软件学院工程实训项目</h2>
<h3>小组成员：宋晨明、翁恺敏、孔飞、刘竹风、王正正、王雷翔、李鑫、张骏哲</h3>
<h3>指导老师：辛宝和-中软国际</h3>
<a href="http://139.199.193.78:8080/csi/swagger-ui.html">点击这里查看接口文档</a>
<form action="${pageContext.request.contextPath }/2/uploadx"
      method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px"> <input
        type="submit" value="上传">
</form>
<hr>
<%--<form action="${pageContext.request.contextPath }/file/down.chao"--%>
<%--      method="get">--%>
<%--    <input type="submit" value="下载">--%>
<%--</form>--%>
</body>
</body>
</html>
