<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de Libros</h2>
    <a href="${pageContext.request.contextPath}/libro/agregar" class="button first-button border-right">Agregar</a>
    <hr>
    <!-- id, isbn, titulo, editorial, numeropag, autor_id -->
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>ISBN</th>
                <th>Título</th>
                <th>Editorial</th>
                <th>Número de páginas</th>
                <th>Autor</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${libros}" var="libro">
            <tr onclick="location.href='${pageContext.request.contextPath}/libro/editar/${libro.id}'">
                <td>${libro.isbn}</td>
                <td>${libro.titulo}</td>
                <td>${libro.editorial}</td>
                <td>${libro.numeropag} páginas</td>
                <td>${libro.autor}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>

