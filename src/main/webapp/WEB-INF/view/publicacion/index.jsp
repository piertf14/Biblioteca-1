<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de publicaciones</h2>
    <a href="${pageContext.request.contextPath}/publicacion/agregar" class="button first-button border-right">Agregar</a><a class="button last-button">Tipos de publicación</a>
    <hr>
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>Titulo</th>
                <th>Subtitulo</th>
                <th>Editor</th>
                <th>Número</th>
                <th>Fecha de edición</th>
                <th>Tipo de publicación</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${publicaciones}" var="publicacion">
            <tr class="over">
                <td>${publicacion.titulo}</td>
                <td>${publicacion.subtitulo}</td>
                <td>${publicacion.editor}</td>
                <td>${publicacion.numero}</td>
                <td>${publicacion.fechaEdicion}</td>
                <td>${publicacion.tipopublicacion.descripcion}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>

