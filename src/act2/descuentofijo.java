package act2;

import java.util.List;

public class descuentofijo implements estrategiadescuento {
    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) total += p.precio;
        return total * 0.90; 
    }
}
