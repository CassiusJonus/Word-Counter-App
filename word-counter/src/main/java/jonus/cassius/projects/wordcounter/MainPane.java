
package jonus.cassius.projects.wordcounter;

import java.io.File;
import java.io.IOException;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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
	private Button btnCountWords;
	private Button btnCountChars;
	private Button btnClose; 
	private Button btnBrowse; 
	private ButtonBar options;
	private Label lblFilePrompt; 
	private TextField txtFileEntry;
	private CheckBox chkIgnoreWhiteSpace;
	private File chosenFile; 

	
	
	public MainPane() {
		super();
		this.setPadding(new Insets(10));
		this.setHgap(8);
		this.setVgap(10);
		configureComponents();
		GridPane.setHalignment(lblFilePrompt, HPos.CENTER);
		GridPane.setMargin(lblFilePrompt, new Insets(0, 0, 15, 0));
		GridPane.setHalignment(options, HPos.RIGHT);
		this.add(lblFilePrompt, 0, 0);
		this.add(txtFileEntry, 0, 1, 1, 1);
		this.add(btnBrowse, 1, 1);
		this.add(chkIgnoreWhiteSpace, 0, 2);
		this.add(options, 0, 3);
	}

	private void configureComponents() {
		btnCountWords = new Button("Count Words");
		btnCountChars = new Button("Count Characters");
		btnClose = new Button("Close");
		btnBrowse = new Button("Browse");
		options = new ButtonBar();
		lblFilePrompt = new Label("Enter a file path or select a file on your computer.");
		txtFileEntry = new TextField();
		chkIgnoreWhiteSpace = new CheckBox("Ignore Whitespace Characters");
		
		lblFilePrompt.setFont(new Font(null, 25));
		txtFileEntry.setAccessibleText("Enter a path to a file.");
		txtFileEntry.requestFocus();
		btnBrowse.setOnAction(e -> chooseFile());
		btnCountWords.setOnAction(e -> displayWordCount());
		btnCountChars.setOnAction(e -> displayCharCount());
		btnClose.setOnAction(e -> closeApp());
		options.getButtons().addAll(btnCountWords, btnCountChars, btnClose);
	}

	private void displayWordCount() {
		chosenFile = new File(txtFileEntry.getText());
		try {
			Alert wordCountDisplay = new Alert(AlertType.INFORMATION);
			wordCountDisplay.setTitle("Word Count");
			wordCountDisplay.setHeaderText("Number of Words in File");
			wordCountDisplay.setContentText(String.format("The number of words in %s is %d.", chosenFile.getName(), 
																							  new WordCounter(chosenFile).countWords()));
			wordCountDisplay.initModality(Modality.APPLICATION_MODAL);
			wordCountDisplay.showAndWait();
		} catch (IOException e) {
			Alert fileError = new Alert(AlertType.ERROR);
			fileError.setTitle("File Reading Error");
			fileError.setHeaderText(null);
			fileError.setContentText("There was a problem accessing the file or no file was entered.");
			fileError.initModality(Modality.APPLICATION_MODAL);
			fileError.showAndWait();
//			e.printStackTrace();
		}
	}

	private void displayCharCount() {
		chosenFile = new File(txtFileEntry.getText());
		try {
			Alert charCountDisplay = new Alert(AlertType.INFORMATION);
			charCountDisplay.setTitle("Character Count");
			charCountDisplay.setHeaderText("Number of characters in File");
			charCountDisplay.setContentText(String.format("The number of characters in %s is %d.", chosenFile.getName(), 
																							  new WordCounter(chosenFile).countChars(chkIgnoreWhiteSpace.isSelected())));
			charCountDisplay.initModality(Modality.APPLICATION_MODAL);
			charCountDisplay.showAndWait();
		} catch (IOException e) {
			Alert fileError = new Alert(AlertType.ERROR);
			fileError.setTitle("File Reading Error");
			fileError.setHeaderText(null);
			fileError.setContentText("There was a problem accessing the file or no file was entered.\n\n");
			fileError.initModality(Modality.APPLICATION_MODAL);
			fileError.showAndWait();
//			e.printStackTrace();
		}
	}

	private void closeApp() {
		parentWindow = (Stage)this.getScene().getWindow();
		parentWindow.close();
	}

	private void chooseFile() {
		FileChooser browser = new FileChooser();
		browser.setTitle("Select file"); 
		this.txtFileEntry.setText(browser.showOpenDialog(this.getScene().getWindow()).getAbsolutePath());
	}
}
