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
	<title>æ æ é¢ææ¡£</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="place">
	<span>ä½ç½®ï¼</span>
		<ul class="placeul">
		<li><a href="#">é¦é¡µ</a></li>
		<li><a href="#">æ¨¡æ¿</a></li>
		<li><a href="#">æ°æ®åè¡¨</a></li>
	</ul>
</div>
<div class="formbody">
	<div class="formtitle" style="cursor: pointer;" id="formtitle"><span>æ¡ä»¶æ¥è¯¢</span></div>
	<ul class="forminfo" style="display: none;" id="forminfo">
		<li>
			<label>æç« æ é¢</label>
			<input name="" type="text" class="dfinput" />
			<i>æ é¢ä¸è½è¶è¿30ä¸ªå­ç¬¦</i>
		</li>
		<li>
			<label>å³é®å­</label>
			<input name="" type="text" class="dfinput" />
			<i>å¤ä¸ªå³é®å­ç¨,éå¼</i>
		</li>
		<li>
			<label>æ¯å¦å®¡æ ¸</label>
			<cite>
				<input name="" type="radio" value="" checked="checked" />æ¯&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="" type="radio" value="" />å¦
			</cite>
		</li>
		<li>
			<label>å¼ç¨å°å</label>
			<input name="" type="text" class="dfinput" value="" /><i class="inputerror">å¤ä¸ªå³é®å­ç¨,éå¼</i>
		</li>
		<li>
			<label>&nbsp;</label>
			<input name="" type="button" class="btn" value="æ¥è¯¢"/>
		</li>
	</ul>
</div>
<div class="rightinfo">
	<div class="tools">
		<ul class="toolbar">
			<li class="click"><span><img src="images/t01.png"/></span>æ·»å </li>
			<li class="click" onclick="toUpdate()"><span><img src="images/t02.png"/></span>ä¿®æ¹</li>
			<li><span><img src="images/t03.png"/></span>å é¤</li>
			<li><span><img src="images/t04.png"/></span>ç»è®¡</li>
		</ul>
		<ul class="toolbar1">
			<li><span><img src="images/t05.png"/></span>è®¾ç½®</li>
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
			</tr>
		</thead>
		<c:forEach var="user" items="${userlist}">
		<tbody>
			<tr>
				<td><input name="id" type="radio" value="5"/></td>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.idleimg}" /></td>
				<td><c:out value="${user.purchasing_date}" /></td>
				<td><c:out value="${user.original_price}" /></td>
				<td><c:out value="${user.transfer_price}" /></td>
				<td><c:out value="${user.transfer_mode}" /></td>
				<td><c:out value="${user.percentage}" /></td>
				<td><c:out value="${user.transfer_state}" /></td>
			</tr>
			
		</tbody>
		</c:forEach>
	</table>
	<div class="pagin">
		<div class="message">å±<i class="blue">1256</i>æ¡è®°å½ï¼å½åæ¾ç¤ºç¬¬&nbsp;<i class="blue">2&nbsp;</i>é¡µ</div>
		<ul class="paginList">
			<li class="paginItem current"><a href="javascript:;">ä¸ä¸é¡µ</a></li>
			<li class="paginItem"><a href="javascript:;">ä¸ä¸é¡µ</a></li>
		</ul>
	</div>
</div>

<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
<script type="text/javascript">
	/**
	 * è¿ä¸ªä½¿ç¨çåéæ¡éæ©å¤æ­
	 */
	function toUpdate(){
		var id = $("input[name='id']:checked").val();
		if(!id){
			alert("è¯·éæ©è¦æä½çè®°å½");
			return false;
		}else{
			alert( "æ¨æä½çå¼ä¸ºï¼"+$("input[name='id']:checked").val())
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

