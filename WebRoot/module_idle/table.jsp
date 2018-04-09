<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
	
 	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	$(function(){
			
			  if (isAutoSend.checked == true) {
                    var isAutoSend = document.getElementsByName('id');
                    alert(isAutoSend);
                }
          
	
	})
	</script>
</head>

<body>
<div class="place">
	<span>位置：</span>
		<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">模板</a></li>
		<li><a href="#">数据列表</a></li>
	</ul>
</div>
<div class="formbody">
	<div class="formtitle" style="cursor: pointer;" id="formtitle"><span>条件查询</span></div>
	<form action="FuzzyqueryServlet" method="post">
	<ul class="forminfo" style="display: none;" id="forminfo">
		<li>
			<label>闲置物品查询</label>
			<input name="select" type="text" class="dfinput" />
		</li>
		<li>
			<label>&nbsp;</label>
			<input name=submit type="submit" class="btn" value="确认保存"/>
		</li>
	</ul>
	</form>
</div>
<div class="rightinfo">
	<div class="tools">
		<ul class="toolbar">
			<li class="click"><span><img src="images/t01.png"/></span>添加</li>
			<li class="click" onclick="toUpdate()"><span><img src="images/t02.png"/></span>修改</li>
			<li><span><img src="images/t03.png"/></span>删除</li>
			<li><span><img src="images/t04.png"/></span>统计</li>
		</ul>
		<ul class="toolbar1">
			<li><span><img src="images/t05.png"/></span>设置</li>
		</ul>
	</div>
	
	<table class="tablelist">
		<thead>
			<tr>
				<th></th>
				<th>编号<i class="sort"><img src="images/px.gif"/></i></th>
				<th>闲置商品名称</th>
				<th>商品图片</th>
				<th>购买时间</th>
				<th>购买价格（原价）</th>
				<th>转让价(折扣价)</th>
				<th>支持的交易方式</th>
				<th>成色</th>
				<th>交易状态</th>
				<th>操作</th>
			</tr>
		</thead>
			
		<tbody>
		<c:forEach var="user" items="${userlist}">
			<tr>
				<td><input name="id" type="radio" value="${user.id}"/></td>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td>
				<img width="100px" height="100px" src="idleimg/${user.idleimg }" alt="" />
				</td>
				<td><c:out value="${user.purchasing_date}" /></td>
				<td><c:out value="${user.original_price}" /></td>
				<td><c:out value="${user.transfer_price}" /></td>
				<td><c:out value="${user.transfer_mode}" /></td>
				<td><c:out value="${user.percentage}" /></td>
				<td><c:out value="${user.uidle_state}" /></td>
				<td>
    					<a href="DeleteServlet?id=${user.id}">删除</a>
    					<a href="UpdateShowServlet?id=${user.id}">修改</a>
    				</td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<div class="pagin">
		<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
		<ul class="paginList">
			<li class="paginItem current"><a href="javascript:;">上一页</a></li>
			<li class="paginItem"><a href="javascript:;">下一页</a></li>
		</ul>
	</div>
</div>

<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	function toUpdate(){
		var id = $("input[name='id']:checked").val();
		if(!id){
			alert("请选择要操作的记录");
			return false;
		}else{
			alert( "您操作的值为："+$("input[name='id']:checked").val())
		}
	}
	$(function(){
		$('.tablelist tbody tr:odd').addClass('odd');
		
		$("#formtitle").click(function(){
			$("#forminfo").slideToggle("slow");
		});
	});
</script>

</body>
</html>

