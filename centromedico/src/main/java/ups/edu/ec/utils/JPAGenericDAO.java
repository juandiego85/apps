package ups.edu.ec.utils;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * Clase Generica para un DAO, consta de los metodos basicos para un mantenimiento
 * @author user
 *
 * @param <T> Clase de entidad
 * @param <ID> Clase de Primary Key ID.
 */
@Stateless
public class JPAGenericDAO<T,ID> 
{
   
	protected Class<T>clasePersistente;
    @Inject   protected EntityManager em;
    @Inject   protected Logger log;
    
    protected String appNombre="JPA"; 
	protected String classNamePersit="";
	
    
    
	/**
	 * Constructor Generico
	 * @param clasePersistente
	 */
	public JPAGenericDAO(Class<T> clasePersistente) 
    {
		this.clasePersistente=clasePersistente;
    }
	public JPAGenericDAO() 
    {
       
    }
	
	
	
    /**
     * obtiene el nombre de la clase
     * @return
     */
    private String getClassNamePersis()
	{    
			String[] className= clasePersistente.getCanonicalName().split("\\.");
			classNamePersit=className[className.length-1];
			return classNamePersit;
	}
    
    /**
     * actualiza o inserta una entidad
     * @param id
     * @param entidad
     */
    public void guardar(ID id,T entidad)
	{
		T p=leer(id);
		if(p==null)
			insertar(entidad);
		else
			actualizar(entidad);
	}
    
    
    /**
     * Metodo para insertar en la base de datos
     * @param entidad
     */
    public void insertar(T entidad) 
    {
          em.persist(entidad);
    }

    
    /**
     * metodo para actualizar en la base de datos
     * @param entidad
     */
    public void actualizar(T entidad) 
    {
            em.merge(entidad);  
    }

     
    /**
     * Metodo para leer un registro a partir del ID
     * @param id
     * @return Entidad leida
     */
    public T leer(ID id)
    {
    	 T result=null;
    	 result=em.find(clasePersistente, id);
       return result;
    }
    
        
    /**
     * borra un registro de una entidad
     * @param id 
     * @param c nombre de la entidad 
     */
    public void eliminar(ID id)
	{
		em.remove(leer(id));
	}
    
    
    /**
     * lista una entidad
     * @param c
     * @return
     */
    public List<T> listarEntidad()
    {
    	String jpql="select f from "+getClassNamePersis()+"  f";
		Query q = em.createQuery(jpql,clasePersistente);
		List<T> lista= q.getResultList();
		return lista;
	}
    
 
  

}