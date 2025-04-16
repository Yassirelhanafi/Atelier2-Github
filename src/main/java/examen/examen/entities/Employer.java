package examen.examen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Employer extends Personne{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="bureau_id")
    private Bureau bureau;


    public Bureau getBureau() {
        return bureau;
    }

    public void setBureau(Bureau bureau) {
        this.bureau = bureau;
    }

    public Employer(Bureau bureau) {
        this.bureau = bureau;
    }

    public Employer(Long ID, String nom, Bureau bureau) {
        super(ID, nom);
        this.bureau = bureau;
    }

    public Employer(Long ID, String nom){
        super(ID,nom);
    }

    public Employer() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer employer)) return false;
        return Objects.equals(bureau, employer.bureau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bureau);
    }
}
