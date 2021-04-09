<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>HTML Table</h2>

<table>
  <tr>
    <th>Employee ID</th>
    <th>Employee Name</th>
    <th>Employee Salary</th>
  </tr>
  <c:forEach items="${emplist}" var="emp">
  	<tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.sal }</td>
  </tr>
  </c:forEach>

</table>

</body>
</html>
