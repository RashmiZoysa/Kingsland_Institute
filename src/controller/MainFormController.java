package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public ImageView imgStudent;
    public ImageView imgCourse;
    public ImageView imgRegistration;
    public AnchorPane DashBoard;
    public ImageView imgRegister;

    public void StudentOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("StudentForm.fxml");
    }

    public void CourseOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("CourseForm.fxml");
    }

    public void RegistrationOnAction(MouseEvent mouseEvent) throws IOException {
        setUI("RegistrationForm.fxml");
    }


    public void setUI(String location) throws IOException {
        Stage stage = (Stage) DashBoard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/" + location))));
        stage.show();
    }

    
}

