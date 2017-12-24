package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_usuario")
public class Usuario {
	@Id
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="usu_nombre")
	@Size(min=6,max=15)
	private String usuNombre;
	
	@Column(name="usu_clave")
	@Size(min=6,max=15)
	private String usuClave;
	
	@Column(name="usu_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date usuFechaRegistro;
	
	@Column(name="usu_estado",length=1)
	private String usuEstado;
	
	@Column(name="usu_ultimo_acceso")
	@Temporal(TemporalType.DATE)
	private Date usuUltimoAcceso;
	
	
/**
 * Encapsulameinto	
 * @return
 */
	

}
