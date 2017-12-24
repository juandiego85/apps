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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "SEQ_PERSONA", sequenceName = "SEQ_PERSONA", initialValue = 1, allocationSize = 1)
@Table(name="tbl_persona",uniqueConstraints = @UniqueConstraint(columnNames = "per_identificacion"))
public class Persona {

	@Id
	@Column(name="id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONA")
	private int id;
	
	@Column(name="per_identificacion",length=10)
	private String perIdentificacion;
	
	@NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "No debe contener numeros")
	@Column(name="per_nombre")
	private String perNombre;
	
	@NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "No debe contener numeros")
	@Column(name="per_apellido")
	private String perApellido;
	
	@Column(name="per_genero")
	private String perGenero;
	
	@Size(min = 7, max = 12,message="minimo 7 maximo 12")
    @Digits(fraction = 0, integer = 12)
	@Column(name="per_telefono")
	private String perTelefono;
	
	@NotNull
    @NotEmpty
    @Email(message="correo incorrecto")
	@Column(name="per_email",length=50)
	private String perEmail;
	
	@Column(name="per_fec_registro")
	@Temporal(TemporalType.DATE)
	private Date perFecRegistro;
	
	
	@Column(name="per_estado", length=1)
	private String perEstado;
	
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
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

	public String getPerEstado() {
		return perEstado;
	}

	public void setPerEstado(String perEstado) {
		this.perEstado = perEstado;
	}

	@Override
	public String toString() {
		return "Persona [perId=" +id + ", perIdentificacion=" + perIdentificacion + ", perNombre=" + perNombre
				+ ", perApellido=" + perApellido + ", perGenero=" + perGenero + ", perTelefono=" + perTelefono
				+ ", perEmail=" + perEmail + ", perFecRegistro=" + perFecRegistro + ", empleado=" + empleado
				+ ", paciente=" + paciente + ", usuario=" + usuario + "]";
	}

	
	

}
