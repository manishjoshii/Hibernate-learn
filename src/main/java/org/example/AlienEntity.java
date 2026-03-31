package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "alien")
public class AlienEntity {

    @Id
    @Column(name = "id")
    private int a_id;
    @Column(name = "name")
    private String a_name;
    @Column(name = "tech")
    private String a_tech;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_tech() {
        return a_tech;
    }

    public void setA_tech(String a_tech) {
        this.a_tech = a_tech;
    }

    @Override
    public String toString() {
        return "AlienEntity{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_tech='" + a_tech + '\'' +
                '}';
    }
}
