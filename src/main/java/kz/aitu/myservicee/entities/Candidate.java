package kz.aitu.myservicee.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.lang.annotation.Repeatable;
import java.util.Objects;

@Entity
@Table(name="candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullname;
    private int age;

    public Candidate(){

    }
    public Candidate(int id, String fullname, int age) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id && age == candidate.age && Objects.equals(fullname, candidate.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, age);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}

