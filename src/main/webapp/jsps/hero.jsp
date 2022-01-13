<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <%@include file="../include.jsp" %>

<script type="text/javascript">
    function btn_commit() {
        // 清空div中的历史内容
        $('#review').text('');

        var data = $('#hero_name');

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

    // 添加英雄
    function add_function() {
        var heroName = $('#add_hero_name').val();

        console.log(heroName);

        jQuery.ajax({
            type:"post",
            url: '${ctx}/hero/addHero',
            cache:false,
            contentType: "application/json;charset=utf-8",
            dataType:"text",
            data: JSON.stringify({heroName:heroName}),
            success:function(){
                alert("添加成功");
            }
        });
    }

    // 添加克制关系
    function add_restrain_function() {
        // 强势英雄名称
        var add_restrain_1 = $('#add_restrain_1').val();
        // 弱势英雄名称
        var add_restrain_2 = $('#add_restrain_2').val();
        // 克制理由
        var reason = $('#reason').val();

        jQuery.ajax({
            type:"post",
            url: '${ctx}/restrain/addRestrain',
            cache:false,
            contentType: "application/json;charset=utf-8",
            dataType:"text",
            data: JSON.stringify(
                {
                    add_restrain_1:add_restrain_1,
                    add_restrain_2:add_restrain_2,
                    reason:reason
                }),
            success:function(){
                alert("添加成功");
            }
        });
    }
</script>
</head>


<body>
<form id="search" name="search">
    <table>
        <tr>
            <td colspan="4">
                用户名称：<input id="hero_name" type="text" name="hero_name">
                <input type="button" value="提交" onclick="btn_commit();"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>

<div id="review" style="width:250px;height:auto;border: 1px solid #ff7700"></div>


<%--分割线--%>
<hr width=500 size=0 color="#999999" align="left">
<hr width="500px" size="0" color="999999" align="left">


<form id="add" name="add">
    <table>
        <tr>
            <td colspan="4">
                添加英雄：<input id="add_hero_name" type="text" name="add_hero_name">
                <input type="button" value="提交" onclick="add_function();"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>


<%--分割线--%>
<hr width=500 size=0 color="#999999" align="left">
<hr width="500px" size="0" color="999999" align="left">


<form id="add_restrain" name="add_restrain">
    <table>
        <tr>
            添加克制关系：
            <input id="add_restrain_1" type="text" placeholder="强势英雄">
            克制
            <input id="add_restrain_2" type="text" placeholder="弱势英雄">

            <td>
                <input id="reason" type="text" placeholder="克制理由">
            </td>
            <td colspan="2">
                <input type="button" value="提交" onclick="add_restrain_function();"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
