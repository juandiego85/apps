package ec.edu.ups.entity.citas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_empleado_especialidad")
@SequenceGenerator(name = "SEQ_EMP_ESP", sequenceName = "SEQ_EMP_ESP", initialValue = 1, allocationSize = 1)
public class EmpleadoEspecialidad {
	
	@Id
	@Column(name="eme_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMP_ESP")
	private int emeId;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Empleado empleado;
	
	@ManyToOne
    @JoinColumn(name="espId", nullable=false)
    private Especialidad especialidad;

	
	
	/**
	 * Encapsulamiento
	 * @return
	 */
	public int getEmeId() {
		return emeId;
	}

	public void setEmeId(int emeId) {
		this.emeId = emeId;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
	

}
