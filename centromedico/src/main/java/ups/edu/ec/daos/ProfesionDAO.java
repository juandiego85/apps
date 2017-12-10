package ups.edu.ec.daos;


import javax.ejb.Stateless;

import ec.edu.ups.entity.citas.Profesion;
import ups.edu.ec.utils.JPAGenericDAO;

@Stateless
public class ProfesionDAO extends JPAGenericDAO<Profesion, Integer>
{

	public ProfesionDAO() {
		super(Profesion.class);
	}
	
}
