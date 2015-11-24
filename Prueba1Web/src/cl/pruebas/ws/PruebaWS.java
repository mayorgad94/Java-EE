package cl.pruebas.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cl.prueba.datos.Reporte;
import cl.prueba.datos.Usuario;
import cl.prueba.ejb.PrimerEJB;

@WebService
public class PruebaWS {

	@EJB
	private PrimerEJB oEjb;
	// SoapUI
	@WebMethod
	public Usuario login(
			@WebParam(name="nombre")
			String sNombre, String sPassword){
		return oEjb.login(sNombre, sPassword);
	}
	
	public boolean registrar(
			@WebParam(name="nombre")
			String sEmail, String sPassword, String sNombre, String sApellido, String sCelular, String sFechaNacimiento,String sCiudad){
		return oEjb.registro(sNombre, sPassword,sEmail,sApellido,sCelular,sFechaNacimiento,sCiudad);
	}

	
	@WebMethod
	public boolean generarReportes (
			@WebParam(name="dato")
			Reporte reporte){
		return oEjb.registrarReporte(reporte);
	}
	
	@WebMethod
	public List<Reporte> filtrarFecha(
			@WebParam(name="dato")
			String fecha){
		return oEjb.buscaReportes(fecha);
	}
	
	@WebMethod
	public List<Reporte> filtrarTipo(
			@WebParam(name="dato")
			String tipo){
		return oEjb.filtrarTipo(tipo);
	}
}

