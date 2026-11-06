public class PersonajeFactory {
    
    // Método fábrica para crear personajes según el tipo elegido
    public static Personaje crearPersonaje(String tipo, String nombre) {
        if (tipo == null) {
            return null;
        }
        if (tipo.equalsIgnoreCase("GUERRERO")) {
            return new GuerreroTierno(nombre);
        } else if (tipo.equalsIgnoreCase("MAGO")) {
            return new MagoMagico(nombre);
        }
        
        // Por defecto devuelve un guerrero tierno si no coincide
        return new GuerreroTierno(nombre);
    }
}