<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<String,Object> map = request.getParameterMap();
for(Iterator<Entry<String,Object>> iter = map.entrySet().iterator();iter.hasNext();){
	Entry<String,Object> entry = iter.next();
	String key = entry.getKey();
	Object[] value =  (Object[])entry.getValue();
	StringBuffer sb  = new StringBuffer();
	sb.append("参数名:"+key+",参数值:");
	for(int i=0;i<value.length;i++){
		sb.append(value[i]+",");
	}
	sb.append("\n");
	System.out.println("控制台:"+sb.toString());
	out.println("服务端返回到客户端:"+sb.toString());
}


%>