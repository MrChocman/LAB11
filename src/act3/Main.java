package act3;

public class Main {
    public static void main(String[] args) {
        luz luzSala = new luz();
        ventilador ventilador = new ventilador();
        aireacondicionado aire = new aireacondicionado();

        comando luzOn = new Cmdluzon(luzSala);
        comando luzOff = new Cmdluzoff(luzSala);
        comando aireOn = new Cmdaireon(aire);
        comando ventOn = new Cmdvention(ventilador);

        Controlremoto control = new Controlremoto();

        System.out.println("--- PRUEBA DE COMANDOS ---");
        control.ejecutarComando(luzOn);  
        control.ejecutarComando(aireOn); 
        control.ejecutarComando(ventOn); 
        control.ejecutarComando(luzOff); 

        System.out.println("\n--- PRUEBA DE DESHACER (UNDO) ---");
        control.botonDeshacer(); 
        
        control.botonDeshacer(); 
    }
}
