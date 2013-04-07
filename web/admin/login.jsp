<%-- 
    Document   : login
    Created on : Apr 7, 2013, 10:51:51 AM
    Author     : ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
  
            html, body {
                background-color: #333;
            }
            body {
                padding-top: 40px; 
            }
            .container {
                width: 300px;
            }

            /* The white background content wrapper */
            .container > .content {
                background-color: #fff;
                padding: 20px;
                margin: 0 -20px; 
                -webkit-border-radius: 10px 10px 10px 10px;
                -moz-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
                -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
            }

            .login-form {
                margin-left: 65px;
            }

            legend {
                margin-right: -50px;
                font-weight: bold;
                color: #404040;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <div class="row">
                    <div class="login-form">
                        <h2>Login</h2>
                        <form name="form" id="form-r" method="post"  action="<%=request.getContextPath()%>/SLogin">
                            <fieldset>
                                <div class="clearfix">
                                    <input name="user" type="text" placeholder="Usuario">
                                </div>
                                <div class="clearfix">
                                    <input name="password" type="password" placeholder="Password">
                                </div>
                                <button class="btn btn-primary" type="submit">Ingresar</button>
                                <p style="color: red">${try}</p>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>