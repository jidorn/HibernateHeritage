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

public class TestHibernateInsert {
    private static Logger log = Logger.getLogger(TestHeritage.class);

    public static void main(String[] args) {
        log.info("TEST hibernate heritage");
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Etudiant etudiant = new Etudiant(null,"etudiant2","prenom","adresse","tel","al26","E1000222");
            Etudiant etudiant2 = new Etudiant(null,"etudiant3","prenom","adresse","tel","al26","E1000222");
            Formateur formateur = new Formateur(null,"formateur","prenom","adresse","tel",480.0f,null);
            Formateur formateur2 = new Formateur(null,"formateur2","prenom","adresse","tel",480.0f,null);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm");
            Cours cours = new Cours("intitule",simpleDateFormat.parse("07:00"),formateur);
            Cours cours2 = new Cours("hibernate",simpleDateFormat.parse("07:00"),formateur);
            Cours cours3 = new Cours("spring",simpleDateFormat.parse("07:00"),formateur);
            session.save(etudiant);
            session.save(etudiant2);
            session.save(formateur);
            session.save(formateur2);
            session.save(cours);
            session.save(cours2);
            session.save(cours3);
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
