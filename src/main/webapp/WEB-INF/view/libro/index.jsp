<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de Autores</h2>
    <a href="${pageContext.request.contextPath}/autor/agregar" class="button first-button border-right">Agregar</a>
    <hr>
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>País</th>
                <th>Fecha de Nacimiento</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${autores}" var="autor">
            <tr onclick="location.href='${pageContext.request.contextPath}/autor/editar/${autor.id}'">
                <td>${autor.nombre}</td>
                <td>${autor.apellidos}</td>
                <td>${autor.pais}</td>
                <td>${autor.fechaNacimiento}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>

