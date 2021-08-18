package com.afpa.exo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAO extends BaseHotel {
    public ClientDAO() {
    }

    @FXML
    public TableColumn colnom;
    @FXML
    public TableColumn colprenom;
    public Button ajout;
    public Button modif;
    public Button supp;
    @FXML
    public TableView<Client> tabloview;
    public Pane pane;
    public TextField addnom;
    public TextField addprenom;
    public TextField addville;
    public Button addok2;
    boolean boul = false;
    ObservableList<Client> model = FXCollections.observableArrayList();


    public ArrayList<Client> liste() {
        ResultSet res1 = null;
        ArrayList<Client> tousClients = new ArrayList<>();
        try {

            Statement stm1 = getConnexion().createStatement();
            res1 = stm1.executeQuery("SELECT * FROM hotel.client");

            while (res1.next()) {

                int id = res1.getInt(1);
                String nom = res1.getString(2);
                String prenom = res1.getString(3);
                String ville = res1.getString(5);
                Client cli = new Client(id, nom, prenom, ville);
                System.out.println(cli);
                tousClients.add(cli);

            }
            stm1.close();
            getConnexion().close();
            return tousClients;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

            return null;
        }
    }


    public void insert(Client cli) {

//        pane.setVisible(true);
        // méthode d'insertion

            try {
                PreparedStatement stm = getConnexion().prepareStatement("INSERT INTO hotel.client (cli_nom, cli_prenom, cli_ville) VALUES (?, ?, ?)");

                stm.setString(1, cli.getNom());
                stm.setString(2, cli.getPrenom());
                stm.setString(3, cli.getVille());

                stm.execute();

                stm.close();
                System.out.println("l'insertion s’est bien effectuée");
                getConnexion().close();


            } catch (Exception e) {
                System.out.println("Erreur lors de l’insertion 'client'");
                System.out.println(e.getMessage());
            }
        }


    public void delete(Client cli) {

        try {
            PreparedStatement stm = getConnexion().prepareStatement("DELETE FROM hotel.client WHERE cli_id=? ");

            stm.setInt(1, cli.getCli_id());
            stm.execute();
            stm.close();
            getConnexion().close();

            System.out.println("la suppression a bien était effectuée");

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression 'client'");
            System.out.println(e.getMessage());
        }
    }

    public void update(Client cli) {

        try {
            PreparedStatement stm = getConnexion().prepareStatement("UPDATE hotel.client SET cli_nom = ? , cli_prenom = ? , cli_ville = ? WHERE cli_id = ? ");
            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());
            stm.setInt(4, cli.getCli_id());

            stm.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
