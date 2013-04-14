/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tur.datasource.BDConnecion;
import tur.manager.ManagerComplementario;
import tur.manager.ManagerHotel;
import tur.manager.ManagerRecurso;
import tur.manager.ManagerRestaurant;
import tur.manager.ManagerTransporte;

/**
 *
 * @author ruben
 */
public class SListar extends HttpServlet {

    ManagerHotel managerHotel = null;
    ManagerRecurso managerRecurso = null;
    ManagerRestaurant managerRestaurant = null;
    ManagerTransporte managerTransporte = null;
    ManagerComplementario managerComplementario = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext ctx = this.getServletConfig().getServletContext();
        BDConnecion conexion_recurso = new BDConnecion(ctx);
        BDConnecion conexion_hotel = new BDConnecion(ctx);
        BDConnecion conexion_restaurant = new BDConnecion(ctx);
        BDConnecion conexion_transporte = new BDConnecion(ctx);
        BDConnecion conexion_complementario = new BDConnecion(ctx);

        managerRecurso = new ManagerRecurso(conexion_recurso);
        managerHotel = new ManagerHotel(conexion_hotel);
        managerRestaurant = new ManagerRestaurant(conexion_restaurant);
        managerTransporte = new ManagerTransporte(conexion_transporte);
        managerComplementario = new ManagerComplementario(conexion_complementario);

        List list_producto = new LinkedList();
        List list_recurso = new LinkedList();
        List list_hotel = new LinkedList();
        List list_restaurant = new LinkedList();
        List list_transporte = new LinkedList();
        List list_complementario = new LinkedList();
        try {

            list_recurso = managerRecurso.listarrecurso();
            for (int i = 0; i < list_recurso.size(); i++) {
                list_producto.add(list_recurso.get(i));
            }

            list_hotel = managerHotel.listarhotel();
            for (int i = 0; i < list_hotel.size(); i++) {
                list_producto.add(list_hotel.get(i));
            }

            list_restaurant = managerRestaurant.listarrestaurant();
            for (int i = 0; i < list_restaurant.size(); i++) {
                list_producto.add(list_restaurant.get(i));
            }
            
            list_transporte = managerTransporte.listarTransporte();
            for (int i = 0; i < list_transporte.size(); i++) {
                list_producto.add(list_transporte.get(i));
            }
             list_complementario = managerComplementario.listarcomplementario();
            for (int i = 0; i < list_complementario.size(); i++) {
                list_producto.add(list_complementario.get(i));
            }

            String json = new Gson().toJson(list_producto);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("callback(" + json + ")");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
