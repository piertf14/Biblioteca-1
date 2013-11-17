<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article>
    <h2>Lista de Autores</h2>
    <a href="${pageContext.request.contextPath}/usuario/agregar" class="button first-button border-right">Agregar</a>
    <hr>
    <!-- id, dni, password, nombres, apellidos, telefono, direccion, tipousuario_id -->
    <table id="list" cellpadding="0" cellspacing="0" border="0">
        <thead>
            <tr>
                <th>DNI</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Tipo de usuario</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
            <tr onclick="location.href='${pageContext.request.contextPath}/usuario/editar/${usuario.id}'">
                <td>${usuario.dni}</td>
                <td>${usuario.nombres}</td>
                <td>${usuario.apellidos}</td>
                <td>${usuario.telefono}</td>
                <td>${usuario.direccion}</td>
                <td>${usuario.tipousuario}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</article>

