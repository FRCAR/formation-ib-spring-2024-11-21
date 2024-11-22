package fr.formation.formation_ib_jpa.model;

import jakarta.persistence.*;

@Entity
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    //Convention Over Configuration -> CoC
    private String name;

    private Boolean valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", valid=" + valid +
                '}';
    }
}
