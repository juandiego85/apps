package ec.edu.ups.entity.citas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_empleado_especialidad")
public class EmpleadoEspecialidad {
	
	@Id
	@Column(name="eme_id")
	private int emeId;
	
	
	
	
	

}
