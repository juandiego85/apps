package ups.edu.ec.converters;

import java.util.List;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.ups.entity.citas.Cargo;


@FacesConverter(value="Converters.CargoConverter")
public class CargoConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		System.out.println( this.getClass().getName()+" llega string: "+valor);
		if(valor==null)return null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		//ELContext ec = ctx.getELContext();
		Application app = ctx.getApplication();
		List<Cargo>lista=(List) app.evaluateExpressionGet(ctx,"#{empleadoBean.cargos}",List.class);	 
		for(Cargo c:lista)
			if(c.getCarId()==Integer.valueOf(valor))
			{
				System.out.println(this.getClass().getName()+" retorna:"+c.getCarNombre());
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
        return String.valueOf(((Cargo) value).getCarId()).toString();
    }
	

}