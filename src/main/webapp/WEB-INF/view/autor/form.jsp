<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/autor/guardar" commandName="autor">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <tbody>            
            <tr>
                <th><form:label path="nombre">Nombre</form:label></th>
                <td>
                    <form:input path="nombre" cssClass="large" placeholder="ingrese nombre"></form:input>
                    <form:errors path="nombre" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="apellidos">Apellidos</form:label></th>
                <td><form:input path="apellidos" cssClass="large" placeholder="ingrese un apellidos"/></td>
            </tr>
            <tr>
                <th><form:label path="pais">País</form:label></th>
                    <td>
                    <form:input path="pais" cssClass="medium" placeholder="ingrese un país"/>
                    <form:errors path="pais"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="fechaNacimiento">Fecha de Nacimiento</form:label></th>
                    <td>
                    <form:input path="fechaNacimiento" cssClass="small datePicker"/>
                    <form:errors path="fechaNacimiento"></form:errors>
                    </td>
                </tr>
            </tbody>
        <form:hidden path="id"/>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/autor" class="button last-button a">Cancelar</a>
</form:form>