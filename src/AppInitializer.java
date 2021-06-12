import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primarystage) throws IOException {
        primarystage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/MainForm.fxml"))));
        primarystage.show();


    }
}

