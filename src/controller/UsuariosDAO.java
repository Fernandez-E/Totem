package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnection;
import model.Usuarios;

public class UsuariosDAO {
	
	public static void insertUser(Usuarios user) {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO users (id, name) VALUES (?, ?)");
			statement.setString(1, user.getId());
			statement.setString(2, user.getName());
			statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static String searchUser(Usuarios user) {
		Connection connection = DBConnection.conectDB();
		PreparedStatement statement;
		ResultSet result;
		try {
			statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			statement.setString(1, user.getId());
			result = statement.executeQuery();
			result.next();
			return result.getString("name");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}