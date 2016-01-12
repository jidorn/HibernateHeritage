package fr.afcepf.al26.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue(value = "FORMATEUR")
public class Formateur extends Personne {
    @Column(length = 10)
    private Float salaire;
    @OneToMany(mappedBy = "formateur")
    private List<Cours> cours;

    @Override
    public String toString() {
        return "Formateur" +getNom()+", salaire=" + salaire;
    }

    public Formateur() {
    }

    public Formateur(Float salaire, List<Cours> cours) {
        this.salaire = salaire;
        this.cours = cours;
    }

    public Formateur(Integer id, String nom, String prenom, String adresse, String tel, Float salaire, List<Cours> cours) {
        super(id, nom, prenom, adresse, tel);
        this.salaire = salaire;
        this.cours = cours;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
