package ba.sum.fpmoz.informatika.fpmozjavafx.controller;

import ba.sum.fpmoz.informatika.fpmozjavafx.HelloApplication;
import ba.sum.fpmoz.informatika.fpmozjavafx.model.Table;
import ba.sum.fpmoz.informatika.fpmozjavafx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnName;

    @FXML
    TableColumn tableColumnSur;

    @FXML
    TableColumn tableColumnMail;

    @FXML
    TableColumn tableColumnLoz;

    @FXML
    TableView tableViewUsers;

    @FXML
    protected void introAdministration(ActionEvent evt) {
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        HelloApplication.swapScene(stage, "intro-view.fxml", "Administracija korisnika");
    }



    @FXML
    TextField ImeTxt;

    @FXML
    TextField surnameTxt;

    @FXML
    TextField mailTxt;

    @FXML
    TextField lozTxt;

    @FXML
    Button deleteBtn;

    User selectedUser;

    @FXML
    protected void selectUser (){
        this.selectedUser = (User) this.tableViewUsers.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.ImeTxt.setText(this.selectedUser.getName());
        this.surnameTxt.setText(this.selectedUser.getSurname());
        this.mailTxt.setText(this.selectedUser.getEmail());
        this.lozTxt.setText(this.selectedUser.getPassword());
        System.out.println(selectedUser);
    }
    @FXML
    protected void deleteUser() throws Exception {
        if (this.selectedUser != null){
            this.selectedUser.delete();
            this.fillUsers();
        }
    }

    @FXML
    protected void saveUser () throws Exception {
        if(this.selectedUser == null) {
            User newUser = new User();
            newUser.setName(this.ImeTxt.getText());
            newUser.setSurname(this.surnameTxt.getText());
            newUser.setEmail(this.mailTxt.getText());
            newUser.setPassword(this.lozTxt.getText());
            newUser.save();
        }else {
            this.selectedUser.setName(this.ImeTxt.getText());
            this.selectedUser.setSurname(this.surnameTxt.getText());
            this.selectedUser.setPassword(this.lozTxt.getText());
            this.selectedUser.setEmail(this.mailTxt.getText());
            this.selectedUser.update();
            this.selectedUser = null;
        }

        this.fillUsers();
        this.ImeTxt.setText("");
        this.surnameTxt.setText("");
        this.mailTxt.setText("");
        this.lozTxt.setText("");
    }



    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnSur.setCellValueFactory(new PropertyValueFactory<>("surname"));
        this.tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tableColumnMail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        this.tableColumnLoz.setCellValueFactory(new PropertyValueFactory<>("password"));


        this.fillUsers();
    }

    private void fillUsers() {
        try {
            ObservableList<?> users = FXCollections.observableList(Table.list(User.class));
            this.tableViewUsers.setItems(users);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }{

    }
}
}
