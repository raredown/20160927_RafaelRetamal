/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.beans.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daw2
 */
@WebServlet(name = "FormularioSesiones", urlPatterns = {"/FormularioSesiones"})
public class FormularioSesiones extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioSesiones</title>");
            out.println("<link rel=\"stylesheet\" href=\"cosascss/estilos.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/jquery-3.1.1.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/bootstrap.min.js\"></script>\n");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormularioSesiones at " + request.getContextPath() + "</h1>");
            //Formulario la primera vezz que vamos a entrar 
            if (request.getParameter("boton") == null) {

                out.println("<form method=\"post\" action=\"FormularioSesiones\">\n");
                //Recolecion de datos de usuario1
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"usuarioPrueba\">Nombre</label>");
                out.println(" <input type=\"text\" class=\"form-control\" id=\"usuario\" name=\"usuario\" placeholder=\"Nombre\" value=\"\">");
                out.println("</div>");
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"ides\">Id</label>");
                out.println("<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\"\">");
                out.println("</div>");
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"sueldo\">Sueldo</label>");
                out.println("<input type=\"text\" class=\"form-control\" id=\"sueldo\" name=\"sueldo\" value=\"\">");
                out.println("</div>");
                // Recolecion de datos usuario dos 
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"usuarioPrueba\">Nombre 2</label>");
                out.println(" <input type=\"text\" class=\"form-control\" id=\"usuarioDos\" name=\"usuarioDos\" placeholder=\"Nombre\" value=\"\">");
                out.println("</div>");
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"ides\">Id</label>");
                out.println("<input type=\"text\" class=\"form-control\" id=\"idDos\" name=\"idDos\" value=\"\">");
                out.println("</div>");
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"sueldo\">Sueldo</label>");
                out.println("<input type=\"text\" class=\"form-control\" id=\"sueldoDos\" name=\"sueldoDos\" value=\"\">");
                out.println("</div>");
                //Recolecion de datos Usuario tres 
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"usuarioPrueba\">Nombre 3</label>");
                out.println(" <input type=\"text\" class=\"form-control\" id=\"usuarioTres\" name=\"usuarioTres\" placeholder=\"Nombre\" value=\"\">");
                out.println("</div>");
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"ides\">Id</label>");
                out.println("<input type=\"text\" class=\"form-control\" id=\"idTres\" name=\"idTres\" value=\"\">");
                out.println("</div>");
                out.println("<div class=\"form-group\">");
                out.println("<label for=\"sueldo\">Sueldo</label>");
                out.println("<input type=\"text\" class=\"form-control\" id=\"sueldoTres\" name=\"sueldoTres\" value=\"\">");
                out.println("</div>");
                out.println("<input type='submit' name=\"boton\" value='validar'/>");
                //out.println("<input type='submit' name=\"boton\" value='Bvolver'/>");
                out.println("</form>");
                //Fin del primer formulario
            }//Terminacion de Formulario de recogida de datos en este else pintamos que emos recogido y pasamos a la tercera pantalla
            else if (request.getParameter("boton").equals("validar")) {
                HttpSession sesion = request.getSession(true);
                //Recogemos los datos del primer usuario 
                Usuarios usuarioUno = new Usuarios();
                usuarioUno.setNombre(request.getParameter("usuario"));
                usuarioUno.setId(Integer.parseInt(request.getParameter("id")));
                usuarioUno.setSueldo(Float.parseFloat(request.getParameter("sueldo")));

                //Recogemos datos del segundo usuario 
                Usuarios usuarioDos = new Usuarios();
                usuarioDos.setNombre(request.getParameter("usuarioDos"));
                usuarioDos.setId(Integer.parseInt(request.getParameter("idDos")));
                usuarioDos.setSueldo(Float.parseFloat(request.getParameter("sueldoDos")));
                //Recogemos datos del tercer usuario 
                Usuarios usuarioTres = new Usuarios();
                usuarioTres.setNombre(request.getParameter("usuarioTres"));
                usuarioTres.setId(Integer.parseInt(request.getParameter("idTres")));
                usuarioTres.setSueldo(Float.parseFloat(request.getParameter("sueldoTres")));
                //Creamos una array de objeto usuarios 
                Usuarios[] arrayUsuarios = new Usuarios[3];
                arrayUsuarios[0] = usuarioUno;
                arrayUsuarios[1] = usuarioDos;
                arrayUsuarios[2] = usuarioTres;
                //añadimos la sesion al atributo array
                sesion.setAttribute("array", arrayUsuarios);
                out.println("segunda pantalla");
                out.println("<form method=\"post\" action=\"FormularioSesiones\">\n");
                out.println("<input type='submit' name=\"boton\" value='confirmar'/>");
                out.println("</form>");

            }//Tercera pantalla donde mostramos los datos
            else {
                //Recogemos la sesion que viene despues
                HttpSession sesion = request.getSession(true);
                Usuarios[] arrayUsuarios = (Usuarios[]) sesion.getAttribute("array");
                // arrayUsuarios[0].getNombre();
                // out.println(arrayUsuarios[0].getNombre());
                for (int i = 0; i < arrayUsuarios.length; i++) {
                    Usuarios usuario = arrayUsuarios[i];
                    out.println("Usuario " + i + " ");
                    out.println("<br>");
                    out.println("id " + usuario.getId());
                    out.println("<br>");
                    out.println("nombre " + usuario.getNombre());
                    out.println("<br>");
                    out.println("sueldo " + usuario.getSueldo());
                    out.println("<br>");
                }
                out.println("tercera");
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
