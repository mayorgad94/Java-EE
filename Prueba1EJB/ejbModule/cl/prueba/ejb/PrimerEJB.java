package cl.prueba.ejb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import cl.prueba.datos.Reporte;
import cl.prueba.datos.Usuario;

/**
 * Session Bean implementation class PrimerEJB
 */
@Stateless
@LocalBean
public class PrimerEJB {
	
	@Resource(mappedName="java:/NombreDS")
	private DataSource oDataSource;
	
	public Usuario login(String sNombre, String sPassword) {
		
		Usuario usuario=null;
		
		try {
			Connection oConexion = oDataSource.getConnection();
			
			//Statement oStatement = oConexion.createStatement();
			//oStatement.execute("INSERT INTO datos (nombre,rut) VALUES('" + sNombre + "','"+ sPassword+"')");
			System.out.println("Nombre: " + sNombre);
			System.out.println("Password: " + sPassword);
			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT email,nombre,sexo,cod_ciudad from usuario where email=? and password=?");
			oPrepStatement.setString(1, sNombre);
			oPrepStatement.setString(2, sPassword);
			ResultSet resultado=oPrepStatement.executeQuery();
			while(resultado.next())
			{
				usuario=new Usuario();
				usuario.setEmail(resultado.getString("email"));
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setSexo(resultado.getString("sexo"));
				usuario.setCodCiudad(resultado.getString("cod_ciudad"));
			}
			/*
			CallableStatement oCallStatement = oConexion.prepareCall("{call login (?,?)}");
			oCallStatement.setString(1, sNombre;
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}

	public boolean registrarReporte(Reporte reporte) {
		boolean resultado=false;
		
		try {
			Connection oConexion = oDataSource.getConnection();
			
			//Statement oStatement = oConexion.createStatement();
			//oStatement.execute("INSERT INTO datos (nombre,rut) VALUES('" + sNombre + "','"+ sPassword+"')");
			
			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT email,nombre,sexo,cod_ciudad from usuario where email=? and password=?");
			oPrepStatement.setString(1, reporte.getEmail());
			oPrepStatement.setString(2, reporte.getFecha());
			oPrepStatement.setString(3, reporte.getTipo());
			oPrepStatement.setBytes(4, reporte.getFoto());
			oPrepStatement.setDouble(5, reporte.getLatitud());
			oPrepStatement.setDouble(6, reporte.getLongitud());
			oPrepStatement.execute();
			resultado=true;
			/*
			CallableStatement oCallStatement = oConexion.prepareCall("{call login (?,?)}");
			oCallStatement.setString(1, sNombre;
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	public List<Reporte> buscaReportes(String sFecha) {
		
		List<Reporte> reportes=new ArrayList<Reporte>();
		
		try {
			Connection oConexion = oDataSource.getConnection();
			
			//Statement oStatement = oConexion.createStatement();
			//oStatement.execute("INSERT INTO datos (nombre,rut) VALUES('" + sNombre + "','"+ sPassword+"')");

			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT foto,emailtipo,latitud,longitud from reportes where fecha=?");
			oPrepStatement.setString(1, sFecha);
			ResultSet resultado=oPrepStatement.executeQuery();
			while(resultado.next())
			{
				Reporte reporte = new Reporte();
				reportes.add(reporte);
			}
			/*
			CallableStatement oCallStatement = oConexion.prepareCall("{call login (?,?)}");
			oCallStatement.setString(1, sNombre;
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reportes;
	}
	
public List<Reporte> filtrarTipo(String sTipo) {
		
		List<Reporte> reportes=new ArrayList<Reporte>();
		
		try {
			Connection oConexion = oDataSource.getConnection();
			
			//Statement oStatement = oConexion.createStatement();
			//oStatement.execute("INSERT INTO datos (nombre,rut) VALUES('" + sNombre + "','"+ sPassword+"')");

			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT foto,emailtipo,latitud,longitud from reportes where fecha=?");
			oPrepStatement.setString(1, sTipo);
			ResultSet resultado=oPrepStatement.executeQuery();
			while(resultado.next())
			{
				Reporte reporte = new Reporte();
				reportes.add(reporte);
			}
			/*
			CallableStatement oCallStatement = oConexion.prepareCall("{call login (?,?)}");
			oCallStatement.setString(1, sNombre;
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reportes;
	}
}
