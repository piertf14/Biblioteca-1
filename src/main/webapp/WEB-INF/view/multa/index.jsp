<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de Multas</h2>
    <a href="${pageContext.request.contextPath}/multa/agregar" class="button first-button border-right">Agregar</a>
    <hr>
    <!-- id, monto, diasTarde, prestamos_id -->
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>Monto</th>
                <th>Días de retraso</th>
                <th>Prestamo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${multas}" var="multa">
            <tr onclick="location.href='${pageContext.request.contextPath}/multa/editar/${libro.id}'">
                <td>${multa.monto.isbn}</td>
                <td>${multa.diasTarde.titulo}</td>
                <td>${multa.prestamo.usuario.dni}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>

