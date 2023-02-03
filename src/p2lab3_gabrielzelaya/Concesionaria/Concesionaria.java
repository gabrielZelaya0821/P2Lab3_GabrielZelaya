package p2lab3_gabrielzelaya.Concesionaria;

import java.util.ArrayList;
import p2lab3_gabrielzelaya.Cliente.Cliente;
import p2lab3_gabrielzelaya.Vehiculo.Vehiculo;

public class Concesionaria {
    
    private String nombre;
    private int empresaId;
    private String direccion;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private double saldo;

    public Concesionaria(String nombre, String direccion, double saldo) {
        this.empresaId++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.saldo = saldo;
    }

    public Concesionaria() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Concesionaria{" + "nombre=" + nombre + ", empresaId=" + empresaId + ", direccion=" + direccion + ", vehiculos=" + vehiculos + ", clientes=" + clientes + ", saldo=" + saldo + '}';
    }
}
