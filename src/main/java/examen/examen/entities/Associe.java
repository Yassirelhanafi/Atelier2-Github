package examen.examen.entities;


import jakarta.persistence.Entity;

@Entity
public class Associe extends Prof{

    public Associe(Long ID, String nom){
        super(ID,nom);
    }

    public Associe() {

    }
}
