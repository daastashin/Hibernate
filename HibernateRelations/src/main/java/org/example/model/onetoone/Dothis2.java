package org.example.model.onetoone;

import org.example.model.onetomany.Item;
import org.example.model.onetomany.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Dothis2 {
    public static void execute() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person2.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        /*try {
            session.beginTransaction();

            Person2 person2 = new Person2("name4", 20);
            Passport passport = new Passport(1111111);

            person2.setPassport(passport);

            session.persist(person2);

            Person2 person21 = new Person2("name5", 30);
            Passport passport1 = new Passport(222222);

            person21.setPassport(passport1);

            session.persist(person21);

            session.getTransaction().commit();
        } finally {
            session.close();
        }*/

        try {
            session.beginTransaction();

            Person2 person = session.get(Person2.class, 1);

            session.remove(person);

            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }
}
