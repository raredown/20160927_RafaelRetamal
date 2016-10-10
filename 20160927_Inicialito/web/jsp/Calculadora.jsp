<%-- 
    Document   : Calculadora
    Created on : 10-oct-2016, 18:08:22
    Author     : Daw2
--%>

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
                            resultado = String.valueOf(suma);
                            break;
                        case "restar":
                            int resta = param1 - param2;
                            resultado = String.valueOf(resta);
                            break;
                        case "dividir":
                            try {
                                int division = param1 / param2;
                                resultado = String.valueOf(division);
                            } catch (ArithmeticException e) {
                                resultado ="un numero no puede ser divisible por 0";
                            }

                            break;
                        case "multiplicar":
                            int multiplicar = param1 * param2;
                            resultado = String.valueOf(multiplicar);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    resultado = "Alguno de los números no contenía dígitos válidos";
                }
                return resultado;
            }

        %>
        <%

            if (request.getParameter("boton") != null) {

                String error = calculetor(request.getParameter("primernumber"), request.getParameter("segundonumber"), request.getParameter("optradio"));
        %><%= error%><%
        } 
        %>


        <form action="../jsp/Calculadora.jsp">
            Primer numero:<input type="text" name="primernumber" value="">
            Segundo numero:<input type="text" name="segundonumber" value="">
            <br>
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
        </form>
    </body>
</html>
