import java.util.ArrayList;
import java.util.List;

// CLASE PADRE
abstract class Criatura {

    protected String nombre;
    protected int edad;
    protected int nivelEnergia;
    protected int vida;
    protected int pos_y;
    protected int pos_x;

    public Criatura(String nombre, int edad, int nivelEnergia,
                    int vida, int pos_x, int pos_y) {

        this.nombre = nombre;
        this.edad = edad;
        this.nivelEnergia = nivelEnergia;
        this.vida = vida;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    public String getNombre() {
        return nombre;
    }

    public void moverse() {
        pos_x++;
        pos_y++;
        gastarEnergia(5);
        System.out.println(nombre + " se esta moviendo.");
    }

    public void recibirDanio(int cantidad) {
        vida = Math.max(0, vida - cantidad);
        System.out.println(nombre + " recibio daño. Vida: " + vida);
    }

    public void causarDanio(Criatura objetivo) {
        objetivo.recibirDanio(10);
    }

    public void alimentarse() {
        nivelEnergia = Math.min(100, nivelEnergia + 10);
        System.out.println(nombre + " se esta alimentando.");
    }

    public void descansar() {
        nivelEnergia = Math.min(100, nivelEnergia + 20);
        System.out.println(nombre + " esta descansando.");
    }

    protected void gastarEnergia(int cantidad) {
        nivelEnergia = Math.max(0, nivelEnergia - cantidad);
    }

    protected void recuperarEnergia(int cantidad) {
        nivelEnergia = Math.min(100, nivelEnergia + cantidad);
    }

    public void mostrarEnergia() {
        System.out.println(nombre + ": " + nivelEnergia + "/100");
    }

    public void mostrarCriatura() {
        System.out.println(
            "Nombre: " + nombre +
            " | Edad: " + edad +
            " | Energia: " + nivelEnergia +
            " | Vida: " + vida +
            " | Posicion: (" + pos_x + "," + pos_y + ")"
        );
    }

    public abstract void realizarActividadPrincipal();
}

// DRAGON
class Dragon extends Criatura {

    private int temperaturaFuego;
    private boolean puedeVolar;

    public Dragon(String nombre, int edad, int energia, int vida,
                  int x, int y, int temperaturaFuego, boolean puedeVolar) {

        super(nombre, edad, energia, vida, x, y);
        this.temperaturaFuego = temperaturaFuego;
        this.puedeVolar = puedeVolar;
    }

    public void lanzarFuego() {
        gastarEnergia(10);
        System.out.println(nombre + " lanza fuego a "
                + temperaturaFuego + " grados.");
    }

    public void realizarActividadPrincipal() {
        lanzarFuego();
    }
}

// UNICORNIO
class Unicornio extends Criatura {

    private String poderMagico;
    private int numeroCuernos;

    public Unicornio(String nombre, int edad, int energia, int vida,
                     int x, int y, String poderMagico, int numeroCuernos) {

        super(nombre, edad, energia, vida, x, y);
        this.poderMagico = poderMagico;
        this.numeroCuernos = numeroCuernos;
    }

    public void usarMagia() {
        gastarEnergia(10);
        System.out.println(nombre + " usa magia: " + poderMagico);
    }

    public void realizarActividadPrincipal() {
        usarMagia();
    }
}

// FENIX
class Fenix extends Criatura {

    private boolean resurgirCenizas;
    private String colorPluma;

    public Fenix(String nombre, int edad, int energia, int vida,
                 int x, int y, boolean resurgirCenizas, String colorPluma) {

        super(nombre, edad, energia, vida, x, y);
        this.resurgirCenizas = resurgirCenizas;
        this.colorPluma = colorPluma;
    }

    public void resucitar() {
        if (resurgirCenizas) {
            recuperarEnergia(20);
            System.out.println(nombre + " resurge de las cenizas. Color: "
                    + colorPluma);
        } else {
            System.out.println(nombre + " no puede resurgir.");
        }
    }

    public void volar() {
        moverse();
        System.out.println(nombre + " esta volando.");
    }

    public void realizarActividadPrincipal() {
        resucitar();
    }
}

// DUENDE
class Duende extends Criatura {

    private String tipoDuende;
    private boolean esTravieso;
    private boolean tesoroEscondido;

    public Duende(String nombre, int edad, int energia, int vida,
                  int x, int y, String tipoDuende,
                  boolean esTravieso, boolean tesoroEscondido) {

        super(nombre, edad, energia, vida, x, y);
        this.tipoDuende = tipoDuende;
        this.esTravieso = esTravieso;
        this.tesoroEscondido = tesoroEscondido;
    }

    public void hacerTravesuras() {
        if (esTravieso) {
            gastarEnergia(5);
            System.out.println(nombre + " hace travesuras. Tipo: "
                    + tipoDuende);
        } else {
            System.out.println(nombre + " no es travieso.");
        }
    }

    public void esconderTesoro() {
        tesoroEscondido = true;
        System.out.println(nombre + " escondio un tesoro.");
    }

