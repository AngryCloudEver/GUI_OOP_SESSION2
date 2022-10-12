package application;

import javafx.application.Application; 
import javafx.scene.Scene;  
import javafx.stage.Stage;
import javafx.scene.text.Font; 
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class Here extends Application {
	//Fungsi buat RNG
	public int getRandomNumber(Integer min, Integer max) {
	    return (int) (Math.round((Math.random() * (max - min)) + min));
	}

	@Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub
		
		//Set Text for Heading
		Text text= new Text();
		text.setFont(new Font(24));
		text.setText("You're trapped! Input 2 numbers to decides your door!");
		
		//Next job, WIP
//		Text res= new Text();
//		text.setText("Looks like Door number " + Num + " is safe");
		
		//Set Label and Text for input
		Label Min = new Label("Min door number");
		Min.setLayoutX(100);
		Label Max = new Label("Max door number");
		TextField a1= new TextField();
		TextField a2= new TextField();
		
		
		//Set Button
		Button Yenson= new Button("Help me!!!");
		Yenson.setPrefSize(80, 40);
//		Yenson.setScaleX(2);
//		Yenson.setScaleY(2);
		Yenson.setOnAction(new EventHandler<ActionEvent>(){
			//jika diclick akan berjalan
			public void handle(ActionEvent arg0) {
				Integer MINIMAL =Integer.parseInt(a1.getText());
				Integer MAXIMAL =Integer.parseInt(a2.getText());
				
				String Num= Integer.toString(getRandomNumber(MINIMAL, MAXIMAL));
                // TODO Auto-generated method stub
                System.out.println("Looks like Door number " + Num + " is safe");
            }
		});
		
		//Gridpane
		GridPane grid= new GridPane();
		grid.setHgap(8);
		grid.setVgap(8);
		grid.setAlignment(Pos.BASELINE_CENTER);
		grid.add(text, 1, 1);
		grid.addRow(2, Min, a1);
		grid.addRow(3, Max, a2);
		grid.addRow(4, Yenson);
//		grid.addRow(5, res);
		
		//Scene
		Scene scene= new Scene(grid, 700,300);
		
		//Stage
		primaryStage.setTitle("Trying to RNG");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
	
	public static void main(String args[]){           
	      launch(args);
	   }
	}
