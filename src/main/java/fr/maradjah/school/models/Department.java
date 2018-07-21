package fr.maradjah.school.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "department_instructor", joinColumns = @JoinColumn(name = "DEPARTMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSTRUCTOR_ID"))
    private Set<Instructor> instructors = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Subject> subjects = new HashSet<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public void addSubject(Subject subject) {
        this.getSubjects().add(subject);
        subject.setDepartment(this);
    }

    public void removeSubject(Subject subject) {
        this.getSubjects().remove(subject);
        subject.setDepartment(null);
    }


}
