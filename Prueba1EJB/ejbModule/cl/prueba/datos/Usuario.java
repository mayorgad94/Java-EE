package cl.prueba.datos;

import java.io.Serializable;

public class Usuario implements Serializable {
private String email;
private String nombre;
private String sexo;
private String codCiudad;
private String nombreCiudad;


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getCodCiudad() {
	return codCiudad;
}
public void setCodCiudad(String codCiudad) {
	this.codCiudad = codCiudad;
}
public String getNombreCiudad() {
	return nombreCiudad;
}
public void setNombreCiudad(String nombreCiudad) {
	this.nombreCiudad = nombreCiudad;
}

 
}
