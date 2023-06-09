package by.ashafalovich.testRest.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
