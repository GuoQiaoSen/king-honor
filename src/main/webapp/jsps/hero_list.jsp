<%--
  Created by IntelliJ IDEA.
  User: SRT
  Date: 2021/12/31
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>英雄列表</title>
    <style type="text/css">
        table{
            border:1px solid #ddd;
        }
        table td{
            border:1px solid #ddd;
        }
        table th{
            border:1px solid #ddd;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>会员类型</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>兴趣</th>
        <th>加入日期</th>
        <th>数据创建时间</th>
        <th>数据修改时间</th>
        <th>操作</th>
    </tr>
    </thead>
</table>
<%--    <a href="${ctx}/dept/add">添加</a>--%>
    <%--<table>
        <thead>
        <tr>
            <th>id</th>
            <th>会员类型</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>兴趣</th>
            <th>加入日期</th>
            <th>数据创建时间</th>
            <th>数据修改时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${depts}" var="dept" varStatus="stat" >
            <tr <c:if test="${stat.index%2==1}">bgColor="gray"</c:if>>
                <td>${dept.id}</td>
                <td>
                    <c:if test="${dept.deptType==1}">铜牌会员</c:if>
                    <c:if test="${dept.deptType==2}">银牌会员</c:if>
                    <c:if test="${dept.deptType==3}">金牌会员</c:if>
                </td>
                <td>${dept.ename}</td>
                <td>
                    <c:if test="${dept.gender==1}">男</c:if>
                    <c:if test="${dept.gender==0}">女</c:if>
                </td>
                <td>${dept.age}</td>
                <!-- id,dept_type,ename,gender,age,hobby,enter_date,create_time,modify_time
                类型,1-铜牌会员,2-银牌会员,3-金牌会员
                性别,1-男,0-女
                兴趣,1-java,2-.net,3-php,4-ruby,5-python
                 -->
                <td>
                    <c:if test="${fn:contains(dept.hobby,'1')}">java,</c:if>
                    <c:if test="${fn:contains(dept.hobby,'2')}">.net,</c:if>
                    <c:if test="${fn:contains(dept.hobby,'3')}">php,</c:if>
                    <c:if test="${fn:contains(dept.hobby,'4')}">ruby,</c:if>
                    <c:if test="${fn:contains(dept.hobby,'5')}">python,</c:if>
                </td>
                <td><fmt:formatDate value="${ dept.enterDate}" pattern="yyyy-MM-dd"/></td>
                <td><fmt:formatDate value="${ dept.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${ dept.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <a href="${ctx}/dept/edit?id=${dept.id}">修改</a>
                    <a href="${ctx}/dept/remove?id=${dept.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </thead>
    </table>--%>
</body>
</html>
