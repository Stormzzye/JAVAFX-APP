package ba.sum.fpmoz.informatika.fpmozjavafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("intro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 240);
        stage.setTitle("Dobrodošli!");

        stage.setScene(scene);
        stage.show();
    }
    public static void swapScene(Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 800, 400);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogrešla: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch();
    }
}