package org.example.model.onetomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //указываем hibernate, что колонка формируется автоматов на стороне бд
    //Есть еще стратегия sequence для того, чтобы обратить к определнному sequence в бд для получения значения
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    //CascadeType.PERSIST - при сохранении человека будут автоматически сохраняться все связанные с ним товары, отдельным SQL запросами
    private List<Item> items;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
