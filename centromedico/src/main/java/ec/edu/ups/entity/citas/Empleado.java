package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_empleado")
public class Empleado {
	
	@Id
	@Column(name="emp_id")
	private int empId;

	@Column(name="emp_fecha_regitro")
	@Temporal(TemporalType.DATE)
	private Date empFechaRegistro;
	
	@Column(name="emp_estado", length=1)
	private String empEstado;
	/**
	 * encapsulacion
	 */
	
	

}
