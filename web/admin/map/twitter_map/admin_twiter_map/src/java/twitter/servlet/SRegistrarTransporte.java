/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.servlet;

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
import twitter.bean.BDestino;
import twitter.bean.BGeometry;
import twitter.bean.BImagen;
import twitter.bean.BDestino;
import twitter.bean.BTransporte;
import twitter.datasource.BDConnecion;
import twitter.manager.ManagerProducto;
import twitter.manager.ManagerRestaurant;
import twitter.manager.ManagerTransporte;

/**
 *
 * @author ruben
 */
public class SRegistrarTransporte extends HttpServlet {

    ManagerProducto managerProducto = null;
    ManagerTransporte managerTransporte = null;

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
        managerTransporte = new ManagerTransporte(conexion);



        BTransporte bTransporte = new BTransporte();
        // BDestino bDestino= new BDestino();
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
        String idtransporte = idproducto + "t";
        String clase = "Transporte";
        Boolean estado = true;
        try {
            //Datos Producto
            bTransporte.setIdproducto(idproducto);
            bTransporte.setNombre(mrequest.getParameter("name"));
            bTransporte.setClase(clase);
            bTransporte.setEstado(estado);

            //Hotel
            bTransporte.setIdtransporte(idtransporte);

            bTransporte.setDescripcion(mrequest.getParameter("description"));
            bTransporte.setDireccion(mrequest.getParameter("direction"));
            bTransporte.setTelefono(mrequest.getParameter("phone"));
            bTransporte.setSitio(mrequest.getParameter("site"));
            bTransporte.setHora_aten(mrequest.getParameter("opening_hours"));

            //Destinos
            ArrayList<BDestino> listdes = new ArrayList<BDestino>();
            int num_destino = Integer.parseInt(mrequest.getParameter("num-destino"));
            System.out.println("num_destino= " + num_destino);
            for (int i = 1; i <= num_destino; i++) {
                BDestino bDestino = new BDestino();
                bDestino.setNombre(mrequest.getParameter("destino" + i));
                bDestino.setIdtransporte(idtransporte);
                listdes.add(bDestino);
            }
            bTransporte.setDestinos(listdes);


            // Geometry            
            bGeometry.setLatitud(Double.parseDouble(mrequest.getParameter("lat")));
            bGeometry.setLongitud(Double.parseDouble(mrequest.getParameter("lon")));
            bGeometry.setIdproducto(idproducto);

            bTransporte.setGeometry(bGeometry);
            //Imagen    
            ArrayList<BImagen> listImagenes = new ArrayList<BImagen>();
            for (int i = 1; i <= files.size(); i++) {
                bImagen = new BImagen();
                System.out.println("file" + i);
                String archivo = ((UploadFile) mrequest.getFiles().get("file" + i)).getFileName();
                int posicionPunto = archivo.indexOf(".");
                String nombreImagen = archivo.substring(0, posicionPunto);
                nombreImagen = nombreImagen + formato.format(new java.util.Date());
                String extension = archivo.substring(posicionPunto);
                nombreImagen = nombreImagen.replaceAll("\\s", "") + extension;
                //Fill bImagen
                //bImagen.setId(id);
                bImagen.setUrl(nombreImagen);
                bImagen.setTitulo(mrequest.getParameter("title_img" + i));
                bImagen.setDescripcion(mrequest.getParameter("description_img" + i));
                bImagen.setIdproducto(idproducto);

                ((UploadFile) mrequest.getFiles().get("file" + i)).setFileName(nombreImagen);
                UploadFile file = (UploadFile) files.get("file" + i);
                upBean.store(mrequest, "file" + i);
                //lista de imagenes
                listImagenes.add(bImagen);
            }

            bTransporte.setImagenes(listImagenes);



            managerTransporte.registrartransporte(bTransporte);
            sesion.setAttribute("conf", "conf");
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
