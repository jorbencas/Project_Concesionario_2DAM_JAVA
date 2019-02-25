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
            urlAction = request.getContextPath() + "/empleado/insert.html";
            break;
        case Update:
            labelButton = "Actualizar";
            urlAction = request.getContextPath() + "/empleado/update.html";
            break;
        case Delete:
            labelButton = "Borrar";
            urlAction = request.getContextPath() + "/empleado/delete.html";
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
                        <label class="control-label" for="id">Id:</label>
                        <input class="input-large disabled " id="id" name="id" type="text" value="${empleado.id}" <%=readOnlyActive%> >

                        <label class="control-label" for="nombre">Nombre:</label>
                        <input class="input-xlarge" id="nombre" type="text" name="nombre" value="${empleado.nombre}" >

                        <label class="control-label" for="ape1">1º Apellido:</label>
                        <input class="input-xlarge" id="primero" type="text" name="primero" value="${empleado.primerApellido}" >

                        <label class="control-label" for="segundo">2º Apellido:</label>
                        <input class="input-xlarge" id="segundo" type="text" name="segundo" value="${empleado.segundoApellido}" >
                        
                         <label class="control-label" for="dni">DNI:</label>
                        <input class="input-xlarge" id="dni" type="text" name="dni" value="${empleado.dni}" >

                        <label class="control-label" for="dni_letra">letra:</label>
                        <input class="input-xlarge" id="dni_letra" type="text" name="dni_letra" value="${empleado.dni_letra}" >
                        
                         <label class="control-label" for="tipo">tipo:</label>
                        <input class="input-xlarge" id="tipo" type="text" name="tipo" value="${empleado.tipo}" >

                        <label class="control-label" for="telefono1">telefono1:</label>
                        <input class="input-xlarge" id="telefono1" type="text" name="telefono1" value="${empleado.telefono1}" >
                        
                         <label class="control-label" for="telefono2">telefono2:</label>
                        <input class="input-xlarge" id="telefono2" type="text" name="telefono2" value="${empleado.telefono2}" >
                        
                         <label class="control-label" for="fijo">fijo:</label>
                        <input class="input-xlarge" id="fijo" type="text" name="fijo" value="${empleado.fijo}" >
                        
                         <label class="control-label" for="tarjeta">Tarjeta:</label>
                        <input class="input-xlarge" id="tarjeta" type="text" name="tarjeta" value="${empleado.tarjeta}" >
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