    public void realizarActividadPrincipal() {
        hacerTravesuras();
    }
}

// LEPRECHAUN
class Leprechaun extends Criatura {

    private boolean ollaDeOro;

    public Leprechaun(String nombre, int edad, int energia, int vida,
                      int x, int y, boolean ollaDeOro) {

        super(nombre, edad, energia, vida, x, y);
        this.ollaDeOro = ollaDeOro;
    }

    public void concederDeseo() {
        if (ollaDeOro) {
            gastarEnergia(10);
            System.out.println(nombre + " concede un deseo.");
        } else {
            System.out.println(nombre + " no tiene olla de oro.");
        }
    }

    public void realizarActividadPrincipal() {
        concederDeseo();
    }
}

// PIXIE
class Pixie extends Criatura {

    private int polvoMagico;
    private boolean puedeVolar;

    public Pixie(String nombre, int edad, int energia, int vida,
                 int x, int y, int polvoMagico, boolean puedeVolar) {

        super(nombre, edad, energia, vida, x, y);
        this.polvoMagico = polvoMagico;
        this.puedeVolar = puedeVolar;
    }

    public void volar() {
        if (puedeVolar) {
            gastarEnergia(5);
            System.out.println(nombre + " esta volando.");
        }
    }

    public void lanzarPolvo() {
        if (polvoMagico >= 10) {
            polvoMagico -= 10;
            gastarEnergia(5);
            System.out.println(nombre + " lanza polvo magico.");
        } else {
            System.out.println(nombre + " no tiene polvo magico suficiente.");
        }
    }

    public void realizarActividadPrincipal() {
        lanzarPolvo();
    }
}

// TRASGO
class Trasgo extends Criatura {

    private int fuerza;
    private boolean esNocturno;

    public Trasgo(String nombre, int edad, int energia, int vida,
                  int x, int y, int fuerza, boolean esNocturno) {

        super(nombre, edad, energia, vida, x, y);
        this.fuerza = fuerza;
        this.esNocturno = esNocturno;
    }

    public void asustar() {
        gastarEnergia(5);
        System.out.println(nombre + " asusta con fuerza " + fuerza);
    }

    public void esconderse() {
        System.out.println(nombre + " se esconde.");
    }

    public void realizarActividadPrincipal() {
        asustar();
    }
}

// CLASE PARQUE
class Parque {

    private String nombre;
    private List<Criatura> listaCriaturas;

    public Parque(String nombre) {
        this.nombre = nombre;
        listaCriaturas = new ArrayList<Criatura>();
    }

    public void agregarCriatura(Criatura criatura) {
        listaCriaturas.add(criatura);
        System.out.println(criatura.getNombre()
                + " agregada al parque.");
    }

    public void listarCriatura() {
        System.out.println("\n===== CRIATURAS DEL PARQUE =====");

        for (Criatura criatura : listaCriaturas) {
            criatura.mostrarCriatura();
        }
    }

    public void mostrarEnergia() {
        System.out.println("\n===== ENERGIA DE LAS CRIATURAS =====");

        for (Criatura criatura : listaCriaturas) {
            criatura.mostrarEnergia();
        }
    }

    public void realizarActividades() {
        System.out.println("\n===== ACTIVIDADES DEL PARQUE =====");

        for (Criatura criatura : listaCriaturas) {
            criatura.realizarActividadPrincipal();
        }
    }
}

// CLASE PRINCIPAL
public class Main {

    public static void main(String[] args) {

        Parque parque = new Parque("Parque Fantastico");

        // CREAR LAS SIETE CRIATURAS

        Dragon dragon = new Dragon(
            "Draco", 100, 90, 100, 0, 0, 500, true
        );

        Unicornio unicornio = new Unicornio(
            "Estrella", 80, 100, 100, 2, 3, "Curacion", 1
        );

        Fenix fenix = new Fenix(
            "Fuego", 200, 80, 100, 4, 5, true, "Rojo"
        );

        Duende duende = new Duende(
            "Verde", 50, 90, 100, 1, 1, "Bosque", true, true
        );

        Leprechaun leprechaun = new Leprechaun(
            "Dorado", 150, 100, 100, 3, 2, true
        );

        Pixie pixie = new Pixie(
            "Campanita", 30, 100, 100, 5, 5, 100, true
        );

        Trasgo trasgo = new Trasgo(
            "Sombra", 60, 85, 100, 6, 6, 80, true
        );

        // AGREGAR LAS CRIATURAS AL PARQUE

        parque.agregarCriatura(dragon);
        parque.agregarCriatura(unicornio);
        parque.agregarCriatura(fenix);
        parque.agregarCriatura(duende);
        parque.agregarCriatura(leprechaun);
        parque.agregarCriatura(pixie);
        parque.agregarCriatura(trasgo);

        // MOSTRAR TODAS LAS CRIATURAS

        parque.listarCriatura();

        // MOSTRAR ENERGIA INICIAL

        parque.mostrarEnergia();

        // REALIZAR ACTIVIDADES

        parque.realizarActividades();

        // MOSTRAR ENERGIA FINAL

        parque.mostrarEnergia();
    }
}