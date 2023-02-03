package p2lab3_gabrielzelaya.Vehiculo;

public class Bici extends Vehiculo{
    
    private String descripcion;
    private double radius;
    private String tipo;
    private double precio = 500;

    public Bici(String descripcion, double radius, String tipo, String color, String marca, String modelo, int año, int numLlantas) {
        super(color, marca, modelo, año, numLlantas);
        this.descripcion = descripcion;
        this.radius = radius;
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getRadius() {
        return radius;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString()+"Bici{" + "descripcion=" + descripcion + ", radius=" + radius + ", tipo=" + tipo + ", precio=" + precio + '}';
    }

}
