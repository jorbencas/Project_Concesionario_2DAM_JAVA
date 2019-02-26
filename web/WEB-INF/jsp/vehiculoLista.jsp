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
           <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body style="background:#FDFDFD">
         <nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
                         <a class="navbar-brand" href="#<%=request.getContextPath()%>/index.html">Concesionario</a>
           
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/index2.html">Empleados</a>
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
                                    <td><a href="<%=request.getContextPath()%>/vehiculo/readForUpdate.html?matricula=<%=vehiculo.getMatricula()%>" title="Editar" ><%= vehiculo.getMatricula()%></a></td>
                                    <td><%=HtmlUtils.htmlEscape(vehiculo.getTipo())%></td>
                                    <td><%=HtmlUtils.htmlEscape(vehiculo.getModelo())%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getPrecio()))%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getKilometros()))%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getAnyo()))%></td>
                                    <td><%=HtmlUtils.htmlEscape(String.valueOf(vehiculo.getMarca()))%></td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/vehiculo/readForDelete.html?matricula=<%=vehiculo.getMatricula()%>" title="Borrar" ><i class="icon-trash"></i></a>
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