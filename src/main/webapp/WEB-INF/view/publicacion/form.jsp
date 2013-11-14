<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/publicacion/guardar" commandName="publicacion">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <tbody>
            <tr>
                <th><form:label path="titulo">Título</form:label></th>
                    <td>
                    <form:input path="titulo" id="titulo" cssClass="large" placeholder="ingrese título"></form:input>
                    <form:errors path="titulo" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="subtitulo">Subtítulo</form:label></th>
                <td><form:input path="subtitulo" id="subtitulo" cssClass="large" placeholder="ingrese un subtítulo"/></td>
            </tr>
            <tr>
                <th><form:label path="editor">Editor</form:label></th>
                    <td>
                    <form:input path="editor" id="editor" cssClass="medium" placeholder="ingrese un editor"/>
                    <form:errors path="editor"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="numero">Número</form:label></th>
                    <td>
                    <form:input path="numero" id="numero" cssClass="small" placeholder="ingrese un número"/>
                    <form:errors path="numero"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><form:label path="fechaEdicion">Fecha de Edición</form:label></th>
                    <td>
                    <form:input path="fechaEdicion" readonly="true" id="fechaEdicion" cssClass="datePicker small"/>
                    <form:errors path="fechaEdicion"></form:errors>
                    </td>
                </tr>
                <tr>
                    <th><label for="tipopublicacion">Tipo de Publicación</label></th>
                    <td>
                    <form:select path="tipopublicacion.id">
                        <form:option value="${null}">Seleccione</form:option>
                        <form:options items="${tipospublicacion}" itemValue="id" itemLabel="descripcion"/>
                    </form:select>
                    <a href="${pageContext.request.contextPath}/tipoPublicacion/agregar" class="button first-button last-button">Crear tipo de publicación</a>
                    <form:errors path="tipopublicacion.id"></form:errors>
                    </td>
                </tr>
            </tbody>
            <!--            <tfoot>
                            <tr>
                                <td colspan="2">
            
                                </td>
                            </tr>
                        </tfoot>-->
        <form:hidden path="id"/>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/publicacion" class="button last-button a">Cancelar</a>
</form:form>