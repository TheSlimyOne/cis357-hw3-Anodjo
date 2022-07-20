
/*
 * Homework 3: Sales Register Program part 3
 * Course: CIS357
 * Due date: 7/19/2022
 * Name: Jordan Anodjo
 * GitHub: https://github.com/TheSlimyOne/cis357-hw3-Anodjo.git
 * Instructor: Il-Hyung Cho
 * ===============================================================================
 * Program description: 
 * 		In this program, a user will interact with a gui and eventually be able to purchase items from it
 * ===============================================================================
 * 
 */

import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class NewSale extends Application {
    // Create scenes
    Scene scene1;
    Scene scene2;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        String style = "-fx-font-size: 15pt;";
        primaryStage.setResizable(false);

        // ----- First Scene ----- //

        // Create the scene with its styling
        VBox vboPostRegister = new VBox(65);
        vboPostRegister.setPadding(new Insets(12, 12, 12, 12));
        vboPostRegister.setAlignment(Pos.BASELINE_CENTER);
        vboPostRegister.setStyle("-fx-font-family: 'comic sans ms';");

        // Create scene
        scene1 = new Scene(vboPostRegister, 400, 300);

        // Defining all the nodes required
        Label lblWelcome = new Label("Welcome to Anodjo's store!!!");
        Button btnNewSale = new Button("New Sale");
        Label lblTotalSale = new Label("Total sale for the day is: $0.00");

        // Styling nodes
        lblWelcome.setStyle(style);
        btnNewSale.setStyle(style);
        lblTotalSale.setStyle(style);

        // Adding functionality
        btnNewSale.setOnAction(e -> primaryStage.setScene(scene2));

        // Display
        vboPostRegister.getChildren().addAll(lblWelcome, btnNewSale, lblTotalSale);
        primaryStage.setTitle("Post Register");
        primaryStage.setScene(scene1);
        primaryStage.show();

        // ----- Second Scene ----- //

        // Create the scene pane with its styling
        VBox vboNewSale = new VBox(15);
        vboNewSale.setPadding(new Insets(12, 12, 12, 12));
        vboNewSale.setStyle("-fx-font-family: 'Helvetica';");
        scene2 = new Scene(vboNewSale, 615, 750);

        // ----- Top pane ----- //
        // Pane for the add item nodes
        GridPane topPane = new GridPane();

        // Styling nodes
        topPane.setStyle("-fx-border-color: lightgray;");
        topPane.setPadding(new Insets(10, 10, 10, 10));

        // Defining all the nodes required
        Label lblItemID = new Label("Item ID:");
        ComboBox<TextField> cboItemID = new ComboBox<TextField>();
        Label lblItemName = new Label("Item Name:");
        Label lblItemNameResult = new Label("N/A");
        Label lblItemPrice = new Label("Item Price:");
        Label lblItemPriceResult = new Label("$0.00");
        Label lblItemQuantity = new Label("Quantity:");
        TextField txtItemQuantityResult = new TextField();
        Label lblItemTotal = new Label("Item Total:");
        Label lblItemTotalResult = new Label("$0.00");
        Button btnAdd = new Button("Add");

        // Styling
        lblItemID.setStyle(style);
        cboItemID.setStyle(style);
        lblItemName.setStyle(style);
        lblItemNameResult.setStyle(style);
        lblItemPrice.setStyle(style);
        lblItemPriceResult.setStyle(style);
        lblItemQuantity.setStyle(style);
        txtItemQuantityResult.setStyle(style);
        lblItemTotal.setStyle(style);
        lblItemTotalResult.setStyle(style);
        btnAdd.setStyle(style);

        // Positioning the nodes in the grid
        topPane.add(lblItemID, 0, 0, 1, 1);
        topPane.add(cboItemID, 1, 0, 1, 1);
        topPane.add(lblItemName, 0, 1, 1, 1);
        topPane.add(lblItemNameResult, 1, 1, 1, 1);
        topPane.add(lblItemPrice, 0, 2, 1, 1);
        topPane.add(lblItemPriceResult, 1, 2, 1, 1);
        topPane.add(lblItemQuantity, 0, 3, 1, 1);
        topPane.add(txtItemQuantityResult, 1, 3, 1, 1);
        topPane.add(lblItemTotal, 0, 4, 1, 1);
        topPane.add(lblItemTotalResult, 1, 4, 1, 1);
        topPane.add(btnAdd, 1, 5, 1, 1);

        // --- Formatting Pane --- //
        btnAdd.setPrefWidth(100);

        // Force the button to be full length
        btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setHalignment(btnAdd, HPos.CENTER);
        GridPane.setHgrow(btnAdd, Priority.ALWAYS);
        GridPane.setValignment(btnAdd, VPos.CENTER);
        GridPane.setVgrow(btnAdd, Priority.ALWAYS);

        // Force the combo box to be full length
        cboItemID.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setHalignment(cboItemID, HPos.CENTER);
        GridPane.setHgrow(cboItemID, Priority.ALWAYS);
        GridPane.setValignment(cboItemID, VPos.CENTER);
        GridPane.setVgrow(cboItemID, Priority.ALWAYS);

        // Setting alignment
        GridPane.setHalignment(lblItemID, HPos.RIGHT);
        GridPane.setHalignment(lblItemName, HPos.RIGHT);
        GridPane.setHalignment(lblItemPrice, HPos.RIGHT);
        GridPane.setHalignment(lblItemQuantity, HPos.RIGHT);
        GridPane.setHalignment(lblItemTotal, HPos.RIGHT);

        // Setting the gap vertically and horizontally
        topPane.setHgap(20);
        topPane.setVgap(5);

        // ----- Bottom pane ----- //
        VBox bottomPane = new VBox(10);

        // Styling
        bottomPane.setStyle("-fx-border-color: lightgray;");
        bottomPane.setPadding(new Insets(10, 10, 10, 10));

        // Pane for the Text Box
        StackPane textPane = new StackPane();
        textPane.getChildren().add(new TextArea());

        // Pane for the Checkout nodes
        GridPane checkoutPane = new GridPane();

        // Defining all the nodes required.
        Label lblSubTotal = new Label("Sale Sub Total:");
        Label lblSubTotalResults = new Label("$0.00");
        Label lblSubTax = new Label("Sale Tax Total (6%):");
        Label lblSubTaxResults = new Label("$0.00");
        Label lblTenderedAmount = new Label("Tendered Amount:");
        TextField lblTenderedAmountResults = new TextField();
        Button btnCheckout = new Button("Checkout");
        Label lblChange = new Label("Change:");
        Label lblChangeResults = new Label("$0.00");

        // Styling
        lblSubTotal.setStyle(style);
        lblSubTotalResults.setStyle(style);
        lblSubTax.setStyle(style);
        lblSubTaxResults.setStyle(style);
        lblTenderedAmount.setStyle(style);
        lblTenderedAmountResults.setStyle(style);
        btnCheckout.setStyle(style);
        lblChange.setStyle(style);
        lblChangeResults.setStyle(style);

        // Positioning the nodes in the grid
        checkoutPane.add(lblSubTotal, 0, 0, 1, 1);
        checkoutPane.add(lblSubTotalResults, 1, 0, 1, 1);
        checkoutPane.add(lblSubTax, 0, 1, 1, 1);
        checkoutPane.add(lblSubTaxResults, 1, 1, 1, 1);
        checkoutPane.add(lblTenderedAmount, 0, 2, 1, 1);
        checkoutPane.add(lblTenderedAmountResults, 1, 2, 1, 1);
        checkoutPane.add(btnCheckout, 2, 2, 1, 1);
        checkoutPane.add(lblChange, 0, 3, 1, 1);
        checkoutPane.add(lblChangeResults, 1, 3, 1, 1);

        // Setting the gap vertically and horizontally
        checkoutPane.setHgap(20);
        checkoutPane.setVgap(5);

        bottomPane.getChildren().addAll(textPane, checkoutPane);

        // ----- Done Button ----- //
        Button btnDone = new Button("Done");
        btnDone.prefWidthProperty().bind(vboNewSale.widthProperty());
        btnDone.setStyle(style);

        btnDone.setOnAction(e -> primaryStage.setScene(scene1));

        // Display
        vboNewSale.getChildren().addAll(topPane, bottomPane, btnDone);
        primaryStage.setTitle("New Sale");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }
}
