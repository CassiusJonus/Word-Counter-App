package jonus.cassius.projects.wordcounter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
/**
 * 
 * @author Cassius
 *
 *         This program launches the Word Counter application, which lets the
 *         user either enter a file path or browse for a file in the file system
 *         and then displays the number of words or characters in the file
 *         depending on the user's choice.
 */
public class WordCounterApp extends Application {

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) {
		
		stage.setScene(new Scene(new MainPane()));
		stage.setTitle("Word Counter");
		stage.show();
	}
	
//	public static void main(String[] args) {
//		launch(args);
//	}
}
