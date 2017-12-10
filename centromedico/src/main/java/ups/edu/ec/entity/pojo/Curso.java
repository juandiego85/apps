package ups.edu.ec.entity.pojo;

public class Curso {
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	
	public Curso(String nombre,String descripcion,String fechaInicio)
	{
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fechaInicio=fechaInicio;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + "]";
	}
	
	
	

}
