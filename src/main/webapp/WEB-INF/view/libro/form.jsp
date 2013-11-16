<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/libro/guardar" commandName="libro">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <tbody>         
            <!-- id, isbn, titulo, editorial, numeropag, autor_id -->
            <tr>
                <th><form:label path="isbn">ISBN</form:label></th>
                <td>
                    <form:input path="isbn" cssClass="small" placeholder="ingrese el isbn"></form:input>
                    <form:errors path="isbn" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="titulo">Título</form:label></th>
                <td><form:input path="titulo" cssClass="medium" placeholder="ingrese un título"/></td>
            </tr>
            <tr>
                <th><form:label path="editorial">Editorial</form:label></th>
                    <td>
                    <form:input path="editorial" cssClass="large" placeholder="ingrese una editorial"/>
                    <form:errors path="editorial"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="numeropag">Número de páginas</form:label></th>
                    <td>
                    <form:input path="numeropag" type="number" min="1" cssClass="small" />
                    <form:errors path="numeropag"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="autor.id">Autor</form:label></th>
                <td>
                <form:select path="autor.id">
                    <form:options items="${autores}" itemValue="id"/>
                </form:select>
                </td>
                </tr>
            </tbody>
        <form:hidden path="id"/>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/libro" class="button last-button a">Cancelar</a>
</form:form>