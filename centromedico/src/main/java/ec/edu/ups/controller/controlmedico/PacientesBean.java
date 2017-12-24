package ec.edu.ups.controller.controlmedico;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.entity.citas.Paciente;
import ec.edu.ups.entity.citas.Persona;
import ups.edu.ec.daos.PersonaDao;
import ups.edu.ec.utils.Constants;
import ups.edu.ec.utils.JPAException;

@ManagedBean
@ViewScoped
public class PacientesBean {
	@Inject private FacesContext facesContext;
	@Inject private PersonaDao daoPersona;
	
	private Persona persona;
	private Paciente paciente;
	
	@PostConstruct
	public void init()
	{
		paciente=new Paciente();
		persona=new Persona();
	}
	
	/**
	 * registra un nuevo paciente
	 * @return
	 */
	public String registrarPaciente()
	{
		
		persona.setPerFecRegistro(new Date());
		persona.setPerEstado(Constants.ESTADO_ACTIVO);
		paciente.setId(getIdPersona()+1);
		paciente.setPacEstado(Constants.ESTADO_ACTIVO);
		paciente.setPacFechaRegistro(new Date());
		persona.setPaciente(paciente);
		
		try {
			daoPersona.insertar(persona);
			instanciarEntidades();
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
	 * retorna la edad del paciente
	 * de acuerdo a la fecha de nacimiento
	 * @return
	 */
	public String retornaEdad()
	{
		System.out.println("fechaNAc"+paciente.getPacFecNacimiento());
		long diferenciaEn_ms = new Date().getTime() - paciente.getPacFecNacimiento().getTime();
		//long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		
		long anios = diferenciaEn_ms / (1000 * 60 * 60);
		Integer i = (int) (long) anios;
		System.out.println("Años:"+i);
		paciente.setPac_edad(i);
		return null;
	}
	
	/**
	 * instancia entidades Persona y paciente
	 * util para el registro
	 */
	public void instanciarEntidades()
	{
		persona=new Persona();
		paciente=new Paciente();
		
	}
	
	/**
	 * encapsulamiento
	 * @return
	 */
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	

}
