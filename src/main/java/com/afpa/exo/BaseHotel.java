package com.afpa.exo;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseHotel {

    public Connection getConnexion(){
        try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "admin");
            return con;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("pédé");
            alert.setTitle("ptitbite");
            alert.showAndWait();
            return null;
        }
    }

}
