/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daw2
 */
@WebServlet(name = "CicloVida", urlPatterns = {"/ciclo"})
public class Parametros extends HttpServlet {
  
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
            out.println("<head>");
            out.println("<title>Par&aacute;metros</title>");  
            out.println("<link rel=\"stylesheet\" href=\"cosascss/estilos.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/jquery-3.1.1.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" media=\"screen\" title=\"no title\">\n");
            out.println("<script src=\"js/bootstrap.min.js\"></script>\n");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Par&aacute;metros iniciales</h1>");
            out.println("<div class=\"panel panel-primary\">");
            out.println("<div class=\"panel-heading\">Cabeceras</div>");
            out.println(" <div class=\"panel-body\">");
            java.util.Enumeration<String> parametros = request.getParameterNames();
            
            while(parametros.hasMoreElements()){
                String elemento = parametros.nextElement();
                String valor = request.getParameter(elemento);
                out.println("<p>" + elemento + " - " + valor + "</p>");
            }
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }
      
    
    

}
