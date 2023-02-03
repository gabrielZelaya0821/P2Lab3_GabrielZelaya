package p2lab3_gabrielzelaya.Vehiculo;

import java.awt.Color;

public class Vehiculo {
    
    private Color color;
    private String marca;
    private String modelo;
    private int año;
    private int numLlantas;

    public Vehiculo(Color color, String marca, String modelo, int año, int numLlantas) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.numLlantas = numLlantas;
    }

    public Vehiculo() {
    }

    public Color getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public int getNumLlantas() {
        return numLlantas;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setNumLlantas(int numLlantas) {
        this.numLlantas = numLlantas;
    }    
}
