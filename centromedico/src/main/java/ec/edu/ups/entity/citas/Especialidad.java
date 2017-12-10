package ec.edu.ups.entity.citas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tsl_especialidad")
public class Especialidad {
	
	@Id
	@Column(name="esp_id")
	private int espId;
	
	@Column(name="esp_nombre")
	private String espNombre;
	
	
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

	@Override
	public String toString() {
		return "Especialidad [espId=" + espId + ", espNombre=" + espNombre + "]";
	}

	
	

}
