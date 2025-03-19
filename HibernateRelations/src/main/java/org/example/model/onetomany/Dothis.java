package org.example.model.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Dothis {
    public static void execute() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 4);
            System.out.println(person);

            List<Item> items = person.getItems(); //После того, как мы вызовем геттер, hibernate автоматчиески сделает запрос
            //и получит все itemы для этого человеека, это работает только в пределах тразакции

            System.out.println(items);

            Item item = session.get(Item.class, 2);

            System.out.println(item.getOwner());

            //Item newItem = new Item("bulb", person);

            //session.persist(newItem);

            //порождает sql запрос
            for (Item item1: items) {
                session.remove(item1);
            }

            // не порождает sql запрос, но необходимо для того, что в кэше hibernate все было верно
            person.getItems().clear();

            person = session.get(Person.class, 3);

            //Породит SQL и из-за каскадирования заменит на null все ссылки на этого человека из таблицы items
            session.remove(person);

            //Не породит SQL
            person.getItems().forEach(i -> i.setOwner(null));

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
