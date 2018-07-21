package fr.maradjah.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "school")
    private Set<Student> students = new HashSet<>();

    public School() {
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addDepartment(Department department) {
        this.getDepartments().add(department);
        department.setSchool(this);
    }

    public void removeDepartment(Department department) {
        this.getDepartments().remove(department);
        department.setSchool(null);
    }

    public void addStudent(Student student) {
        this.getStudents().add(student);
        student.setSchool(this);
    }

    public void removeStudent(Student student) {
        this.getStudents().remove(student);
        student.setSchool(null);
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id) &&
                Objects.equals(name, school.name) &&
                Objects.equals(address, school.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        return  name ;
    }
}
