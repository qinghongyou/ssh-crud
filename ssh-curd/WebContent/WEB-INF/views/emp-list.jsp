<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		// 1. 点击delete 时，弹出确定是要删除 xx 信息吗， 若确定，执行删除，若取消，则不执行
		$(".delete").click(function(){
			var lastName = $(this).next(":input").val();
			var flag = confirm("确定要删除 "+ lastName +" 的信息吗？");
			if(flag){
				// 删除，使用ajax 的方式
				var $tr = $(this).parent().parent();
				var url = this.href;
				var args = {"time": new Date()};
				$.post(url, args, function(data){
					// 若data 返回值是1，删除成功，并把当前行删除
					if(data == "1"){
						alert("删除成功！");
						$tr.remove();
					}else{
						// 若data 返回值不是1，删除失败
						alert("删除失败！");
					}
				});
			}
			// 取消超链接的默认行为
			return false;
		});
	})
	
</script>
</head>
<body>
	<h4 align="center">Employee List Page</h4>
	
	<s:if test="#request.employees == null || #request.employees.size() ==0">
		<h5 align="center">没有任何员工信息！</h5>
	</s:if>
	<s:else>
		<table align="center" border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Birth</td>
				<td>CreateTime</td>
				<td>Dept</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id }</td>
					<td>${lastName }</td>
					<td>${email }</td>
					<td>
						<s:date name="birth" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>${department.departmentName }</td>
					<td>
						<a href="emp-delete?id=${id }" class="delete">Delete</a>
						<input type="hidden" value="${lastName }">
					</td>
					<td>
						<a href="emp-input?id=${id }">Edit</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
</body>
</html>