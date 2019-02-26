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
        <title>Empleados</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body style="background:#FDFDFD">
        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
                         <a class="navbar-brand" href="#<%=request.getContextPath()%>/index.html"">Concesionario</a>
           
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/index.html">Empleados</a>
                                </li>
                                <li class="nav-item">
                                     <a class="nav-link" href="<%=request.getContextPath()%>/index3.html">Vehiculos</a>
                                </li>
                            </ul>
                        </div>

                    </nav>
                                
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
                                        <a  href="<%=request.getContextPath()%>/empleado/readForDelete.html?id=<%=empleado.getId()%>" title="Borrar" ><i class=" btn btn-danger btn-xs icon-trash"></i></a>
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