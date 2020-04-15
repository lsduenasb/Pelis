/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;

/**
 *
 * @author Equipo
 */
public class RealizarRegistro extends HttpServlet {

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

        String nombreUsuario="";
        String nombre="";
        String apellido="";
        String edadn="";
        int edad=0;
        String contrasena="";
        String correo="";
        nombreUsuario=request.getParameter("usuario");
        nombre=request.getParameter("nombre");
        apellido=request.getParameter("apellidos");
        edadn=request.getParameter("edad");
        contrasena=request.getParameter("contrasena");
        correo=request.getParameter("correo");
        try{
          edad=Integer.parseInt(edadn);  
        }catch(Exception e){
            //lo manda a otra vista, ingrese solo numeros en la edad
            request.getRequestDispatcher("ERROR.html").forward(request, response);
        }
        
        //Se envian los datos al modelo
        Persona p = new Persona(nombreUsuario, contrasena, nombre, apellido, edad, correo);
        
        //se registra el usuario
        p.registro(nombreUsuario, contrasena, nombre, apellido, edad, correo);
        boolean validarRegistro=p.registro(nombreUsuario, contrasena, nombre, apellido, edad, correo);
        if(validarRegistro==true){
            request.getRequestDispatcher("RegistroExitoso.html").forward(request, response);
        }else{
            request.getRequestDispatcher("RegistroNOExitoso.html").forward(request, response);
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
