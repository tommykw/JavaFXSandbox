package property_binding;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by tommy on 2016/09/20.
 */
public class Main {
    public static void main(String... args) {
        Bill bill = new Bill();
        bill.amountDueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("changed " + oldValue + " to " + newValue);
            }
        });

        bill.setAmountDue(50);
        bill.setAmountDue(100);
        bill.setAmountDue(10000);
    }
}
