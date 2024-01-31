/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet_login es un Servlet que maneja el inicio de sesión en una aplicación web.
 */
@WebServlet(name = "Servlet_login", urlPatterns = {"/Servlet_login"})
public class Servlet_login extends HttpServlet {

    /**
     * Procesa tanto las solicitudes HTTP GET como POST.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de entrada/salida
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtención de parámetros del formulario de inicio de sesión
//        String name = request.getParameter("nombre");
        String user = request.getParameter("usuario");
        String password = request.getParameter("contrasena");
       
        Connection conn = null;
        try {
            // Parámetros para establecer la conexión a la base de datos Sybase
            String URL = "jdbc:sybase:Tds:localhost:2638/prog4";
            String driverClass ="com.sybase.jdbc4.jdbc.SybDataSource";

            try {
                // Carga del driver de la base de datos
                Class.forName(driverClass);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servlet_login.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Establecimiento de la conexión a la base de datos
            conn = DriverManager.getConnection(URL, user, password);
           
            HttpSession sesion = ((HttpServletRequest)request).getSession();
           
            if( conn != null){        
                // Establecimiento de la sesión para el usuario autenticado
                sesion.setAttribute("USUARIO", user);
                // Redireccionamiento a la página index.xhtml después del inicio de sesión exitoso
                request.getRequestDispatcher("faces/index.xhtml").forward(request, response);               
            }
        } catch (SQLException e) {
            // Log del error
            Logger.getLogger(Servlet_login.class.getName()).log(Level.SEVERE, null, e);
            // Enviar mensaje de error a la página
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            // Redirigir de nuevo a la página de inicio de sesión
            request.getRequestDispatcher("faces/login/login.xhtml").forward(request, response);
        }
//        } catch (SQLException e) {
//            // Manejo de errores de conexión a la base de datos
//            request.getRequestDispatcher("faces/login/ErrorLogin.html").forward(request, response);
//        }
    }

    // Métodos HTTP GET y POST

    /**
     * Maneja la solicitud HTTP GET.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de entrada/salida
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Maneja la solicitud HTTP POST.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de entrada/salida
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Retorna una breve descripción del servlet.
     *
     * @return una cadena que contiene la descripción del servlet
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}