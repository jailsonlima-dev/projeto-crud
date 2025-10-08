package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.conexaoBD;
import model.Usuario;

public class UsuarioDAO {

	public void inserir(Usuario usuario) throws Exception {
		String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
		try (Connection conn = conexaoBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, usuario.getnome());
			ps.setString(2, usuario.getemail());
			ps.setString(3, usuario.getsenha());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
