<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">表单</a></li>
	</ul>
</div>

<form >
	<div class="formbody">
		<div class="formtitle"><span>修改密码</span></div>
		<ul class="forminfo">
			<li>
				<label>原始密码</label>
				<input id="oripwd" onblur="checkOripwd()" name="password" type="password" class="dfinput" />
				<i id="m1"></i>
			</li>
			<li>
				<label>新密码</label>
				<input  id="psw1" name="psw1" type="password" class="dfinput" readonly="readonly"/>
				<i></i>
			</li>
			<li>
				<label>确认密码</label>
				<input id="psw2" name="psw2" onblur="checkSamePwd()" type="password" class="dfinput"  readonly="readonly"/>
				<i></i>
			</li>
			
			
			<li>
				<label>&nbsp;</label>
				<input name="sub" id="sub" onclick="updatepwd()" type="button" class="btn" disabled="disabled" value="确认保存"/>
			</li>
		</ul>
	</div>
</form>

<script src="<%=basePath %>js/upload.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
<script>
	function checkOripwd(){
		var oripwd = $('#oripwd').val();
		$.ajax({
			url:'CheckOriPwd',
			data:'oripwd='+oripwd+'',
			success:function(data){
			if(data=="ok")
			{
			$('#m1').html("<font color='green'>√</font>");
			$('#psw1').removeAttr("readonly");
			$('#psw2').removeAttr("readonly");}
			
			else
			{$('#m1').html("<font color='red'>×</font>");
			$('#psw1').
			$('#psw2').createAttr("readonly");}
				
			},
			error:function(){
				alert('请求失败')
			}
		});
	}
		function checkSamePwd(){
		var psw1 = $('#psw1').val();
		var psw2 = $('#psw2').val();
		if(psw1 == psw2){
			$('#sub').removeAttr('disabled');
		}else{
			alert('两次密码不一致');
		}
		
		
	}
	
	function updatepwd(){
		var psw = $('#psw1').val();
		$.ajax({
			url:'UpdatePwd',
			data:'psw='+psw+'',
			success:function(m){
				if(m=='ok')
				{
				parent.location.href="../login.jsp";
				}else
				{
				alert('修改失败');
				}
			},
			error:function(){
				alert('请求失败')
			}
		});
		
		
	}
	
	
	
</script>
</body>
</html>
	