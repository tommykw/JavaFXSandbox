package ex;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tommy on 2016/09/24.
 */
public final class KeyboardApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Keyboard keyboard = new Keyboard();
        final Scene scene = new Scene(new Group(keyboard.createNode()));
        primaryStage.setScene(scene);
        primaryStage.setTitle("keyboard");
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
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

        private void installEventHandler(final Node keyNode) {
            final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.ENTER) {
                        setPressed(event.getEventType() == KeyEvent.KEY_PRESSED);
                        event.consume();
                    }
                }
            };

            keyNode.setOnKeyPressed(keyEventHandler);
            keyNode.setOnKeyReleased(keyEventHandler);
        }
    }

    private static final class Keyboard {
        private final Key[] keys;

        public Keyboard(final Key... keys) {
            this.keys = keys.clone();
        }

        public Node createNode() {
            final HBox keyboardNode = new HBox(6);
            keyboardNode.setPadding(new Insets(6));

            final List<Node> keyboardNodeChildren = keyboardNode.getChildren();
            for (final Key key : keys) {
                keyboardNodeChildren.add(key.createNode());
            }

            installEventHandler(keyboardNode);
            return keyboardNode;
        }

        private void installEventHandler(final Parent keyboardNode) {
            final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent event) {
                    final Key key = lookupKey(event.getCode());
                    if (key != null) {
                        key.setPressed(event.getEventType() == event.KEY_PRESSED);
                        event.consume();
                    }
                }
            };

            keyboardNode.setOnKeyPressed(keyEventHandler);
            keyboardNode.setOnKeyReleased(keyEventHandler);
            keyboardNode.addEventHandler(
                    KeyEvent.KEY_PRESSED,
                    new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            handleFocusTraversal(keyboardNode, event);
                        }
                    }
            );

        }

        private Key lookupKey(final KeyCode keyCode) {
            for (final Key key : keys) {
                if (key.getKeyCode() == keyCode) {
                    return key;
                }
            }
            return null;
        }

        private static void handleFocusTraversal(final Parent traversalGroup,
                                                 final KeyEvent keyEvent) {
            final Node nextFocusedNode;
            switch (keyEvent.getCode()) {
                case LEFT:
                    nextFocusedNode = getPreviousNode(
                            traversalGroup,
                            (Node) keyEvent.getTarget()
                    );
                    keyEvent.consume();
                    break;
                case RIGHT:
                    nextFocusedNode = getNextNode(
                            traversalGroup,
                            (Node) keyEvent.getTarget()
                    );
                    keyEvent.consume();
                    break;
                default:
                    return;
            }

            if (nextFocusedNode != null) {
                nextFocusedNode.requestFocus();
            }
        }

        private static Node getPreviousNode(final Parent parent, final Node node) {
            final Iterator<Node> childIterator = parent.getChildrenUnmodifiable().iterator();
            Node lastNode = null;

            while (childIterator.hasNext()) {
                final Node currentNode = childIterator.next();
                if (currentNode == node) {
                    return lastNode;
                }

                lastNode = currentNode;
            }

            return null;
        }

        private static Node getNextNode(final Parent parent,
                                        final Node node) {
            final Iterator<Node> childIterator = parent.getChildrenUnmodifiable().iterator();
            while (childIterator.hasNext()) {
                if (childIterator.next() == node) {
                    return childIterator.hasNext() ? childIterator.next() : null;
                }
            }

            return null;
        }
    }
}
