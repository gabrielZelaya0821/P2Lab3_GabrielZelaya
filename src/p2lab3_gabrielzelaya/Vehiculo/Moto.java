package p2lab3_gabrielzelaya.Vehiculo;

public class Moto extends Vehiculo{
    
    private String desplazamiento;
    private boolean electrica;

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
}
