package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.BorderPane;
import java.util.Random;

public class DiiferentScenes extends Application {

	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setHeight(300);
		window.setWidth(300);
		
		Label label1, label2, label3;
		
		label1 = new Label("Random Number Generator");
		Button button1 = new Button("Get Yours");
		button1.setOnAction(e -> {
			window.setScene(scene2);
		});
		
		// Layout 1 -> children are laid out in vertical column
		VBox layout1 = new VBox(20); // 20 pixels space
		layout1.getChildren().addAll(label1,button1);
		layout1.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
		scene1 = new Scene(layout1,Color.AQUA);
		scene1.setRoot(layout1);
		
		label2 = new Label("Here's Yours");
		Button button2 = new Button("Try Again?");
		button2.setOnAction(e -> {
			window.setScene(scene1);
		});
		
		// Layout 2
		VBox layout2 = new VBox(20);
		label3 = new Label(strFunc()); 
		layout2.getChildren().addAll(label2,label3,button2);
		scene2 = new Scene(layout2,Color.GREEN);
		scene2.setRoot(layout2);
		
		window.setScene(scene1);
		window.setTitle("IDK What I Was Expecting");
		window.show();
	}
	
	public String strFunc() {
		Random rand = new Random();
		Integer ans = rand.nextInt(100)+1;
		return ans.toString();
	}

}
