package p2lab3_gabrielzelaya.Vehiculo;

import java.awt.Color;

public class Bici extends Vehiculo{
    
    private String descripcion;
    private double radius;
    private String tipo;

    public Bici(String descripcion, double radius, String tipo, Color color, 
            String marca, String modelo, int año, int numLlantas) {
        super(color, marca, modelo, año, numLlantas);
        this.descripcion = descripcion;
        this.radius = radius;
        this.tipo = tipo;
    }
}
