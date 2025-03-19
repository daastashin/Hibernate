package org.example.model.onetoone;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "Person2")
public class Person2 {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "age")
    private int age;
    @OneToOne(mappedBy = "person2", cascade = CascadeType.PERSIST)
    private Passport passport;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPerson2(this);
    }
}
