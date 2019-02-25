/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.presentacion;

import com.fpmislata.persistencia.dao.BussinessException;
import ejemplo03.dominio.Empleado;
import ejemplo03.persistencia.dao.EmpleadoDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jorge
 */
public class IndexController {
    
    @RequestMapping
    public ModelAndView listarIndex(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;
            System.out.println("Hola Mundo: -------------------------------------------");
            viewName = "index";
      
        return new ModelAndView(viewName, model);
    }
}
