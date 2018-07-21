package fr.maradjah.school.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "instructors")
    private Set<Department> departments = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "instructor_subject", joinColumns = @JoinColumn(name = "instructor_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects = new HashSet<>();

    public Instructor() {
    }

    public Instructor(String name) {
        this.name = name;
    }
}
