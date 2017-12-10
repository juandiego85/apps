package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class CentroMedico {
	
	
	@Id
	@Column(name="cem_id")
	@NotNull
	private int cemId;
	
	@Column(name="cem_nombre",length=50)
	private String nombre;

	@Column(name="cem_direccion",length=60)
	private String cemDireccion;
	
	@Column(name="cem_telefono",length=30)
	private String cemTelefono;
	
	@Column(name="cem_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date cemFechaRegistro;

		
	
	
}
