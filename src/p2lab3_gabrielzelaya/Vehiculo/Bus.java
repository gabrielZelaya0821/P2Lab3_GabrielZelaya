package p2lab3_gabrielzelaya.Vehiculo;

public class Bus extends Vehiculo{
    
    private String tipo;
    private int pasajeros;

    public Bus(String color, String marca, String modelo, int año, int numLlantas,int pasajeros) {
        super(color, marca, modelo, año, numLlantas);
        this.pasajeros = pasajeros;
        setTipo(pasajeros);
    }

    public void setTipo(int pasajeros) {
        if (pasajeros<51){
            this.tipo = "Rapidito";
        }else{
            this.tipo = "De ruta";
        }
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
        setTipo(pasajeros);
    }
    
}
