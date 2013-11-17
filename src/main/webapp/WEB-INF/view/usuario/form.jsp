<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/usuario/guardar" commandName="usuario">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <!-- id, dni, password, nombres, apellidos, telefono, direccion, tipousuario_id -->
        <tbody>            
            <tr>
                <th><form:label path="dni">DNI</form:label></th>
                <td>
                    <form:input path="dni" cssClass="small" placeholder="ingrese un dni"></form:input>
                    <form:errors path="dni" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="nombres">Nombres</form:label></th>
                <td><form:input path="nombres" cssClass="large" placeholder="ingrese un nombre"/></td>
            </tr>
            <tr>
                <th><form:label path="apellidos">Apellidos</form:label></th>
                    <td>
                    <form:input path="apellidos" cssClass="large" placeholder="ingrese un apellido"/>
                    <form:errors path="apellidos"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="telefono">Teléfono</form:label></th>
                    <td>
                    <form:input path="telefono" cssClass="medium"/>
                    <form:errors path="telefono"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="direccion">Dirección</form:label></th>
                    <td>
                    <form:input path="direccion" cssClass="large"/>
                    <form:errors path="direccion"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="tipousuario.id">Tipo de usuario</form:label></th>
                    <td>
                    <form:select path="tipousuario.id">
                        <form:options items="${tiposusuario}" itemValue="id"></form:options>
                    </form:select>
                    </td>
                </tr>
            </tbody>
        <form:hidden path="id"/>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/usuario" class="button last-button a">Cancelar</a>
</form:form>