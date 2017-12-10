package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_empleado")
@SequenceGenerator(name = "SEQ_EMPLEADO", sequenceName = "SEQ_EMPLEADO", initialValue = 1, allocationSize = 1)
public class Empleado {
	
	@Id
	@Column(name="emp_id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLEADO")
	private int empId;

	@Column(name="emp_fecha_regitro")
	@Temporal(TemporalType.DATE)
	private Date empFechaRegistro;
	
	@Column(name="emp_estado", length=1)
	private String empEstado;

	@ManyToOne
	@JoinColumn(name="cargo")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="profesion")
	private Profesion profesion;
	
	/**
	 * encapsulacion
	 */
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getEmpFechaRegistro() {
		return empFechaRegistro;
	}

	public void setEmpFechaRegistro(Date empFechaRegistro) {
		this.empFechaRegistro = empFechaRegistro;
	}

	public String getEmpEstado() {
		return empEstado;
	}

	public void setEmpEstado(String empEstado) {
		this.empEstado = empEstado;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
	
	
	
	

}
