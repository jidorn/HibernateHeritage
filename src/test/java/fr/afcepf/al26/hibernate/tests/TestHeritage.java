package fr.afcepf.al26.hibernate.tests;

import fr.afcepf.al26.hibernate.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by Stagiaire on 12/01/2016.
 */
public class TestHeritage {
    private static Logger log = Logger.getLogger(TestHeritage.class);

    public static void main(String[] args) {
        log.info("TEST hibernate");
        Session session = HibernateUtil.getSession();
        log.info("bdd créée");
        session.close();
    }
}
