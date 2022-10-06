package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application { // implements EventHandler<ActionEvent>
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Torture");
			button = new Button();
			button.setText("Click Here");
			// button = new Button("Press here"); // bisa juga begini
//			button.setOnAction(new EventHandler<ActionEvent>() {
//				@Override
//				public void handle(ActionEvent event) {
//					System.out.println(Math.round(Math.random()*Math.random()*Math.random()*1000)); // anonymous inner class
//				}
//			});
			button.setOnAction(e -> {
				System.out.println(Math.round(Math.random()*Math.random()*Math.random()*1000)%100);
				
			});
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			Scene scene = new Scene(layout,300,300);
			primaryStage.setScene(scene);
			primaryStage.show();
			
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Override
//	public void handle(ActionEvent event) {
//		if(event.getSource()==button) {
//			System.out.println(Math.round(Math.random()*Math.random()*100));
//		}
//	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
