package ec.edu.ups.controller.mantenimiento;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.entity.citas.Especialidad;
import ups.edu.ec.daos.EspecialidadDao;
import ups.edu.ec.utils.JPAException;

@ManagedBean
@ViewScoped
public class EspecialidadBean {
	@Inject FacesContext facesContext;
	@Inject EspecialidadDao daoEspec;
	private Especialidad especialidad;
	private List<Especialidad>especialidades;
	
	@PostConstruct
	public void init()
	{
		especialidad=new Especialidad();
		loadEspecialidades();
	}
	
	/**
	 * registra una especialidad
	 * @return
	 */
	public String resgistrarEspecialidad()
	{
		
		try {
			daoEspec.insertar(especialidad);
			especialidad=new Especialidad();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "REGISTRO EXITOSO");
            facesContext.addMessage(null, m);
            loadEspecialidades();
		} catch (JPAException e) {
			String msg=e.getMensaje();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            facesContext.addMessage(null, m);
		}
		return null;
	}
	
	
	/**
	 * carga las especialidades
	 */
	public void loadEspecialidades()
	{
		especialidades=daoEspec.listarEntidad();
	}
	
	
	/**
	 * Encapsulamiento
	 * @return
	 */
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
	
	

}
