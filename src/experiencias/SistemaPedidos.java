package experiencias;
import java.util.ArrayList;
import java.util.List;

public class SistemaPedidos { 
}

class Pedido {
    List<Observador> observadores = new ArrayList<>();
    EstrategiaPrecio estrategia = new PrecioNormal();
    double monto;
    String estado;

    public Pedido(double m) { this.monto = m; this.estado = "Creado"; }

    public void agregarObs(Observador o) { observadores.add(o); }
    
    public void notificar() {
        for(Observador o : observadores) o.actualizar(estado);
    }

    public void setEstrategia(EstrategiaPrecio e) { this.estrategia = e; }
    
    public void mostrarTotal() {
        System.out.println("   >> Total: " + estrategia.calcular(monto));
    }

    public void setEstado(String e) {
        this.estado = e;
        notificar();
    }
}

interface Comando {
    void ejecutar();
}

class CmdCocinar implements Comando {
    Pedido p;
    public CmdCocinar(Pedido p) { this.p = p; }
    public void ejecutar() {
        System.out.println("\n--- COCINA: Preparando ---");
        p.setEstado("En Preparación");
    }
}

class CmdEntregar implements Comando {
    Pedido p;
    public CmdEntregar(Pedido p) { this.p = p; }
    public void ejecutar() {
        System.out.println("\n--- MOZO: Entregando ---");
        p.setEstado("Entregado");
        p.mostrarTotal();
    }
}