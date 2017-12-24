package ups.edu.ec.daos;


import javax.ejb.Stateless;

import ec.edu.ups.entity.citas.EmpleadoEspecialidad;


@Stateless
public class AsignarEspecialidadDao extends JPAGenericDAO<EmpleadoEspecialidad, Integer>
{

	public AsignarEspecialidadDao() {
		super(EmpleadoEspecialidad.class);
	}
	
}
