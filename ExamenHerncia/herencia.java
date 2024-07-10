
package examene2.pkg0;
public class herencia {
    public static void main(String[] args) {
        Secretario secretario = new Secretario("Ana", "Gomez", "12345678", "Calle Principal 123",
                                               5, "987654321", "Despacho 1", 160, 10.0, 10);
        
        Vendedor vendedor = new Vendedor("Juan", "Lopez", "23456789", "Avenida Secundaria 456",
                                         3, "654321987", "ABC123", "Toyota", "Corolla",
                                         "987654321", "Zona Norte", 0.05, 1500.0);
        
        Vendedor vendedor2 = new Vendedor("Maria", "Martinez", "34567890", "Plaza Central 789",
                                          2, "321987654", "DEF456", "Ford", "Fiesta",
                                          "654321987", "Zona Sur", 0.03, 1200.0);
        
        Vendedor[] vendedoresACargo = {vendedor, vendedor2};
        
        JefeZona jefeZona = new JefeZona("Pedro", "Rodriguez", "45678901", "Avenida Principal 789",
                                         7, "789012345", "Despacho 2", secretario, vendedoresACargo);
        
        // Mostrar los salarios calculados
        System.out.println("Salario del Secretario " + secretario.nombre + ": $" + secretario.calcularSalario());
        System.out.println("Salario del Vendedor " + vendedor.nombre + ": $" + vendedor.calcularSalario());
        System.out.println("Salario del Vendedor " + vendedor2.nombre + ": $" + vendedor2.calcularSalario());
        System.out.println("Salario del Jefe de Zona " + jefeZona.nombre + ": $" + jefeZona.calcularSalario());
    }
}

class Empleado {
    // Atributos comunes públicos
    public String nombre;
    public String apellidos;
    public String cedula;
    public String direccion;
    public int antiguedad;
    public String telefonoContacto;

    // Constructor
    public Empleado(String nombre, String apellidos, String cedula, String direccion,
                    int antiguedad, String telefonoContacto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.antiguedad = antiguedad;
        this.telefonoContacto = telefonoContacto;
    }

    // Método para calcular salario (a ser implementado en subclases)
    public double calcularSalario() {
        return 0.0;
    }
}

// Clase Secretario
class Secretario extends Empleado {
    // Atributos adicionales públicos para Secretario
    public String despacho;
    public int horasLaboradas;
    public double costoHora;
    public int horasExtras;

    // Constructor
    public Secretario(String nombre, String apellidos, String cedula, String direccion,
                      int antiguedad, String telefonoContacto, String despacho,
                      int horasLaboradas, double costoHora, int horasExtras) {
        super(nombre, apellidos, cedula, direccion, antiguedad, telefonoContacto);
        this.despacho = despacho;
        this.horasLaboradas = horasLaboradas;
        this.costoHora = costoHora;
        this.horasExtras = horasExtras;
    }

    // Método para calcular el salario del Secretario
    @Override
    public double calcularSalario() {
        double salarioBase = horasLaboradas * costoHora;
        double salarioHorasExtras = horasExtras * costoHora * 1.5; // 50% de incremento
        return salarioBase + salarioHorasExtras;
    }
}

// Clase Vendedor
class Vendedor extends Empleado {
    // Atributos adicionales públicos para Vendedor
    public String matriculaCoche;
    public String marcaCoche;
    public String modeloCoche;
    public String telefonoMovil;
    public String areaVenta;
    public double porcentajeComision;
    public double salarioBasico;

    // Constructor
    public Vendedor(String nombre, String apellidos, String cedula, String direccion,
                    int antiguedad, String telefonoContacto, String matriculaCoche,
                    String marcaCoche, String modeloCoche, String telefonoMovil,
                    String areaVenta, double porcentajeComision, double salarioBasico) {
        super(nombre, apellidos, cedula, direccion, antiguedad, telefonoContacto);
        this.matriculaCoche = matriculaCoche;
        this.marcaCoche = marcaCoche;
        this.modeloCoche = modeloCoche;
        this.telefonoMovil = telefonoMovil;
        this.areaVenta = areaVenta;
        this.porcentajeComision = porcentajeComision;
        this.salarioBasico = salarioBasico;
    }

    // Método para calcular el salario del Vendedor
    @Override
    public double calcularSalario() {
        // Suponiendo que el salario incluye el básico más las comisiones
        // Calcular las comisiones sobre ventas y sumar al salario básico
        return salarioBasico; // ajustar según la lógica real de comisiones
    }
}

// Clase JefeZona
class JefeZona extends Empleado {
    // Atributos adicionales públicos para JefeZona
    public String despacho;
    public Secretario secretario;
    public Vendedor[] vendedoresACargo; // Array de vendedores a cargo

    // Constructor
    public JefeZona(String nombre, String apellidos, String cedula, String direccion,
                    int antiguedad, String telefonoContacto, String despacho,
                    Secretario secretario, Vendedor[] vendedoresACargo) {
        super(nombre, apellidos, cedula, direccion, antiguedad, telefonoContacto);
        this.despacho = despacho;
        this.secretario = secretario;
        this.vendedoresACargo = vendedoresACargo;
    }

    // Método para calcular el salario del JefeZona
    @Override
    public double calcularSalario() {
        // Calcular el total de ventas globales de los vendedores a cargo
        double ventasTotales = 0.0;
        for (Vendedor vendedor : vendedoresACargo) {
            // Sumar las ventas de cada vendedor
            // ventasTotales += vendedor.getVentas(); // Suponiendo que hay un método getVentas()
        }
        
        // Calcular salario basado en un porcentaje de las ventas totales
        double salario = ventasTotales * 0.10; // 10% de las ventas globales
        return salario;
    }
}
