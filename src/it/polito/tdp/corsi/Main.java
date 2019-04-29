package it.polito.tdp.corsi;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.CorsiModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			CorsiModel model= new CorsiModel();
			FXMLLoader loader= new FXMLLoader(getClass().getResource("GestoreCorsi.fxml"));
			BorderPane root = (BorderPane)loader.load();
			GestoreCorsiController controller =loader.getController();
			controller.setModel(model);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
