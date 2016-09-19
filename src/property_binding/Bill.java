package property_binding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by tommy on 2016/09/20.
 */
public class Bill {
    private DoubleProperty amountDue = new SimpleDoubleProperty();
    public final double getAmountDue() {
        return amountDue.get();
    }

    public final void setAmountDue(double value) {
        amountDue.set(value);
    }

    public DoubleProperty amountDueProperty() {
        return amountDue;
    }
}
