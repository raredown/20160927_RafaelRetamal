/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
@WebServlet(name = "FormularioGuayDos", urlPatterns = {"/FormGuayDos"})
public class FormularioGuayDos extends HttpServlet {
/**
 * Creo varias variables de errores por que controlo varios errores de la misma variable
 */
    public boolean errNombre = true;
    public boolean errPasword = true;
    public boolean errUsuario = true;
/**
 * En este metodo compruebo si ahi errores y creo el panel de los errores para luego pintaro
 * @param request
 * @return un string q es el panel
 * @throws ServletException
 * @throws IOException 
 */
    protected String controladorFormulario(HttpServletRequest request)
            throws ServletException, IOException {

        StringBuilder divError;
        divError = new StringBuilder();
        //Comprobar
        divError.append("<div class=\"alert alert-danger\">");
        if ("".equals(request.getParameter("nombre"))) {
            divError.append("<p>nombre vacio</p>");
            errNombre = true;

        } else if (request.getParameter("nombre").length() < 3) {
            errNombre = true;
            divError.append("<p>nombre muy pequeno</p>");

        } else {
            errNombre = false;
        }
        if ("".equals(request.getParameter("usuario"))) {
            errUsuario = true;
            divError.append("<p>usuario vacio</p>");

        } else if (request.getParameter("usuario").length() < 3) {
            errUsuario = true;
            divError.append("<p>usuario muy pequeno</p>");

        } else {
            errUsuario = false;
        }
        if ("".equals(request.getParameter("Password"))) {
            errPasword = true;
            divError.append("<p>Password vacio</p>");

        } else if (request.getParameter("Password").length() < 3) {
            errPasword = true;
            divError.append("<p>Password muy pequeno</p>");

        } else {
            errPasword = false;
        }
        divError.append("</div>");
        return divError.toString();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //pinto la cabecera por que para las dos pagina que ejecuta el servlet son iguales
            
            //pongo las variables de errores a true o false dependiendo 
            String panelError = controladorFormulario(request);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioCorrecto</title>");
            out.println("<link rel=\"stylesheet\" href=\"cosascss/estilos.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/jquery-3.1.1.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/bootstrap.min.js\"></script>\n");
            out.println("</head>");
            out.println("<body>");
            //compuebo si ahi ahi errores para pintar errores 
            if (errNombre || errPasword || errUsuario) {

                out.println("<div class=\"container\">\n");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-xs-6 col-sm-4\"> \n");
                //pinto los errores
                out.println(panelError);
                //si no ahi nigun parametro de volver pinto un form hidden de los datos para la segunda pagina y el boton de volver
                if (request.getParameter("volver") == null) {
                    out.println("<form method=\"post\" action=\"FormGuayDos\">");

                    out.println("<input type=\"hidden\" class=\"form-control\" id=\"nombre\" name=\"nombre\" placeholder=\"Nombre\" value=\"" + request.getParameter("nombre") + "\">");
                    out.println("<input type=\"hidden\" class=\"form-control\" id=\"apellidos\" name=\"apellidos\"  value=\"" + request.getParameter("apellidos") + "\">");
                    out.println("<input type=\"hidden\" name=\"bday\" value=\"" + request.getParameter("bday") + "\">");
                    out.println("<input type=\"hidden\" class=\"form-control\" id=\"usuario\" name=\"usuario\" value=\"" + request.getParameter("usuario") + "\" >");
                    out.println("<input type=\"hidden\" class=\"form-control\" id=\"pwd\" name=\"Password\" value=\"" + request.getParameter("Password") + "\">");

                    if (request.getParameter("deporte") != null) {
                        out.println(" <input type=\"hidden\" name=\"deporte\" value=\"deporte\" checked>");
                    }
                    if (request.getParameter("lectura") != null) {
                        out.println(" <input type=\"hidden\" name=\"lectura\" value=\"lectura\" checked>");
                    }
                    if (request.getParameter("vagear") != null) {
                        out.println(" <input type=\"hidden\" name=\"vagear\" value=\"vagear\" checked>");
                    }
                    if (request.getParameter("holgacenear") != null) {
                        out.println(" <input type=\"hidden\" name=\"holgacenear\" value=\"holgacenear\" checked>");
                    }
                    if ("hombre".equals(request.getParameter("intradio"))) {
                        out.println("<input type=\"hidden\" name=\"intradio\" value=\"hombre\" checked>");

                    } else {

                        out.println("<input type=\"hidden\" name=\"intradio\"  value=\"mujer\" checked>");
                    }
                    out.println("<input type='submit' name=\"volver\" value='volver'/>");

                    out.println("</form>");
                    out.println("</div>");
                    out.println("</div>");
                } 
                //si exicte el boton volver pintamos el mismo formulario q en el html
                else {
                    out.println("<form method=\"post\" action=\"FormGuayDos\">");
                    out.println("<fieldset>");
                    out.println("<legend>Datos personales</legend>");
                    if (errNombre) {
                        out.println("<div class=\"form-group has-error has-feedback\">");

                    } else {
                        out.println("<div class=\"form-group has-success has-feedback\">");
                    }
                    //out.println("<div class=\"form-group\">");

                    out.println("<label for=\"usuarioPrueba\">*Nombre</label>");
                    out.println("<input type=\"text\" class=\"form-control\" id=\"nombre\" name=\"nombre\" placeholder=\"Nombre\" value=\"" + request.getParameter("nombre") + "\">");
                    out.println("</div>");
                    out.println("<div class=\"form-group\">");
                    out.println("<label for=\"apellidos\">Apellidos</label>");
                    out.println("<input type=\"text\" class=\"form-control\" id=\"apellidos\" name=\"apellidos\"  value=\"" + request.getParameter("apellidos") + "\">");
                    out.println("</div>");
                    out.println("<div class=\"form-group\">");
                    out.println("<label for=\"fecha\">Fecha</label>");
                    out.println("<input type=\"date\" name=\"bday\" value=\"" + request.getParameter("bday") + "\">");

                    out.println("</div>");
                    out.println("<div class=\"radio\">");
                    if ("hombre".equals(request.getParameter("intradio"))) {
                        out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"intradio\" value=\"hombre\" checked>Hombre</label>");
                        out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"intradio\"  value=\"mujer\">Mujer</label>");
                    } else {
                        out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"intradio\" value=\"hombre\" >Hombre</label>");
                        out.println("<label class=\"radio-inline\"><input type=\"radio\" name=\"intradio\"  value=\"mujer\" checked>Mujer</label>");
                    }

                    out.println("</div>");
                    out.println("</fieldset>");
                    out.println("<fieldset>");
                    out.println("<legend>Informacion general</legend>");
                    if (errUsuario) {
                        out.println("<div class=\"form-group has-error has-feedback\">");

                    } else {
                        out.println("<div class=\"form-group has-success has-feedback\">");
                    }
                    out.println("<label for=\"usuario\">*Usuario</label>");
                    out.println("<input type=\"text\" class=\"form-control\" id=\"usuario\" name=\"usuario\" value=\"" + request.getParameter("usuario") + "\" >");
                    out.println("</div>");
                    if (errPasword) {
                        out.println("<div class=\"form-group has-error has-feedback\">");

                    } else {
                        out.println("<div class=\"form-group has-success has-feedback\">");
                    }
                    out.println("<label for=\"pwd\" >*Password:</label>");
                    out.println("<input type=\"password\" class=\"form-control\" id=\"pwd\" name=\"Password\" value=\"" + request.getParameter("Password") + "\">");
                    out.println("</div>");
                    out.println("</fieldset>");
                    out.println("<fieldset>");
                    out.println("<legend>Informacion general</legend>");
                    // out.println(request.getParameter("intradio"));
                    if (request.getParameter("deporte") != null) {
                        out.println(" <input type=\"checkbox\" name=\"deporte\" value=\"deporte\" checked> Deporte<br>");
                    } else {
                        out.println(" <input type=\"checkbox\" name=\"deporte\" value=\"deporte\"> Deporte<br>");

                    }
                    if (request.getParameter("lectura") != null) {
                        out.println(" <input type=\"checkbox\" name=\"lectura\" value=\"lectura\" checked> lectura<br>");
                    } else {
                        out.println(" <input type=\"checkbox\" name=\"lectura\" value=\"lectura\"> lectura<br>");

                    }
                    if (request.getParameter("vagear") != null) {
                        out.println(" <input type=\"checkbox\" name=\"vagear\" value=\"vagear\" checked> Vagear<br>");
                    } else {
                        out.println(" <input type=\"checkbox\" name=\"vagear\" value=\"vagear\"> Vagear<br>");

                    }
                    if (request.getParameter("holgacenear") != null) {
                        out.println(" <input type=\"checkbox\" name=\"holgacenear\" value=\"holgacenear\" checked> Holgacenear<br>");
                    } else {
                        out.println(" <input type=\"checkbox\" name=\"holgacenear\" value=\"holgacenear\"> Holgacenear<br>");

                    }
                    out.println("</fieldset>");
                    out.println("");
                    out.println("<input type='submit' name=\"Bdos\" value='validar'/>");
                    out.println("<input type=\"button\" value=\"reset\" onclick = \"location='" + request.getContextPath() + "/html/formcorrectodos.html'\"/>");
                    out.println("</form>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                }
            } //Else de if primero que compruebas los errores 
            // si no ahi errores mostramos la pantallas de datos enviados
            else {
                out.println("<p>datos enviado</p>");
                out.println("  <div class=\"panel-body\">");

                java.util.Enumeration<String> parametros = request.getParameterNames();

                while (parametros.hasMoreElements()) {
                    String elemento = parametros.nextElement();
                    String[] parametritos;
                    parametritos = request.getParameterValues(elemento);
                    out.println("<p> <strong>" + elemento + " : </strong>");

                    for (String parametrito : parametritos) {
                        out.println(parametrito);
                    }
                    out.println("</p>");

                }
                out.println("  <div>");
                out.println("  <div>");
                out.println("<input type=\"button\" value=\"volver\" onclick = \"location='" + request.getContextPath() + "/html/formcorrectodos.html'\"/>");

            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
