package bank;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

import java.net.URL;

/**
 * Created by tommy on 2016/09/19.
 */
public class Controller {
    @FXML
    TextField InsertPinNumber;
    @FXML
    TextField InsertAcoNumber;
    @FXML
    TextField InfoText;
    @FXML
    TextField AmmountMoneyToWid;
    @FXML
    Button PinAccept;
    @FXML
    Button CardAccept;
    @FXML
    Button StateOfAccount;
    @FXML
    Button MoneyToWith;
    @FXML
    Button CardOut;
    @FXML
    RadioButton FreeMoney;
    @FXML
    RadioButton ChoiceMoney;
    @FXML
    ComboBox<Integer> ComboBox = new ComboBox<Integer>(
            FXCollections.observableArrayList(10,20,30)
    );
    @FXML
    ResourceBundle resources;
    @FXML
    URL location;

    @FXML
    public void initialized() {

    }
}
