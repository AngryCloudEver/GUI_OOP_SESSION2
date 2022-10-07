package application;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//import javafx.scene.paint.Color;
//import javafx.scene.text.TextAlignment;
//import javafx.scene.layout.BorderPane;
import java.util.Random;

public class test1 extends Application{

	public static void main(String[] args) {
        launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Stage window = primaryStage;
		window.setTitle("Something's Here");
		Button button = new Button("Press Here");
		Image icon = new Image("flower.png");
		window.getIcons().add(icon);
		
		button.setOnAction(e -> {
			Integer number = (int) (Math.random() * 100) + 1;  // (Math.random()*(max-min+1))+min;
			Label num1 = new Label(number.toString());
			Stage window1 = new Stage();
			window1.setTitle("It's Here");
			window1.getIcons().add(icon);
			window1.initModality(Modality.APPLICATION_MODAL);
			
			Button close = new Button("Close");
			
			close.setOnAction(f -> {
				window1.close();
			});
			
			Label label = new Label("Here's What You Get: ");
			label.setFont(Font.font(STYLESHEET_MODENA,27));
			label.setTextFill(Color.ANTIQUEWHITE);
			VBox num = new VBox(20);
			num.setBackground(Background.fill(Color.BLACK));
			num1.setFont(Font.font(STYLESHEET_MODENA,35));
			num1.setTextFill(Color.ANTIQUEWHITE);
			num.getChildren().addAll(label,num1,close);
			num.setAlignment(Pos.CENTER);
			Scene scene = new Scene(num,300,300);
			window1.setScene(scene);
			window1.showAndWait();
		});
		
		VBox layout = new VBox(20);
		layout.setBackground(Background.fill(Color.BLACK));
		Label label = new Label("Randomizer");
		label.setFont(Font.font(STYLESHEET_MODENA,35));
		label.setTextFill(Color.ANTIQUEWHITE);
		layout.getChildren().addAll(label,button);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout,400,400);
		window.setScene(scene);
		window.show();
	}
}
