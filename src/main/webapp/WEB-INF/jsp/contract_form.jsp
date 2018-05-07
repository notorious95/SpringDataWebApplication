<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<br><br>
<spring:url value="/save" var="saveURL" />
<form:form modelAttribute="contractForm" method="post" action="${saveURL }" >
    <form:hidden path="id"/>

    <form>
        <div class="form-group">
            <label for="number">Numer umowy:</label>
            <form:input path="number" type="text" class="form-control" id="number" placeholder="Numer" required="required"/>
        </div>

        <div class="form-group">
            <label for="startDate">Data poczatkowa:</label>
            <form:input path="startDate" type="text" class="form-control" id="startDate" placeholder="Data poczatkowa" required="required"/>
        </div>

        <div class="form-group">
            <label for="endDate">Data koncowa:</label>
            <form:input path="endDate" type="text" class="form-control" id="endDate" placeholder="Data koncowa" required="required"/>
        </div>

        <div class="form-group">
            <label for="incomes">Przychody:</label>
            <form:input path="incomes" type="number" class="form-control" id="incomes" required="required"/>
        </div>

        <div class="form-group">
            <label for="scale">w skali:</label>
            <form:input path="scale" type="text" class="form-control" id="scale" placeholder="Skala" required="required"/>
        </div>

        <label for="soft-radio">System:</label>
        <div class="form-check" id="soft-radio">
            <form:radiobutton path="softId" class="form-check-input" name="exampleRadios" id="system1" value="1" checked="checked"/>
            <label class="form-check-label" for="system1">
                System1
            </label>
        </div>
        <div class="form-check">
            <form:radiobutton path="softId" class="form-check-input" name="exampleRadios" id="system2" value="2"/>
            <label class="form-check-label" for="system2">
                System2
            </label>
        </div>
        <br>

        <label for="status-radio">Status umowy:</label>
        <div class="form-check" id="status-radio">
            <form:radiobutton path="status" class="form-check-input" name="exampleRadios2" id="active" value="aktywna" checked="checked" />
            <label class="form-check-label" for="active">
                Aktywna
            </label>
        </div>
        <div class="form-check">
            <form:radiobutton path="status" class="form-check-input" name="exampleRadios2" id="inactive" value="nieaktywna"/>
            <label class="form-check-label" for="inactive">
                Nieaktywna
            </label>
        </div>
        <br><br>
        <button type="submit" class="btn btn-primary">Zatwierdz</button>
    </form>

</form:form>

</body>
</html>


