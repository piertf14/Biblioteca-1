<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
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
            <h1>Publicaciones - <tiles:insertAttribute name="body"></tiles:insertAttribute></h1>
        </header>
        <section>
            <article>
                <h2>Lista de publicaciones</h2>
                <a class="button" href="#new-publicacion">Agregar</a>		
                <form id="search" method="post" action="">
                    <input type="text" placeholder="buscar personal...">
                    <input type="submit" value="Buscar">
                </form>

                <table cellpadding="0" cellspacing="0" border="0" class="list">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Subtitulo</th>
                            <th>Editor</th>
                            <th>N&uacute;mero</th>
                            <th>Fecha de ediciÃ³n</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="over">
                            <td>Piura progresa</td>
                            <td></td>
                            <td>Correo</td>
                            <td>12323</td>
                            <td>2009</td>
                        </tr>
                        <tr class="over">
                            <td>Piura progresa</td>
                            <td></td>
                            <td>Correo</td>
                            <td>453223</td>
                            <td>2013</td>
                        </tr>

                    </tbody>
                </table>
            </article>
            <article>
                <h2>Ingresar publicaciÃ³n</h2>
                <form method="post" action="">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                            <tr>
                                <th>TÃ­tulo</th>
                                <td>
                                    <input type="text" name="" placeholder="ingrese un tÃ­tulo">
                                </td>
                            </tr>
                            <tr>
                                <th>SubtÃ­tulo</th>
                                <td><input type="text" name="" placeholder="ingrese un subtÃ­tulo"></td>
                            </tr>
                            <tr>
                                <th>Editor</th>
                                <td><input type="text" name="" placeholder="ingrese un editor"></td>
                            </tr>
                            <tr>
                                <th>NÃºmero</th>
                                <td><input type="text" name="" placeholder="ingrese un nÃºmero"></td>
                            </tr>
                            <tr>
                                <th>Fecha EdiciÃ³n</th>
                                <td><input type="date" name="" ></td>
                            </tr>
                            <tr>
                                <th>Tipo</th>
                                <td>
                                    <select>
                                        <option>Selecciona</option>
                                    </select>
                                    <a href="#new-tipopublicacion">Crear tipo de publicaciÃ³n</a>
                                </td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Guardar">
                                    <input type="reset" value="Cancelar">
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </form>
            </article>
            <article id="new-tipopublicacion">
                <h2>Tipo de PublicaciÃ³n</h2>
                <form method="post" action="">
                    <!-- id, descripcion -->
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                            <tr>
                                <th>DescripciÃ³n</th>
                                <td>
                                    <input type="text" name="" placeholder="ingrese una descripciÃ³n">
                                </td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Guardar">
                                    <input type="reset" value="Cancelar">
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </form>
            </article>
        </section>
    </body>
</html>