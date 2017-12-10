package ec.edu.ups.entity.citas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_usuario_rol")
public class UsuarioRol {
	
	@Id
	@Column(name="usr_id")
	private int usrId;
	
	@Column(name="usr_estado",length=1)
	private String usrEstado;
	
	
	/**
	 * Encapsulamiento
	 */
	
	

}
