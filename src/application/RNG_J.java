package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class RNG_J extends Application {
	public final int TEXT_TITLE_FONT_SIZE = 16;
	public final int TEXT_OTHERS_FONT_SIZE = 16;
	public final int TEXT_GENERATED_RANDOM_NUMBER_FONT_SIZE = 32;
	public final int BUTTON_WIDTH_SIZE = 200;
	public final int RANGE_MIN_DEFAULT = 1;
	public final int RANGE_MAX_DEFAULT = 100;

	public static long generateRandomNumber(int minRange, int maxRange) {
		return Math.round(Math.random() * (maxRange - minRange) + minRange);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Labels
		Label titleLabel = new Label();
		titleLabel.setFont(Font.font(TEXT_TITLE_FONT_SIZE));
		titleLabel.setText("Random Number Generator");
		
		Label inputMinRangeLabel = new Label();
		inputMinRangeLabel.setFont(Font.font(TEXT_OTHERS_FONT_SIZE));
		inputMinRangeLabel.setText("Min Range (Inclusive)");
		
		Label inputMaxRangeLabel = new Label();
		inputMaxRangeLabel.setFont(Font.font(TEXT_OTHERS_FONT_SIZE));
		inputMaxRangeLabel.setText("Max Range (Inclusive)");
		
		Label generatedRandomNumberLabel = new Label();
		generatedRandomNumberLabel.setText("");
		generatedRandomNumberLabel.setFont(Font.font(TEXT_GENERATED_RANDOM_NUMBER_FONT_SIZE));
		
		// TextFields
		TextField inputMinRangeTextField = new TextField();
		inputMinRangeTextField.setText(Integer.toString(RANGE_MIN_DEFAULT));
		inputMinRangeTextField.setFont(Font.font(TEXT_OTHERS_FONT_SIZE));
		
		TextField inputMaxRangeTextField = new TextField();
		inputMaxRangeTextField.setText(Integer.toString(RANGE_MAX_DEFAULT));
		inputMaxRangeTextField.setFont(Font.font(TEXT_OTHERS_FONT_SIZE));
		
		// Buttons
		Button generateButton = new Button();
		generateButton.setPrefWidth(BUTTON_WIDTH_SIZE);
		generateButton.setFont(Font.font(TEXT_OTHERS_FONT_SIZE));
		generateButton.setText("Generate");
		generateButton.setOnAction(
				(event) -> {
					String inputMinRangeString = inputMinRangeTextField.getText();
					String inputMaxRangeString = inputMaxRangeTextField.getText();
					int inputMinRange;
					int inputMaxRange;
					
					try {
						inputMinRange = Integer.parseInt(inputMinRangeString);
						inputMaxRange = Integer.parseInt(inputMaxRangeString);
						
						String generatedRandomNumber = Long.toString(generateRandomNumber(inputMaxRange, inputMinRange));
						
						generatedRandomNumberLabel.setTextFill(Color.BLACK);
						generatedRandomNumberLabel.setText(generatedRandomNumber);
					} catch (Exception exception) {
						generatedRandomNumberLabel.setTextFill(Color.RED);
						generatedRandomNumberLabel.setText("Invalid input!");
					}
				}
		);
		
		Button clearButton = new Button();
		clearButton.setText("Clear input");
		clearButton.setFont(Font.font(TEXT_OTHERS_FONT_SIZE));
		clearButton.setPrefWidth(BUTTON_WIDTH_SIZE);
		clearButton.setOnAction(
				(event) -> {
					inputMinRangeTextField.setText("");
					inputMaxRangeTextField.setText("");
				}		
		);
		
		// Layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(8);
		root.setVgap(8);
		root.addRow(0, titleLabel);
		root.addRow(1, inputMinRangeLabel, inputMinRangeTextField);
		root.addRow(2, inputMaxRangeLabel, inputMaxRangeTextField);
		root.addRow(3, generateButton, clearButton);
		root.addRow(4, generatedRandomNumberLabel);
		
		// Scene
		Scene scene = new Scene(root, 500, 500);
		
		// Stage
		primaryStage.setTitle("Random Number Generator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
