package org.campus.numerique.client.model;

public class Client
{
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private int numeroPermis;


    public Client(){
    }

    public Client(int id, String nom, String prenom, String dateNaissance, int numeroPermis) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroPermis = numeroPermis;
    }


    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public int getNumeroPermis() {
        return numeroPermis;
    }





    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public void setNumeroPermis(int numeroPermis) {
        this.numeroPermis = numeroPermis;
    }


    @Override
    public String toString() {
        return "Client" +
                "id=" + id +
                ", nom=" + nom +
                ", prenom=" + prenom +
                ", date de naissance=" + dateNaissance +
                ", numéro de permis=" + numeroPermis;
    }

}
