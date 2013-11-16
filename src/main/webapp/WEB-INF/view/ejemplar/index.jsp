<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de Autores</h2>
    <a href="${pageContext.request.contextPath}/ejemplar/agregar" class="button first-button border-right">Agregar</a>
    <hr>
    <!-- id, localizacion, anno, estado, libros_id -->
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>Localización</th>
                <th>Año</th>
                <th>Estado</th>
                <th>Libro - Título</th>
                <th>Libro - Autor</th>
                <th>Libro - Editorial</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ejemplares}" var="ejemplar">
            <tr onclick="location.href='${pageContext.request.contextPath}/ejemplar/editar/${autor.id}'">
                <td>${ejemplar.localizacion}</td>
                <td>${ejemplar.anno}</td>
                <td>${ejemplar.estado}</td>
                <td>${ejemplar.libro.titulo}</td>
                <td>${ejemplar.libro.autor}</td>
                <td>${ejemplar.libro.editorial}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>

