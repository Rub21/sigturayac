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
import javazoom.upload.UploadFile;
import org.apache.commons.fileupload.FileUploadException;
import twitter.datasource.BDConnecion;
import twitter.manager.ManagerPuntosDesechos;

/**
 *
 * @author ruben
 */
public class SRegistrarPunto extends HttpServlet {

  
    ManagerPuntosDesechos managerPuntosDesechos=null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //declarte connecion to data base and context
        ServletContext ctx = this.getServletConfig().getServletContext();
        HttpSession sesion = request.getSession();
        
        BDConnecion conexion = new BDConnecion(ctx);

        //manager adn bean
        managerPuntosDesechos = new ManagerPuntosDesechos(conexion);
     
        
        UploadBean upBean;
        //clases for upload images
        upBean = new UploadBean();
        String direccion = request.getSession().getServletContext().getRealPath("imagenesDB/");
        upBean.setFolderstore(direccion);
        MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
        mrequest.DEFAULTENCODING = "ISO-8859-1";
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyMMddHHmmss");//fecha        
        Hashtable files = mrequest.getFiles();


        //get the last id
        /*String id = managerPuntosDesechos.getlast();//id=idproducto
        String idrecurso = id + "r";
        String clase = "Recurso Turístico";
        Boolean estado = true;*/


        try {
         
            //imagen
            String url_img = "";
            

                String archivo = ((UploadFile) mrequest.getFiles().get("imagen")).getFileName();                
                int posicionPunto = archivo.indexOf(".");                
                String nombreImagen = archivo.substring(0, posicionPunto);
                
                nombreImagen = nombreImagen + formato.format(new java.util.Date());
                String extension = archivo.substring(posicionPunto);
                nombreImagen = nombreImagen.replaceAll("\\s", "") + extension;

               ((UploadFile) mrequest.getFiles().get("imagen")).setFileName(nombreImagen);
                UploadFile file = (UploadFile) files.get("imagen");
                upBean.store(mrequest, "imagen");


                //System.out.println(" file names" + i + " " + file.getFileName());

                //lista de imagenes
        
            

   
            sesion.setAttribute("conf", "conf");
            response.sendRedirect("admin/registrar.jsp");
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
            System.out.println("error");
        } finally {
            out.close();
        }
    }

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(SRegistrarPunto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SRegistrarPunto.class.getName()).log(Level.SEVERE, null, ex);
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

            //getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(SRegistrarPunto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SRegistrarPunto.class.getName()).log(Level.SEVERE, null, ex);
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
