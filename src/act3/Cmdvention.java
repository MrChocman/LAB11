package act3;

public class Cmdvention implements comando {
    ventilador vent;
    public Cmdvention(ventilador v) { this.vent = v; }
    public void ejecutar() { vent.encender(); }
    public void deshacer() { vent.apagar(); }
}
