//package com.afpa.exo;
//
//import javafx.fxml.Initializable;
//
//import java.awt.*;
//import java.net.URL;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class FourniDAO implements Initializable {
//
//
//    public void insert(Fournisseur four) {
//
//    }
//
//
//    public ArrayList<Fournisseur> list() {
//        // méthode de création de liste
////
//
//
//        try {
//            String url = "jdbc:mysql://localhost:3306/papyrus";
//            Connection con = DriverManager.getConnection(url, "root", "admin");
//            Fournisseur Tous =new Fournisseur();
//            Tous.setNomfou();
//            Tous.setNumfou();
//
//
////            Alert alert = new Alert(Alert.AlertType.INFORMATION);
////            alert.setContentText("Connexion à la BDD réussi");
////            alert.setTitle("Connexion BDD");
////            alert.showAndWait();
//
//            // création d'un objet requête directe
//            Statement stm = con.createStatement();
//
//            //executeQuery correspond à la demande d'exécution de la
//            // requête. La variable result ( ResultSet ) est
//            // l'ensemble des résultats renvoyés par la requête
//            ResultSet res = stm.executeQuery ("SELECT * FROM papyrus.fournis");
//
////            while (res.next()) {
////                Fournisseur f = new Fournisseur();
////                f.setId(res.getInt("numfou"));
////                f.setNom(res.getString("nomfou"));
////                f.setPrenom(res.getString("cli_prenom"));
////                resultat.add(f);
////            }
//
//        }
//        catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//        return null;
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//}
