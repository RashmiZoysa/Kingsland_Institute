package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationFormController {
    public Button btnBack;
    public JFXTextField txtRegNo;
    public JFXTextField txtID;
    public JFXTextField txtCode;
    public JFXTextField txtRegFee;
    public JFXTextField txtDate;
    public Button btnRegister;
    public AnchorPane DashBoard;



    public void RegisterOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        PreparedStatement stm= DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO REGISTRATION VALUES(?,?,?,?)");
        stm.setObject(1,txtRegNo.getText());
        stm.setObject(2,txtID.getText());
        stm.setObject(3,txtCode.getText());
        stm.setObject(4,txtRegFee.getText());
        stm.executeUpdate();

    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUI("MainForm.fxml");

    }

    public void setUI(String location) throws IOException {
        Stage stage = (Stage) DashBoard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/" + location))));
        stage.show();
    }
}
