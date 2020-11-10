package es.pruebatec.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/";
		
		String usuario="root";
		String contra="root";
		
		try {
			System.out.println("Conectando a bbdd: " + jdbcUrl);
			Connection miConexion=DriverManager.getConnection(jdbcUrl,usuario,contra);
			System.out.println("Conexion correcta");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
