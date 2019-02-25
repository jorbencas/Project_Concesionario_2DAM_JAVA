<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="ejemplo03.dominio.Vehiculo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Vehiculo> vehiculoslista = (List<Vehiculo>) request.getAttribute("vehiculos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
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
                        <a id="btnNuevo" class="btn btn-primary" href="<%=request.getContextPath()%>/vehiculo/newForInsert.html">Nuevo Vehiculo</a>
                    </div>
                </div>
                <div class="row-fluid">


                    <div class="span12">



                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                                <tr>
                                    <th>Matricula</th>
                                    <th>Tipo</th>
                                    <th>&nbsp; Modelo</th> 
                                    <th>&nbsp; Precios</th>
                                    <th>&nbsp; Kilometros</th>
                                    <th>&nbsp; Año</th>
                                    <th>&nbsp; Marca</th> 
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Vehiculo vehiculo : vehiculoslista) {
                                %>
                                <tr>
                                    <td><a href="<%=request.getContextPath()%>/vehiculo/readForUpdate.html?id=<%=vehiculo.getMatricula()%>" title="Editar" ><%= vehiculo.getMatricula()%></a></td>
                                    <td><%=HtmlUtils.htmlEscape(vehiculo.getTipo())%></td>
                                    <td><%=HtmlUtils.htmlEscape(vehiculo.getModelo())%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getPrecio()))%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getKilometros()))%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getAnyo()))%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getMarca()))%></td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/vehiculo/readForDelete.html?id=<%=vehiculo.getMatricula()%>" title="Borrar" ><i class="icon-trash"></i></a>
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