package proyectointegrador;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ufc_db", "root", "");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("SELECT Nombre, Apodo FROM luchador");
			while (miResultset.next()) {
				System.out.println(miResultset.getString("Nombre") + ", apodo: " + miResultset.getString("Apodo"));

			}
			miResultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Login a = new Login();
		a.setResizable(false);
		a.setVisible(true);

	}

}