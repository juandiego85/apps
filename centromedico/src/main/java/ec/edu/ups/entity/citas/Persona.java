package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="tbl_persona")
@SequenceGenerator(name = "SEQ_PERSONA", sequenceName = "SEQ_PERSONA", initialValue = 1, allocationSize = 1)
public class Persona {

	@Id
	@Column(name="per_id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONA")
	private int perId;
	
	@Column(name="per_identificacion",length=10)
	private String perIdentificacion;
	
	@Column(name="per_nombre")
	private String perNombre;
	
	@Column(name="per_apellido")
	private String perApellido;
	
	@Column(name="per_genero")
	private String perGenero;
	
	@Column(name="per_telefono")
	private String perTelefono;
	
	@Email
	@Column(name="per_email",length=50)
	private String perEmail;
	
	@Column(name="per_fec_registro")
	@Temporal(TemporalType.DATE)
	private Date perFecRegistro;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Empleado empleado;
	
	@OneToOne(cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Paciente paciente;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	
	/**
	 * Encapsulamiento
	 * @return
	 */
	public int getPerId() {
		return perId;
	}
	
	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerIdentificacion() {
		return perIdentificacion;
	}

	public void setPerIdentificacion(String perIdentificacion) {
		this.perIdentificacion = perIdentificacion;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public String getPerGenero() {
		return perGenero;
	}

	public void setPerGenero(String perGenero) {
		this.perGenero = perGenero;
	}

	public String getPerTelefono() {
		return perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Date getPerFecRegistro() {
		return perFecRegistro;
	}

	public void setPerFecRegistro(Date perFecRegistro) {
		this.perFecRegistro = perFecRegistro;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Persona [perId=" + perId + ", perIdentificacion=" + perIdentificacion + ", perNombre=" + perNombre
				+ ", perApellido=" + perApellido + ", perGenero=" + perGenero + ", perTelefono=" + perTelefono
				+ ", perEmail=" + perEmail + ", perFecRegistro=" + perFecRegistro + ", empleado=" + empleado
				+ ", paciente=" + paciente + ", usuario=" + usuario + "]";
	}

	
	

}
