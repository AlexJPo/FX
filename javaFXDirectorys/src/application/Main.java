package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/dir/view/fxml/directory.fxml"));
			Parent mainWindow = fxmlLoader.load();
			
			Scene scene = new Scene(mainWindow, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/dir/style/css/application.css").toExternalForm());
			
			primaryStage.setMinWidth(400);
			primaryStage.setMinHeight(300);
			primaryStage.setTitle("File explorer");
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
