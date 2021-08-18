package com.afpa.exo;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.sql.*;

public class Exo1Controller {

    public TextField codfour;
    public Button recherche;
    public TextField nom;
    public TextField adress;
    public TextField contact;
    public TextField cp;
    public TextField ville;




    public void req_papyrus() throws SQLException {

        try {

            String url = "jdbc:mysql://localhost:3306/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "admin");

//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setContentText("Connexion à la BDD réussi");
//            alert.setTitle("Connexion BDD");
//            alert.showAndWait();

            // création d'un objet requête directe
            PreparedStatement stm = con.prepareStatement("SELECT * FROM papyrus.fournis WHERE numfou=? ");

            // création d'une variable qui référencera l'ensemble des résultats
            stm.setInt(1, Integer.parseInt(codfour.getText()));

            // création d'une variable qui référencera l'ensemble des résultats
            ResultSet res = stm.executeQuery();
            while (res.next()) {
                int numfou = res.getInt("numfou");
                String nomfou = res.getString("nomfou");
                String ruefou = res.getString("ruefou");
                String villefou = res.getString("vilfou");
                int codpost = res.getInt("posfou");
                String contactfou = res.getString("confou");
                System.out.format("[%d] %s %s %d %s\n", numfou, nomfou, villefou, codpost, contact);

                nom.setText(nomfou);
                adress.setText(ruefou);
                ville.setText(villefou);
                cp.setText(""+codpost);
                contact.setText(contactfou);

            }

            System.out.println("resultat" + res);}
            catch(Exception e) {

       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setContentText("La connexion à echouée");
       alert.setTitle("Connexion BDD");
       alert.showAndWait();
            }

            }

        }




