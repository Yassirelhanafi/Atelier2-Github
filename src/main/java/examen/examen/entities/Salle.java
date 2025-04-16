package examen.examen.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Salle {
    @Id
    @Column(nullable = false,unique = true)
    private Long ID;
    private Long nbSiege;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Université_id")
    private Université université;

    public Université getUniversité() {
        return université;
    }

    public void setUniversité(Université université) {
        this.université = université;
    }

    public Salle() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getNbSiege() {
        return nbSiege;
    }

    public void setNbSiege(Long nbSiege) {
        this.nbSiege = nbSiege;
    }

    public Salle(Long ID, Long nbSiege) {
        this.ID = ID;
        this.nbSiege = nbSiege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salle salle)) return false;
        return Objects.equals(ID, salle.ID) && Objects.equals(nbSiege, salle.nbSiege) && Objects.equals(université, salle.université);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, nbSiege, université);
    }
}
