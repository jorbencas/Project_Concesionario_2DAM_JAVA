<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="ejemplo03.dominio.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Empleado> empleadolista = (List<Empleado>) request.getAttribute("empleados");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesor</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
    </head>
    <body style="background:#FDFDFD">
        <div class="row-fluid">
            <div class="span12">&nbsp;</div>
        </div>
        <div class="row-fluid">
            <div class="offset1  span10">
                <div class="row-fluid">
                    <div class="span12">
                        <a id="btnNuevo" class="btn btn-primary" href="<%=request.getContextPath()%>/empleado/newForInsert.html">Nuevo Empleado</a>
                    </div>
                </div>
                <div class="row-fluid">


                    <div class="span12">



                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>1&ordm; Apellido</th>
                                    <th>2&ordm; Apellido</th>
                                    <th>&nbsp; Dni</th>
                                    <th>&nbsp; Letra DNI</th>
                                    <th>&nbsp; Tipo</th>  
                                    <th>&nbsp; Telefono 1</th>
                                    <th>&nbsp; Telefono 2</th>
                                    <th>&nbsp; Fijo</th>
                                    <th>&nbsp; Tarjeta</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Empleado empleado : empleadolista) {
                                %>
                                <tr>
                                    <td><a href="<%=request.getContextPath()%>/empleado/readForUpdate.html?id=<%=empleado.getId()%>" title="Editar" ><%=empleado.getId()%></a></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getNombre())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getPrimerApellido())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getSegundoApellido())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getDni())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getDni_letra())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getTipo())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getTelefono1())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getTelefono2())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getFijo())%></td>
                                    <td><%=HtmlUtils.htmlEscape(empleado.getTarjeta())%></td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/empleado/readForDelete.html?id=<%=empleado.getId()%>" title="Borrar" ><i class="icon-trash"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>


                    </div>
                </div>
            </div>
            <div class="span1"></div>
        </div>
    </body>
</html>