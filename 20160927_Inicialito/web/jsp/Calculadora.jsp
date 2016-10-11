<%-- 
    Document   : Calculadora
    Created on : 10-oct-2016, 18:08:22
    Author     : Daw2
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="../js/jquery-3.1.1.js"></script>
        <link rel="stylesheet" href="../cosascss/estilos.css" media="screen" title="no title">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>   
        <div class="container">
            <div class="row">

                <h1>Calculadora</h1>

                <%!
                    public String calculetor(String primerNumero, String segundoNumero, String operacion) {
                        String resultado = null;
                        try {
                            int param1 = Integer.parseInt(primerNumero);
                            int param2 = Integer.parseInt(segundoNumero);
                            switch (operacion) {

                                case "sumar":
                                    int suma = param1 + param2;
                                    resultado = "Los numero " + primerNumero + "," + segundoNumero + " en la operacion de " + operacion + "es igual a" + String.valueOf(suma);
                                    break;
                                case "restar":
                                    int resta = param1 - param2;
                                    resultado = "Los numero " + primerNumero + "," + segundoNumero + " en la operacion de " + operacion + "es igual a" + String.valueOf(resta);
                                    break;
                                case "dividir":
                                    try {
                                        int division = param1 / param2;
                                        resultado = "Los numero " + primerNumero + "," + segundoNumero + " en la operacion de " + operacion + "es igual a" + String.valueOf(division);
                                    } catch (ArithmeticException e) {
                                        resultado = "un numero no puede ser divisible por 0";
                                    }

                                    break;
                                case "multiplicar":
                                    int multiplicar = param1 * param2;
                                    resultado = "Los numero " + primerNumero + "," + segundoNumero + " en la operacion de " + operacion + "es igual a" + String.valueOf(multiplicar);
                                    break;
                            }
                        } catch (NumberFormatException ex) {
                            resultado = "Alguno de los números no contenía dígitos válidos";
                        }
                        return resultado;
                    }

                    public String metodoHora() {
                        java.util.Date fecha = new Date();
                        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es"));
                        String fechados = formato.format(new Date());
                        Calendar c = Calendar.getInstance();
                        String dia = Integer.toString(c.get(Calendar.DATE));
                        String mes = Integer.toString(c.get(Calendar.MONTH));
                        String annio = Integer.toString(c.get(Calendar.YEAR));
                        return "La fecha de hoy es " + dia + "/" + mes + "/" + annio + "o como a jesus le gusta "+fechados;
                    }

                %>
                <%

                    if (request.getParameter("boton") != null) {

                        String navegador = request.getHeader("user-agent");
                        String error = calculetor(request.getParameter("primernumber"), request.getParameter("segundonumber"), request.getParameter("optradio"));
                        String fecha = metodoHora();
                %> <div class="panel panel-warning">
                    <div class="panel-body">
                        Información
                    </div><div class="panel-footer"><p><%= error%></p><p><%= navegador%></p><p><%= fecha%></p></div> </div><%
                        }
                            %>


                <form action="../jsp/Calculadora.jsp">
                    <div class="form-group">
                        <label for="numeroUno">Primer numero:</label>
                        <input type="text" name="primernumber" value=""> 
                    </div>
                    <div class="form-group">
                        <label for="numeroDos">Segundo numero:</label>
                        <input type="text" name="segundonumber" value="">
                    </div>
                    <br>
                    <div class="radio">
                        <label class="radio-inline"><input type="radio" name="optradio" value="sumar" checked="cheked">sumar</label>
                        <label class="radio-inline"><input type="radio" name="optradio"  value="restar">restar</label>
                        <label class="radio-inline"><input type="radio" name="optradio"  value="dividir">dividir</label>
                        <label class="radio-inline"><input type="radio" name="optradio"  value="multiplicar">multiplicar</label>
                    </div>
                    <br>
                    <br>
                    <input type="submit" name="boton" value="Enviar">
                    <input type="reset" value="reset">
                    <input type=button onClick="location.href = '../index.html'" value='indice'>
                </form>
            </div>
        </div>
    </div> 
</body>
</html>
