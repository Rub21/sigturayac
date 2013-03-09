/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import tur.bean.BGeometry;
import tur.bean.BHabitacion;
import tur.bean.BImagen;
import tur.bean.BHotel;
import tur.bean.BPromocion;
import tur.bean.BServiciosAdicional;
import tur.datasource.BDConnecion;
import tur.manager.ManagerHotel;
import tur.manager.ManagerProducto;
import tur.manager.ManagerRecurso;

/**
 *
 * @author ruben
 */
public class SRegistrarHotel extends HttpServlet {

    ManagerProducto managerProducto = null;
    ManagerHotel managerHotel = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UploadException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();



        //declarte connecion to data base and context
        ServletContext ctx = this.getServletConfig().getServletContext();
        HttpSession sesion = request.getSession();
        BDConnecion conexion_producto = new BDConnecion(ctx);
        BDConnecion conexion = new BDConnecion(ctx);
        //manager adn bean
        managerProducto = new ManagerProducto(conexion_producto);
        managerHotel = new ManagerHotel(conexion);



        BHotel bHotel = new BHotel();
        BImagen bImagen;// = new BImagen();
        BGeometry bGeometry = new BGeometry();






        UploadBean upBean;
        //clases for upload images
        upBean = new UploadBean();
        String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
        upBean.setFolderstore(direccion);

        MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);

        mrequest.DEFAULTENCODING = "ISO-8859-1";

        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyMMddHHmmss");//fecha        
        Hashtable files = mrequest.getFiles();

        //get the last idproducto             
        String idproducto = managerProducto.getlast() + "p";//id=idproducto
        String idhotel = idproducto + "h";
        String clase = "Hotel";
        Boolean estado = true;


        try {
            //Datos Producto
            bHotel.setIdproducto(idproducto);
            bHotel.setNombre(mrequest.getParameter("name"));
            bHotel.setClase(clase);
            bHotel.setEstado(estado);

            //Hotel
            bHotel.setIdhotel(idhotel);
            bHotel.setCategoria(mrequest.getParameter("category"));
            bHotel.setDescripcion(mrequest.getParameter("description"));
            bHotel.setDireccion(mrequest.getParameter("direction"));
            bHotel.setTelefono(mrequest.getParameter("phone"));
            bHotel.setSitio(mrequest.getParameter("site"));
            bHotel.setHora_aten(mrequest.getParameter("opening_hours"));

            // Geometry            
            bGeometry.setLatitud(Double.parseDouble(mrequest.getParameter("lat")));
            bGeometry.setLongitud(Double.parseDouble(mrequest.getParameter("lon")));
            bGeometry.setIdproducto(idproducto);

            //Habitacion
            ArrayList<BHabitacion> listhab = new ArrayList<BHabitacion>();
            int num_habitaciones = Integer.parseInt(mrequest.getParameter("num-rooms"));
            for (int i = 1; i <= num_habitaciones; i++) {
                BHabitacion bHab = new BHabitacion();

                bHab.setTipo(mrequest.getParameter("type-room" + i));
                bHab.setPrecio(Double.parseDouble(mrequest.getParameter("price-room" + i)));
                bHab.setDescripcion(mrequest.getParameter("description-room" + i));
                bHab.setIdhotel(idhotel);
                listhab.add(bHab);
            }
            bHotel.setbHabitacion(listhab);

            //Servicios Adicional
            ArrayList<BServiciosAdicional> listser = new ArrayList<BServiciosAdicional>();
            int num_servicios = Integer.parseInt(mrequest.getParameter("num-services"));
            System.out.println("num_services= " + num_servicios);
            for (int i = 1; i <= num_servicios; i++) {
                System.out.println("=====================Servicio adicional i= " + i);
                BServiciosAdicional bServiciosAdicional = new BServiciosAdicional();
                bServiciosAdicional.setTipo(mrequest.getParameter("type-service" + i));
                bServiciosAdicional.setDescripcion(mrequest.getParameter("description-service" + i));
                bServiciosAdicional.setIdproducto(idproducto);
                listser.add(bServiciosAdicional);
            }
            bHotel.setbServiciosAdicional(listser);

            //Promocion
            ArrayList<BPromocion> listprom = new ArrayList<BPromocion>();
            int num_promociones = Integer.parseInt(mrequest.getParameter("num-promotions"));
            for (int i = 1; i <= num_promociones; i++) {
                BPromocion bPromocion = new BPromocion();
                bPromocion.setTipo(mrequest.getParameter("type-promotion" + i));
                bPromocion.setDescripcion(mrequest.getParameter("description-promotion" + i));
                bPromocion.setIdproducto(idproducto);
                listprom.add(bPromocion);
            }
            bHotel.setbPromocion(listprom);

            //Imagen    
            ArrayList<BImagen> listImagenes = new ArrayList<BImagen>();
            for (int i = 1; i <= files.size(); i++) {
                bImagen = new BImagen();

                String archivo = ((UploadFile) mrequest.getFiles().get("file" + i)).getFileName();
                int posicionPunto = archivo.indexOf(".");
                String nombreImagen = archivo.substring(0, posicionPunto);
                nombreImagen = nombreImagen + formato.format(new java.util.Date());
                String extension = archivo.substring(posicionPunto);
                nombreImagen = nombreImagen.replaceAll("\\s", "") + extension;

                //Fill bImagen                
                bImagen.setUrl(nombreImagen);
                bImagen.setTitulo(mrequest.getParameter("title_img" + i));
                bImagen.setDescripcion(mrequest.getParameter("description_img" + i));
                bImagen.setIdproducto(idproducto);

                ((UploadFile) mrequest.getFiles().get("file" + i)).setFileName(nombreImagen);
                UploadFile file = (UploadFile) files.get("file" + i);
                upBean.store(mrequest, "file" + i);

                System.out.println(" file names" + i + " " + file.getFileName());
                //lista de imagenes
                listImagenes.add(bImagen);

            }

            //System.out.println("list.toString(); "+ list.toString());         
            //System.out.println("features " + bHotel.features());            
            bHotel.setbGeometry(bGeometry);
            bHotel.setImagenes(listImagenes);

            managerHotel.registrarHotel(bHotel);
            //System.out.println("termino ");
            response.sendRedirect("admin/registrar.jsp");
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
            System.out.println("Error" + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (UploadException ex) {
            Logger.getLogger(SRegistrarHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (UploadException ex) {
            Logger.getLogger(SRegistrarHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
