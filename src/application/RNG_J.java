package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RNG_j extends Application {
	public static final String APP_TITLE = "Random Number Generator";
	public static final int DEFAULT_RANGE_MIN_VALUE = 1;
	public static final int DEFAULT_RANGE_MAX_VALUE = 100;
	public static final int GENERATED_VALUE_FONT_SIZE = 32;
	public static final int PREF_WIDTH_SIZE = 160;
	
	public static long generateRandomInteger(int minRange, int maxRange) {
		return Math.round(Math.random() * (maxRange - minRange) + minRange);
	}
	
	public static double generateRandomFloat(int minRange, int maxRange) {
		return Math.random() * (maxRange - minRange) + minRange;
	}
	
	public static double roundDown2(double d) {
	    return Math.floor(d * 1e2) / 1e2;
	}
	
	public static void setInvalid(Label label) {
		label.setFont(Font.font(GENERATED_VALUE_FONT_SIZE * 0.8));
		label.setTextFill(Color.RED);
		label.setText("Invalid input!");
	}
	
	@Override
	public void start(Stage primaryStage) {
		// Component Initializations
		// Labels
		Label dataTypeLabel = new Label();
		dataTypeLabel.setText("Data Type");
		
		Label valueRangeLabel = new Label();
		valueRangeLabel.setText("Value Range");
		
		Label rangeMinValueLabel = new Label();
		rangeMinValueLabel.setText("Min Value (Inclusive)");
		
		Label rangeMaxValueLabel = new Label();
		rangeMaxValueLabel.setText("Max Value (Inclusive)");
		
		Label generatedValueLabel = new Label();
		generatedValueLabel.setFont(Font.font(GENERATED_VALUE_FONT_SIZE));
		generatedValueLabel.setText("");
		
		// Text Fields
		TextField rangeMinValueTextField = new TextField();
		rangeMinValueTextField.setText(Integer.toString(DEFAULT_RANGE_MIN_VALUE));
		
		TextField rangeMaxValueTextField = new TextField();
		rangeMaxValueTextField.setText(Integer.toString(DEFAULT_RANGE_MAX_VALUE));
		
		// Buttons
		Button generateButton = new Button();
		generateButton.setPrefWidth(PREF_WIDTH_SIZE);
		generateButton.setText("Generate");
		
		Button resetButton = new Button();
		resetButton.setPrefWidth(PREF_WIDTH_SIZE);
		resetButton.setText("Reset");
		
		Button copyButton = new Button();
		copyButton.setPrefWidth(PREF_WIDTH_SIZE * 0.5);
		copyButton.setVisible(false);
		copyButton.setText("Copy");
		
		// Choice Boxes
		ChoiceBox<String> dataTypeChoiceBox = new ChoiceBox<String>();
		dataTypeChoiceBox.setPrefWidth(PREF_WIDTH_SIZE);
		dataTypeChoiceBox.getItems().addAll("Integer", "Float (2 Decimal Points)");
		dataTypeChoiceBox.setValue("Integer");
		
		// Event Handling
		// Buttons
		// generateButton
		generateButton.setOnAction(
				(e) -> {
					try {
						String rangeMinValueInput = rangeMinValueTextField.getText();
						String rangeMaxValueInput = rangeMaxValueTextField.getText();
						
						int rangeMinValue = Integer.parseInt(rangeMinValueInput);
						int rangeMaxValue = Integer.parseInt(rangeMaxValueInput);
						
						if (rangeMinValue > rangeMaxValue) {
							setInvalid(generatedValueLabel);
						} else {
							String dataTypeInput = dataTypeChoiceBox.getValue();
							String generatedValueString;
							
							generatedValueLabel.setFont(Font.font(GENERATED_VALUE_FONT_SIZE));
							generatedValueLabel.setTextFill(Color.BLACK);
							copyButton.setVisible(true);
							
							if (dataTypeInput.equals("Integer")) {
								generatedValueString = Long.toString(generateRandomInteger(rangeMinValue, rangeMaxValue));
								generatedValueLabel.setText(generatedValueString);
							} else {
								generatedValueString = Double.toString(roundDown2(generateRandomFloat(rangeMinValue, rangeMaxValue)));
								generatedValueLabel.setText(generatedValueString);
							}
						}
					} catch (NumberFormatException nfe) {
						setInvalid(generatedValueLabel);
						copyButton.setVisible(false);
					}
				}
	    );
		
		// clearInputButton
		resetButton.setOnAction(
				(e) -> {
					rangeMinValueTextField.setText("1");
					rangeMaxValueTextField.setText("100");
					generatedValueLabel.setText("");
					copyButton.setVisible(false);
				}
		);
		
		// copyButton
		copyButton.setOnAction(
				(e) -> {
					 final Clipboard clipboard = Clipboard.getSystemClipboard();
				     final ClipboardContent content = new ClipboardContent();
				     content.putString(generatedValueLabel.getText());
				     clipboard.setContent(content);
				}
		);

		// Scene Layout
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(32, 32, 32, 32));
		gridPane.setHgap(16);
		gridPane.setVgap(16);
		gridPane.add(dataTypeLabel, 0, 0);
		gridPane.add(dataTypeChoiceBox, 1, 0);
		gridPane.add(valueRangeLabel, 0, 1);
		gridPane.add(rangeMinValueLabel, 0, 2);
		gridPane.add(rangeMinValueTextField, 1, 2);
		gridPane.add(rangeMaxValueLabel, 0, 3);
		gridPane.add(rangeMaxValueTextField, 1, 3);
		gridPane.add(generateButton, 0, 5);
		gridPane.add(resetButton, 1, 5);
		gridPane.add(generatedValueLabel, 0, 6);
		gridPane.add(copyButton, 1, 6);

		Scene scene = new Scene(gridPane, 400, 320);
		
		primaryStage.setTitle(APP_TITLE);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
