package com.afpa.exo;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.layout.Pane;
        import java.io.IOException;
        import java.util.ArrayList;

public class crudController {


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

    ObservableList<Client> model = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        pane.setVisible(false);
        listeDesClients();
    }
    public void getDetails(){
        Client cli = tabloview.getSelectionModel().getSelectedItem();
        System.out.println(cli.toString());

        addnom.setText(cli.getNom());
        addprenom.setText(cli.getPrenom());
        addville.setText(cli.getVille());

    }

    public void listeDesClients(){
        ClientDAO reqCli = new ClientDAO();
        ArrayList<Client> tousClients = reqCli.liste();
        model.clear();
        model.addAll(tousClients);
        tabloview.setItems(model);
    }


    public void add(ActionEvent actionEvent) throws IOException {
        pane.setVisible(true);
    }

    public void ajout() {

        if (tabloview.getSelectionModel().getSelectedItem() == null) {
        if (!addnom.getText().equals("")|| !addprenom.getText().equals("")|| !addville.getText().equals("")){
            ClientDAO reqCli = new ClientDAO();
            Client cli = new Client();
            cli.setNom(addnom.getText());
            cli.setPrenom(addprenom.getText());
            cli.setVille(addville.getText());
            reqCli.insert(cli);
            listeDesClients();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("tout les champs ne sont pas remplis");
            alert.setTitle("manque info");
            alert.showAndWait();

        }
    } else {
            ClientDAO reqCli = new ClientDAO();
            Client cli = tabloview.getSelectionModel().getSelectedItem();

            cli.setNom(addnom.getText());
            cli.setPrenom(addprenom.getText());
            cli.setVille(addville.getText());
            reqCli.update(cli);

            listeDesClients();
        }
    }

    public void Annul() {
        addnom.clear();
        addprenom.setText("");
        addville.clear();
    }

    public void maj() {
        pane.setVisible(true);
    }

//    public void aff(ActionEvent actionEvent){
//        ClientDAO reqCli = new ClientDAO();
//        Client cli = tabloview.getSelectionModel().getSelectedItem();
//        addnom.setText(cli.getNom());
//        addprenom.setText(cli.getPrenom());
//        addville.setText(cli.getVille());
//        System.out.println("hell");
//    }





    public void efface(ActionEvent actionEvent) {
    ClientDAO reqCli= new ClientDAO();
    Client cli = tabloview.getSelectionModel().getSelectedItem();
    System.out.println(cli);
    reqCli.delete(cli);
    listeDesClients();

    }


}