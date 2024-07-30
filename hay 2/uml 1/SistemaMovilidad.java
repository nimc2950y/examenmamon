/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examn;
public class SistemaMovilidad {
    public static void main(String[] args) {
        // Crear usuarios
        Usuario usuario1 = new Usuario(1, "Juan Perez", "1234567890", "Estudiante", "password123");
        usuario1.registrar();

        // Crear servicios de movilidad
        Ktaxi kTaxi = new Ktaxi(true);
        kTaxi.setRecorrido(5.0); // 5 km
        kTaxi.setTiempo(10.0); // 10 minutos

        Situ situ = new Situ(true); // con descuento

        AppBusesUTPL appBuses = new AppBusesUTPL();

        // Emitir facturas
        Factura facturaKtaxi = kTaxi.emitirFactura(usuario1);
        facturaKtaxi.mostrarFactura();

        Factura facturaSitu = situ.emitirFactura(usuario1);
        facturaSitu.mostrarFactura();

        Factura facturaBuses = appBuses.emitirFactura(usuario1);
        facturaBuses.mostrarFactura();
    }
}

class Usuario {
    private String nombre;
    private String identificacion;
    private String tipoUsuario; // Ej. "Estudiante", "Publico", etc.

    public Usuario(int par, String nombre, String identificacion, String tipoUsuario, String password123) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoUsuario = tipoUsuario;
    }

    public void registrar() {
        // Código para registrar al usuario
        System.out.println("Usuario registrado: " + this.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    // Getters y setters
}

abstract class ServicioMovilidad {
    protected String empresa;
    protected double tarifaPorKm;
    protected double tiempo; // en minutos
    protected double recorrido; // en km

    public ServicioMovilidad(String empresa, double tarifaPorKm) {
        this.empresa = empresa;
        this.tarifaPorKm = tarifaPorKm;
    }

    public abstract double calcularTarifa();

    public Factura emitirFactura(Usuario usuario) {
        double tarifa = calcularTarifa();
        return new Factura(usuario, this.empresa, this.recorrido, this.tiempo, tarifa);
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    // Getters y setters
}

class Ktaxi extends ServicioMovilidad {
    private boolean taximetroDigital;

    public Ktaxi(boolean taximetroDigital) {
        super("Ktaxi", 1.5); // tarifaPorKm = 1.5 como ejemplo
        this.taximetroDigital = taximetroDigital;
    }

    @Override
    public double calcularTarifa() {
        return this.recorrido * this.tarifaPorKm + this.tiempo * 0.5; // Ejemplo de cálculo
    }
}

class Situ extends ServicioMovilidad {
    private boolean descuento; // True si aplica descuento del 50%

    public Situ(boolean descuento) {
        super("Situ", 0.3); // tarifa fija de $0.30
        this.descuento = descuento;
    }

    @Override
    public double calcularTarifa() {
        double tarifa = 0.30; // tarifa fija
        if (this.descuento) {
            tarifa *= 0.5; // aplica descuento del 50%
        }
        return tarifa;
    }
}

class AppBusesUTPL extends ServicioMovilidad {
    private String central;

    public AppBusesUTPL() {
        super("UTPL", 0); // Servicio gratuito
        this.central = "Estacionamiento UTPL";
    }

    @Override
    public double calcularTarifa() {
        return 0; // Servicio gratuito
    }
}

class Factura {
    private Usuario usuario;
    private String empresa;
    private double recorrido;
    private double tiempo;
    private double tarifa;

    public Factura(Usuario usuario, String empresa, double recorrido, double tiempo, double tarifa) {
        this.usuario = usuario;
        this.empresa = empresa;
        this.recorrido = recorrido;
        this.tiempo = tiempo;
        this.tarifa = tarifa;
    }

    public void mostrarFactura() {
        System.out.println("Factura:");
        System.out.println("Usuario: " + this.usuario.getNombre());
        System.out.println("Empresa: " + this.empresa);
        System.out.println("Recorrido: " + this.recorrido + " km");
        System.out.println("Tiempo: " + this.tiempo + " min");
        System.out.println("Tarifa: $" + this.tarifa);
    }
}
