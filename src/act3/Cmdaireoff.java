package act3;

public class Cmdaireoff implements comando {
    aireacondicionado aire;
    public Cmdaireoff(aireacondicionado a) { this.aire = a; }
    public void ejecutar() { aire.apagar(); }
    public void deshacer() { aire.encender(); }
}
