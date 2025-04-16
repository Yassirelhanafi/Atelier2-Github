package examen.examen.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Departement {
    @Id
    @Column(nullable = false,unique = true)
    private Long Id;
    private String nom;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Université_name")
    private Université université;
    @OneToMany(mappedBy ="departement")
    private List<Bureau> bureaux=new ArrayList<>();
    @OneToMany(mappedBy="departement")
    private List<Prof> profs=new ArrayList<>();

    public Departement() {

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

    public Université getUniversité() {
        return université;
    }

    public void setUniversité(Université université) {
        this.université = université;
    }

    public List<Bureau> getBureaux() {
        return bureaux;
    }

    public void setBureaux(List<Bureau> bureaux) {
        this.bureaux = bureaux;
    }

    public List<Prof> getProfs() {
        return profs;
    }

    public void setProfs(List<Prof> profs) {
        this.profs = profs;
    }

    public Departement(Long id, String nom, Université université) {
        Id = id;
        this.nom = nom;
        this.université = université;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement that)) return false;
        return Objects.equals(Id, that.Id) && Objects.equals(nom, that.nom) && Objects.equals(université, that.université) && Objects.equals(bureaux, that.bureaux) && Objects.equals(profs, that.profs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nom, université, bureaux, profs);
    }
}
