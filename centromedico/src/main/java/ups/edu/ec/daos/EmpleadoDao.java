package ups.edu.ec.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ups.entity.citas.Empleado;

@Stateless
public class EmpleadoDao extends JPAGenericDAO<Empleado, Integer> {
	
	public EmpleadoDao()
	{
		super(Empleado.class);
	}
		
	/**
	 * retorna los nombres de sus empleados con su id
	 * util para el combomenu
	 * @return
	 */
	public List<Object[]> empleados()
	{
		String sql="select  e.id,concat(p.per_apellido,p.per_nombre) as nombres"
				+ " from tbl_persona p,tbl_empleado e"
				+ " where p.id=e.id";
		Query q=em.createNativeQuery(sql);
		List<Object[]>lista=q.getResultList();
		return lista;
	}
}
