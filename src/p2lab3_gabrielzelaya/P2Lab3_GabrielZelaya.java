package p2lab3_gabrielzelaya;

import java.util.ArrayList;
import java.util.Scanner;
import p2lab3_gabrielzelaya.Cliente.Cliente;
import p2lab3_gabrielzelaya.Concesionaria.Concesionaria;
import p2lab3_gabrielzelaya.Vehiculo.Vehiculo;

public class P2Lab3_GabrielZelaya {
    
    public static Scanner str = new Scanner(System.in);
    public static Scanner num = new Scanner(System.in);
    public static ArrayList<Concesionaria> concesionarias = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        
    }
    
    public static void menu(){
        
    }
    
    public static void crudConcesionaria(){
        System.out.println("(1)Crear (2)Modificar (3)Borrar (4)Salir");
        int menu = num.nextInt();
        switch (menu){
            case 1 -> createConcesionaria();
            case 2 -> updateConcesionaria();
            case 3 -> deleteConcesionaria();
            case 4 -> System.out.println("Saliendo al menú...");
            default -> {
                System.out.println("Número inválido");
                crudConcesionaria();
            }
        }
    }
    
    public static void createConcesionaria(){
        System.out.println("-----Crear-----");
        System.out.println("Ingrese un nombre para la empresa: ");
        String nombre = str.nextLine();
        System.out.println("Ingrese la dirección de la empresa: ");
        String direccion = str.nextLine();
        System.out.println("Ingrese el saldo de la empresa: ");
        double saldo = num.nextDouble();
        Concesionaria concesionaria = new Concesionaria(nombre, direccion, saldo);
        concesionarias.add(concesionaria);
    }
    
    public static void listarConcesionaria(){
        for (Concesionaria empresa : concesionarias) {
            System.out.println(concesionarias.indexOf(empresa)+"-> "+empresa);
        }
    }
    
    public static void updateConcesionaria(){
        System.out.println("-----Modificar-----");
        listarConcesionaria();
        System.out.println("¿Qué desea modificar?");
        int modificar = num.nextInt();
        if (modificar >= 0 && modificar < concesionarias.size()){
            System.out.println("(1)Dirección (2)Salir");
            int menu = num.nextInt();
            switch (menu){
                case 1 ->{
                    System.out.println("Ingrese la nueva dirección: ");
                    String direccion = str.nextLine();
                    concesionarias.get(menu).setDireccion(direccion);
                }
                case 2 -> crudConcesionaria();
                default ->{
                    System.out.println("Número inválido, regresando al menú");
                    updateConcesionaria();
                }
            }
        }else{
            System.out.println("Número inválido, regresando al menú");
            crudConcesionaria();
        }
    }
    
    public static void deleteConcesionaria(){
        System.out.println("----Borrar-----");
        listarConcesionaria();
        System.out.println("¿Qué desea borrar?");
        int borrar = num.nextInt();
        if (borrar >= 0 && borrar < concesionarias.size()){
            concesionarias.remove(borrar);
        }else{
            System.out.println("Número inválido, regresando al menú");
            crudConcesionaria();
        }
    }
    
    public static void crudClientes(){
        System.out.println("(1)Crear (2)Borrar (3)Salir");
        int menu = num.nextInt();
        switch (menu){
            case 1 -> createCliente();
            case 2 -> deleteCLiente();
            case 3 -> System.out.println("Saliendo al menú...");
            default -> {
                System.out.println("Número inválido");
                crudClientes();
            }
        }
    }
    
    public static void createCliente(){
        System.out.println("-----Crear-----");
        System.out.println("Ingrese su nombre: ");
        String nombre = str.nextLine();
        System.out.println("Ingrese su saldo: ");
        double saldo = num.nextDouble();
        Cliente cliente = new Cliente (nombre, saldo);
        clientes.add(cliente);
    }
    
    public static void deleteCLiente(){
        for (Cliente cliente : clientes) {
            System.out.println(clientes.indexOf(cliente)+"-> "+cliente);
        }
        int borrar = num.nextInt();
        if(borrar >= 0 && borrar < clientes.size()){
            clientes.remove(borrar);
        }else{
            System.out.println("Número inválido, regresando al menú");
            crudClientes();
        }
    }
    
    public static void crudVehiculos(){
        System.out.println("(1)Crear (2)Modificar (3)Borrar (4)Salir");
        int menu = num.nextInt();
        switch (menu){
            case 1 -> createCliente();
            case 2 -> deleteCLiente();
            case 3 -> System.out.println("Saliendo al menú...");
            default -> {
                System.out.println("Número inválido");
                crudClientes();
            }
        }
    }
    
    public static void createVehiculo(){
        System.out.println("-----Crear-----");
        
    }
}
