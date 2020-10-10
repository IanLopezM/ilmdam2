/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf_act1_coches;

/**
 *
 * @author Alumne
 */
import java.io.*;
import java.io.Serializable;
import java.util.Scanner;

public class Uf_act1_coches implements Serializable {
					//Implementa la interfície Serializable
	private String marca;
        private String model;
	private int any;
        private String matricula;
	
	//constructor amb paràmetres
	public Uf_act1_coches (String marca, String model, int any, String matricula){
		//per no confondre el paràmetre amb el camp de variable
		this.marca = marca;
		//per no confondre el paràmetre amb el camp de variable
		this.model = model;
                //per no confondre el paràmetre amb el camp de variable
		this.any = any;
		//per no confondre el paràmetre amb el camp de variable
		this.matricula = matricula;
	}
	public Uf_act1_coches (){//constructor per defecte
		this.marca = null;
	}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    

}

