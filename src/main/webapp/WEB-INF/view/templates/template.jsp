<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Biblioteca - <tiles:insertAttribute name="title"></tiles:insertAttribute></title>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bower_components/normalize-css/normalize.css">

<!--link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/datatables/media/css/demo_page.css"/-->
<!--link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/datatables/media/css/demo_table.css"/-->

        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/datatables/media/css/demo_table_jui.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/datatables/media/css/jquery.dataTables.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/jquery-ui/themes/overcast/jquery-ui.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/estilo.css">

<!--link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/datatables/media/css/jquery.dataTables_themeroller.css"/-->
<!--script src="${pageContext.request.contextPath}/static/bower_components/jquery/jquery.js"></script-->
        <script src="${pageContext.request.contextPath}/static/bower_components/datatables/media/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/static/bower_components/datatables/media/js/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/static/bower_components/jquery-ui/ui/jquery-ui.js"></script>

    </head>
    <body>
        <nav>
            <ul>
                <li class="title">Biblioteca 1</li>
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
            <h1><tiles:insertAttribute name="title"/></h1>
        </header>
        <section>
            <tiles:insertAttribute name="body"/>
        </section>
        <script>
            $(document).ready(function() {
                $(".datePicker").datepicker({
                    dateFormat: "yy-mm-dd"
                });
                oTable = $('#list').dataTable({
                    "bJQueryUI": true,
                    "sPaginationType": "full_numbers",
                    "oLanguage": {
                        "sUrl": "${pageContext.request.contextPath}/static/datatables-language-spanish.json"
                    }
                });
            });
        </script>
    </body>
</html>