<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form:form method="post" action="${pageContext.request.contextPath}/ejemplar/guardar" commandName="ejemplar">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
            <c:forEach items="${messages}" var="message">
                <tr><td>${message}</td></tr>
            </c:forEach>
        </thead>
        <!-- id, localizacion, anno, estado, libros_id -->
        <tbody>            
            <tr>
                <th><form:label path="localizacion">Localización</form:label></th>
                <td>
                    <form:input path="localizacion" cssClass="large" placeholder="ingrese localización"></form:input>
                    <form:errors path="localizacion" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><form:label path="anno">Año</form:label></th>
                <td><form:input path="anno" cssClass="small" placeholder="ingrese el año"/></td>
            </tr>
            <tr>
                <th><form:label path="estado">Estado</form:label></th>
                    <td>
                    <form:checkbox path="estado" value="1"/>
                    </td>
                </tr>
                
                <tr>
                    <th><form:label path="libro.id">Libro</form:label></th>
                    <td>
                    <form:select path="libro.id">
                        <form:options items="${libros}" itemLabel="titulo" itemValue="id"/> 
                    </form:select>
                        
                    </td>
                </tr>
            </tbody>
        <form:hidden path="id"/>
    </table>
    <hr>
    <input type="submit" value="Guardar" class="first-button border-right"><a href="/biblioteca/ejemplar" class="button last-button a">Cancelar</a>
</form:form>