
package jonus.cassius.projects.wordcounter;

import java.io.File;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
/**
 * @author Cassius
 *
 *This class handles the functionality and components for the main pane
 *of the application. 
 */
public class MainPane extends GridPane {
	private Stage parentWindow;
	private Button btnCountWords = new Button("Count Words");
	private Button btnCountChars = new Button("Count Characters");
	private Button btnClose = new Button("Close");
	private Button btnBrowse = new Button("Browse");
	private ButtonBar options = new ButtonBar();
	private Label lblFilePrompt = new Label("Enter a file path or select a file on your computer.");
	private TextField txtFileEntry;
	private CheckBox chkIgnoreWhiteSpace = new CheckBox("Ignore Whitespace Characters");
	private File chosenFile;
	
	
	public MainPane() {
		super();
		parentWindow = (Stage)this.getScene().getWindow();
		this.setPadding(new Insets(10));
		this.setHgap(8);
		this.setVgap(10);
		GridPane.setHalignment(lblFilePrompt, HPos.CENTER);
		GridPane.setMargin(lblFilePrompt, new Insets(0, 0, 15, 0));
		configureComponents();
		this.add(lblFilePrompt, 0, 0);
		this.add(txtFileEntry, 0, 1, 3, 1);
		this.add(btnBrowse, 3, 0);
		this.add(chkIgnoreWhiteSpace, 1, 2);
		this.add(options, 2, 3);
	}

	private void configureComponents() {
		lblFilePrompt.setFont(new Font(null, 25));
		txtFileEntry.setAccessibleText("Enter a path to a file.");
		txtFileEntry.requestFocus();
		options.getButtons().addAll(btnCountWords, btnCountChars, btnClose);
	}
}
