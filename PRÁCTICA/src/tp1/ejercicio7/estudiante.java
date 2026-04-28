package tp1.ejercicio7;

import java.util.Objects;

public class estudiante {
	private String apellido;
	private String nombre;
	private int comision;
	private String email;
	private String direccion;
	
	public estudiante(String apellido, String nombre, String email, String direccion,int comision) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.comision = comision;
		this.email = email;
		this.direccion = direccion;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String str = "Apellido y nombre: "+getApellido()+", "+getNombre()+"\n"+
				"Email: "+getEmail()+"\n"+
				"Comision: "+getComision()+"\n"+
				"Direccion: "+getDireccion()+"\n";
		return str;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, comision, direccion, email, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		estudiante other = (estudiante) obj;
		return Objects.equals(apellido, other.apellido) && comision == other.comision
				&& Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}