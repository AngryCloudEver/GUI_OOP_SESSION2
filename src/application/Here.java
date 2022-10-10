package application;

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;
import javafx.scene.text.Font; 
import javafx.scene.text.Text;
import javafx.scene.control.Button;



public class Here extends Application {

	@Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub
		
		//Initiate
		
		//Set Text
		Text text= new Text();
		text.setFont(new Font(45));
		text.setX(100);
		text.setY(100);
		text.setText("Welcome");
		
		//Set Button
		Button Yenson= new Button("Hi");
		
		//Group
		Group group = new Group();
		group.getChildren().add(Yenson);
		group.getChildren().add(text);
		
		//Scene
		Scene scene= new Scene(group, 1000,500);
		scene.setFill(Color.CORAL);
		
		//Stage
		primaryStage.setTitle("OK OK OK");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
	
	public static void main(String args[]){           
	      launch(args);      
	   }
	}
