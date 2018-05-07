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

<br><br><br>
<script type="text/javascript">
    $(document).ready(function () {
        $('#table_id').dataTable();
    });
</script>

<table id="table_id" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Technologia</th>
        <th>Wlasciciel</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Technologia</th>
        <th>Wlasciciel</th>
    </tr>
    </tfoot>

    <tbody>
    <c:forEach items="${listAllSofts }" var="soft" >
        <tr>
            <td>${soft.name }</td>
            <td>${soft.description }</td>
            <td>${soft.technology }</td>
            <td>${soft.owner }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>



