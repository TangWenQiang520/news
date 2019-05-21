<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>新闻管理系统</title>
</head>

<body>
<style>
    form{
        width: 500px;
    }
   div{
       margin: 0px auto;
   }
</style>

<form method="post" action="${pageContext.request.contextPath}/news/newslist">
    新闻分类：
    <select name="categoryId">
        <option value="0">全部</option>
        <c:forEach items="${news_categoryList}" var="category" >
            <option value="${category.id}" <c:if test="${categoryId == category.id}">selected</c:if>>${category.name}</option>
        </c:forEach>
    </select>
    新闻标题：
    <input name="title" value="${title}"/>
    <input type="submit" value="查询"/>
</form>

<table border="1">
    <tr>
        <th colspan="6"><h2>新闻列表</h2></th>
    </tr>
    <tr>
        <th>新闻编号</th>
        <th>新闻标题</th>
        <th>新闻摘要</th>
        <th>作者</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${news_detailList}" var="news">
        <tr>
            <td>${news.id}</td>
            <td>${news.title}</td>
            <td>${news.summary}</td>
            <td>${news.author}</td>
            <td><fmt:formatDate  pattern="yyyy-MM-dd" value="${news.createDate}"/></td>
            <td><a href="${pageContext.request.contextPath}/news/update/${news.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
