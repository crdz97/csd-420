//Carolina Rodriguez
//CSd-420 Assignment 10
//Show Java code to connect to a database and show the results in a JavaFX application.
//Resources used:

//Payne, D. (2026). Another_JDBC_App.[Unpublished class video]. CSD 420. Bellevue University.
//OpenAI. (2026). ChatGPT (GPT-5.3) [Large language model]. https://chat.openai.com/
//Oracle. (2013). Working with layouts in JavaFX: Using built-in layout panes. JavaFX 2 Documentation.https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class Rodriguez_FansConnect extends Application {

// Text fields layout 4 fields
    TextField idField = new TextField();
    TextField firstField = new TextField();
    TextField lastField = new TextField();
    TextField teamField = new TextField();

    Label message = new Label(); //show messages to the user

    @Override
    public void start(Stage stage) { //Starts JavaFx application

//Buttons for display and update
        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");

// Layout
        GridPane pane = new GridPane(); //grid rows and columns
        pane.setAlignment(javafx.geometry.Pos.CENTER); //center 

        pane.setVgap(10); //spacing between rows
        pane.setHgap(10);//spacing between columns

// Add labels and text fields
        pane.add(new Label("ID:"), 0, 0); //row 0, column 0 ID label
        pane.add(idField, 1, 0); //input

        pane.add(new Label("First Name:"), 0, 1); //row 1, column 0 First Name label
        pane.add(firstField, 1, 1);

        pane.add(new Label("Last Name:"), 0, 2); //row 2, column 0 Last Name label
        pane.add(lastField, 1, 2);

        pane.add(new Label("Favorite Team:"), 0, 3); //row 3, column 0 Favorite Team label
        pane.add(teamField, 1, 3);

// Add buttons
        pane.add(displayButton, 0, 4);
        pane.add(updateButton, 1, 4);

        pane.add(message, 0, 5);

// Display button action
        displayButton.setOnAction(e -> displayRecord());

 // Update button action
        updateButton.setOnAction(e -> updateRecord());

        Scene scene = new Scene(pane, 350, 250); //window size

        stage.setTitle("Fans Database");
        stage.setScene(scene);
        stage.show();
    }

// Display record method
    public void displayRecord() {

        try {

            Connection conn = DriverManager.getConnection( //connection to databasedb
                    "jdbc:mysql://localhost:3306/databasedb",
                    "student1",
                    "pass");

            String sql = "SELECT * FROM fans WHERE ID = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, Integer.parseInt(idField.getText()));

            ResultSet rs = stmt.executeQuery(); // if record exists

            if (rs.next()) {

                firstField.setText(rs.getString("firstname")); //put DB into field
                lastField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));

                message.setText("Record Found"); //show message if record is found

            } else {

                message.setText("No Record Found");
            }

            conn.close();

        } catch (Exception ex) {

            message.setText("Error");
            ex.printStackTrace();
        }
    }

// Update record method
    public void updateRecord() {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/databasedb",
                    "student1",
                    "pass");

            String sql = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, firstField.getText()); //set text fields
            stmt.setString(2, lastField.getText());
            stmt.setString(3, teamField.getText());
            stmt.setInt(4, Integer.parseInt(idField.getText()));

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                message.setText("Record Updated");

            } else {

                message.setText("Update Failed");
            }

            conn.close(); //close connection

        } catch (Exception ex) { //error message 

            message.setText("Error");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
