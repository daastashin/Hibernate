package org.example.model.onetoone;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Passport")
public class Passport implements Serializable { // делаем Serializable, т.к. нету поля id, а в качестве PK выступает FK
    //в виде ссылки на человека. В последствии добавляем колонку id, а на колонку со ссылкой на человека вешаем UNIQUE,
    //тогда получается, что выстроено отношение один к одному при этом можем искать пасспорт по id

    @Id
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person2 person2;

    @Column(name = "passport_number")
    private int pssportNumber;

    public Passport(int pssportNumber) {
        this.pssportNumber = pssportNumber;
    }
}
