package modelo;

import java.io.Serializable;

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int ruc;
	private String nombre;
	private String actividad;
	private String gerenteGeneral;
	private String gereneRh;
	private String direccion;
	private int telefono;
	private String email;
	private String responsable;
	
	public Empresa(){
	}

	
	
	
	public Empresa(int id, int ruc, String nombre, String actividad,
			String gerenteGeneral, String gereneRh, String direccion,
			int telefono, String email, String responsable) {
		super();
		this.id = id;
		this.ruc = ruc;
		this.nombre = nombre;
		this.actividad = actividad;
		this.gerenteGeneral = gerenteGeneral;
		this.gereneRh = gereneRh;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.responsable = responsable;
	}

	



	public Empresa(int ruc, String nombre, String actividad,
			String gerenteGeneral, String gereneRh, String direccion,
			int telefono, String email, String responsable) {
		super();
		this.ruc = ruc;
		this.nombre = nombre;
		this.actividad = actividad;
		this.gerenteGeneral = gerenteGeneral;
		this.gereneRh = gereneRh;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.responsable = responsable;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getGerenteGeneral() {
		return gerenteGeneral;
	}

	public void setGerenteGeneral(String gerenteGeneral) {
		this.gerenteGeneral = gerenteGeneral;
	}

	public String getGereneRh() {
		return gereneRh;
	}

	public void setGereneRh(String gereneRh) {
		this.gereneRh = gereneRh;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	
	
	
}
