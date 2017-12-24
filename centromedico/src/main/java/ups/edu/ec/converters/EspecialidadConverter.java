package ups.edu.ec.converters;

import java.util.List;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.entity.citas.Especialidad;
import ec.edu.ups.entity.negocio.PersonaEmpleado;


@FacesConverter(value="Converters.EspecialidadConverter")
public class EspecialidadConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		System.out.println( this.getClass().getName()+" llega string: "+valor);
		if(valor==null)return null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		//ELContext ec = ctx.getELContext();
		Application app = ctx.getApplication();
		List<Especialidad>lista=(List) app.evaluateExpressionGet(ctx,"#{asignarEspecialidadBean.especialidades}",List.class);	 
		for(Especialidad c:lista)
			if(c.getEspId()==Integer.valueOf(valor))
			{
				System.out.println(this.getClass().getName()+" retorna:"+c.getEspNombre());
				return c;
			
			}
		return null;
	}

/*	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Cargo c=(Cargo)obj;
		System.out.println("hasta aqui ok");
		return ""+c.getCarId();
	}*/
	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        }
        return String.valueOf(((Especialidad) value).getEspId()).toString();
    }
}