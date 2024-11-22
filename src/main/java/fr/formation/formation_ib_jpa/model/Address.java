package fr.formation.formation_ib_jpa.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String codePostal;
    private String ville;

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
