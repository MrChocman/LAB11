package act3;

public class Cmdluzoff implements comando {
    luz luz;
    public Cmdluzoff(luz l) { this.luz = l; }
    public void ejecutar() { luz.apagar(); }
    public void deshacer() { luz.encender(); }
}
