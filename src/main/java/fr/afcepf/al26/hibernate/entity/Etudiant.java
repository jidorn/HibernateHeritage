package fr.afcepf.al26.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "ETUDIANT")
public class Etudiant extends Personne{
    @Column(name = "numero",length = 255)
    private String numEtudiant;
    @Column(name = "cursus",length = 50)
    private String cursus;

    @Override
    public String toString() {
        return "Etudiant=" +getNom()+
                ", cursus='" + cursus;
    }

    public Etudiant() {
    }

    public Etudiant(String numEtudiant, String cursus) {
        this.numEtudiant = numEtudiant;
        this.cursus = cursus;
    }

    public Etudiant(Integer id, String nom, String prenom, String adresse, String tel, String numEtudiant, String cursus) {
        super(id, nom, prenom, adresse, tel);
        this.numEtudiant = numEtudiant;
        this.cursus = cursus;
    }

    public String getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(String numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }
}
