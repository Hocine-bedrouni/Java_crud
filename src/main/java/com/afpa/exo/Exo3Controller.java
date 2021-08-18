package com.afpa.exo;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class Exo3Controller {


    public TextField nomField;
    public TextField rueField;
    public TextField contactField;
    public TextField cpField;
    public TextField villeField;
    public Button ajout;
    public Button annul;

    boolean nomOk = false, rueOk = false, cpOk = false, villeOk = false, contactOk = false;
    boolean fieldOk;

    public void ajoutfourni(ActionEvent actionEvent){

        int num = 0;

        fieldOk = true;
        if (fieldOk) {
            try {
                String dest = "jdbc:mysql://localhost:3306/papyrus";
                Connection con = DriverManager.getConnection(dest, "root", "admin");
                PreparedStatement stm = con.prepareStatement("SELECT papyrus.fournis.nomfou FROM papyrus.fournis WHERE nomfou = ?");
                Statement stm1 = con.createStatement();

                PreparedStatement stm2 = con.prepareStatement("INSERT INTO papyrus.fournis(numfou, nomfou, ruefou, posfou, vilfou, confou) VALUES (?, ?, ?, ?, ?, ?)");
                ResultSet res1 = stm1.executeQuery("SELECT max(numfou) as 'dernier' from papyrus.fournis");

                stm.setString(1, nomField.getText());
                ResultSet res= stm.executeQuery();
                if(!res.next()) {
                    while (res1.next()){
                        num = res1.getInt("dernier");
                    }
                    stm2.setInt(1, num+ 1);
                    stm2.setString(2, nomField.getText());
                    stm2.setString(3, rueField.getText());
                    stm2.setString(4, villeField.getText());
                    stm2.setString(5, cpField.getText());
                    stm2.setString(6, contactField.getText());

                    stm2.execute();

                    stm1.close();
                    stm1.close();
                    res1.close();
                    con.close();
                    //affiche une alerte pour valider l'action
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("le fournisseur a bien été ajouté");
                    alert.setHeaderText("Creation du nouveau fournisseur");
                    alert.setTitle("Validation");
                    alert.showAndWait();

                    Annuler(actionEvent);
                    System.out.println("c'est fait!!!");

                } else
                {
                    //affiche une alertre car le fournisseur existe déjà
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("le fournisseur n'a pas été ajouté");
                    alert.setHeaderText("Le fournisseur existe déjà");
                    alert.setTitle("Validation");
                    alert.showAndWait();

                    alert.showAndWait();
                    Annuler(actionEvent);
                }


            }  catch (Exception e) {

            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Méga problème");
            alert.setHeaderText("Problème de connection");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    } else {
            System.out.println("j'ai rien fait!!!");
        }
    }

    public void Annuler(ActionEvent actionEvent) throws IOException {
        cpField.clear();
        cpField.setStyle("");
        nomField.clear();
        nomField.setStyle("");
        rueField.clear();
        rueField.setStyle("");
        contactField.clear();
        contactField.setStyle("");
        villeField.clear();
        villeField.setStyle("");
    }

}
