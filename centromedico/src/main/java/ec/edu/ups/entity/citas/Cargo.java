package ec.edu.ups.entity.citas;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_cargo")
@SequenceGenerator(name = "SEQ_CARGO", sequenceName = "SEQ_CARGO", initialValue = 1, allocationSize = 1)
public class Cargo {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARGO")
	@Column(name="car_id")
	private int carId;
	
	@Column(name="car_nombre",length=50)
	private String carNombre;
	
	@Column(name="car_estado",length=1)
	private String carEstado;
	
	@Column(name="car_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date carFecharegistro;

	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="cargo",referencedColumnName="car_id")
	private List<Empleado>empleados;
	
	
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

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Cargo [carId=" + carId + ", carNombre=" + carNombre + ", carEstado=" + carEstado + ", carFecharegistro="
				+ carFecharegistro + "]";
	}
	
	
	
	

}
