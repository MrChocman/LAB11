package act3;

public class Cmdluzon implements comando {
    luz luz;
    public Cmdluzon(luz l) { this.luz = l; }
    public void ejecutar() { luz.encender(); }
    public void deshacer() { luz.apagar(); } 
}
