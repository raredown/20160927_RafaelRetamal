<%-- 
    Document   : Carrito
    Created on : 17-oct-2016, 18:21:56
    Author     : Daw2
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
            boolean finalizar = false;
            String mensaje = "";
            if (sesion.isNew()) {
                ArrayList<Libro> array = new ArrayList();
                sesion.setAttribute("libros", array);
            }
            //comprovamos si es la primera vez que entramos o no
            if (request.getParameter("boton") != null) {
                if (request.getParameter("boton").equals("Anadir")) {
                    String nombreLib = request.getParameter("libro");
                    Libro librecito = new Libro();

                    //Comprovamos si es un numero corregtor
                    try {
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        if (cantidad > 0) {
                            //comprovamos si a selecionado un libro 
                            if (nombreLib == null) {
                                //    out.println("no as cojido nigun libro");
                                mensaje = "no as cojido nigun libro";
                            } else {
                                ArrayList<Libro> array = (ArrayList) sesion.getAttribute("libros");
                                Iterator<Libro> it = array.iterator();
                                librecito.setNombre(nombreLib);
                                boolean estas = false;
                                while (it.hasNext()) {
                                    Libro libre = it.next();
                                    //out.println(libre.getNombre());
                                    // out.println("iiuijj");

                                    if (libre.getNombre().equals(librecito.getNombre())) {
                                        estas = true;
                                        // out.println("igual");
                                        mensaje = "Has sumado la cantidad de " + cantidad + " al libro " + libre.getNombre();
                                        libre.setCantidad(cantidad + libre.getCantidad());
                                    }
                                }
                                if (estas) {
                                } else {
                                    mensaje = "Has introducido la cantidad de " + cantidad + " al libro " + nombreLib;

                                    librecito.setCantidad(cantidad);
                                    array.add(librecito);

                                }
                                //debemos comprobar si esta vacio o no y los errores

                                sesion.setAttribute("libros", array);
                            }

                        } else {
                            //  out.println("numero no puede ser 0 o negativo");
                            mensaje = "numero no puede ser 0 o negativo";
                        }
                    } catch (Exception e) {
                        //out.println("numero no corrector");
                        mensaje = "numero no corrector";
                    }

                } else if (request.getParameter("boton").equals("Finalizar compra")) {
                    finalizar = true;
                    ArrayList<Libro> array = (ArrayList) sesion.getAttribute("libros");
                    Iterator<Libro> it = array.iterator();
                    while (it.hasNext()) {
                        Libro libre = it.next();
                       // out.println(libre.getNombre());
                       // out.println(libre.getCantidad());
                    }

                }
            }

        %>
        
        <div class="container">
            <div class="row">
                <div class="col-xs-6 col-sm-4"> 
                    <h2>Bienvenido a mi tienda¡</h2>
                    <img src="../imagenes/carrito.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236">
                    <div id="error">

                    </div>
                    <% if (!finalizar) {
                    %>
                    <% if (!mensaje.equals("")) {
                    %>
                    <div class="panel panel-default">
                        <div class="panel-heading">Panel Informacion</div>
                        <div class="panel-body"><%= mensaje%></div>
                    </div>

                    <%}
                    %>
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
                        <input type="submit" name="boton" value="Anadir">
                        <input type="submit" name="boton" value="Finalizar compra">
                        <input type="reset" value="limpiar">
                    </form>
                    <% } else {
                        ArrayList<Libro> arrayPrueba = new ArrayList();
                        boolean lleno = true;
                        if (sesion.getAttribute("libros").equals(arrayPrueba)) {
                            //out.println("vacio");
                            lleno = false;
                        }
                    %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Libros</th>
                                <th>Cantidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Libro> array = (ArrayList) sesion.getAttribute("libros");
                                Iterator<Libro> it = array.iterator();
                                while (it.hasNext()) {
                                    Libro libre = it.next();
                                    //out.println(libre.getNombre());
                                    //out.println(libre.getCantidad());


                            %>
                        <tr><td><%= libre.getNombre()%></td><td><%= libre.getCantidad()%></td></tr>

                        <% }%>
                        </tbody>
                    </table>

                    <%
                        if (lleno) {
                    %>
                    <p class="text-center"><a href="../index.html">gracias por su compra</a></p>
                    <%} else {
                    %>
                    <p class="text-center"><a href="../index.html">no has comprado nada</a></p>
                    <%
                            }

                            sesion.invalidate();
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
