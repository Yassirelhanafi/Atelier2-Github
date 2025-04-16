package examen.examen.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @OneToOne(mappedBy ="personne")
    private Université université;
    private String nom;

    public Université getUniversité() {
        return université;
    }

    public void setUniversité(Université université) {
        this.université = université;
    }

    public Personne() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Personne(Long ID, String nom) {
        this.ID = ID;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne personne)) return false;
        return Objects.equals(ID, personne.ID) && Objects.equals(université, personne.université) && Objects.equals(nom, personne.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, université, nom);
    }
}
