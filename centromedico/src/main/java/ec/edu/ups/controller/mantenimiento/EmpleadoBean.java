package ec.edu.ups.controller.mantenimiento;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.entity.citas.Cargo;
import ec.edu.ups.entity.citas.Empleado;
import ec.edu.ups.entity.citas.Persona;
import ec.edu.ups.entity.citas.Profesion;
import ups.edu.ec.daos.CargoDAO;
import ups.edu.ec.daos.PersonaDao;
import ups.edu.ec.daos.ProfesionDAO;
import ups.edu.ec.utils.Constants;
import ups.edu.ec.utils.JPAException;

@ManagedBean
@ViewScoped
public class EmpleadoBean {
	
	@Inject private FacesContext facesContext;
	@Inject private PersonaDao daoPersona;
	@Inject private CargoDAO daoCargo;
	@Inject private ProfesionDAO daoProfesion;
	
	private Persona persona;
	private Empleado empleado;
	private List<Cargo>cargos;
	private List<Profesion>profesiones; 
	
	@PostConstruct
	public void init()
	{
		persona=new Persona();
		empleado=new Empleado();
		loadCargos();
		loadProfesiones();
	}
	
	/**
	 * registra un empleado
	 * @return
	 */
	public String registrarEmpleado()
	{
		
		persona.setPerFecRegistro(new Date());
		persona.setPerEstado(Constants.ESTADO_ACTIVO);
		empleado.setId(getIdPersona()+1);
		empleado.setEmpEstado(Constants.ESTADO_ACTIVO);
		empleado.setEmpFechaRegistro(new Date());
		persona.setEmpleado(empleado);
		try {
			daoPersona.insertar(persona);
			instanciarEntidades();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "REGISTRO EXITOSO");
            facesContext.addMessage(null, m);
		} catch (JPAException e) {
			String msg=e.getMensaje();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            facesContext.addMessage(null, m);
		}
		return null;
	}
	
	
	/**
	 * retorna el id maxima de la tabla persona
	 * @return
	 */
	public int getIdPersona()
	{
		String aux=daoPersona.getMaxIdPersona();
		System.out.println("aux:"+aux);
		int c = 0;
		if(aux==null)
			return c;
		else
		return Integer.valueOf(aux);
	}
	
	/**
	 * instanciar las entidades
	 * persona y empleado
	 */
	public void instanciarEntidades()
	{
		persona=new Persona();
		empleado=new Empleado();
	}
	
	
	
	/**
	 * lista los cargos
	 */
	public void loadCargos()
	{
		cargos=daoCargo.listarCargos();
	}
	
	/**
	 * listar las profesiones
	 */
	public void loadProfesiones()
	{
		profesiones=daoProfesion.listarEntidad();
	}
	
	/**
	 * Encapsulamiento
	 */
	public Persona getPersona() {return persona;}
	public void setPersona(Persona persona) {this.persona = persona;}
	public List<Cargo> getCargos() {return cargos;}
	public void setCargos(List<Cargo> cargos) {this.cargos = cargos;}
	public Empleado getEmpleado() {return empleado;}
	public void setEmpleado(Empleado empleado) {this.empleado = empleado;}
	

	public List<Profesion> getProfesiones() {return profesiones;}
	public void setProfesiones(List<Profesion> profesiones) {this.profesiones = profesiones;}
	
	
	
	

}
