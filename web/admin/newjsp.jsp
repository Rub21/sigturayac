<%-- 
    Document   : newjsp
    Created on : Apr 4, 2013, 11:30:26 PM
    Author     : ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <div class='well file_upload' id='f1-re'>
                    <input name='file1' type='file' id='file_img1-re'required/>
                    <input type='text' name='title_img1' value=''  id='title_img1-re' placeholder='Nombre de Imagen 1' />
                    <textarea class="span8" name='description_img1' rows='2' cols='75'  id='description_img1-re'placeholder='Descripcion de la imagen 1'></textarea>
                </div>
                  <div class='well file_upload' id='f2-re' >
                    <input name='file2' type='file' id='file_img2-re' required/>
                    <input type='text' name='title_img2' value=''  id='title_img2-re' placeholder='Nombre de Imagen 2' />
                    <textarea class="span8" name='description_img2' rows='2' cols='75'  id='description_img2-re'placeholder='Descripcion de la imagen 2'></textarea>
                </div>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
