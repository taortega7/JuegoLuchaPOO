import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje j1, Personaje j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
    }

    public void iniciarPelea() {
        System.out.println("\n🌸 ¡Comienza la gran batalla: " + jugador1.getNombre() + " VS " + jugador2.getNombre() + "! 🌸\n");
        
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        System.out.println("\n========================================");
        if (jugador1.estaVivo()) {
            System.out.println("🎉 ¡" + jugador1.getNombre() + " ha ganado la pelea con honor! 🏆✨");
        } else {
            System.out.println("🎉 ¡" + jugador2.getNombre() + " ha ganado la pelea con honor! 🏆✨");
        }
        System.out.println("========================================\n");
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("----------------------------------------");
        System.out.println("👉 Turno de: " + atacante.getNombre());
        System.out.println("   Salud de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida() + " HP.");
        
        atacante.atacar(defensor);
        
        System.out.println("   Salud restante -> " + defensor.getPuntosDeVida() + " HP.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("💖 ¡Bienvenido al Juego de Lucha con Patrones de Diseño! 💖");
        
        // Jugador 1
        System.out.print("Introduce el nombre del Jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Elige la clase de " + nombre1 + " (GUERRERO / MAGO): ");
        String tipo1 = scanner.nextLine();
        Personaje p1 = PersonajeFactory.crearPersonaje(tipo1, nombre1);

        // Jugador 2
        System.out.print("Introduce el nombre del Jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Elige la clase de " + nombre2 + " (GUERRERO / MAGO): ");
        String tipo2 = scanner.nextLine();
        Personaje p2 = PersonajeFactory.crearPersonaje(tipo2, nombre2);

        // Iniciar juego usando la Fábrica y la Herencia
        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciarPelea();
        
   
    }
}