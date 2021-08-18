package com.afpa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    public void exo1(ActionEvent actionEvent) throws IOException {
        Stage stage1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("exo/exo1.fxml"));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
    }

    public void exo2(ActionEvent actionEvent) throws IOException {
        Stage stage1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("exo/exo2.fxml"));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
    }

    public void exo3(ActionEvent actionEvent) throws IOException {
        Stage stage1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("exo/exo3.fxml"));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
    }

    public void crud(ActionEvent actionEvent) throws IOException {
        Stage stage1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("exo/crud.fxml"));
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.show();
    }




}
