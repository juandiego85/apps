package ec.edu.ups.entity.citas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_especialidad")
@SequenceGenerator(name = "SEQ_ESPECIALIDAD", sequenceName = "SEQ_ESPECIALIDAD", initialValue = 1, allocationSize = 1)
public class Especialidad {
	
	@Id
	@Column(name="esp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESPECIALIDAD")
	private int espId;
	
	@Column(name="esp_nombre")
	private String espNombre;
	
	
	@OneToMany(mappedBy="especialidad")
	private List<EmpleadoEspecialidad> especialidades;
	
	
	/**
	 * Encapsulamiento
	 * @return
	 */

	public int getEspId() {
		return espId;
	}

	public void setEspId(int espId) {
		this.espId = espId;
	}

	public String getEspNombre() {
		return espNombre;
	}

	public void setEspNombre(String espNombre) {
		this.espNombre = espNombre;
	}

	
	public List<EmpleadoEspecialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<EmpleadoEspecialidad> especialidades) {
		this.especialidades = especialidades;
	}

	@Override
	public String toString() {
		return "Especialidad [espId=" + espId + ", espNombre=" + espNombre + "]";
	}

	
	

}
