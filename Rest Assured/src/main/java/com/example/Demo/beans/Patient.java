package com.example.Demo.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
    @Id                         //primary key in a table(here id is a primary key)
    @Column(name="id")          //attribute of a table(name should be same as, name of attribute in a table)
    int id;

    @Column(name="name")
    String name;

    @Column(name="gender")
    String gender;

    @Column(name="prescription")
    String prescription;

    public Patient()            //default constructor
    {

    }

    public Patient(int id, String name, String gender, String prescription){      //parameterized constructor
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.prescription=prescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

}
