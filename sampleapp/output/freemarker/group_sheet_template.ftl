<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Group Sheet</title>
<style>
.blackbg{
	background-color: #000000;
}
table {
    width: 100%;
}

th {
    height: 50px;
}
table {
    border-collapse: collapse;
}
table, th, td {
   border: 1px solid black;
}
th, td {
    padding: 8px;
    text-align: left;
}
</style>
</head>
<body>
<#list objs as obj>
	<div>
	<h3 align="center">ADK Table Tennis Tournament Manager</h3>
	<p align="center"><b><u>Category:</u></b> ${obj.category} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Type:</u></b> ${obj.type}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Round:</u></b> ${obj.round} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Group Name:</u></b> ${obj.groupName} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Table No:</u></b> ${obj.tableNo}</p>
	<table>
		<thead>
			<tr>
				<td></td>
				<td>${obj.player1}</td>
				<td>${obj.player2}</td>
				<td>${obj.player3}</td>
				<td>${obj.player4}</td>
			</tr>
		</thead>
		<tr>
			<td>${obj.player1}</td>
			<td class="blackbg"></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>${obj.player2}</td>
			<td></td>
			<td class="blackbg"></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>${obj.player3}</td>
			<td></td>
			<td></td>
			<td class="blackbg"></td>
			<td></td>
		</tr>
		<tr>
			<td>${obj.player4}</td>
			<td></td>
			<td></td>
			<td></td>
			<td class="blackbg"></td>
		</tr>
	</table>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<p align="center"><b>Umpire Name & Sign</b></p>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	</#list>
</body>
</html>