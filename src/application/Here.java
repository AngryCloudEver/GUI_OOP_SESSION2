package application;

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage;
import javafx.scene.text.Font; 
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class Here extends Application {

	@Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub
		
		//Initiate Integer
		Integer MINIMAL;
		Integer MAXIMAL;
		
		//Set Text for Heading
		Text text= new Text();
		text.setFont(new Font(24));
		text.setText("You're trapped. Input 2 numbers to decides your door!");
		
		//Set Label and Text for input
		Label Min = new Label("Min door number");
		Min.setLayoutX(100);
		Label Max = new Label("Max door number");
		TextField a1= new TextField();
		TextField a2= new TextField();
		
		
		//Set Button
		Button Yenson= new Button("Hi My Friend");
		Yenson.setScaleX(1.4);
		Yenson.setScaleY(1.5);
		Yenson.setOnAction(new EventHandler<ActionEvent>(){
			//jika diclick akan berjalan
			public void handle(ActionEvent arg0) {  
                // TODO Auto-generated method stub  
                System.out.println("Looks like Door number " +a1.getText()+ " is safe");
            }
		});
		
		//Gridpane
		GridPane grid= new GridPane();
		grid.setHgap(8);
		grid.setVgap(8);
		grid.add(text, 1, 1);
		grid.addRow(2, Min, a1);
		grid.addRow(3, Max, a2);
		grid.addRow(4, Yenson);
		
		//Scene
		Scene scene= new Scene(grid, 700,500);
		
		//Stage
		primaryStage.setTitle("Trying to RNG");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
	
	public static void main(String args[]){           
	      launch(args);
	   }
	}
