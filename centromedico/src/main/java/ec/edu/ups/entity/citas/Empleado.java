package ec.edu.ups.entity.citas;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="tbl_empleado")
//@SequenceGenerator(name = "SEQ_EMPLEADO", sequenceName = "SEQ_EMPLEADO", initialValue = 1, allocationSize = 1)
public class Empleado {
	
	@Id
	@Column(name="id")
	@NotNull
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLEADO")
	private int id;

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
	
	
	@OneToMany(mappedBy="empleado")
	private List<EmpleadoEspecialidad> especialidades;
	
	
	/**
	 * encapsulacion
	 */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public List<EmpleadoEspecialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<EmpleadoEspecialidad> especialidades) {
		this.especialidades = especialidades;
	}

	
	
	
	
	
	
	
	

}
