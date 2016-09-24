package ex;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by tommy on 2016/09/24.
 */
public final class KeyboardApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Keyboard keyboard = new Keyboard();
    }

    private static final class Key {
        private final KeyCode keyCode;
        private final BooleanProperty pressedProperty;

        public Key(final KeyCode keyCode) {
            this.keyCode = keyCode;
            this.pressedProperty = new SimpleBooleanProperty(this, "pressed");
        }

        public KeyCode getKeyCode() {
            return keyCode;
        }

        public boolean isPressed() {
            return pressedProperty.get();
        }

        public void setPressed(final boolean value) {
            pressedProperty.set(value);
        }

        public Node createNode() {
            final StackPane keyNode = new StackPane();
            keyNode.setFocusTraversable(true);
            return null;
        }
    }

    private void installEventHandler(final Parent keyboardNode) {
        final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                final Key key = lookupKey(event.getCode());
            }
        };
    }

    private Key lookupKey(final KeyCode keyCode) {
        return null;
    }

    private static final class Keyboard {
    }
}
