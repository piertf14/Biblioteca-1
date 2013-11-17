<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/prestamo/guardar" commandName="prestamo">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <tbody>         
            <!-- id, monto, diasTarde, prestamos_id -->
            <tr>
                <th><form:label path="monto">Monto</form:label></th>
                <td>
                    <form:input path="monto" cssClass="small" placeholder="ingrese el monto"></form:input>
                    <form:errors path="monto" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="diasTarde">Dias tarde</form:label></th>
                <td><form:input path="diasTarde" type="number" cssClass="small"/></td>
            </tr>
                <tr>
                    <th><form:label path="prestamo.id">Préstamo</form:label></th>
                <td>
                <form:select path="prestamo.id">
                    <form:options items="${prestamos}" itemValue="id"/>
                </form:select>
                </td>
                </tr>
            </tbody>
        <form:hidden path="id"/>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/libro" class="button last-button a">Cancelar</a>
</form:form>