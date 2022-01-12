<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <%@include file="../include.jsp" %>

<script type="text/javascript">
    function btn_commit() {
        var data = $('#hero_name');

        console.log(data);

        var url = "${ctx}/restrain/getRestrain";

        jQuery.ajax({
            type:"post",
            url: '${ctx}/restrain/getRestrain',
            cache:false,
            dataType:"text",
            data: data,
            success:function(res){
                $('#review').append(res);
            }
        });
    }
</script>
</head>


<body>
<%--    <form action="${ctx}/restrain/getRestrain" method="post">--%>
<form>
    <table>
        用户名称：<input id="hero_name" type="text" name="hero_name">
        <tr>
            <td colspan="2">
                <!-- ajax方式提交 2.修改submit按钮,换成button,给定一个onclick属性-->
                <!-- <input type="submit" value="提交"/> -->
                <input type="button" value="提交" onclick="btn_commit();"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>

<div id="review" style="width:250px;height:auto;border: 1px solid #FF0000">

</div>
    <%--<h2>法师</h2>
    <h2>上路</h2>
    <h2>打野</h2>
    <h2>射手</h2>
    <h2>辅助</h2>--%>
</body>
</html>
