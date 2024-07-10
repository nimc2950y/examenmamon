
package examene2.pkg0;
public class polimofismo {
    public static void main(String[] args) {
        // Crear un secretario
        Secretario secretario = new Secretario("Juan", "Pérez", "123456789", "Calle Falsa 123", 5, "555-1234", "Despacho 1", 160, 15, 10);

        // Crear coche
        Coche coche = new Coche("XYZ-123", "Toyota", "Corolla");

        // Crear vendedores
        Vendedor vendedor1 = new Vendedor("Ana", "Gómez", "987654321", "Avenida Siempre Viva 456", 3, "555-5678", coche, "555-7890", "Zona Norte", 5, 20000);
        Vendedor vendedor2 = new Vendedor("Luis", "Martínez", "112233445", "Boulevard Falso 789", 2, "555-2468", coche, "555-1357", "Zona Sur", 5, 25000);
        
        // Crear lista de vendedores
        Vendedor[] vendedores = {vendedor1, vendedor2};

        // Crear un jefe de zona
        JefeZona jefeZona = new JefeZona("Carlos", "Sánchez", "223344556", "Calle Verdadera 321", 10, "555-1122", "Despacho 2", secretario, vendedores);
        System.out.println("Informacion del secretario: \n" + secretario);
        System.out.println("Informacion del vendedor 1: \n" + vendedor1);
        System.out.println("Informacion del vendedor 2: \n" + vendedor2);
        System.out.println("Informacion del jefe de zona: \n" + jefeZona);
    }
}
abstract class Empleado {
    public String nombre;
    public String apellidos;
    public String cedula;
    public String direccion;
    public int añosAntiguedad;
    public String telefonoContacto;
    public double salario;

    public Empleado(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefonoContacto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.añosAntiguedad = añosAntiguedad;
        this.telefonoContacto = telefonoContacto;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellidos + "\n" +
               "Cedula: " + cedula + "\n" +
               "Direccion: " + direccion + "\n" +
               "Años de Antiguedad: " + añosAntiguedad + "\n" +
               "Telefono de Contacto: " + telefonoContacto + "\n" +
               "Salario: " + salario + "\n";
    }
}
class Secretario extends Empleado {
    public String despacho;
    public int horasTrabajadas;
    public double costoHora;
    public int horasExtras;

    public Secretario(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefonoContacto, String despacho, int horasTrabajadas, double costoHora, int horasExtras) {
        super(nombre, apellidos, cedula, direccion, añosAntiguedad, telefonoContacto);
        this.despacho = despacho;
        this.horasTrabajadas = horasTrabajadas;
        this.costoHora = costoHora;
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSalario() {
        double salarioBase = horasTrabajadas * costoHora;
        double salarioExtra = horasExtras * (costoHora * 1.5);
        this.salario = salarioBase + salarioExtra;
        return this.salario;
    }
    @Override
    public String toString() {
        return super.toString() +
               "Despacho: " + despacho + "\n" +
               "Horas Trabajadas: " + horasTrabajadas + "\n" +
               "Costo por Hora: " + costoHora + "\n" +
               "Horas Extras: " + horasExtras + "\n";
    }
}
 class Vendedor extends Empleado {
    public Coche coche;
    public String telefonoMovil;
    public String areaVenta;
    public double porcentajeComision;
    public double ventasMensuales;

    public Vendedor(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefonoContacto, Coche coche, String telefonoMovil, String areaVenta, double porcentajeComision, double ventasMensuales) {
        super(nombre, apellidos, cedula, direccion, añosAntiguedad, telefonoContacto);
        this.coche = coche;
        this.telefonoMovil = telefonoMovil;
        this.areaVenta = areaVenta;
        this.porcentajeComision = porcentajeComision;
        this.ventasMensuales = ventasMensuales;
    }
    @Override
    public double calcularSalario() {
        double comision = ventasMensuales * (porcentajeComision / 100);
        this.salario = salario + comision;
        return this.salario;
    }
    @Override
    public String toString() {
        return super.toString() +
               "Coche: " + coche + "\n" +
               "Telefono Movil: " + telefonoMovil + "\n" +
               "Area de Venta: " + areaVenta + "\n" +
               "Porcentaje de Comision: " + porcentajeComision + "\n" +
               "Ventas Mensuales: " + ventasMensuales + "\n";
    }
}
 class JefeZona extends Empleado {
    public String despacho;
    public Secretario secretario;
    public Vendedor[] vendedores;

    public JefeZona(String nombre, String apellidos, String cedula, String direccion, int añosAntiguedad, String telefonoContacto, String despacho, Secretario secretario, Vendedor[] vendedores) {
        super(nombre, apellidos, cedula, direccion, añosAntiguedad, telefonoContacto);
        this.despacho = despacho;
        this.secretario = secretario;
        this.vendedores = vendedores;
    }

    @Override
    public double calcularSalario() {
        double ventasGlobales = 0;
        for (Vendedor vendedor : vendedores) {
            ventasGlobales += vendedor.calcularSalario();
        }
        this.salario = ventasGlobales * 0.10;
        return this.salario;
    }

    @Override
    public String toString() {
        String vendedoresStr = "";
        for (Vendedor vendedor : vendedores) {
            vendedoresStr += vendedor.toString() + "\n";
        }
        return super.toString() +
               "Despacho: " + despacho + "\n" +
               "Secretario: " + secretario + "\n" +
               "Vendedores: \n" + vendedoresStr;
    }
}
class Coche {
    public String matricula;
    public String marca;
    public String modelo;

    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo;
    }
}

