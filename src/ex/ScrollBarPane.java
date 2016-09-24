package ex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by tommy on 2016/09/24.
 */
public class ScrollBarPane extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane = new AnchorPane();
        Scene frame = new Scene(pane, 300, 300);
        primaryStage.setScene(frame);

        TextArea ta = new TextArea("foo");
        ta.setMaxSize(150, 150);
        ta.setWrapText(true);
        pane.getChildren().addAll(ta);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
