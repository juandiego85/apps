package ups.edu.ec.converters;

import java.util.List;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.entity.citas.Cargo;
import ec.edu.ups.entity.citas.Profesion;


@FacesConverter(value="Converters.ProfesionConverter")
public class ProfesionConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		System.out.println( this.getClass().getName()+" llega string: "+valor);
		if(valor==null)return null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		//ELContext ec = ctx.getELContext();
		Application app = ctx.getApplication();
		List<Profesion>lista=(List) app.evaluateExpressionGet(ctx,"#{empleadoBean.profesiones}",List.class);	 
		for(Profesion c:lista)
			if(c.getProId()==Integer.valueOf(valor))
			{
				System.out.println(this.getClass().getName()+" retorna:"+c.getProNombre());
				return c;
			
			}
		return null;
	}

	/*@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Servicios c=(Servicios)obj;
		System.out.println("hasta aqui ok");
		return ""+c.getIdServicio();
	}*/
	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        }
        return String.valueOf(((Profesion) value).getProId()).toString();
    }
	

}