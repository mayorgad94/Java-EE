package cl.prueba.datos;

import java.io.Serializable;

public class Reporte implements Serializable {
	private String fecha;
	private String email;
	private String tipo;
	private double latitud;					
	private double longitud;
	private String subTipo;
	
	public String getSubTipo() {
		return subTipo;
	}
	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
}
