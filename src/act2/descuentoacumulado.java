package act2;

import java.util.List;

public class descuentoacumulado implements estrategiadescuento {
    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0;
        double minPrecio = Double.MAX_VALUE;

        for (Producto p : productos) {
            total += p.precio;
            if (p.precio < minPrecio) minPrecio = p.precio;
        }

        if (productos.size() >= 3) {
            System.out.println("   -> Más de 3 productos. 50% desc. al más barato (" + minPrecio + ").");
            return total - (minPrecio * 0.50); // Restamos la mitad del más barato
        } else {
            System.out.println("   -> Menos de 3 productos. Precio normal.");
            return total;
        }
    }
}
