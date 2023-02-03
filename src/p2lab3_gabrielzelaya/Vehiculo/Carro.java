package p2lab3_gabrielzelaya.Vehiculo;

public class Carro extends Vehiculo{
    
    private int puertas;
    private String descripcionMotor;
    private double velocidadMax;

    public Carro(int puertas, String descripcionMotor, double velocidadMax, String color, String marca, String modelo, int año, int numLlantas) {
        super(color, marca, modelo, año, numLlantas);
        this.puertas = puertas;
        this.descripcionMotor = descripcionMotor;
        this.velocidadMax = velocidadMax;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setDescripcionMotor(String descripcionMotor) {
        this.descripcionMotor = descripcionMotor;
    }

    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public int getPuertas() {
        return puertas;
    }

    public String getDescripcionMotor() {
        return descripcionMotor;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }
       
}
