/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.presentacion;

import com.fpmislata.persistencia.dao.BussinessException;
import com.fpmislata.persistencia.dao.BussinessMessage;
import ejemplo03.dominio.Empleado;
import ejemplo03.dominio.Vehiculo;
import ejemplo03.persistencia.dao.VehiculoDAO;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jorge
 */
@Controller
public class VehiculoController {
    @Autowired
    private VehiculoDAO vehiculoDAO;
    
    @RequestMapping({"/index3.html"})
    public ModelAndView listarVehiculos(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            List<Vehiculo> vehiculos = vehiculoDAO.findAll();
            model.put("vehiculos",vehiculos);
            viewName = "vehiculoLista";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index3.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }
    @RequestMapping({"/vehiculo/newForInsert"})
    public ModelAndView newForInsert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            Vehiculo vehiculo = vehiculoDAO.create();
            model.put("formOperation", FormOperation.Insert);
            model.put("vehiculo", vehiculo);
            viewName = "vehiculo";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index3.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/vehiculo/readForUpdate"})
    public ModelAndView readForUpdate(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }

            Vehiculo vehiculo = vehiculoDAO.get(id);
            if (vehiculo == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el vehiculo con id=" + id));
            }
            model.put("formOperation", FormOperation.Update);
            model.put("vehiculo", vehiculo);
            viewName = "vehiculo";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index3.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/vehiculo/readForDelete"})
    public ModelAndView readForDelete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }

            Vehiculo vehiculo = vehiculoDAO.get(id);
            if (vehiculo == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el profesor con id=" + id));
            }
            model.put("formOperation", FormOperation.Delete);
            model.put("vehiculo", vehiculo);
            viewName = "vehiculo";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index3.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/vehiculo/insert.html"})
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

        Vehiculo vehiculo = null;
        try {
            vehiculo = vehiculoDAO.create();
            
            vehiculo.setMatricula(request.getParameter("matricula"));
            vehiculo.setKilometros(Integer.parseInt(request.getParameter("kilometros")));
            vehiculo.setPrecio(Integer.parseInt(request.getParameter("precio")));
            vehiculo.setAnyo(Integer.parseInt(request.getParameter("anyo")));
            vehiculo.setMarca(request.getParameter("marca"));
            vehiculo.setModelo(request.getParameter("tupo"));
           
            Empleado emp = new Empleado();
            emp.setId(Integer.parseInt(request.getParameter("empleado")));
            vehiculo.setEmpleado(emp);
           
            
            vehiculoDAO.saveOrUpdate(vehiculo);

            viewName = "redirect:/index.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            if (vehiculo!=null) {
                vehiculo.setMatricula("");
            }
            model.put("vehiculo", vehiculo);
            model.put("formOperation", FormOperation.Insert);
            viewName = "vehiculo";
        }



        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/vehiculo/update.html"})
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        Vehiculo vehiculo = null;
        try {
           String matricula;
            try {
                matricula = request.getParameter("id");
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }
            //vehiculo = vehiculoDAO.get(matricula);
            if (vehiculo == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe el profesor."));
            }
            
            vehiculo.setKilometros(Integer.parseInt(request.getParameter("kilometros")));
            vehiculo.setPrecio(Integer.parseInt(request.getParameter("precio")));
            vehiculo.setAnyo(Integer.parseInt(request.getParameter("anyo")));
            vehiculo.setMarca(request.getParameter("marca"));
            vehiculo.setModelo(request.getParameter("tupo"));
           
            Empleado emp = new Empleado();
            emp.setId(Integer.parseInt(request.getParameter("empleado")));
            vehiculo.setEmpleado(emp);
           
            
            vehiculoDAO.saveOrUpdate(vehiculo);
            vehiculoDAO.saveOrUpdate(vehiculo);

            viewName = "redirect:/index.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("vehiculo", vehiculo);
            model.put("formOperation", FormOperation.Update);
            viewName = "vehiculo";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/vehiculo/delete.html"})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        Vehiculo vehiculo=null;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }
            vehiculo = vehiculoDAO.get(id);
            if (vehiculo == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe el profesor a borrar"));
            }

            vehiculoDAO.delete(id);

            viewName = "redirect:/index.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("vehiculo", vehiculo);
            model.put("formOperation", FormOperation.Delete);
            viewName = "vehiculo";
        }

        return new ModelAndView(viewName, model);
    }

}
