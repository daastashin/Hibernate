package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.PersistenceSettings;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //получить человека
/*        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person);
            session.getTransaction().commit();
            System.out.println(person.getId()); // Hibernate позже свяжется с бд и узнает какой id Был присвоен человеку
        } finally {
            sessionFactory.close();
        }*/

        //сохраняем людей
/*        try {
            session.beginTransaction();
            Person person1 = new Person("Bob1", 10);
            Person person2 = new Person("Bob2", 20);
            Person person3 = new Person("Bob3", 30);
            session.persist(person1);
            session.persist(person2);
            session.persist(person3);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

        //изменяем имя
/*        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            person.setName("newName");
            System.out.println(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

        //удаляем человека
/*        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            session.remove(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

        //HQL запрос
/*        try {
            session.beginTransaction();
            List<Person> personList = session.createQuery("FROM Person where age > 25").getResultList();
            session.createQuery("update Person set name = 'TestName' where age > 25").executeUpdate();
            System.out.println(personList);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

        

    }
}