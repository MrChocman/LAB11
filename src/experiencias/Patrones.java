package experiencias;

@SuppressWarnings("unused")
interface EstrategiaPrecio {
    double calcular(double precioBase);
}

class PrecioNormal implements EstrategiaPrecio {
    public double calcular(double precioBase) {
        return precioBase;
    }
}

class PrecioVIP implements EstrategiaPrecio {
    public double calcular(double precioBase) {
        System.out.println("   (Cliente VIP: -20% descuento)");
        return precioBase * 0.80;
    }
}

interface Observador {
    void actualizar(String estado);
}

class Cliente implements Observador {
    String nombre;

    public Cliente(String n) { this.nombre = n; }

    @Override
    public void actualizar(String estado) {
        System.out.println(" [SMS a " + nombre + "]: Tu pedido está " + estado);
    }
}