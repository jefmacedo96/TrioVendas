package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DbUtil;

public class UserDAO {

	private static Connection connection = DbUtil.getConnection();

	public static User addUser(String cpf, String senha, String name, String email, String telefone, String estado, String cidade, String complemento) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("insert into users(cpf,senha,name,email,telefone,estado,cidade,complemento) values (?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1,cpf);
			pStmt.setString(2,senha);
			pStmt.setString(3,name);
			pStmt.setString(4,email);
			pStmt.setString(5,telefone);
			pStmt.setString(6,estado);
			pStmt.setString(7,cidade);
			pStmt.setString(8,complemento);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("name"), rs.getString("email"), rs.getString("telefone"), rs.getString("estado"), rs.getString("cidade"), rs.getString("complemento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User updateUser(int id, String cpf, String senha, String name, String email, String telefone, String estado, String cidade, String complemento) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set cpf=?,senha=?,name=?,email=?,telefone=?,estado=?,cidade=?,complemento=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1,cpf);
			pStmt.setString(2,senha);
			pStmt.setString(3,name);
			pStmt.setString(4,email);
			pStmt.setString(5,telefone);
			pStmt.setString(6,estado);
			pStmt.setString(7,cidade);
			pStmt.setString(8,complemento);
			pStmt.setInt(9,id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("name"), rs.getString("email"), rs.getString("telefone"), rs.getString("estado"), rs.getString("cidade"), rs.getString("complemento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("name"), rs.getString("email"), rs.getString("telefone"), rs.getString("estado"), rs.getString("cidade"), rs.getString("complemento"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static User getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("name"), rs.getString("email"), rs.getString("telefone"), rs.getString("estado"), rs.getString("cidade"), rs.getString("complemento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByCpf(String cpf) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where cpf=?");
			pStmt.setString(1, cpf);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("name"), rs.getString("email"), rs.getString("telefone"), rs.getString("estado"), rs.getString("cidade"), rs.getString("complemento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}