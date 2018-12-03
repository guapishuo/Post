<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客</title>
</head>
<body>

<form action="/" method="post">
    <input type="text" name="p_id" placeholder="编号" />
    <select name="p_name">
        <option>请选择作者</option>
        <c:forEach items="${posts}" var="post">
        <option value="${post.p_name}">${post.p_name}</option>
        </c:forEach>
    </select>
    <input type="text" name="p_title" placeholder="标题11">
    <input type="text" name="p_content" placeholder="内容">
    <input type="date" name="p_date" >
    <input type="submit" />
</form>

<ul>
<c:forEach items="${posts}" var="post">
    <li>编号:${post.p_id}</li>
    <li>作者:${post.p_name}</li>
    <li>标题:${post.p_title}</li>
    <li>内容:${post.p_content}<li>
    <li>时间:${post.p_date}</li>
    <a href="/del/${post.p_id}">删除</a><hr/><br/>
</c:forEach>
</ul>

<div>
    <p>总共有 ${pageInfo.pages} 页，总共有 ${pageInfo.total}</p>
    <p>当前是第 ${pageInfo.pageNum} 页</p>
    <c:forEach begin="1" end="${pageInfo.pages}" var="p">
        <a href="/?page=${p}">第 ${p} 页  </a>
    </c:forEach>
</div>

</body>
</html>
