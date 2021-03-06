package fr.afcepf.al26.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Stagiaire on 12/01/2016.
 */
@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titre",length = 250,nullable = false)
    private String intitule;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "duree", nullable = false)
    private Date duree;
    @ManyToOne
    @JoinColumn(name = "id_personne", nullable = false)
    private Formateur formateur;

    public Cours(String intitule, Date duree, Formateur formateur) {
        this.intitule = intitule;
        this.duree = duree;
        this.formateur = formateur;
    }

    public Cours() {
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
