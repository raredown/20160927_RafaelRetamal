<%-- 
    Document   : Carrito
    Created on : 17-oct-2016, 18:21:56
    Author     : Daw2
--%>

<%@page import="es.albarregas.beans.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../js/jquery-3.1.1.js"></script>
        <link rel="stylesheet" href="../cosascss/estilos.css" media="screen" title="no title">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession(true);
            //comprovamos si es la primera vez que entramos o no
            if (request.getParameter("boton") != null) {
                String nombreLib = request.getParameter("libro");
                Libro librecito = new Libro();
                //Comprovamos si es un numero corregtor
                try {
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    librecito.setCantidad(cantidad);
                } catch (Exception e) {
                    out.println("numero no corrector");
                }
                //comprovamos si a selecionado un libro 
                if (nombreLib == null) {
                    out.println("no as cojido nigun libro");
                } else {
                    librecito.setNombre(nombreLib);
                }
                //preguntamos si la sesion a sido creada por primera vez o no para hacer el nuevo parametro o cogerlo
            }

        %>
        <h1>Hello World!</h1>
        <div class="container">
            <div class="row">
                <div class="col-xs-6 col-sm-4"> 
                    <div id="error">

                    </div>
                    <form method="post" action="../jsp/Carrito.jsp">
                        <label for="">Carrito:</label><br>
                        <select size="4" name="libro">
                            <option name="libro" value="Juego de Tronos">Juego de Tronos</option>
                            <option name="libro" value="Juego del Hambre">Juegos del hambre</option>
                            <option name="libro" value="El principito">El principito</option>
                            <option name="libro" value="El jardin secreto">El jardin secreto</option>
                            <option name="libro" value="Alicia en el pais de la maravillas">Alicia en el pais de la maravilla</option>
                            <option name="libro" value="Crimen y castigo">Crimen y castigo</option>
                            <option name="libro" value="El manual de la vida">El manual de la vida</option>
                            <option name="libro" value="Sobre la felicidad">Sobre la felicidad</option>
                        </select>
                        <div class="form-group">
                            <label for="cantidad">Cantidad</label>
                            <input type="text" class="form-control" id="cantidad" name="cantidad">
                        </div>
                        <input type="submit" name="boton" value="Añadir">
                        <input type="submit" name="boton" value="Finalizar compra">
                        <input type="reset" value="limpiar">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
