package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Main extends Application { // implements EventHandler<ActionEvent>
	Stage window = new Stage();
	Text mainTitle = new Text();
	Text mainTitle2 = new Text();
	Text descText = new Text();
	Text resultText = new Text();
	VBox layout = new VBox();
	VBox layout2 = new VBox();
	Button buttonPullGacha = new Button();
	Button buttonRestart = new Button();
	
	Scene scene1, scene2;
	
	Integer gachaResult;
	
	@Override
	public void start(Stage primaryStage) {		
		window = primaryStage;
		
		try {
			primaryStage.setTitle("BINUS FOOD GACHA");
			
			layout.setAlignment(Pos.CENTER);
			layout.setSpacing(10);
			
			// Title
			mainTitle.setText("BINUS FOOD GACHA");
			mainTitle.setFont(Font.font("Verdana", FontWeight.BLACK, 16));
			
			// Description
			descText.setText("Klik Tombol Di Bawah untuk Gacha Makanan!");
			
			// Button
			buttonPullGacha.setText("Pull Food");
			
			layout.getChildren().addAll(mainTitle, descText, buttonPullGacha);
			
			// Scene 2
			layout2.setAlignment(Pos.CENTER);
			layout2.setSpacing(10);
			
			mainTitle2.setText("BINUS FOOD GACHA");
			mainTitle2.setFont(Font.font("Verdana", FontWeight.BLACK, 16));
			
			buttonRestart.setText("Restart");
			
			layout2.getChildren().addAll(mainTitle2, resultText, buttonRestart);
			
			scene1 = new Scene(layout, 300, 300);
			scene2 = new Scene(layout2, 300, 300);
			window.setScene(scene1);
			window.show();
			
			buttonPullGacha.setOnAction(e -> {				
				gachaResult = (int)(Math.random() * 100);
				
				if(gachaResult < 50) {
					resultText.setText("Selamat, kamu mendapatkan Indomie!");
				}
				else if(gachaResult >= 50 && gachaResult < 75) {
					resultText.setText("Selamat, kamu mendapatkan Soto Betawi!");
				}
				else if(gachaResult >= 75 && gachaResult < 90) {
					resultText.setText("Selamat, kamu mendapatkan Kerak Telur!");
				}
				else if(gachaResult >= 90 && gachaResult < 98) {
					resultText.setText("Selamat, kamu mendapatkan Nasi Padang!");
				}
				else {
					resultText.setText("Sayang sekali, kamu tidak mendapatkan apa-apa! Silahkan coba lagi!");
				}
				
				window.setScene(scene2);
			});
			
			buttonRestart.setOnAction(e -> {
				window.setScene(scene1);
			});
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
