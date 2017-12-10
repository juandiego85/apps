package ec.edu.ups.controller.mantenimiento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.entity.citas.Cargo;
import ups.edu.ec.daos.CargoDAO;


@ManagedBean
@ViewScoped
public class CargoController {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Inject
    private FacesContext facesContext;
	
	private Cargo cargo;
	private List<Cargo> cargos;
	private boolean estado;
	
	@Inject
	private CargoDAO pdao;
	
	private String id;
	
	@PostConstruct
	public void init()
	{
		cargo=new Cargo();
		estado=true;
		loadCargos();
	}

		
	public String guardar()
	{
		System.out.println(cargo);
		try
		{
			pdao.guardar(cargo);
			loadCargos();
		}catch(Exception e){
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		
		return "listado-personas";
	}
	
	
	
	public String guardar2()
	{
		System.out.println("valor id:"+String.valueOf(id));
		try
		{
			if(this.id!=null)
				pdao.actualizar(cargo);
			else 
			{
				cargo.setCarFecharegistro(new Date());
				if(estado)
					cargo.setCarEstado("A");
				else
					cargo.setCarEstado("I");
				pdao.insertar(cargo);	
			}
				
			loadCargos();
		}catch(Exception e){
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		
		return null;
	}
	
	
	public String eliminarCargo(int id)
	{
		pdao.eliminar(id);
		loadCargos();
		return "listado-cargos";
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
	
	public void loadCargos()
	{
		cargos=pdao.listarCargos();
	}
	
	public String loadDatosEditar(int id)
	{
		cargo=pdao.leer(id);
		return "crear-cargo";
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		loadDatosEditar(Integer.valueOf(id));
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	public List<Cargo> getCargos() {
		return cargos;
	}


	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

	
	
}
