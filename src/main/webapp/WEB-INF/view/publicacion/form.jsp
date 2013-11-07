<%@page contentType="text/html" pageEncoding="UTF-8"%>
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