package com.ThirdLab.View;

import com.ThirdLab.Model.*;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Class which create Main Grid Pane to Scene
 * @author Illia Vysotski
 * @version  1.0.0
 */
public class MainWindow {
    private Customer customer;
    private Pack pack;
    private GridPane mainPane;
    private GridPane controlPane;
    private Button buttonAddBread;
    private Button buttonAddMatches;
    private Button buttonAddMilk;
    private Button buttonBuyGoods;
    private Button buttonMoveGoodsToPack;
    private TextField inputNewGoodsName;
    private Label ErrorLabel;
    private Label InformationLabel1;
    private Label InformationLabel2;
    private ListView<String> listOfGoods;

    /**
     * Constructor of class
     * @param customer
     */
    public MainWindow(Customer customer) {
        this.customer = customer;
        InitialControllers();
        SetPosition();
        SetHandlers();
    }

    /**
     * Initial all Controllers and Pane of Class
     */
    private void InitialControllers() {
        mainPane = new GridPane();
        mainPane.setHgap(2);
        mainPane.setVgap(2);
        mainPane.setMinSize(500, 300);
        mainPane.setAlignment(Pos.TOP_LEFT);
        controlPane = new GridPane();
        controlPane.setVgap(10);
        controlPane.setMinSize(300, 300);
        controlPane.setAlignment(Pos.TOP_LEFT);
        controlPane.setHgap(10);
        buttonAddBread = new Button("Add bread");
        buttonAddMatches = new Button("Add matches");
        buttonAddMilk = new Button("Add milk");
        buttonBuyGoods = new Button("Buy goods");
        buttonMoveGoodsToPack = new Button("Move items to pack");
        inputNewGoodsName = new TextField();
        inputNewGoodsName.setPromptText("Enter name of product");
        ErrorLabel = new Label();
        ErrorLabel.setText("");
        ErrorLabel.setVisible(false);
        InformationLabel1 = new Label();
        InformationLabel1.setText("");
        InformationLabel1.setVisible(false);
        InformationLabel2 = new Label();
        InformationLabel2.setText("");
        InformationLabel2.setVisible(false);
        listOfGoods = new ListView<String>();
        listOfGoods.setItems(FXCollections.observableArrayList(customer.getGoods()));
    }

    /**
     * Set Position of elements in Main Grid
     */
    private void SetPosition() {
        controlPane.add(inputNewGoodsName, 0, 0);//1,0
        controlPane.add(buttonAddMatches, 0, 1);//1,2
        controlPane.add(buttonAddBread, 0, 2);//1,3
        controlPane.add(buttonAddMilk, 0, 3);
        controlPane.add(buttonMoveGoodsToPack, 0, 7);
        controlPane.add(InformationLabel1, 0, 4);
        controlPane.add(InformationLabel2, 0, 8);
        controlPane.add(ErrorLabel, 0, 6);
        mainPane.add(buttonBuyGoods, 0, 1);
        mainPane.add(controlPane, 1, 0);
        mainPane.add(listOfGoods, 0, 0);
    }

    /**
     * Add event handlers to elements
     */
    private void SetHandlers() {
        //buttonDownloadFile.setOnAction(event -> ButtonDownloadFileClick());
        buttonBuyGoods.setOnAction(event -> ButtonBuyGoodsClick());
        buttonMoveGoodsToPack.setOnAction(event -> ButtonMoveGoodsToPackClick());
        buttonAddMatches.setOnAction(event -> ButtonAddMatchesClick());
        buttonAddBread.setOnAction(event -> ButtonAddBreadClick());
        buttonAddMilk.setOnAction(event -> ButtonAddMilkClick());
    }

    private void UpdateListView(){
        listOfGoods.getItems().clear();
        listOfGoods.setItems(FXCollections.observableArrayList(customer.getGoods()));
    }


    private void ButtonAddBreadClick(){
        if(!(inputNewGoodsName.getText().isEmpty() )) {
            ErrorLabel.setVisible(false);
            Goods goods = new Bread(inputNewGoodsName.getText());
            customer.putGoodsInCart(inputNewGoodsName.getText(), goods);
            UpdateListView();
        }
        else{
            ErrorLabel.setText("Error of adding the item.");
            ErrorLabel.setVisible(true);
        }
        inputNewGoodsName.setText("");
    }

    private void ButtonAddMatchesClick(){
        if(!(inputNewGoodsName.getText().isEmpty() )) {
            ErrorLabel.setVisible(false);
            Goods goods = new Matches(inputNewGoodsName.getText());
            customer.putGoodsInCart(inputNewGoodsName.getText(), goods);
            UpdateListView();
        }
        else{
            ErrorLabel.setText("Error of adding the item.");
            ErrorLabel.setVisible(true);
        }
        inputNewGoodsName.setText("");
    }

    private void ButtonAddMilkClick(){
        if(!(inputNewGoodsName.getText().isEmpty() )) {
            ErrorLabel.setVisible(false);
            Goods goods = new Bread(inputNewGoodsName.getText());
            customer.putGoodsInCart(inputNewGoodsName.getText(), goods);
            UpdateListView();
        }
        else{
            ErrorLabel.setText("Error of adding the item.");
            ErrorLabel.setVisible(true);
        }
        inputNewGoodsName.setText("");
    }

    private void ButtonBuyGoodsClick(){
        try{
            if(listOfGoods.getSelectionModel().getSelectedItem() != null) {
                ErrorLabel.setVisible(false);
                if(!customer.buyGoods(listOfGoods.getSelectionModel().getSelectedItem(), customer))
                {
                    ErrorLabel.setText("Sorry, you don't have enough money.");
                    ErrorLabel.setVisible(true);
                } else {
                    InformationLabel1.setText("Payment successfully proceed." +"\n"+ "Your current balance is " + customer.money + "$");
                    InformationLabel1.setVisible(true);
                }
                UpdateListView();
            }
            else {
                ErrorLabel.setText("Choose wanted item.");
                ErrorLabel.setVisible(true);
            }
        }catch (Exception e){
            ErrorLabel.setText(e.getMessage());
            ErrorLabel.setVisible(true);
        }
    }

    private void ButtonMoveGoodsToPackClick(){
        InformationLabel2.setText("Goods put in pack." /*+ pack.getGoodsAmount()*/);
        InformationLabel2.setVisible(true);
        inputNewGoodsName.setText("");
    }

    public GridPane getMainGrid() {
        return mainPane;
    }
}