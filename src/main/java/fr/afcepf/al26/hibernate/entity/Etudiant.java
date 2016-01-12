package fr.afcepf.al26.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "ETUDIANT")
public class Etudiant extends Personne{
    @Column(name = "numero",length = 255)
    private Integer numEtudiant;
    @Column(name = "cursus",length = 50)
    private String cursus;

    public Etudiant() {
    }

    public Etudiant(Integer numEtudiant, String cursus) {
        this.numEtudiant = numEtudiant;
        this.cursus = cursus;
    }

    public Etudiant(Integer id, String nom, String prenom, String adresse, String tel, Integer numEtudiant, String cursus) {
        super(id, nom, prenom, adresse, tel);
        this.numEtudiant = numEtudiant;
        this.cursus = cursus;
    }

    public Integer getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(Integer numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }
}
