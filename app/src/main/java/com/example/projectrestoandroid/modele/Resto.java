package com.example.projectrestoandroid.modele;

public class Resto {
    protected String nomResto;
    protected String Ville;

    public Resto(String nomResto, String Ville) {
        this.nomResto = nomResto;
        this.Ville = Ville;
    }

    public String getNomResto() { return nomResto;}

    public void setNomResto(String nomResto) {this.nomResto = nomResto;}

    public String getVille() {return Ville;}

    public void setVille(String ville) {this.Ville = Ville;}{}

    @Override
    public String toString() {
        return "Resto{" +
                "nomResto='" + nomResto + '\'' +
                ", Ville=" + Ville +
                '}';
    }
}
