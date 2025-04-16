package examen.examen.entities;


import jakarta.persistence.Entity;

@Entity
public class Adjoint extends Prof{
    public Adjoint(Long ID, String nom){
        super(ID,nom);
    }

    public Adjoint() {
        super();

    }

}
