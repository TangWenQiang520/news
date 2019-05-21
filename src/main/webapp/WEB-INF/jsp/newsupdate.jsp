<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/19
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>新闻修改</title>
</head>
<style>
    table{
        margin:0px auto;
    }
</style>
<body>
<form method="post" action="${pageContext.request.contextPath}/news/newsupdate">
    <table border="1" width="400px">
        <tr>
            <th colspan="2" id="title"><h2>更新新闻内容</h2></th>
        </tr>
        <tr>
            <td>新闻编号</td>
            <td>
                <input name="id" type="hidden" value="${news_detail.id}"/>
               ${news_detail.id}
            </td>
        </tr>
        <tr>
            <td>新闻分类</td>
            <td>
                <select name="categoryId">
                    <c:forEach items="${news_categoryList}" var="category" >
                        <option value="${category.id}" <c:if test="${news_detail.categoryId == category.id}">selected</c:if>>${category.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>新闻标题(*)</td>
            <td><input name="title" type="text" value="${news_detail.title}"/></td>
        </tr>
        <tr>
            <td>新闻摘要</td>
            <td><textarea name="summary" >${news_detail.summary}</textarea></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input name="author" type="text" value="${news_detail.author}"/></td>
        </tr>
        <tr>
            <td colspan="2" id="btn">
                <input type="submit" value="提交"/>
                <input type="button" value="返回" onclick="javascript:go(-1);"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
