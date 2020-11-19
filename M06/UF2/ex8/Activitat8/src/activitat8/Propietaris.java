/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat8;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alumne
 */
@Entity
public class Propietaris implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;
    
    private int cp;
    private String nombre;
    private Date naixement;
    private boolean discapacitado;
    
    public Propietaris(){
    }

    public Propietaris(int cp, String nombre, Date naixement, boolean discapacitado) {
        this.cp = cp;
        this.nombre = nombre;
        this.naixement = naixement;
        this.discapacitado = discapacitado;
    }

    public long getId() {
        return id;
    }

    public int getCp() {
        return cp;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getNaixement() {
        return naixement;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }

    @Override
    public String toString() {
        return "Propietaris{" + "id=" + id + ", cp=" + cp + ", nombre=" + 
                nombre + ", naixement=" + naixement + ", discapacitado=" + 
                discapacitado + '}';
    }
    
    
    
    
}
