import java.util.Random;

public abstract class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100; // Todos empiezan con 100 HP[cite: 2]
    }

    // Método de ataque requerido[cite: 1]
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        oponente.recibirDano(dano);
        System.out.println("✨ " + this.nombre + " realiza un ataque mágico a " + oponente.getNombre() + ", causando " + dano + " puntos de daño. 💖");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    // Métodos obligatorios pedidos por el profesor[cite: 1]
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}