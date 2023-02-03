package p2lab3_gabrielzelaya;

import java.util.ArrayList;
import java.util.Scanner;
import p2lab3_gabrielzelaya.Cliente.Cliente;
import p2lab3_gabrielzelaya.Concesionaria.Concesionaria;
import p2lab3_gabrielzelaya.Vehiculo.Bici;
import p2lab3_gabrielzelaya.Vehiculo.Bus;
import p2lab3_gabrielzelaya.Vehiculo.Camion;
import p2lab3_gabrielzelaya.Vehiculo.Carro;
import p2lab3_gabrielzelaya.Vehiculo.Moto;
import p2lab3_gabrielzelaya.Vehiculo.Vehiculo;

public class P2Lab3_GabrielZelaya {
    
    public static Scanner str = new Scanner(System.in);
    public static Scanner num = new Scanner(System.in);
    public static ArrayList<Concesionaria> concesionarias = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        menu();
    }
    
    public static void menu() throws Exception{
        int menu;
        do{
            System.out.println("(1)CrudConcesionaria \n(2)CrudClientes \n(3)CrudVehiculos \n(4)Compra/Venta \n(5)Salir");
            menu = num.nextInt();
            switch (menu){
                case 1 -> crudConcesionaria();
                case 2 -> crudClientes();
                case 3 -> crudVehiculos();
                case 4 ->{
                    System.out.println("(1)Comprar (2)Vender");
                    int decision = num.nextInt();
                    switch (decision){
                        case 1 -> comprarVehiculo();
                    }
                }
                case 5 -> System.out.println("Saliendo del menú");
                default ->{
                    System.out.println("Número no es válido");
                    menu();
                }
            }
        }while(menu<6);
    }
    
    public static Cliente clienteAccede() throws Exception {
        for (Cliente cliente : clientes) {
            System.out.println(clientes.indexOf(cliente)+"-> "+cliente);
        }
        System.out.println("¿Que cliente desea comprar/vender?");
        int cliente = num.nextInt();
        if (cliente >= 0 && cliente < clientes.size()){
            return clientes.get(cliente);
        }else{
            throw new Exception("Cliente no encontrado");
        }
    }
    
    public static double definirCosto(Vehiculo vehiculo){
        double costo = 0;
        if (vehiculo instanceof Bici bici){
            costo = bici.getPrecio();
        }else if (vehiculo instanceof Bus bus){
            costo = bus.getPrecio();
        }else if (vehiculo instanceof Camion camion){
            costo = camion.getPrecio();
        }else if (vehiculo instanceof Carro carro){
            costo = carro.getPrecio();
        }else if (vehiculo instanceof Moto moto){
            costo = moto.getPrecio();
        }
        return costo;
    }
    
    public static void comprarVehiculo() throws Exception{
        listarConcesionaria();
        Cliente cliente = clienteAccede();
        System.out.println("¿De cuál concesoria desea comprar el carro");
        int opcion = num.nextInt();
        if (opcion >= 0 && opcion < concesionarias.size()){
            for (Vehiculo vehiculo : concesionarias.get(opcion).getVehiculos()) {
                System.out.println(concesionarias.get(opcion).
                        getVehiculos().indexOf(vehiculo)+"-> "+vehiculo);
            }
            System.out.println("¿Qué vehiculo desea comprar?");
            int compra = num.nextInt();
            if (compra >= 0 && compra < concesionarias.get(opcion).getVehiculos().size()){
                double costo = definirCosto(concesionarias.get(opcion).getVehiculos().get(compra));
                double costoFinal;
                if(cliente.getSaldo() >= costo){
                    costoFinal = cliente.getSaldo() - costo;
                    cliente.setSaldo(costoFinal);
                    concesionarias.get(opcion).getClientes().add(cliente);
                }else{
                    System.out.println("No tiene suficiente saldo");
                }
                
            }else{
                System.out.println("Número no es válido");
            }
        }
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
            case 2 -> updateVehiculos();
            case 3 -> deleteCLiente();
            case 4 -> System.out.println("Saliendo al menú...");
            default -> {
                System.out.println("Número inválido");
                crudClientes();
            }
        }
    }
    
    public static void createVehiculo(){
        System.out.println("-----Crear-----");
        System.out.println("Ingrese el color del vehículo: ");
        String color = str.nextLine();
        System.out.println("Ingrese la marca del vehículo: ");
        String marca = str.nextLine();
        System.out.println("Ingrese el modelo del vehículo: ");
        String modelo = str.nextLine();
        System.out.println("Ingrese el año de creación: ");
        int año = num.nextInt();
        System.out.println("Ingrese el número de llantas: ");
        int llantas = num.nextInt();
        switch (llantas){
            case 2 -> crearVehiculoDosLlantas(color,marca,modelo,año);
            case 4 -> crearVehiculoCuatroLlantas(color, marca, modelo, año);
            default -> {
                System.out.println("Número no es válido");
                createVehiculo();
            }
        }
    }
    
    public static void crearVehiculoDosLlantas(String color,String marca,String modelo,int año){
        System.out.println("(1)Bici (2)Moto");
        int opcion = num.nextInt();
        switch (opcion){
            case 1 -> {
                System.out.println("Ingrese una descripción: ");
                String descripcion = str.nextLine();
                System.out.println("Ingrese el radio de la llanta: ");
                double radius = num.nextDouble();
                System.out.println("Ingrese el tipo de la bici: ");
                System.out.println("(1)BMX (2)Calle");
                int tipoBici = num.nextInt();
                String tipo = "";
                switch (tipoBici){
                    case 1 -> tipo = "BMX";
                    case 2 -> tipo = "De calle";
                    default ->{
                        System.out.println("Número inválido");
                        crearVehiculoDosLlantas(color,marca,modelo,año);
                    }
                }
                Bici bici = new Bici(descripcion, radius, tipo, color, marca, modelo, año, 2);
                listarConcesionaria();
                int posicion = num.nextInt();
                if (posicion >= 0 && posicion < concesionarias.size()){
                    concesionarias.get(posicion).getVehiculos().add(bici);
                }else{
                    System.out.println("Número no es válido");
                }
                System.out.println("Ingrese a cuál concecionaria la enviara: ");
            }
            case 2 ->{
                System.out.println("Ingrese el desplazamiento del motor: ");
                String desplazamiento = str.nextLine();
                System.out.println("¿La moto es electrica? s/n");
                char opcionMoto = str.nextLine().toLowerCase().charAt(0);
                boolean electrica = true;
                switch (opcionMoto){
                    case 's' -> electrica = true;
                    case 'n' -> electrica = false;
                    default ->{
                        System.out.println("Opción no es válida");
                        crearVehiculoDosLlantas(color, marca, modelo, año);
                    }
                }
                Moto moto = new Moto(desplazamiento, electrica, color, marca, modelo, año, 2);
                listarConcesionaria();
                int posicion = num.nextInt();
                if (posicion >= 0 && posicion < concesionarias.size()){
                    concesionarias.get(posicion).getVehiculos().add(moto);
                }else{
                    System.out.println("Número no es válido");
                }
                System.out.println("Ingrese a cuál concecionaria la enviara: ");
            }
        }
    }
    
    public static void crearVehiculoCuatroLlantas(String color,String marca,String modelo,int año){
        System.out.println("(1)Carro (2)Bus (3)Camión");
        int opcion = num.nextInt();
        switch (opcion){
            case 1 ->{
                System.out.println("Ingrese el número de puertas: ");
                int puertas = num.nextInt();
                System.out.println("Ingrese la descripción del motor");
                String descripcionMotor = str.nextLine();
                System.out.println("Ingrese la velocidad máxima: ");
                double velocidadMax = num.nextDouble();
                Carro carro = new Carro(puertas, descripcionMotor, velocidadMax, color, marca, modelo, año, 4);
                listarConcesionaria();
                int posicion = num.nextInt();
                if (posicion >= 0 && posicion < concesionarias.size()){
                    concesionarias.get(posicion).getVehiculos().add(carro);
                }else{
                    System.out.println("Número no es válido");
                }
                System.out.println("Ingrese a cuál concecionaria la enviara: ");
            }
            case 2 ->{
                System.out.println("Ingrese la capacidad máxima de pasajeros: ");
                int pasajeros = num.nextInt();
                Bus bus = new Bus(color, marca, modelo, año, 4, pasajeros);
                listarConcesionaria();
                int posicion = num.nextInt();
                if (posicion >= 0 && posicion < concesionarias.size()){
                    concesionarias.get(posicion).getVehiculos().add(bus);
                }else{
                    System.out.println("Número no es válido");
                }
                System.out.println("Ingrese a cuál concecionaria la enviara: ");
            }
            case 3 ->{
                System.out.println("Ingrese el volumen máximo: ");
                double volumenMax = num.nextDouble();
                System.out.println("Ingrese la altura: ");
                double altura = num.nextDouble();
                System.out.println("¿Tiene retroexcavadora? s/n");
                char opcionRetro = str.nextLine().toLowerCase().charAt(0);
                boolean retroExcavadora = false;
                switch (opcionRetro){
                    case 's' -> retroExcavadora = true;
                    case 'n' -> retroExcavadora = false;
                    default ->{
                        System.out.println("Número no es válida");
                        crearVehiculoCuatroLlantas(color, marca, modelo, año);
                    }
                }
                Camion camion = new Camion(volumenMax, altura, retroExcavadora, color, marca, modelo, año, opcion);
                listarConcesionaria();
                int posicion = num.nextInt();
                if (posicion >= 0 && posicion < concesionarias.size()){
                    concesionarias.get(posicion).getVehiculos().add(camion);
                }else{
                    System.out.println("Número no es válido");
                }
                System.out.println("Ingrese a cuál concecionaria la enviara: ");
            }
        }
        
        
    }

    public static void listarVehiculos(){
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculos.indexOf(vehiculo)+"-> "+vehiculo);
        }
    }
    
    public static void updateVehiculos(){
        System.out.println("-----Modificar-----");
        listarVehiculos();
        System.out.println("¿Qué desea modificar?");
        int opcion = num.nextInt();
        if (opcion >= 0 && opcion < vehiculos.size()){
            if (vehiculos.get(opcion) instanceof Bici bici){
                updateBici(bici);
            }else if (vehiculos.get(opcion) instanceof Bus bus){
                updateBus(bus);
            }else if (vehiculos.get(opcion) instanceof Camion camion){
                updateCamion(camion);
            }else if (vehiculos.get(opcion) instanceof Carro carro){
                updateCarro(carro);
            }else if (vehiculos.get(opcion) instanceof Moto moto){
                updateMoto(moto);
            }
        }
    }
    
    public static void updateBici(Bici bici){
        System.out.println("(1)Descripcion (2)Radio (3)Tipo");
        int opcion = num.nextInt();
        switch (opcion){
            case 1 ->{
                System.out.println("Ingrese una descripción: ");
                String descripcion = str.nextLine();
                bici.setDescripcion(descripcion);
            }
            case 2 ->{
                System.out.println("Ingrese el radio de las llantas: ");
                double radius = num.nextDouble();
                bici.setRadius(radius);
            }
            case 3 ->{
                System.out.println("Ingrese el tipo de la bici: ");
                System.out.println("(1)BMX (2)Calle");
                int tipoBici = num.nextInt();
                String tipo = "";
                switch (tipoBici){
                    case 1 -> tipo = "BMX";
                    case 2 -> tipo = "De calle";
                    default ->{
                        System.out.println("Número inválido");
                        updateBici(bici);
                    }
                }
                bici.setTipo(tipo);
            }
            default ->{
                System.out.println("Número no es válido");
                updateBici(bici);
            }
        }
    }

    public static void updateBus(Bus bus){
        System.out.println("Ingrese la capacidad máxima de pasajeros: ");
        int pasajeros = num.nextInt();
        bus.setPasajeros(pasajeros);
    }
    
    public static void updateCamion(Camion camion){
        System.out.println("(1)Volumen (2)Altura (3)Retroexcavadora");
        int opcion = num.nextInt();
        switch(opcion){
            case 1 ->{
                System.out.println("Ingrese el volumen máximo: ");
                double volumenMax = num.nextDouble();
                camion.setVolumenMax(volumenMax);
            }
            case 2 ->{
                System.out.println("Ingrese la altura: ");
                double altura = num.nextDouble();
                camion.setAltura(altura);
            }
            case 3 ->{
                System.out.println("¿Tiene retroexcavadora? s/n");
                char opcionRetro = str.nextLine().toLowerCase().charAt(0);
                boolean retroExcavadora = false;
                switch (opcionRetro){
                    case 's' -> retroExcavadora = true;
                    case 'n' -> retroExcavadora = false;
                    default ->{
                        System.out.println("Número no es válida");
                    }
                }
                camion.setRetroexcavadora(retroExcavadora);
            }
            default ->{
                System.out.println("Número no es válido");
                updateCamion(camion);
            }
        }
    }

    public static void updateCarro(Carro carro){
        System.out.println("(1)Puertas (2)Descripción (3)Velocidad");
        int opcion = num.nextInt();
        switch (opcion){
            case 1 ->{
                System.out.println("Ingrese el número de puertas: ");
                int puertas = num.nextInt();
                carro.setPuertas(puertas);
            }
            case 2 ->{
                System.out.println("Ingrese la descripción del motor");
                String descripcionMotor = str.nextLine();
                carro.setDescripcionMotor(descripcionMotor);
            }
            case 3 ->{
                System.out.println("Ingrese la velocidad máxima: ");
                double velocidadMax = num.nextDouble();
                carro.setVelocidadMax(velocidadMax);
            }
            default ->{
                System.out.println("Número no es válido");
                updateCarro(carro);
            }
        }
    }
    
    public static void updateMoto(Moto moto){
        System.out.println("(1)Desplazamiento (2)Electrica");
        int opcion = num.nextInt();
        switch (opcion){
            case 1 ->{
                System.out.println("Ingrese el desplazamiento del motor: ");
                String desplazamiento = str.nextLine();
                moto.setDesplazamiento(desplazamiento);
            }
            case 2 ->{
                System.out.println("¿La moto es electrica? s/n");
                char opcionMoto = str.nextLine().toLowerCase().charAt(0);
                boolean electrica = true;
                switch (opcionMoto){
                    case 's' -> electrica = true;
                    case 'n' -> electrica = false;
                    default ->{
                        System.out.println("Opción no es válida");
                    }
                }
                moto.setElectrica(electrica);
            }
            default ->{
                System.out.println("Número no es válido");
                updateMoto(moto);
            }
        }
    }
}
