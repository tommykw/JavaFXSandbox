package malc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by tommy on 2016/10/06.
 */
public class ShowHideApp extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(root);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(root);
        }
        stage.sizeToScene();
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }
}
