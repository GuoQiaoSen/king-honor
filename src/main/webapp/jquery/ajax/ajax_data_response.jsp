<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

String name = request.getParameter("name");

System.out.println("id:"+id+",name:"+name);

response.setCharacterEncoding("UTF-8");
out.println("请求参数为{id:"+id+",name:"+name+"}");
%>