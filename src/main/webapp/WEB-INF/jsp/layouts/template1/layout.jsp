<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
    <title><tiles:getAsString name="title"/></title>
</head>

<body style="background-color: #B0BEC5">
    <table width="100%" border="0">
        <tr>
            <td><tiles:insertAttribute name="header"/> </td>
        </tr>
        <tr>
            <td><tiles:insertAttribute name="nav"/> </td>
        </tr>
        <tr>
            <td><tiles:insertAttribute name="content"/> </td>
        </tr>
        <tr>
            <td><tiles:insertAttribute name="footer"/> </td>
        </tr>
    </table>
</body>

</html>