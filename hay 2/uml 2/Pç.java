/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pç;
public class Pç {
    public static void main(String[] args) {
        // Crear usuario
        Usuario usuario = new Usuario(1, "Juan", "Pérez", "juan.perez@example.com", "password123");

        // Crear opción de movilidad
        OpcionMovilidad ktaxi = new Ktaxi(1, "Ktaxi", "Servicio de taxi", 2.5, 10, 5);

        // Crear servicio de movilidad
        ServicioMovilidad servicio = new ServicioMovilidad(usuario, ktaxi);

        // Solicitar servicio
        servicio.solicitarServicio();

        // Calificar servicio
        servicio.calificarServicio();

        // Mostrar detalle de factura
        servicio.mostrarDetalleFactura();
    }
}

// Clase Usuario
class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    public Usuario(int id, String nombre, String apellido, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

// Clase OpcionMovilidad
abstract class OpcionMovilidad {
    protected int id;
    protected String nombre;
    protected String descripcion;

    public OpcionMovilidad(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract double calcularTarifa();

    public abstract void mostrarDetalleFactura();
}

// Clase Ktaxi extiende OpcionMovilidad
class Ktaxi extends OpcionMovilidad {
    private double tarifaPorKm;
    private double tiempoTranscurrido;
    private double longitudRecorrida;

    public Ktaxi(int id, String nombre, String descripcion, double tarifaPorKm, double tiempoTranscurrido, double longitudRecorrida) {
        super(id, nombre, descripcion);
        this.tarifaPorKm = tarifaPorKm;
        this.tiempoTranscurrido = tiempoTranscurrido;
        this.longitudRecorrida = longitudRecorrida;
    }

    @Override
    public double calcularTarifa() {
        return tarifaPorKm * longitudRecorrida + tiempoTranscurrido * 0.1;
    }

    @Override
    public void mostrarDetalleFactura() {
        System.out.println("Detalle de factura:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Tarifa por Km: " + tarifaPorKm);
        System.out.println("Tiempo transcurrido: " + tiempoTranscurrido);
        System.out.println("Longitud recorrida: " + longitudRecorrida);
        System.out.println("Total: " + calcularTarifa());
    }
}

// Clase ServicioMovilidad
class ServicioMovilidad {
    private Usuario usuario;
    private OpcionMovilidad opcionMovilidad;

    public ServicioMovilidad(Usuario usuario, OpcionMovilidad opcionMovilidad) {
        this.usuario = usuario;
        this.opcionMovilidad = opcionMovilidad;
    }

    public void solicitarServicio() {
        System.out.println("Servicio solicitado con éxito");
    }

    public void calificarServicio() {
        System.out.println("Servicio calificado con éxito");
    }

    public void mostrarDetalleFactura() {
        opcionMovilidad.mostrarDetalleFactura();
    }
}
