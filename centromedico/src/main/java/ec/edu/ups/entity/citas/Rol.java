package ec.edu.ups.entity.citas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_rol")
public class Rol {
	
	@Id
	@Column(name="rol_id")
	@NotNull
	private int rolId;
	
	@Column(name="rol_nombre",length=50)
	private String rolNombre;
	
	@Column(name="rol_descripcion",length=80)
	private String rolDescripcion;

	
	/**
	 * encapsulamiento
	 */
	
	
	
}
