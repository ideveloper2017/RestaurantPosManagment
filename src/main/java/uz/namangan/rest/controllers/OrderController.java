package uz.namangan.rest.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    @FXML
    private ListView<Button> listvieww;

    @FXML
    private HBox hboxx;

//    List<String> listOfSomething = null;

    private ObservableList<Button> buttons = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hboxx.getChildren().add((Node) buttons);
    }

    @FXML
    void acttable(ActionEvent event) {
                ObservableList<String> list = FXCollections.observableArrayList("1","2");
                Button b = new Button(list.toString());
                buttons.add(b);
    }
}
