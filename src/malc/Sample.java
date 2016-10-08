package malc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by tommy on 2016/10/07.
 */
public class Sample implements Initializable {
    @FXML
    private TreeView<?> tree;
    @FXML
    private TextArea area;
    @FXML
    private StackPane parentStack;

    @FXML
    private void loadTree(ActionEvent event) {
        tree.setVisible(true);
        area.setVisible(false);
    }

    @FXML
    private void loadTextArea(ActionEvent event) {
        area.setVisible(true);
        tree.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        area = (TextArea) parentStack.lookup("#textArea");
    }
}
