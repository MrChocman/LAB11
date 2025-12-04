package act3;

public class Cmdaireon implements comando {
    aireacondicionado aire;
    public Cmdaireon(aireacondicionado a) { this.aire = a; }
    public void ejecutar() { aire.encender(); }
    public void deshacer() { aire.apagar(); }
}
