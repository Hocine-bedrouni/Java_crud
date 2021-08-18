package com.afpa.exo;

public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String ville;

    /**
     * constructeur par défaut
     */
    public Client(){}

    /**
     * Constructeur avec paramètre
     *
     */
    public Client (String n, String p, String v){
        this.nom = n;
        this.prenom = p;
        this.ville = v;
    }

    public Client(int id, String nom, String prenom, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
    }

    public int getCli_id() {
        return id;
    }

    public void setCli_id(int cli_id) {
        this.id = cli_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString(){
//        return this.nom;
        return this.id + " " + this.nom + " " + this.prenom + " " + this.ville;
    }
}
