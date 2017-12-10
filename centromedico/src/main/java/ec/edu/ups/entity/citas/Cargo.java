package ec.edu.ups.entity.citas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_cargo")
public class Cargo {
	
	@Id
	@Column(name="car_id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
	@Column(name="car_nombre",length=50)
	private String carNombre;
	
	@Column(name="car_estado",length=1)
	private String carEstado;
	
	@Column(name="car_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date carFecharegistro;

	
	
	/**
	 * Encapsulamiento
	 */
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNombre() {
		return carNombre;
	}

	public void setCarNombre(String carNombre) {
		this.carNombre = carNombre;
	}

	public String getCarEstado() {
		return carEstado;
	}

	public void setCarEstado(String carEstado) {
		this.carEstado = carEstado;
	}

	public Date getCarFecharegistro() {
		return carFecharegistro;
	}

	public void setCarFecharegistro(Date carFecharegistro) {
		this.carFecharegistro = carFecharegistro;
	}

	@Override
	public String toString() {
		return "Cargo [carId=" + carId + ", carNombre=" + carNombre + ", carEstado=" + carEstado + ", carFecharegistro="
				+ carFecharegistro + "]";
	}
	
	
	
	

}
