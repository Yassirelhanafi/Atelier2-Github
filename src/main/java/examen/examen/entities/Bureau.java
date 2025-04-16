package examen.examen.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Bureau {
    @Id
    @Column(nullable = false,unique = true)
    private Long ID;
    private String nom;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Université_id")
    private Université BrUniversité;
    @OneToMany(mappedBy ="bureau")
    private List<Employer> employees=new ArrayList<>();
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="departement_name")
    private Departement departement;



    public Université getBrUniversité() {
        return BrUniversité;
    }

    public void setBrUniversité(Université brUniversité) {
        BrUniversité = brUniversité;
    }

    public List<Employer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employer> employees) {
        this.employees = employees;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }



    public Bureau() {

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

    public Bureau(Long ID, String nom) {
        this.ID = ID;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Bureau{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", BrUniversité=" + BrUniversité +
                ", employees=" + employees +
                ", departement=" + departement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bureau bureau)) return false;
        return Objects.equals(ID, bureau.ID) && Objects.equals(nom, bureau.nom) && Objects.equals(BrUniversité, bureau.BrUniversité) && Objects.equals(employees, bureau.employees) && Objects.equals(departement, bureau.departement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nom, BrUniversité, employees, departement);
    }
}
