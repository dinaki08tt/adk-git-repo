<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score Sheet</title>
<style>
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
	<p align="center"><b><u>Category:</u></b> ${obj.category} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Type:</u></b> ${obj.type}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Round:</u></b> ${obj.round} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Match Id:</u></b> ${obj.matchId} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Group Name:</u></b> ${obj.groupName} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><u>Table No:</u></b> ${obj.tableNo}</p>
	<table>
		<thead>
			<td>Player Name</td>
			<td>Game 1</td>
			<td>Game 2</td>
			<td>Game 3</td>
			<td>Game 4</td>
			<td>Game 5</td>
			<td>Game 6</td>
			<td>Game 7</td>
		</thead>
		<tr>
			<td>${obj.player1}<td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>${obj.player2}<td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<p align="center"><b>Umpire Name & Sign</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Winner Name & Sign</b></p>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	</#list>
</body>
</html>