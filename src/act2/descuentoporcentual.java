package act2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class descuentoporcentual implements estrategiadescuento {
    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        boolean hayDuplicados = false;
        Set<String> nombres = new HashSet<>();

        for (Producto p : productos) {
            total += p.precio;
            if (!nombres.add(p.nombre)) {
                hayDuplicados = true;
            }
        }

        if (hayDuplicados) {
            System.out.println("   -> ¡Detectados productos iguales! Aplicando 30%.");
            return total * 0.70;
        } else {
            System.out.println("   -> No hay productos iguales. Precio normal.");
            return total;
        }
    }
}
