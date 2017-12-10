package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_paciente")
public class Paciente {
	
	@Id
	@Column(name="pac_id")
	@NotNull
	private int pacId;
	
	@Column(name="pac_fec_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date pacFecNacimiento;
	
	@Column(name="pac_edad")
	private int pac_edad;
	
	@Column(name="pac_direccion")
	private String pacDireccion;
	
	@Column(name="pac_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date pacFechaRegistro;
	
	@Column(name="pac_estado",length=1)
	private String pacEstado;
	
	
	
	
	
	/**
	 * Encapsulacion
	 * @return
	 */
	

	
	
	

}
