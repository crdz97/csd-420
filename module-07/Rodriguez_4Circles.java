//Carolina Rodriguez
//CSD-420 
//Assignment 7
//This program creates a JavaFX application that displays four circles with different styles. 
// The first circle has a border effect, the second circle is plain, the third circle is red, and the fourth circle is green. 
// The styles are defined in a CSS file named "myStyle.css".

//Resources:
//Bro Code. (2023). JavaFX CSS styling [Video]. YouTube. https://www.youtube.com/watch?v=o-lAsVuskKI
//OpenJFX. (n.d.). StageStyle (JavaFX API documentation).https://openjfx.io/javadoc/12/javafx.graphics/javafx/stage/StageStyle.html
//OpenAI. (2026). ChatGPT (GPT-5.3) [Large language model]. https://chat.openai.com/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Rodriguez_4Circles extends Application {

    @Override
    public void start(Stage stage) {

        Circle c1 = new Circle(50);
        c1.getStyleClass().addAll("plaincircle", "circleborder");

        Circle c2 = new Circle(50);
        c2.getStyleClass().add("plaincircle");

        Circle c3 = new Circle(50);
        c3.setId("redcircle");

        Circle c4 = new Circle(50);
        c4.setId("greencircle");

// Box effect for first circle
        StackPane box = new StackPane(c1);
        box.getStyleClass().add("border");

        HBox root = new HBox(20, box, c2, c3, c4);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, 500, 200);
        scene.getStylesheets().add(getClass().getResource("myStyle.css").toExternalForm());

        stage.setTitle("Exercise 31_01");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
