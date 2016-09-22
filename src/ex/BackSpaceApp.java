package ex;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by tommy on 2016/09/22.
 */
public class BackSpaceApp extends Application {
    private final ObservableList<String> strings = FXCollections.observableArrayList(
            "p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"
    );

    private final ObservableList<String> fonts = FXCollections.observableArrayList(
            Font.getFamilies()
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Box");
        VBox nonEditBox = new VBox(15);
        ComboBox comboBox1 = new ComboBox();
        comboBox1.setEditable(true);
        comboBox1.setItems(
                FXCollections.observableArrayList(strings.subList(0, 4))
        );
        comboBox1.sceneProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("sceneProperty changed");
            }
        });

        nonEditBox.getChildren().add(comboBox1);
        ComboBox comboBox2 = new ComboBox();
        comboBox2.setEditable(true);
        comboBox2.setItems(
                FXCollections.observableArrayList(strings.subList(0, 5))
        );
        nonEditBox.getChildren().add(comboBox2);
        TextField textField1 = new TextField();
        nonEditBox.getChildren().add(textField1);
        nonEditBox.addEventFilter(KeyEvent.ANY, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.BACK_SPACE) ||
                        event.getCode().equals(KeyCode.DELETE)) {
                    System.out.println("VBox is receiving key event");
                }
            }
        });

        HBox vbox = new HBox(20);
        vbox.setLayoutX(40);
        vbox.setLayoutY(25);
        vbox.getChildren().addAll(nonEditBox);
        Scene scene = new Scene(new Group(vbox), 620, 190);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
