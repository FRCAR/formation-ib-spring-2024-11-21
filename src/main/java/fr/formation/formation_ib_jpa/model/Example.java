package fr.formation.formation_ib_jpa.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

@Entity
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    //Convention Over Configuration -> CoC
    private String name;

    private Boolean valid;

    @Enumerated(EnumType.STRING)
    private ExampleState state;

    @ManyToOne
    @JoinColumn(name = "EXAMPLE_TYPE_ID")
    private ExampleType type;

    //Embedded signifie que les attributs
    // de address seront persistés dans des colonnes
    // de la table EXAMPLE
    @Embedded
    private Address address;

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

    public ExampleState getState() {
        return state;
    }

    public void setState(ExampleState state) {
        this.state = state;
    }

    public ExampleType getType() {
        return type;
    }

    public void setType(ExampleType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
