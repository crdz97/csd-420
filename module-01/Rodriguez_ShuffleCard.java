//Carolina Rodriguez
//CSD-420
//JavaFx 4 Card Shuffle CardApplication with Refresh Button

//Resources: 
//Berris, R. (2019, November 25). JavaFX Image from resources folder [Stack Overflow question]. Stack Overflow.https://stackoverflow.com/questions/59029879/javafx-image-from-resources-folder
//BroCode.(2021, February 1). JavaFx ImageView [Video]. YouTube.https://www.youtube.com/watch?v=ePT4maOtjVA
//GeeksforGeeks.(2019, October 28).JavaFX Button with examples.https://www.geeksforgeeks.org/java/javafx-button-with-examples/
//JavaFX Documentation. (n.d.). Uses of Class javafx.geometry.Pos (JavaFX 17). OpenJFX.https://openjfx.io/javadoc/17/javafx.graphics/javafx/geometry/class-use/Pos.html

import javafx.application.Application; //JavaFx library
import javafx.scene.Scene;//container
import javafx.scene.control.Button; //clickable button
import javafx.scene.image.Image;//image class
import javafx.scene.image.ImageView;//view image class
import javafx.scene.layout.VBox;//vertical box layout
import javafx.scene.layout.HBox;//horizontal box layout
import javafx.stage.Stage;//main
import javafx.geometry.Pos;//center alignment

import java.util.ArrayList; //array list for deck of cards
import java.util.Collections; //shuffle method()

public class Rodriguez_ShuffleCard extends Application {

    private ImageView[] cardViews = new ImageView[4]; //array to hold 4 ImageViews for displaying cards

    @Override
    public void start(Stage primaryStage) {

        HBox cardBox = new HBox(10);//Horizontal box to hold image with 10 spacing
        cardBox.setAlignment(Pos.CENTER);//center alignment


        for (int i = 0; i < 4; i++) { //loop to create 4 images for cards
            cardViews[i] = new ImageView(); //start
            cardViews[i].setFitWidth(100); //100 pixel
            cardViews[i].setPreserveRatio(true); //small image
            cardBox.getChildren().add(cardViews[i]); //add Image to Hbox
        }

        
        Button refreshButton = new Button("Refresh"); //button to refresh cards

        refreshButton.setOnAction(e -> displayRandomCards()); //lambda expression to call displayRandomCards() when button is clicked

        VBox root = new VBox(15, cardBox, refreshButton); //Vertical box to hold cardBox and refresh button with 15 spacing
        root.setAlignment(Pos.CENTER);

        displayRandomCards();

        Scene scene = new Scene(root, 500, 300); //500x300 small window size
        primaryStage.setTitle("Rodriguez Shuffle Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {

        ArrayList<Integer> deck = new ArrayList<>(); //creates 1-52 for deck of cards
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        
        Collections.shuffle(deck); //shuffle the deck of cards

        
        for (int i = 0; i < 4; i++) { //loop to display 4 random cards
            String imagePath = "cards/" + deck.get(i) + ".png";

            System.out.println(imagePath);

            Image image = new Image(imagePath);
            cardViews[i].setImage(image);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}