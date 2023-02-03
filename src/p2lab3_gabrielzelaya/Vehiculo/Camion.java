package p2lab3_gabrielzelaya.Vehiculo;

public class Camion extends Vehiculo{
    
    private double volumenMax;
    private double altura;
    private boolean retroexcavadora;
    private double precio = 5000;

    public Camion(double volumenMax, double altura, boolean retroexcavadora, String color, String marca, String modelo, int año, int numLlantas) {
        super(color, marca, modelo, año, numLlantas);
        this.volumenMax = volumenMax;
        this.altura = altura;
        this.retroexcavadora = retroexcavadora;
    }

    public void setVolumenMax(double volumenMax) {
        this.volumenMax = volumenMax;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setRetroexcavadora(boolean retroexcavadora) {
        this.retroexcavadora = retroexcavadora;
    }

    public double getVolumenMax() {
        return volumenMax;
    }

    public double getAltura() {
        return altura;
    }

    public boolean isRetroexcavadora() {
        return retroexcavadora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString()+"Camion{" + "volumenMax=" + volumenMax + ", altura=" + altura + ", retroexcavadora=" + retroexcavadora + ", precio=" + precio + '}';
    }
    
}
