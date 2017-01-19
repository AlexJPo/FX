package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/javaFxCalc/view/fxml/Calculator.fxml"));
			Parent mainWindow = fxmlLoader.load();
			
			Scene scene = new Scene(mainWindow, 300, 200);
			scene.getStylesheets().add(getClass().getResource("/javaFxCalc/style/css/application.css").toExternalForm());
			primaryStage.setTitle("Калькулятор 228");
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
