/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.presentacion;

import com.fpmislata.persistencia.dao.BussinessException;
import com.fpmislata.persistencia.dao.BussinessMessage;
import ejemplo03.dominio.Empleado;
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
import ejemplo03.persistencia.dao.EmpleadoDAO;

/**
 *
 * @author Lorenzo González
 */
@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoDAO empleadoDAO;
    
    @RequestMapping({"/index2.html"})
    public ModelAndView listarProfesores(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            List<Empleado> empleados=empleadoDAO.findAll();
            model.put("empleados",empleados);
            viewName = "empleadoLista";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index2.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }
    @RequestMapping({"/empleado/newForInsert"})
    public ModelAndView newForInsert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            Empleado empleado = empleadoDAO.create();
            model.put("formOperation", FormOperation.Insert);
            model.put("empleado", empleado);
            viewName = "empleado";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index2.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/empleado/readForUpdate"})
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

            Empleado empleado = empleadoDAO.get(id);
            if (empleado == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el empleado con id=" + id));
            }
            model.put("formOperation", FormOperation.Update);
            model.put("empleado", empleado);
            viewName = "empleado";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index2.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/empleado/readForDelete"})
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

            Empleado empleado = empleadoDAO.get(id);
            if (empleado == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe el profesor con id=" + id));
            }
            model.put("formOperation", FormOperation.Delete);
            model.put("empleado", empleado);
            viewName = "empleado";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index2.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/empleado/insert.html"})
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

        Empleado empleado = null;
        try {
            empleado = empleadoDAO.create();

            empleado.setNombre(request.getParameter("nombre"));
            empleado.setPrimerApellido(request.getParameter("primero"));
            empleado.setSegundoApellido(request.getParameter("segundo"));
            empleado.setDni(request.getParameter("dni"));
            empleado.setDni_letra(request.getParameter("dni_letra"));
            empleado.setTipo(request.getParameter("tupo"));
            empleado.setTelefono1(request.getParameter("telefono1"));
            empleado.setTelefono2(request.getParameter("telefono2"));
            empleado.setFijo(request.getParameter("fijo"));
            empleado.setTarjeta(request.getParameter("tarjeta"));
            
            empleadoDAO.saveOrUpdate(empleado);

            viewName = "redirect:/index2.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            if (empleado!=null) {
                empleado.setId(0);
            }
            model.put("empleado", empleado);
            model.put("formOperation", FormOperation.Insert);
            viewName = "empleado";
        }



        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/empleado/update.html"})
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        Empleado empleado = null;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }
            empleado = empleadoDAO.get(id);
            if (empleado == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe el profesor."));
            }
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setPrimerApellido(request.getParameter("primero"));
            empleado.setSegundoApellido(request.getParameter("segundo"));
            empleado.setDni(request.getParameter("dni"));
            empleado.setDni_letra(request.getParameter("dni_letra"));
            empleado.setTipo(request.getParameter("tupo"));
            empleado.setTelefono1(request.getParameter("telefono1"));
            empleado.setTelefono2(request.getParameter("telefono2"));
            empleado.setFijo(request.getParameter("fijo"));
            empleado.setTarjeta(request.getParameter("tarjeta"));
            empleadoDAO.saveOrUpdate(empleado);

            viewName = "redirect:/index2.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("empleado", empleado);
            model.put("formOperation", FormOperation.Update);
            viewName = "empleado";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/empleado/delete.html"})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        Empleado empleado=null;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }
            empleado = empleadoDAO.get(id);
            if (empleado == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe el profesor a borrar"));
            }

            empleadoDAO.delete(id);

            viewName = "redirect:/index2.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("empleado", empleado);
            model.put("formOperation", FormOperation.Delete);
            viewName = "empleado";
        }

        return new ModelAndView(viewName, model);
    }

}
