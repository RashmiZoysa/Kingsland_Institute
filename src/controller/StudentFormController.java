package controller;

import bo.BOFactory;
import bo.student.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.StudentTM;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentFormController {
    public JFXTextField txtID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtDate;
    public TableView<StudentTM> tblStudent;
    public Button btnSave;
    public Button btnGetAll;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDate;
    public TableColumn colGender;
    public TableColumn colOperation;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnBack;
    public ToggleGroup Gender;
    public AnchorPane DashBoard;
    public JFXComboBox cmbgender;
    StudentBO bo;

    public void initialize() throws Exception {
        ObservableList<String> genderList=FXCollections.observableArrayList();
        genderList.add("Male");
        genderList.add("Female");
        cmbgender.setItems(genderList);

        bo = BOFactory.getInstance().getBo(BOFactory.BoType.STUDENT);

        loadId();

        colID.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colDate.setCellFactory(new PropertyValueFactory("date"));
        colOperation.setCellValueFactory(new PropertyValueFactory("btn"));

        loadALlStudents();// Alt+ Enter

        //------------------------------ set Listener-------------

        tblStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

        //------------------------------ set Listener-------------
    }


    private void setData(StudentTM tm) {
        txtID.setText(tm.getId());
        txtName.setText(tm.getStudentName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        cmbgender.setValue(tm.getGender());
    }


    private void loadALlStudents() throws Exception {
        ObservableList<StudentTM> tmList =
                FXCollections.observableArrayList();
        List<StudentDTO> allCustomers = bo.getAllStudents();
        for (StudentDTO dto : allCustomers) {
            Button btn = new Button("Delete");
            StudentTM tm = new StudentTM(dto.getId(), dto.getName(),dto.getAddress(), dto.getContact(),dto.getDate(),dto.getGender(),btn);
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteStudent(tm.getId())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            /*loadAllStudent();*/
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                        //no
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblStudent.setItems(tmList);

    }

    private void loadId() throws Exception {
        String id = bo.getId();
        txtID.setText(id);
    }



    public void SaveOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = bo.saveStudent(
                new StudentDTO(txtID.getText(),
                        txtName.getText(),
                        txtAddress.getText(),txtContact.getText(),txtDate.getText(), (String) cmbgender.getValue())
        );
        System.out.println(isSaved);
    }

    public void UpdateOnAction(ActionEvent actionEvent) throws Exception {
        boolean isUpdated = bo.updateStudent(
                new StudentDTO(txtID.getText(),
                        txtName.getText(),
                        txtAddress.getText(),txtContact.getText(),txtDate.getText(), (String) cmbgender.getValue())
        );
        System.out.println(isUpdated);
    }

    public void GetAllOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = bo.getStudent(txtID.getText());
        if (dto != null) {
            txtID.setText(dto.getId());
            txtName.setText(dto.getName());
            txtAddress.setText(dto.getAddress());
            txtContact.setText(dto.getContact());
            txtDate.setText(dto.getDate());
            cmbgender.setValue(dto.getGender());
        }

    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM STUDENT WHERE id=?");
        stm.setObject(1, txtID.getText());
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