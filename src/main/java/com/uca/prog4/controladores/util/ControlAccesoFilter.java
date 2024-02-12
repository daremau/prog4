/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uca.prog4.controladores.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/faces/*") // Este filtro se aplicará a todas las URLs que coincidan con este patrón.
public class ControlAccesoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método para inicialización del filtro. Se llama una vez cuando el filtro se carga por primera vez.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession(false); // false indica que no se debe crear una nueva sesión si no existe una.

        String path = req.getRequestURI().substring(req.getContextPath().length());
        
        boolean isLoginPage = path.equals("/faces/login/login.xhtml") || path.equals("/");

        if (session != null && session.getAttribute("USUARIO") != null || isLoginPage) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    public void destroy() {
        // Método para la limpieza del filtro. Se llama una vez cuando el filtro se está por destruir.
    }
}
