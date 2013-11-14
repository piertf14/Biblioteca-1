<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/tipoPublicacion/guardar" commandName="tipopublicacion">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <tbody>
            <tr>
                <th>
                    <form:label path="descripcion">Descripción</form:label>
                    </th>
                    <td>
                    <form:input path="descripcion" cssClass="large" placeholder="ingrese descripción"></form:input>
                    <form:errors path="descripcion" cssClass="error"/>
                </td>
            </tr>
        </tbody>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/tipoPublicacion" class="button last-button a">Cancelar</a>
    <form:hidden path="id"/>
</form:form>