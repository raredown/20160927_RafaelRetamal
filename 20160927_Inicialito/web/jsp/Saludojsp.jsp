<%-- 
    Document   : saludojsp
    Created on : 10-oct-2016, 17:21:19
    Author     : Daw2
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            //metodo que comprueba a que franja horaria estamos 
            public String metodoHora() {
                Calendar c = Calendar.getInstance();
                // String dia = Integer.toString(c.get(Calendar.DATE));
                // String mes = Integer.toString(c.get(Calendar.MONTH));
                //String annio = Integer.toString(c.get(Calendar.YEAR));
                String buenas = null;
                if (c.get(Calendar.HOUR_OF_DAY) > 7 && c.get(Calendar.HOUR_OF_DAY) < 12) {
                    buenas = "Dias";
                }
                if (c.get(Calendar.HOUR_OF_DAY) > 12 && c.get(Calendar.HOUR_OF_DAY) < 20) {
                    buenas = "Tarde";
                }
                if (buenas.equals(null)) {
                    buenas = "Noche";
                }
                return buenas;
            }
        %>
        <h1>Buenas
            <%= metodoHora()%>
            <%
                if (request.getParameter("intradio").equals("hombre")) {

            %>
            señor
            <% } else {
            %>
            señora
            <% }%>

            <%=request.getParameter("usuario")%>!
        </h1>

    </body>
</html>
