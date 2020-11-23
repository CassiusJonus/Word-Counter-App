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
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setScene(new Scene(new MainPane()));
		primaryStage.setTitle("Word Counter");
		primaryStage.show();
	}
	

}
