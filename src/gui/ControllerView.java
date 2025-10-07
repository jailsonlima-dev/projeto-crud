 	package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.conexaoBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Alerts;

public class ControllerView {

	@FXML
	private Button btentrar;

	@FXML
	private TextField txtemail;

	@FXML
	private TextField txtsenha;

	@FXML
	private void initialize() {

		btentrar.setOnAction(event -> {
			String email = txtemail.getText();
			String senha = txtsenha.getText();

			try (Connection conn = conexaoBD.getConnection()) {
				String sql = "SELECT * FROM funcionarios WHERE email = ? AND senha = ? ";
				PreparedStatement stms = conn.prepareStatement(sql);
				stms.setString(1, email);
				stms.setString(2, senha);

				ResultSet rs = stms.executeQuery();
				if (rs.next()) {
					//Alerts.showAlert(null, "login bem-sucedido", null, AlertType.INFORMATION);

					btentrar.getScene().getWindow().hide();
					Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
					Stage stage = new Stage();
					Scene scene = new Scene(root);

					stage.setScene(scene);
					stage.setTitle("Tela menu |Sistema");
					stage.centerOnScreen();
					//stage.setMaximized(true);
					stage.show();

				} else {
					Alerts.showAlert(null, "Email ou Senha esta incorreto!", null, AlertType.ERROR);

				}
			} catch (Exception e) {
				e.printStackTrace();
				Alerts.showAlert(null, "Erro na conexão com o Banco de Dados!", null, AlertType.ERROR);

			}

		});
	}

	/*
	 * @FXML void onBtentrarAction(ActionEvent event) { String email =
	 * txtemail.getText(); String senha = txtsenha.getText();
	 * 
	 * try (Connection conn = conexaoBD.getConnection()) { String sql =
	 * "SELECT * FROM funcionarios WHERE email = ? AND senha = ? ";
	 * PreparedStatement stms = conn.prepareStatement(sql); stms.setString(1,
	 * email); stms.setString(2, senha);
	 * 
	 * ResultSet rs = stms.executeQuery(); if (rs.next()) { Alerts.showAlert(null,
	 * "login bem-sucedido", null, AlertType.INFORMATION);
	 * 
	 * Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
	 * Stage stage = new Stage(); Scene scene = new Scene(root);
	 * 
	 * stage.setScene(scene); stage.setTitle("Tela menu |Sistema");
	 * stage.centerOnScreen(); stage.setMaximized(true); stage.show();
	 * btentrar.getScene().getWindow().hide();
	 * 
	 * } else { Alerts.showAlert(null, "Email ou Senha esta incorreto!", null,
	 * AlertType.ERROR);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); Alerts.showAlert(null,
	 * "Erro na conexão com o Banco de Dados!", null, AlertType.ERROR);
	 * 
	 * }
	 * 
	 * }
	 */

}
