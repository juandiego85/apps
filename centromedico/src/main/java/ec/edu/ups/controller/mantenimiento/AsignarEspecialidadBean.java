package ec.edu.ups.controller.mantenimiento;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.entity.citas.Empleado;
import ec.edu.ups.entity.citas.EmpleadoEspecialidad;
import ec.edu.ups.entity.citas.Especialidad;
import ec.edu.ups.entity.negocio.PersonaEmpleado;
import ups.edu.ec.daos.AsignarEspecialidadDao;
import ups.edu.ec.daos.EmpleadoDao;
import ups.edu.ec.daos.EspecialidadDao;
import ups.edu.ec.utils.JPAException;

@ManagedBean
@ViewScoped
public class AsignarEspecialidadBean {
	@Inject FacesContext facesContext;
	@Inject AsignarEspecialidadDao daoAsignarEsp;
	@Inject EmpleadoDao daoEmpleado;
	@Inject EspecialidadDao daoEspecialidad;
	private EmpleadoEspecialidad empleadoEspecialidad;
	List<PersonaEmpleado>empleados;
	List<Especialidad>especialidades;
	private PersonaEmpleado negPersonaEmpleado;//entidad de negocio
	private int idEmpleadoSelected; 
	
	@PostConstruct
	public void init()
	{
		empleadoEspecialidad=new EmpleadoEspecialidad();
		loadEmpleados();
		loadEspecialidades();
	}

	/**
	 * carga los empleados al combo
	 */
	public void loadEmpleados()
	{
		List<Object[]>aux=daoEmpleado.empleados();
		empleados=new ArrayList<PersonaEmpleado>();
		for(Object[] obj:aux)
		{
			negPersonaEmpleado =new PersonaEmpleado();
			negPersonaEmpleado.setId(Integer.valueOf(obj[0].toString()));
			negPersonaEmpleado.setNombres(obj[1].toString());
		empleados.add(negPersonaEmpleado);
		}
	}
	
	/**
	 * carga las especialidades
	 */
	public void loadEspecialidades() 
	{
		especialidades=daoEspecialidad.listarEntidad();
	}
	
	/**
	 * registra la asignacion de un empleado con una especialidad
	 * @return
	 */
	public String registraEmpEspecialidad()
	{
		try {
			Empleado empleado=daoEmpleado.leer(idEmpleadoSelected);
			empleadoEspecialidad.setEmpleado(empleado);
			daoAsignarEsp.insertar(empleadoEspecialidad);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "REGISTRO EXITOSO");
            facesContext.addMessage("msg2", m);
            
            FacesMessage p = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "REGISTRO EXITOSO");
            facesContext.addMessage("msg1", p);
		} catch (JPAException e) {
			String msg=e.getMensaje();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            facesContext.addMessage(null, m);
		}
		return null;
		
	}
	
	
	/**
	 * encapsulamiento
	 * @return
	 */
	public EmpleadoEspecialidad getEmpleadoEspecialidad() {
		return empleadoEspecialidad;
	}

	public void setEmpleadoEspecialidad(EmpleadoEspecialidad empleadoEspecialidad) {
		this.empleadoEspecialidad = empleadoEspecialidad;
	}

	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public List<PersonaEmpleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<PersonaEmpleado> empleados) {
		this.empleados = empleados;
	}

	public PersonaEmpleado getNegPersonaEmpleado() {
		return negPersonaEmpleado;
	}

	public void setNegPersonaEmpleado(PersonaEmpleado negPersonaEmpleado) {
		this.negPersonaEmpleado = negPersonaEmpleado;
	}

	public int getIdEmpleadoSelected() {
		return idEmpleadoSelected;
	}

	public void setIdEmpleadoSelected(int idEmpleadoSelected) {
		this.idEmpleadoSelected = idEmpleadoSelected;
	}

		
	
	
	
}
