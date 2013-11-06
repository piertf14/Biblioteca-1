<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Biblioteca - <tiles:insertAttribute name="title"></tiles:insertAttribute></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="/biblioteca/static/vendor/normalize-css/normalize.css">
        <link rel="stylesheet" type="text/css" href="/biblioteca/static/css/estilo.css">
        <script src="/biblioteca/static/vendor/jquery/jquery.js"></script>
    </head>
    <body>
        <nav>
            <ul>
                <li class="title">Biblioteca</li>
                <li><a href="viewUsuarios.html">Usuario</a></li>
                <li><a href="viewReservas.html">Reservas</a></li>
                <li><a href="viewPrestamos.html">Préstamos</a></li>
                <li><a href="viewLibros.html">Libros</a></li>
                <li class="selected"><a href="viewPublicaciones.html">Publicaciones</a></li>

                <!-- -->
                <li class="right"><a href="logout.html">Cerrar sesión</a></li>
                <li class="title right">Ginna Santiago</li>
                <!-- -->
            </ul>
        </nav>
        <header>
            <h1><tiles:insertAttribute name="title"></tiles:insertAttribute></h1>
        </header>
        <section>
        <tiles:insertAttribute name="body"></tiles:insertAttribute>
        </section>
    </body>
</html>