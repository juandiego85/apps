package ups.edu.ec.daos;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ups.entity.citas.Persona;

@Stateless
public class PersonaDao extends JPAGenericDAO<Persona,Integer> {
	
	public PersonaDao() {
		super(Persona.class);
	}
	
	public String getMaxIdPersona()
    {
    	String sql="select max(id) from tbl_persona";
		Query q = em.createNativeQuery(sql);
		String id=(String) q.getSingleResult();
		System.out.println("object:"+id);
		return id;
    }

}
