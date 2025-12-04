package act3;

public class Cmdvenitoff implements comando {
    ventilador vent;
    public Cmdvenitoff(ventilador v) { this.vent = v; }
    public void ejecutar() { vent.apagar(); }
    public void deshacer() { vent.encender(); }
}
