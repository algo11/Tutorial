/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.ejercicio1.servlet;

import com.uniminuto.ejercicio1.dao.ParadaDaoImpl;
import com.uniminuto.ejercicio1.dao.ServicioDaoImpl;
import com.uniminuto.ejercicio1.entityEjb.Parada;
import com.uniminuto.ejercicio1.entityEjb.Servicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        String nombreVariable = request.getParameter("yourName");
        String codigoVariable = "000001";

//        ServicioDaoImpl servicioDao = new ServicioDaoImpl();
//        Servicio servicioPojo = crearServicioPojo();
//        Long idServicio = servicioDao.insert(servicioPojo);
//        boolean isDelete = servicioDao.delete(1L);
//        Servicio servicio = servicioDao.findById(idServicio);

        ParadaDaoImpl paradaDao =  new ParadaDaoImpl();
        List<Parada> findParadaListByServicioId = paradaDao.findParadaListByServicioId(5L);
        
        System.out.println("");
    }
    
    public Servicio crearServicioPojo() {
        Servicio servicio = new Servicio();
        servicio.setIdServicio(5L);
        servicio.setPuntoFinal("Portal 80");
        servicio.setPuntoInicio("Portal Tunal");
        return servicio;
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
