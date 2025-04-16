package examen.examen.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Prof  extends Personne{

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Depatement_name")
    private Departement departement;

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Prof(Long ID, String nom){
        super(ID,nom);
    }

    public Prof() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prof prof)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(departement, prof.departement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departement);
    }
}
