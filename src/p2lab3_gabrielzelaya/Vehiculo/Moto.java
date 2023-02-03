package p2lab3_gabrielzelaya.Vehiculo;

public class Moto extends Vehiculo{
    
    private String desplazamiento;
    private boolean electrica;
    private double precio = 2000;

    public Moto(String desplazamiento, boolean electrica, String color, String marca, String modelo, int año, int numLlantas) {
        super(color, marca, modelo, año, numLlantas);
        this.desplazamiento = desplazamiento;
        this.electrica = electrica;
    }

    public void setDesplazamiento(String desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public void setElectrica(boolean electrica) {
        this.electrica = electrica;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDesplazamiento() {
        return desplazamiento;
    }

    public boolean isElectrica() {
        return electrica;
    }

    public double getPrecio() {
        return precio;
    }
    
}
