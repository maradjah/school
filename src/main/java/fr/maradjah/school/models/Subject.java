package fr.maradjah.school.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @JoinColumn(name ="department_id")
    private Department department;

    @ManyToMany(mappedBy = "subjects")
    private Set<Instructor> instructors = new HashSet<>();

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }
}
