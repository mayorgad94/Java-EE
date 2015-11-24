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
			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT email,nombre from usuario where email=? and password=?");
			oPrepStatement.setString(1, sNombre);
			oPrepStatement.setString(2, sPassword);
			ResultSet resultado=oPrepStatement.executeQuery();
			while(resultado.next())
			{
				usuario=new Usuario();
				usuario.setEmail(resultado.getString("email"));
				usuario.setNombre(resultado.getString("nombre"));

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
			
			PreparedStatement oPrepStatement = oConexion.prepareStatement(" INSERT INTO reporte (fecha,tipo,latitud,longitud,sub_tipo,email) VALUES (?,?,?,?,?,?)");
			oPrepStatement.setString(1, reporte.getFecha());
			oPrepStatement.setString(2, reporte.getTipo());
			oPrepStatement.setDouble(3, reporte.getLatitud());
			oPrepStatement.setDouble(4, reporte.getLongitud());
			oPrepStatement.setString(5, reporte.getSubTipo());
			oPrepStatement.setString(6, reporte.getEmail());
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

			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT email,tipo,latitud,longitud,sub_tipo from reporte where fecha=?");
			oPrepStatement.setString(1, sFecha);
			ResultSet resultado=oPrepStatement.executeQuery();
			while(resultado.next())
			{
				Reporte reporte = new Reporte();
				reporte.setEmail(resultado.getString("email"));
				reporte.setTipo(resultado.getString("tipo"));
				reporte.setLatitud(resultado.getDouble("latitud"));
				reporte.setLongitud(resultado.getDouble("longitud"));
				reporte.setSubTipo(resultado.getString("sub_tipo"));
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

			PreparedStatement oPrepStatement = oConexion.prepareStatement(" SELECT email,tipo,latitud,longitud,sub_tipo from reporte where tipo=?");
			oPrepStatement.setString(1, sTipo);
			ResultSet resultado=oPrepStatement.executeQuery();
			while(resultado.next())
			{
				Reporte reporte = new Reporte();
				reporte.setEmail(resultado.getString("email"));
				reporte.setTipo(resultado.getString("tipo"));
				reporte.setLatitud(resultado.getDouble("latitud"));
				reporte.setLongitud(resultado.getDouble("longitud"));
				reporte.setSubTipo(resultado.getString("sub_tipo"));
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

public boolean registro(String sNombre, String sPassword, String sEmail, String sApellido, String sCelular,
		String sFechaNacimiento, String sCiudad) {
	// TODO Auto-generated method stub
	boolean resultado=false;
	
	try {
		Connection oConexion = oDataSource.getConnection();
		
		//Statement oStatement = oConexion.createStatement();
		//oStatement.execute("INSERT INTO datos (nombre,rut) VALUES('" + sNombre + "','"+ sPassword+"')");
		
		PreparedStatement oPrepStatement = oConexion.prepareStatement(" INSERT INTO usuario (email,nombre,password,apellido,fecha_nacimiento,celular,nombre_ciudad) VALUES (?,?,?,?,?,?,?)");
		oPrepStatement.setString(1, sEmail);
		oPrepStatement.setString(2, sNombre);
		oPrepStatement.setString(3, sPassword);
		oPrepStatement.setString(4, sApellido);
		oPrepStatement.setString(5, sFechaNacimiento);
		oPrepStatement.setString(6, sCelular);
		oPrepStatement.setString(7, sCiudad);
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
}
