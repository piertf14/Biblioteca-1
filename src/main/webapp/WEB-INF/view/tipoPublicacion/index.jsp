<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de Tipos de publicación</h2>
    <a href="${pageContext.request.contextPath}/tipoPublicacion/agregar"
       class="button first-button border-right">Agregar</a>
    <hr>
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>Descripción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tipospublicacion}" var="tipopublicacion">
            <tr onclick="location.href='${pageContext.request.contextPath}/tipoPublicacion/editar/${tipopublicacion.id}'">
                <td>${tipopublicacion.descripcion}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>