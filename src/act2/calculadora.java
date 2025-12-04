package act2;

import java.util.ArrayList;
import java.util.List;

public class calculadora {
    private estrategiadescuento estrategia;
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String nombre, double precio) {
        productos.add(new Producto(nombre, precio));
    }

    public void setEstrategia(estrategiadescuento estrategia) {
        this.estrategia = estrategia;
    }

    public void ejecutarCalculo() {
        if (estrategia == null) {
            System.out.println("Error: Selecciona una estrategia primero.");
            return;
        }
        if (productos.isEmpty()) {
            System.out.println("Error: No hay productos en el carrito.");
            return;
        }
        
        double resultado = estrategia.calcularTotal(productos);
        System.out.println("El precio final a pagar es: $" + String.format("%.2f", resultado));
    }
}
