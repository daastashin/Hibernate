package org.example.model.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dothis3 {
    public static void execute() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();
//filling the tables
/*            Movie movie = new Movie("Movie1", 1994);
            Actor actor1 = new Actor("name1", 30);
            Actor actor2 = new Actor("name2", 20);

            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));

            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(movie);
            session.save(actor1);
            session.save(actor2);*/

//получаем всех актеров фильма
/*            Movie movie = session.get(Movie.class, 7);
            System.out.println(movie.getActors());*/

// adding new movie, with existing actor
/*            Movie newMovie = new Movie("Movie2", 2015);
            Actor actor3 = session.get(Actor.class, 10);

            newMovie.setActors(Collections.singletonList(actor3));

            actor3.getMovies().add(newMovie);

            session.persist(newMovie);*/

//deleting movie from the actor
/*            Actor actor4 = session.get(Actor.class, 11);

            Movie movieToRemove = actor4.getMovies().get(0);

            actor4.getMovies().remove(0);
            movieToRemove.getActors().remove(actor4);*/

            session.getTransaction().commit();
        }

    }
}
