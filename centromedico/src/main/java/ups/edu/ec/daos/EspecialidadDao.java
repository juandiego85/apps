package ups.edu.ec.daos;


import javax.ejb.Stateless;

import ec.edu.ups.entity.citas.Especialidad;


@Stateless
public class EspecialidadDao extends JPAGenericDAO<Especialidad, Integer>
{

	public EspecialidadDao() {
		super(Especialidad.class);
	}
	
}
