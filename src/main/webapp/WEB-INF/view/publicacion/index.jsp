<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <th>Número</th>
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
    <h2>Ingresar publicación</h2>
    <form method="post" action="">
        <table border="0" cellpadding="0" cellspacing="0">
            <tbody>
                <tr>
                    <th>Título</th>
                    <td>
                        <input type="text" name="" placeholder="ingrese un título">
                    </td>
                </tr>
                <tr>
                    <th>Subtítulo</th>
                    <td><input type="text" name="" placeholder="ingrese un subtítulo"></td>
                </tr>
                <tr>
                    <th>Editor</th>
                    <td><input type="text" name="" placeholder="ingrese un editor"></td>
                </tr>
                <tr>
                    <th>Número</th>
                    <td><input type="text" name="" placeholder="ingrese un nÃºmero"></td>
                </tr>
                <tr>
                    <th>Fecha Edición</th>
                    <td><input type="date" name="" ></td>
                </tr>
                <tr>
                    <th>Tipo</th>
                    <td>
                        <select>
                            <option>Selecciona</option>
                        </select>
                        <a href="#new-tipopublicacion">Crear tipo de publicación</a>
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
