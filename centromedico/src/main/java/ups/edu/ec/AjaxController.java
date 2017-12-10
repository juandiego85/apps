package ups.edu.ec;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class AjaxController {

	// Ejercicio 1
	private String fecha;
	// Ejercicio 2
	private int contador;
	// Ejercicio 3
	private String texto;
	private int caracteres;
	// Ejercicio 4
	private String tPais;
	private String tCiudad;
	private String tParroquia;
	private List<SelectItem> listaPaises;
	private List<SelectItem> listaCiudades;
	private List<SelectItem> listaParroquias;
	// Argentina
	private List<SelectItem> ciudadesArgentina;
	private List<SelectItem> parroquiasBuenosAires;
	private List<SelectItem> parroquiasRosario;
	private List<SelectItem> parroquiasCordoba;
	// Ecuador
	private List<SelectItem> ciudadesEcuador;
	private List<SelectItem> parroquiasCuenca;
	private List<SelectItem> parroquiasQuito;
	private List<SelectItem> parroquiasGuayaquil;
	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(int caracteres) {
		this.caracteres = caracteres;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String gettPais() {
		return tPais;
	}

	public void settPais(String tPais) {
		this.tPais = tPais;
	}

	public String gettCiudad() {
		return tCiudad;
	}

	public void settCiudad(String tCiudad) {
		this.tCiudad = tCiudad;
	}

	public String gettParroquia() {
		return tParroquia;
	}

	public void settParroquia(String tParroquia) {
		this.tParroquia = tParroquia;
	}

	public List<SelectItem> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<SelectItem> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public List<SelectItem> getCiudadesEcuador() {
		return ciudadesEcuador;
	}

	public void setCiudadesEcuador(List<SelectItem> ciudadesEcuador) {
		this.ciudadesEcuador = ciudadesEcuador;
	}

	public List<SelectItem> getParroquiasCuenca() {
		return parroquiasCuenca;
	}

	public void setParroquiasCuenca(List<SelectItem> parroquiasCuenca) {
		this.parroquiasCuenca = parroquiasCuenca;
	}

	public List<SelectItem> getParroquiasQuito() {
		return parroquiasQuito;
	}

	public void setParroquiasQuito(List<SelectItem> parroquiasQuito) {
		this.parroquiasQuito = parroquiasQuito;
	}

	public List<SelectItem> getParroquiasGuayaquil() {
		return parroquiasGuayaquil;
	}

	public void setParroquiasGuayaquil(List<SelectItem> parroquiasGuayaquil) {
		this.parroquiasGuayaquil = parroquiasGuayaquil;
	}

	public List<SelectItem> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<SelectItem> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public List<SelectItem> getListaParroquias() {
		return listaParroquias;
	}

	public void setListaParroquias(List<SelectItem> listaParroquias) {
		this.listaParroquias = listaParroquias;
	}

	public List<SelectItem> getCiudadesArgentina() {
		return ciudadesArgentina;
	}

	public void setCiudadesArgentina(List<SelectItem> ciudadesArgentina) {
		this.ciudadesArgentina = ciudadesArgentina;
	}

	public List<SelectItem> getParroquiasBuenosAires() {
		return parroquiasBuenosAires;
	}

	public void setParroquiasBuenosAires(List<SelectItem> parroquiasBuenosAires) {
		this.parroquiasBuenosAires = parroquiasBuenosAires;
	}

	public List<SelectItem> getParroquiasRosario() {
		return parroquiasRosario;
	}

	public void setParroquiasRosario(List<SelectItem> parroquiasRosario) {
		this.parroquiasRosario = parroquiasRosario;
	}

	public List<SelectItem> getParroquiasCordoba() {
		return parroquiasCordoba;
	}

	public void setParroquiasCordoba(List<SelectItem> parroquiasCordoba) {
		this.parroquiasCordoba = parroquiasCordoba;
	}
	
	@PostConstruct
	private void fill(){
		fillListaPaises();
		fillCiudadesEcuador();
		fillParroquiasCuenca();
		fillParroquiasGuayaquil();
		fillParroquiasQuito();
		fillCiudadesArgentina();
		fillParroquiasBuenosAires();
		fillParroquiasRosario();
		fillParroquiasCordoba();
	}
	
	private void fillListaPaises(){
		listaPaises = new ArrayList<SelectItem>();
		listaPaises.add(new SelectItem("ar","Argentina"));
		listaPaises.add(new SelectItem("ec","Ecuador"));
	}
	
	private void fillCiudadesEcuador(){
		ciudadesEcuador = new ArrayList<SelectItem>();
		ciudadesEcuador.add(new SelectItem("cu","Cuenca"));
		ciudadesEcuador.add(new SelectItem("gye","Guayaquil"));
		ciudadesEcuador.add(new SelectItem("uio","Quito"));
	}
	
	private void fillParroquiasCuenca(){
		parroquiasCuenca = new ArrayList<SelectItem>();
		parroquiasCuenca.add(new SelectItem("El Sagrario"));
		parroquiasCuenca.add(new SelectItem("Gil Ramirez Davalos"));
		parroquiasCuenca.add(new SelectItem("San Sebastian"));
	}
	
	private void fillParroquiasGuayaquil(){
		parroquiasGuayaquil = new ArrayList<SelectItem>();
		parroquiasGuayaquil.add(new SelectItem("Ayacucho"));
		parroquiasGuayaquil.add(new SelectItem("Letamendi"));
		parroquiasGuayaquil.add(new SelectItem("9 de Octubre"));
	}
	
	private void fillParroquiasQuito(){
		parroquiasQuito = new ArrayList<SelectItem>();
		parroquiasQuito.add(new SelectItem("Centro Historico"));
		parroquiasQuito.add(new SelectItem("EL Inca"));
		parroquiasQuito.add(new SelectItem("Magdalena"));
	}
	
	private void fillCiudadesArgentina(){
		ciudadesArgentina = new ArrayList<SelectItem>();
		ciudadesArgentina.add(new SelectItem("bair","Buenos Aires"));
		ciudadesArgentina.add(new SelectItem("rosa","Rosario"));
		ciudadesArgentina.add(new SelectItem("cord","Cordoba"));
	}
	
	private void fillParroquiasBuenosAires(){
		parroquiasBuenosAires = new ArrayList<SelectItem>();
		parroquiasBuenosAires.add(new SelectItem("Nuestra Sra. Lujan"));
		parroquiasBuenosAires.add(new SelectItem("San Francisco Javier"));
		parroquiasBuenosAires.add(new SelectItem("Santa Maria de Betania"));
	}
	
	private void fillParroquiasRosario(){
		parroquiasRosario = new ArrayList<SelectItem>();
		parroquiasRosario.add(new SelectItem("Cooperadores Parroquiales del Cristo"));
		parroquiasRosario.add(new SelectItem("Santa Rosa de lima"));
		parroquiasRosario.add(new SelectItem("Inmaculado Corazon de Maria"));
	}
	
	private void fillParroquiasCordoba(){
		parroquiasCordoba = new ArrayList<SelectItem>();
		parroquiasCordoba.add(new SelectItem("Nuestra Sra. del Valle"));
		parroquiasCordoba.add(new SelectItem("Santisima Trinidad"));
		parroquiasCordoba.add(new SelectItem("Cristo Redentor"));
	}
	
	// Action Controllers
	public String generarFecha(){
		//Calendar cal = Calendar.getInstance();
		Calendar calendario = new GregorianCalendar();
				
		String dia = Integer.toString(calendario.get(Calendar.DATE));
		String mes = Integer.toString(calendario.get(Calendar.MONTH));
		String year = Integer.toString(calendario.get(Calendar.YEAR));
		String hora = Integer.toString(calendario.get(Calendar.HOUR));
		String minuto = Integer.toString(calendario.get(Calendar.MINUTE));
		String segundo = Integer.toString(calendario.get(Calendar.SECOND));
		
		fecha = dia+"/"+mes+"/"+year+" -- "+hora+":"+minuto+"."+segundo;
		return null;
	}
	
	public String contarClicks(){
		this.contador = contador + 1;
		return null;
	}
	
	public String contarCaracteres(){
		caracteres = texto.length()+1;
		return null;
	}
	
	public String verificarPais(){
		if(tPais.equals("ar")){
			listaCiudades = ciudadesArgentina;
		}
		if(tPais.equals("ec")){
			listaCiudades = ciudadesEcuador;
		}
		return null;
	}
	
	public String verificarCiudad(){
		// Argentina
		if(tCiudad.equals("bair")){
			listaParroquias = parroquiasBuenosAires;
		}
		if(tCiudad.equals("rosa")){
			listaParroquias = parroquiasRosario;
		}
		if(tCiudad.equals("cord")){
			listaParroquias = parroquiasCordoba;
		}
		// Ecuador
		if(tCiudad.equals("cu")){
			listaParroquias = parroquiasCuenca;
		}
		if(tCiudad.equals("gye")){
			listaParroquias = parroquiasGuayaquil;
		}
		if(tCiudad.equals("uio")){
			listaParroquias = parroquiasQuito;
		}
		return null;
	}
	

}
