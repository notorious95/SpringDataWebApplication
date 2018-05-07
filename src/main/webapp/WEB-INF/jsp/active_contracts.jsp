<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<spring:url value="/add" var="addURL"/>
<spring:url value="/readFile" var="readURL"/>
<div style="margin-left: 2%; margin-top: 4%">
    <a href="${addURL }" class="btn btn-success btn-md" role="button">Dodaj nowa umowe</a>
    <a href="${readURL }" class="btn btn-success btn-md" role="button">Wczytaj umowy z pliku</a>
</div>

<br><br>
<script type="text/javascript">
    $(document).ready(function () {
        $('#table_id').dataTable();
    });
</script>

<table id="table_id" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Numer umowy</th>
        <th>System</th>
        <th>Od</th>
        <th>Do</th>
        <th>Wplywy</th>
        <th>w skali</th>
        <th>Edycja</th>
        <th>Dezaktywacja</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>Numer umowy</th>
        <th>System</th>
        <th>Od</th>
        <th>Do</th>
        <th>Wplywy</th>
        <th>w skali</th>
        <th>Edycja</th>
        <th>Dezaktywacja</th>
    </tr>
    </tfoot>

    <tbody>
    <c:forEach items="${listActiveContracts}" var="contract">
        <tr>
            <td>${contract.number }</td>
            <td>${contract.soft.name }</td>
            <td>${contract.startDate }</td>
            <td>${contract.endDate }</td>
            <td>${contract.incomes }</td>
            <td>${contract.scale }</td>
            <td>
                <spring:url value="/update/${contract.id }" var="updateURL"/>
                <a href="${updateURL }" class="btn btn-info btn-sm" role="button">Zmien</a>
            </td>
            <td>
                <spring:url value="/delete/${contract.id }" var="deleteURL"/>
                <a href="${deleteURL }" class="btn btn-danger btn-sm" role="button">Dezaktywuj</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>


