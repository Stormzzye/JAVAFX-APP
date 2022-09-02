package ba.sum.fpmoz.informatika.fpmozjavafx.controller;

import ba.sum.fpmoz.informatika.fpmozjavafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IntroController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Aplikacija za izradu online testova");
    }

    @FXML
    protected void userAdministration(ActionEvent evt) {
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        HelloApplication.swapScene(stage, "user-view.fxml", "Admin Page");
    }
}
