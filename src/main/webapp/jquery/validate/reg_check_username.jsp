<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//如果用户名为aaaaaa,就存在
//如果用户名不为aaaaaa,就不存在
//模拟用户名是否存在,实际情况应该去数据库查找
String username = request.getParameter("username");
if("aaaaaa".equals(username)){
	out.println("0");//存在相同的用户名,返回0,表示不可用
	return;
}
response.setContentType("text/html;charset=UTF-8");
out.println("1");//不存在相同的用户名,返回1,表示可用
// if("aaaaaa".equals(username)){
// 	out.println("0");
// }else{
// 	out.println("1");
// }
%>