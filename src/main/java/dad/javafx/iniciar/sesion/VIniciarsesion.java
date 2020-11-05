package dad.javafx.iniciar.sesion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VIniciarsesion extends Application {

	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	private TextField usertxt;
	private TextField passtxt;
	public void start(Stage stage) throws Exception {
		
		window = stage;
		window.setTitle("Iniciar sesión");
		
	

		// name label
		Label username = new Label("Usuario: ");
		username.setMinWidth(80);
		username.setMaxWidth(100);

		// name input
		usertxt = new TextField();
		usertxt.setPromptText("Usuario");
		
		HBox user=new HBox();
		user.getChildren().addAll(username, usertxt);
		user.setPadding(new Insets(5));
		user.setAlignment(Pos.BASELINE_CENTER);
		
		
		// Password label
		Label password = new Label("Contraseña: ");
		password.setMinWidth(80);
		password.setMaxWidth(100);

		// Password input
		passtxt = new TextField();
		passtxt.setPromptText("Contraseña");
		
		HBox pass=new HBox();
		pass.getChildren().addAll(password, passtxt);
		pass.setPadding(new Insets(5));
		pass.setAlignment(Pos.BASELINE_CENTER);
		
		
		Button AcepButton = new Button("Aceptar");
		AcepButton.setOnAction(e ->AcepButtonAction(e));
		Button CancButton = new Button("Cancelar");
		CancButton.setOnAction(e ->window.close());
		
		HBox Buttbox=new HBox();
		Buttbox.setPadding(new Insets(5));
		Buttbox.setSpacing(5);
		Buttbox.setAlignment(Pos.BASELINE_CENTER);
		Buttbox.getChildren().addAll(AcepButton, CancButton);
		
		
		VBox root=new VBox();
		root.getChildren().addAll(user,pass,Buttbox);
		root.setAlignment(Pos.CENTER);
		Scene scene =new Scene(root, 300, 200);
		window.setScene(scene);
		window.show();
		window.setMinWidth(50);
		window.setMaxWidth(500);
		window.setMinHeight(150);
		window.setMaxHeight(500);
		
		Validar.CargarCsv();
		}
	
	private void AcepButtonAction(ActionEvent e) {
	if(Validar.validarAcceso(usertxt.getText(),passtxt.getText())) {
	accessgranted();}
	else {
	accesdeny("Error");}}
	
	
	private void accessgranted() {
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Acceso permitido");
		alert.setContentText("Las credenciales de acceso son válidas");
		alert.showAndWait();
	}
	
	private void accesdeny(String error) {
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o la contraseña no son válidos");
		alert.showAndWait();
	}
	
	
}
