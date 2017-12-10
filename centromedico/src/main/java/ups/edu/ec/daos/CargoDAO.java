package ups.edu.ec.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.entity.citas.Cargo;
import ec.edu.ups.entity.citas.Persona;

@Stateless
public class CargoDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Cargo cargo)
	{
		Cargo p=leer(cargo.getCarId());
		if(p==null)
			insertar(cargo);
		else
			actualizar(cargo);
	}
	
	public void insertar(Cargo cargo)
	{
		em.persist(cargo);
	}
	
	public void actualizar(Cargo cargo)
	{
		em.merge(cargo);
	}
	
	public void eliminar(int id )
	{
		em.remove(leer(id));
	}
	
	public Cargo leer(int id)
	{
		Cargo c=em.find(Cargo.class, id);
		return c;
	}
	
	public List<Cargo> listarCargos()
	{
		String jpql="select p from Cargo p";
		Query q = em.createQuery(jpql,Cargo.class);
		List<Cargo> lista= q.getResultList();
		return lista;
	}
	
}
