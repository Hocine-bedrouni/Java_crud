package com.afpa.exo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Exo2Controller implements Initializable{


    public ComboBox combobox;
    public TextArea textarea;
    public Button menuButton;
    ObservableList<String> listFournis = FXCollections.observableArrayList("Tous");

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        try {
            String dest = "jdbc:mysql://localhost:3306/papyrus";
            Connection con = DriverManager.getConnection(dest, "root", "admin");
            PreparedStatement stm = con.prepareStatement("SELECT papyrus.fournis.nomfou FROM papyrus.fournis");

            ResultSet result = stm.executeQuery();
            while (result.next()) {
                listFournis.add(result.getString("nomfou"));
            }

            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("La base de donnée n'est pas joignable.");

        }
        combobox.setItems(listFournis);
    }


    public void boiteselectfourni(ActionEvent actionEvent) {
        String dest = "jdbc:mysql://localhost:3306/papyrus";
        String nom = (String) combobox.getValue();
        int num = 0;
        String tmp = "";
        if (nom.equals("Tous")) {
            try {
                Connection con = DriverManager.getConnection(dest, "root", "admin");
                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery("SELECT * FROM papyrus.entcom");

                while (res.next()) {
                    tmp += res.getString("numcom") + "|" + res.getString("datcom") + "|" + res.getString("obscom") + "\n";
                    System.out.println(tmp);
                }

                textarea.setText(tmp);

            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());
            }
        } else {
            try {
                Connection con = DriverManager.getConnection(dest, "root", "admin");
                PreparedStatement stm1 = con.prepareStatement("SELECT numfou, nomfou FROM papyrus.fournis where nomfou = ?");
                PreparedStatement stm2 = con.prepareStatement("SELECT * FROM papyrus.entcom WHERE numfou = ?");

                stm1.setString(1, nom);
                ResultSet res1 = stm1.executeQuery();
                while (res1.next()) {
                    num = res1.getInt("numfou");
                }

                stm2.setInt(1, num);
                ResultSet res2 = stm2.executeQuery();
                while (res2.next()) {
                    tmp += res2.getString("numcom") + "|" + res2.getString("datcom") + "|" + res2.getString("obscom") + "\n";
                }
                textarea.setText((tmp));
                stm1.close();
                stm2.close();
                con.close();

            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());
            }
        }
    }
}



