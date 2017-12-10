package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="tbl_persona")
public class Persona {

	@Id
	@Column(name="per_id")
	@NotNull
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
	
	@Column(name="per_estado",length=1)
	private String perEstado;
	
	/**
	 * Encapsulamiento
	 * @return
	 */
	
	
	

}
