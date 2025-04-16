package examen.examen.entities;

import jakarta.persistence.Entity;

@Entity
public class PleinTemps extends Prof{
    public PleinTemps(Long ID, String nom){
        super(ID,nom);
    }

    public PleinTemps() {
        super();

    }



}
