package experiencias;
import java.util.Stack;

interface Comando {
    void ejecutar();
    void deshacer();
}

class Televisor {
    boolean encendido = false;
    int volumen = 10;

    public void prender() {
        encendido = true;
        System.out.println("TV: --- ENCENDIDO ---");
    }

    public void apagar() {
        encendido = false;
        System.out.println("TV: --- APAGADO ---");
    }

    public void subirVolumen() {
        if (encendido) {
            volumen++;
            System.out.println("TV: Volumen subió a " + volumen);
        } else {
            System.out.println("TV: (No responde, está apagado)");
        }
    }

    public void bajarVolumen() {
        if (encendido) {
            volumen--;
            System.out.println("TV: Volumen bajó a " + volumen);
        }
    }

    public void ponerMute() {
        if (encendido) {
            System.out.println("TV: MUTE ACTIVADO (Silencio total)");
        }
    }

    public void quitarMute() {
        if (encendido) {
            System.out.println("TV: SONIDO REACTIVADO");
        }
    }
}


// Funcionalidad 1: Encender
class CmdEncender implements Comando {
    Televisor tele;
    public CmdEncender(Televisor t) { this.tele = t; }
    
    public void ejecutar() { tele.prender(); }
    public void deshacer() { tele.apagar(); } // Lo contrario de prender es apagar
}

// Funcionalidad 2: Apagar
class CmdApagar implements Comando {
    Televisor tele;
    public CmdApagar(Televisor t) { this.tele = t; }
    
    public void ejecutar() { tele.apagar(); }
    public void deshacer() { tele.prender(); }
}

// Funcionalidad 3: Subir Volumen
class CmdSubirVol implements Comando {
    Televisor tele;
    public CmdSubirVol(Televisor t) { this.tele = t; }
    
    public void ejecutar() { tele.subirVolumen(); }
    public void deshacer() { tele.bajarVolumen(); } // Si subí, deshacer es bajar
}

// Funcionalidad 4: Bajar Volumen
class CmdBajarVol implements Comando {
    Televisor tele;
    public CmdBajarVol(Televisor t) { this.tele = t; }
    
    public void ejecutar() { tele.bajarVolumen(); }
    public void deshacer() { tele.subirVolumen(); }
}

// Funcionalidad 5: Silenciar (Mute)
class CmdSilenciar implements Comando {
    Televisor tele;
    public CmdSilenciar(Televisor t) { this.tele = t; }
    
    public void ejecutar() { tele.ponerMute(); }
    public void deshacer() { tele.quitarMute(); }
}

// 3. El Control Remoto (Invoker)
class ControlRemoto {
    Comando botonActual;
    // Usamos Stack (Pila) para guardar el historial de botones presionados
    Stack<Comando> historial = new Stack<>();

    public void setComando(Comando c) {
        this.botonActual = c;
    }

    public void presionarBoton() {
        if (botonActual != null) {
            botonActual.ejecutar();
            // Guardamos el comando en el historial por si queremos deshacer
            historial.push(botonActual);
        }
    }

    public void botonDeshacer() {
        if (!historial.isEmpty()) {
            // Sacamos el último comando de la pila
            Comando ultimoComando = historial.pop();
            System.out.print("   (Deshaciendo acción...) -> ");
            ultimoComando.deshacer();
        } else {
            System.out.println("Nada para deshacer.");
        }
    }
}
//Clase Principal
public class MainCommand {
    public static void main(String[] args) {
        Televisor miTV = new Televisor();
        ControlRemoto control = new ControlRemoto();


        // 1. Prender la TV
        control.setComando(new CmdEncender(miTV));
        control.presionarBoton();

        // 2. Subir volumen varias veces
        control.setComando(new CmdSubirVol(miTV));
        control.presionarBoton();
        control.presionarBoton();

        // 3. Bajar volumen
        control.setComando(new CmdBajarVol(miTV));
        control.presionarBoton();

        // 4. Silenciar (Mute)
        control.setComando(new CmdSilenciar(miTV));
        control.presionarBoton();

        control.botonDeshacer();

        // 5. Apagar
        control.setComando(new CmdApagar(miTV));
        control.presionarBoton();
        
        control.botonDeshacer();
    }
}