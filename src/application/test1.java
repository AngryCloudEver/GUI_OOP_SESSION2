package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class test1 extends Application{

	public static void main(String[] args) {
        launch(args);
	}
	
	public static long RandomNumberGenerator(long Max) {
		return Math.round(Math.random() * Max);
	}
	
	@Override
	public void start(Stage stage) {
		// Image
		Image image = new Image("flower.png");
		
		// Label
		Label Title = new Label("Randomizer");
		Title.setFont(Font.font("Pacifico",FontWeight.BOLD,20));
		
		Label Description = new Label("Random Number Generator From 0 to ");
		Description.setFont(Font.font("Times New Roman",FontWeight.BLACK,16));
		
		Label GeneratedNumber = new Label();
		GeneratedNumber.setFont(Font.font("Quicksand",FontWeight.BLACK,FontPosture.ITALIC,18));
		
		// Textfield
		TextField InputtedNumber = new TextField();
		InputtedNumber.setText(Integer.toString(50));
		InputtedNumber.setFont(Font.font("Times New Roman",FontWeight.BLACK,16));
		
		// Button
		Button GenerateNumber = new Button("Generate");
		Button ClearBox = new Button("Clear");
		Button RandomInput = new Button("Random Max");
		
		GenerateNumber.setPrefSize(100,50);
		GenerateNumber.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,14));
		GenerateNumber.setOnAction(g -> {
			String InputtedMax = InputtedNumber.getText();
			long Max;
			
			try {
				Max = Long.parseLong(InputtedMax);
				
				if(Max < 1 || Max > 1000000) {
					GeneratedNumber.setTextFill(Color.DARKRED);
					GeneratedNumber.setText("Please Input only between 1 to 1.000.000 (inclusive)");
				} 
				else {
					String FromFunction = Long.toString(RandomNumberGenerator(Max));
					
					GeneratedNumber.setTextFill(Color.GREEN);
					GeneratedNumber.setText(FromFunction);
				}
			} 
			catch(Exception e) {
				GeneratedNumber.setTextFill(Color.RED);
				GeneratedNumber.setText("Please Input a Proper Real Number");
			}
		});
		
		ClearBox.setPrefSize(100,50);
		ClearBox.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,14));
		ClearBox.setOnAction(c -> {
			InputtedNumber.setText("");
		});
		
		RandomInput.setPrefSize(100,50);
		RandomInput.setFont(Font.font("Times New Roman",FontWeight.MEDIUM,14));
		RandomInput.setOnAction(r -> {
			long Max = Math.round((Math.random() * (1000000-1)) + 1);
			String StringMax = Long.toString(Max);
			InputtedNumber.setText(StringMax);
		});
		
		// Layout
		GridPane layout = new GridPane();
		layout.setBackground(Background.EMPTY);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setAlignment(Pos.BASELINE_CENTER);
		layout.addRow(1,Title);
		layout.addRow(2,Description);
		layout.addRow(3,InputtedNumber);
		layout.addRow(4,GenerateNumber);
		layout.addRow(5,ClearBox);
		layout.addRow(6,RandomInput);
		layout.addRow(7,GeneratedNumber);
		
		// Scene
		Scene scene = new Scene(layout,480,350);
		
		// Stage
		stage.setTitle("Random Number Generator");
		stage.getIcons().add(image);
		stage.setScene(scene);
		stage.show();
	}
}
