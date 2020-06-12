package mipaquete;

public class Alumno {
	// Zona de declaración de Atributos
	private String legajo;
	private String nombre;
	private String apellido;
	private int numeroDni;
	private char tipoDni;
	private String calle, ciudad, telefono;
	private int numeroDomicilio;
	private String usuario;
	private String clave;
	
	// Constructores
	
	public Alumno(String legajo) {
		this.legajo = legajo;
	}
	public Alumno(String legajo, String usuario, String clave) {
		this.legajo = legajo;
		this.usuario = usuario;
		this.clave = clave;
	}
	public Alumno() {
		this.legajo = "";
		this.nombre = "";
		this.apellido = "";
		this.numeroDni = 0;
		this.tipoDni = 'A';
		this.calle = "";
		this.ciudad = "";
		this.telefono = "";
		this.numeroDomicilio = 0;
		this.usuario = "";
		this.clave = "";
	}
	
	// Observadores
	
	public String getLegajo() {
		return this.legajo;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public int getNumeroDni() {
		return this.numeroDni;
	}
	public char getTipoDni() {
		return this.tipoDni;
	}
	public String getCalle() {
		return this.calle;
	}
	public String getCiudad() {
		return this.ciudad;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public int getNumeroDomicilio() {
		return this.numeroDomicilio;
	}
	/*public String getUsuario() {
		return this.usuario;
	}*/
	
	// Modificadores
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido ;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setNumeroDomicilio(int numeroDomicilio) {
		this.numeroDomicilio = numeroDomicilio;
	}
	
	public String toString() {
		return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nLegajo: " + this.legajo 
				+ "\nNumero de dni: " + this.numeroDni + "\nTipo de dni: " + this.tipoDni + "\nCalle: " + calle
				+ "\nCiudad: " + this.ciudad + "\nTelefono: " + this.telefono + "\nNumero de domicilio: " + this.numeroDomicilio;
	}
	
	public boolean equals(String legajo) {
		return this.legajo.equalsIgnoreCase(legajo);
	}
	
	
	
}
