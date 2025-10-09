package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class controllerMenuPrincipal {

	@FXML
	private Button BtCadastroUsuario;
	
	@FXML
    private Button BtLista;

	// pao@gmail.com

	@FXML
	private void initialize () {

		BtCadastroUsuario.setOnAction(e->{abrirPagina("cadastroUsuario.fxml");});
		
		BtLista.setOnAction(e->{abrirPagina("listaUsuarios.fxml");});
		
	}
	
	
	private void abrirPagina(String fxml) {
		try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(getClass().getResource(fxml));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
			
			
			} catch(Exception e ) {
				e.printStackTrace();
			}
	}
	
}
