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
//@SequenceGenerator(name = "SEQ_PACIENTE", sequenceName = "SEQ_PACIENTE", initialValue = 1, allocationSize = 1)
public class Paciente {
	
	@Id
	@Column(name="id")
	@NotNull
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PACIENTE")
	private int id;
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPacFecNacimiento() {
		return pacFecNacimiento;
	}

	public void setPacFecNacimiento(Date pacFecNacimiento) {
		this.pacFecNacimiento = pacFecNacimiento;
	}

	public int getPac_edad() {
		return pac_edad;
	}

	public void setPac_edad(int pac_edad) {
		this.pac_edad = pac_edad;
	}

	public String getPacDireccion() {
		return pacDireccion;
	}

	public void setPacDireccion(String pacDireccion) {
		this.pacDireccion = pacDireccion;
	}

	public Date getPacFechaRegistro() {
		return pacFechaRegistro;
	}

	public void setPacFechaRegistro(Date pacFechaRegistro) {
		this.pacFechaRegistro = pacFechaRegistro;
	}

	public String getPacEstado() {
		return pacEstado;
	}

	public void setPacEstado(String pacEstado) {
		this.pacEstado = pacEstado;
	}
	
	
	
	
	
	
	
	
	
	

}
