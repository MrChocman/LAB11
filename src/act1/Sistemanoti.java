package act1;
import java.util.List;
import java.util.ArrayList;

class SistemaNoti{
    private List<Observer> suscriptores = new ArrayList<>();

    public void suscribir(Observer usuario) {
        suscriptores.add(usuario);
        System.out.println("Suscriptor agregado.");
    }

    public void desuscribir(Observer usuario) {
        suscriptores.remove(usuario);
        System.out.println("Suscriptor eliminado.");
    }

    public void notificar(String evento) {
        System.out.println("\nEnviando...: " + evento + "");
        for (Observer obs : suscriptores) {
            obs.actualizar(evento);
        }
    }
}