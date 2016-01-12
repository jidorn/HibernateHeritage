package fr.afcepf.al26.hibernate.tests;

import fr.afcepf.al26.hibernate.entity.Cours;
import fr.afcepf.al26.hibernate.entity.Etudiant;
import fr.afcepf.al26.hibernate.entity.Formateur;
import fr.afcepf.al26.hibernate.entity.Personne;
import fr.afcepf.al26.hibernate.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Stagiaire on 12/01/2016.
 */
public class TestRecherche {
    private static Logger log = Logger.getLogger(TestHeritage.class);

    public static void main(String[] args) {
        log.info("TEST hibernate heritage");
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query hql = session.createQuery("SELECT f FROM Formateur f");
            List<Formateur>formateurList = hql.list();
            for (Formateur formateur: formateurList){
                log.info(formateur.toString());
                if (formateur.getCours()!=null){
                    for (Cours cours: formateur.getCours()){
                        log.info("cours : "+cours.getId()+", "+cours.getIntitule());
                    }
                }
            }
            Query query = session.createQuery("SELECT p FROM Personne p");
            List<Personne>personnes = query.list();
            for (Personne personne: personnes){
                if (personne.getClass()==Etudiant.class){
                    log.info("Etudiant : "+personne.toString());
                } else if (personne.getClass()==Formateur.class){
                    log.info("Formateur : "+personne.toString());
                }
            }
            tx.commit();
        } catch (Exception e) {
            log.debug("erreur : " + e.getMessage());
            assert tx != null;
            tx.rollback();
        } finally {
            assert session != null;
            session.close();
        }
    }
}
