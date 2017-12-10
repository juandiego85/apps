package ec.edu.ups.controller.mantenimiento;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.entity.citas.Profesion;
import ups.edu.ec.daos.ProfesionDAO;



@ManagedBean
@ViewScoped
public class Profesioncontroller {

	@Inject ProfesionDAO daoProfesion;
	@Inject private FacesContext facesContext;
	Profesion profesion;
	List<Profesion>listProfesion;
	private String id;
	
	@PostConstruct
	public void load()
	{
		profesion=new Profesion();
		loadProfesiones();
	}
	
	/**
	 * lista las profesiones registradas
	 */
	public void loadProfesiones()
	{
		listProfesion=daoProfesion.listarEntidad();
	}
	
	public String guardar()
	{
		try
		{
			if(this.id!=null)
				daoProfesion.actualizar(profesion);
			else
				daoProfesion.insertar(profesion);
			loadProfesiones();
		}catch(Exception e){
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		return null;
	}
	
	private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
	

	/**
	 * encapsulamiento
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public List<Profesion> getListProfesion() {
		return listProfesion;
	}

	public void setListProfesion(List<Profesion> listProfesion) {
		this.listProfesion = listProfesion;
	}
	
	
	
	

}
