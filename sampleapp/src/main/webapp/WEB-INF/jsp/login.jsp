<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<center>

		<h1>Welcome to Spring Security Learning</h1>


		<div
			style="text-align: center; padding: 30px; border: 1px solid; width: 250px;">

			<form method="post"
				action="<c:url value='j_spring_security_check' />">

				<table>

					<tr>

						<td colspan="2" style="color: red">${message}</td>

					</tr>


					<tr>

						<td>User Name:</td>


						<td><input type="text" name="j_username" /></td>

					</tr>


					<tr>

						<td>Password:</td>


						<td><input type="password" name="j_password" /></td>

					</tr>


					<tr>

						<td colspan="1"><input type="submit" value="Login" /></td>


						<td colspan="1"><input name="reset" type="reset" /></td>

					</tr>

				</table>

			</form>

		</div>

	</center>
</body>
</html>