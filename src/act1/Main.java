package act1;
public class Main {
    public static void main(String[] args) {
        SistemaNoti sistema = new SistemaNoti();

        Usuario u1 = new Usuario("Pepe");
        Usuario u2 = new Usuario("Juan");
        Usuario u3 = new Usuario("Maria");

        sistema.suscribir(u1);
        sistema.suscribir(u2);
        sistema.suscribir(u3);

        sistema.notificar("¡Oferta 2x1 en Cervezas!");

        sistema.desuscribir(u3);
        sistema.desuscribir(u1);

        sistema.notificar("Servidor en mantenimiento a las 10 PM");
    }
}