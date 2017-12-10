package ec.edu.ups.entity.citas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_profesion")
@SequenceGenerator(name = "SEQ_PROFESION", sequenceName = "SEQ_PROFESION", initialValue = 1, allocationSize = 1)
public class Profesion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pro_id")
	@NotNull
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROFESION")
	private int proId;
	
	@Column(name="pro_nombre",length=50)
	private String proNombre;
	
	@Column(name="pro_descripcion",length=50)
	private String proDescripcion;

	
	/**
	 * encapsulameinto
	 */
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProNombre() {
		return proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public String getProDescripcion() {
		return proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	@Override
	public String toString() {
		return "Profesion [proId=" + proId + ", proNombre=" + proNombre + ", proDescripcion=" + proDescripcion + "]";
	}
	
	

	
	
}
