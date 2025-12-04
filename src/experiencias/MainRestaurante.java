package experiencias;
public class MainRestaurante {
    public static void main(String[] args) {
        Pedido p = new Pedido(100.0);
        
        Cliente c = new Cliente("Jorge");
        p.agregarObs(c);

        p.setEstrategia(new PrecioVIP());

        Comando btnCocinar = new CmdCocinar(p);
        Comando btnEntregar = new CmdEntregar(p);

        btnCocinar.ejecutar();
        
        
        btnEntregar.ejecutar();
    }
}