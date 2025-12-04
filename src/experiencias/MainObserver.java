package experiencias;
import java.util.ArrayList;
import java.util.List;

interface Observador {
    void actualizar(String mensaje);
}

class Usuario implements Observador {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(" [" + nombre + "] Ha recibido: " + mensaje);
    }
}

class SistemaNotificaciones {
    private List<Observador> listaUsuarios;

    public SistemaNotificaciones() {
        this.listaUsuarios = new ArrayList<>();
    }
    public void suscribir(Observador usuario) {
        listaUsuarios.add(usuario);
    }
    public void desuscribir(Observador usuario) {
        listaUsuarios.remove(usuario);
    }

    public void notificar(String evento) {
        System.out.println("\n>>> ENVIANDO ALERTA: " + evento);
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Observador u = listaUsuarios.get(i);
            u.actualizar(evento);
        }
    }
}

public class MainObserver {
    public static void main(String[] args) {
        SistemaNotificaciones canal = new SistemaNotificaciones();

        Usuario u1 = new Usuario("Victor");
        Usuario u2 = new Usuario("Manuel");
        Usuario u3 = new Usuario("Oscar");

        canal.suscribir(u1);
        canal.suscribir(u2);
        
        canal.notificar("¡Descuentos del 50% en zapatillas!");

        canal.desuscribir(u2);
        canal.suscribir(u3);

        canal.notificar("Nuevo stock de camisetas disponible");
    }
}