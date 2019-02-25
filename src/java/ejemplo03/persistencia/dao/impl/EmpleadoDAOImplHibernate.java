package ejemplo03.persistencia.dao.impl;

import ejemplo03.dominio.Empleado;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;
import ejemplo03.persistencia.dao.EmpleadoDAO;

public class EmpleadoDAOImplHibernate extends GenericDAOImplHibernate<Empleado,Integer> implements  EmpleadoDAO {

}
