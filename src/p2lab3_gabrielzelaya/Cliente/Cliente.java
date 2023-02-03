package p2lab3_gabrielzelaya.Cliente;

import java.util.ArrayList;
import p2lab3_gabrielzelaya.Vehiculo.Vehiculo;

public class Cliente {
    
    private int clientId;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private int saldo;

    public Cliente(int clientId, String nombre, int saldo) {
        this.clientId = clientId;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Cliente() {
    }

    public int getClientId() {
        return clientId;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
