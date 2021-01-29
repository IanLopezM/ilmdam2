package entity;
// Generated 28/01/2021 18:11:38 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;






/**
 * Movimiento generated by hbm2java
 */
@Entity
@Table(name="movimiento")
public class Movimiento  implements java.io.Serializable {

     private Integer idMovimiento;
     private Partida partida;
     private int columnaOrigen;
     private int columnaDestino;
     private int filaOrigen;
     private int filaDestino;

    public Movimiento() {
    }

    public Movimiento(Partida partida, int columnaOrigen, int columnaDestino, int filaOrigen, int filaDestino) {
       this.partida = partida;
       this.columnaOrigen = columnaOrigen;
       this.columnaDestino = columnaDestino;
       this.filaOrigen = filaOrigen;
       this.filaDestino = filaDestino;
    }
   
    @Id
    @GeneratedValue
    @Column(name="idMovimiento")
    public Integer getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    
    @Column(name="idPartida")
    public Partida getPartida() {
        return this.partida;
    }
    
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    @Column(name="columnaOrigen")
    public int getColumnaOrigen() {
        return this.columnaOrigen;
    }
    
    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }
    
    @Column(name="columnaDestino")
    public int getColumnaDestino() {
        return this.columnaDestino;
    }
    
    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }
    
    @Column(name="filaOrigen")
    public int getFilaOrigen() {
        return this.filaOrigen;
    }
    
    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }
    
    @Column(name="filaDestino")
    public int getFilaDestino() {
        return this.filaDestino;
    }
    
    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    


}


