package examen.examen.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Université{
    private static volatile Université instance;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nom;
    @OneToMany(mappedBy = "université")

    private List<Salle> salles=new ArrayList<>();
    @OneToMany(mappedBy = "BrUniversité")
    @JsonIgnore
    private List<Bureau> bureaux=new ArrayList<>();

    @OneToOne
    @JoinColumn(name="id_personne" ,referencedColumnName = "ID")
    private Personne personne;
    @OneToMany(mappedBy ="université")
    private List<Departement> departements=new ArrayList<>();

    public static Université getInstance() {
        if (instance == null) {
            synchronized (Université.class) {
                if (instance == null) {
                    instance = new Université();
                }
            }
        }
        return instance;
    }


    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public List<Bureau> getBureaux() {
        return bureaux;
    }

    public void setBureaux(List<Bureau> bureaux) {
        this.bureaux = bureaux;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

    public Université() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Université(Long id, String nom) {
        Id = id;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Université that)) return false;
        return Objects.equals(Id, that.Id) && Objects.equals(nom, that.nom) && Objects.equals(salles, that.salles) && Objects.equals(bureaux, that.bureaux) && Objects.equals(personne, that.personne) && Objects.equals(departements, that.departements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nom, salles, bureaux, personne, departements);
    }
}
