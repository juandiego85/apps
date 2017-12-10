package ec.edu.ups.entity.citas;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_cita")
public class Cita {
	
	@Id
	@Column(name="cit_id")
	private int citId;
	
	@Column(name="cit_fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date citFechaRegistro;
	
	@Column(name="cit_hora")
	@Temporal(TemporalType.TIME)
	private Date citHora;
	
	@Column(name="cit_valor")
	private Double citValor;
	
	@Column(name="cit_estado")
	private String citEstado;
	
	

}
