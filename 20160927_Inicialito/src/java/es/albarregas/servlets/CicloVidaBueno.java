/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rrd.informatica
 */

@WebServlet(name = "CicloVidaBueno", urlPatterns = {"/vida"})
public class CicloVidaBueno extends HttpServlet {
    @Override
    public void init(ServletConfig config){
         System.out.println("init()");
            }
     @Override
    public void destroy(){
        System.out.println("destroy()");
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("service()");
        }

}
