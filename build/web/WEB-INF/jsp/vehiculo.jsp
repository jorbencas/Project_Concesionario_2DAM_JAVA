<%@page import="java.util.Set"%>
<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="com.fpmislata.persistencia.dao.BussinessMessage"%>
<%@page import="ejemplo03.presentacion.FormOperation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    FormOperation formOperation = (FormOperation) request.getAttribute("formOperation");
    String labelButton = null;
    String urlAction;
    String readOnlyActive = "";
    
    
    switch (formOperation) {
        case Insert:
            labelButton = "Insertar";
            urlAction = request.getContextPath() + "/vehiculo/insert.html";
            break;
        case Update:
            labelButton = "Actualizar";
            urlAction = request.getContextPath() + "/vehiculo/update.html";
            break;
        case Delete:
            labelButton = "Borrar";
            urlAction = request.getContextPath() + "/vehiculo/delete.html";
            break;
        default:
            throw new RuntimeException("El valor de 'formOperation' no es válido" + formOperation);
    }
    

    if(labelButton.equals("Actualizar") || labelButton.equals("Borrar")){
        readOnlyActive = "readonly";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
    </head>
    <body style="background:#FDFDFD">
        <div class="row">
            <div class="span12">&nbsp;</div>
        </div>
        <div class="row">
            <div class="offset1 span10 well">
                <h3>Empleado</h3>
                <form action="<%=urlAction%>" method="post" >
                    <fieldset>
                        <label class="control-label" for="matricula">Matricula:</label>
                        <input class="input-large disabled " id="matricula" name="matricula" type="text" value="${vehiculo.matricula}" <%=readOnlyActive%> >

                        <label class="control-label" for="kilometros">Kilometros:</label>
                        <input class="input-xlarge" id="kilometros" type="text" name="kilometros" value="${vehiculo.kilometros}" >

                        <label class="control-label" for="precio">Precio:</label>
                        <input class="input-xlarge" id="precio" type="text" name="precio" value="${vehiculo.precio}" >

                        <label class="control-label" for="anyo">Año:</label>
                        <input class="input-xlarge" id="anyo" type="text" name="anyo" value="${vehiculo.anyo}" >
                        
                         <label class="control-label" for="tipo">Tipo:</label>
                        <input class="input-xlarge" id="tipo" type="text" name="tipo" value="${vehiculo.tipo}" >

                        <label class="control-label" for="modelo">Modelo</label>
                        <input class="input-xlarge" id="modelo" type="text" name="modelo" value="${vehiculo.modelo}" >
                        
                    </fieldset>
                    <% if (request.getAttribute("bussinessMessages") != null) {%>
                    <div class="alert alert-error alert-block">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <ul>
                            <%for (BussinessMessage bussinessMessage : (Set<BussinessMessage>) request.getAttribute("bussinessMessages")) {%>
                            <li>
                                <%if (bussinessMessage.getFieldName() != null) {
                                        out.print("<strong>" + HtmlUtils.htmlEscape(bussinessMessage.getFieldName()) + "</strong>");
                                    }
                                %>
                                <%=HtmlUtils.htmlEscape(bussinessMessage.getMessage())%>
                            </li>
                            <%} %>
                        </ul>
                    </div>
                    <%} %>
                    <div class="form-actions">
                        <button id="aceptarBtn" class="btn btn-primary" type="submit"><%=labelButton%></button>
                        <a class="btn" href="<%=request.getContextPath()%>/index2.html" >Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
        <script>

        </script>
    </body>
</html>