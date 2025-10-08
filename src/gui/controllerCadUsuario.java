package gui;

import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;

import application.conexaoBD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class controllerCadUsuario {
	@FXML
    private Button BtSair;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;

	public void cadastro(){
		//btCadastrar.setOnAction(event-> {
			String email = txtEmail.getText();
			String nome = txtNome.getText();
			String senha = txtSenha.getText();
			
			String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

		try (Connection conn = conexaoBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.setString(3, senha);
			
			System.out.println("deu certo!");
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
			
			

	//	});

}

}
