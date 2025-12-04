package act3;

import java.util.Stack;

public class Controlremoto {
    private Stack<comando> historial = new Stack<>();

    public void ejecutarComando(comando c) {
        c.ejecutar();
        historial.push(c); 
    }

    public void botonDeshacer() {
        if (!historial.isEmpty()) {
            comando ultimo = historial.pop(); 
            System.out.print("(Deshaciendo) -> ");
            ultimo.deshacer(); 
        } else {
            System.out.println("No hay nada que deshacer.");
        }
    }
}
