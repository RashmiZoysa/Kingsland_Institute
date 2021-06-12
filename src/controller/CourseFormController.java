package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseFormController {

    public JFXTextField txtCode;
    public JFXTextField txtCourseName;
    public JFXTextField txtDuration;
    public JFXTextField txtCourseType;
    public Button btnSave;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnGetAll;
    public TableView tblCourse;
    public Button btnBack;
    public AnchorPane DashBoard;

    public void SaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        PreparedStatement stm= DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO COURSE VALUES(?,?,?,?)");
        stm.setObject(1,txtCode.getText());
        stm.setObject(2,txtCourseName.getText());
        stm.setObject(3,txtDuration.getText());
        stm.setObject(4,txtCourseType.getText());
        stm.executeUpdate();
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        PreparedStatement stm=DBConnection.getInstance().getConnection().prepareStatement("DELETE COURSE WHERE code");
        stm.setObject(1,txtCode.getText());
        stm.executeUpdate();

    }

    public void UpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        PreparedStatement stm=DBConnection.getInstance().getConnection().prepareStatement("UPDATE COURSE SET CourseName=?,SET Duration=?,SET CourseType=? ,WHERE Code=?");
        stm.setObject(1,txtCode.getText());
        stm.setObject(2,txtCourseName.getText());
        stm.setObject(3,txtDuration.getText());
        stm.setObject(4,txtCourseType.getText());
        stm.executeUpdate();
    }

    public void GetAllOnAction(ActionEvent actionEvent) {
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
