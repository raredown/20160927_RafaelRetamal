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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daw2
 */
@WebServlet(name = "ContadorVisitasServlet", urlPatterns = {"/ContadorVisitasServlet"})
public class ContadorVisitasCookie extends HttpServlet {

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
        Cookie cookie = null;
        Cookie arrayCookie[] = request.getCookies();
        String fallos = "";
     
        for (int i = 0; i < arrayCookie.length; i++) {
            //Cookie cookie1 = arrayCookie[i];
            
        //}
          // for (Cookie arrayCookie1 : arrayCookie) { 
            //if (arrayCookie[i].getName() != null) {
                if (arrayCookie[i].getName().equals("CONTADOR")) {
                    fallos = "entro";
                    cookie = arrayCookie[i];
                    String valor = cookie.getValue();
                    String valorcito = String.valueOf((Integer.parseInt(valor) + 1));
                    cookie.setValue(valorcito);
              //  }
            }
        }
        if (cookie == null) {
            cookie = new Cookie("CONTADOR", "0");
            cookie.setMaxAge(300000);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"cosascss/estilos.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/jquery-3.1.1.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/bootstrap.min.js\"></script>\n");

            out.println("<title>Servlet Saludo</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h2> Su contador de visitas es : </h2>");

            String botonPulsado = null;
            botonPulsado = request.getParameter("Bdos");
            try {
                if (botonPulsado.equals("Limpiar") && !cookie.getValue().equals("0")) {
                    cookie = new Cookie("CONTADOR", "0");
                    cookie.setMaxAge(300000);

                }
            } catch (Exception e) {
            }
            response.addCookie(cookie);
            out.println("<p>El valor del contador es "+cookie.getValue()+"</p>");
            out.println("<p>El dominio es "+cookie.getDomain()+"</p>");
             out.println("<p>El path es  "+cookie.getPath()+"</p>");
              out.println("<p>El nombre es "+cookie.getName()+"</p>");
               out.println("<p>Es segura "+cookie.getSecure()+"</p>");
                out.println("<p>La version de la cookie es "+cookie.getVersion()+"</p>");
              
            // out.println(fallos);
            out.println("<form method=\"post\" action=\"ContadorVisitasServlet\">\n");
            out.println(" <input type='submit' name=\"Bdos\" value='Subir'/>");
            out.println(" <input type='submit' name=\"Bdos\" value='Limpiar'/>");
            out.println("</form");
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
