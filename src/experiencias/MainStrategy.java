package experiencias;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
interface EstrategiaDescuento {
    double calcularTotal(List<Producto> listaProductos);
}


class SinDescuento implements EstrategiaDescuento {
    public double calcularTotal(List<Producto> listaProductos) {
        double suma = 0;
        for (Producto p : listaProductos) {
            suma = suma + p.precio;
        }
        return suma;
    }
}

class DescuentoFijo implements EstrategiaDescuento {
    public double calcularTotal(List<Producto> listaProductos) {
        double suma = 0;
        for (Producto p : listaProductos) {
            suma = suma + p.precio;
        }
        return suma * 0.90;
    }
}

class DescuentoPorcentual implements EstrategiaDescuento {
    public double calcularTotal(List<Producto> listaProductos) {
        double suma = 0;
        boolean hayRepetidos = false;

        for (Producto p : listaProductos) {
            suma = suma + p.precio;
        }

        for (int i = 0; i < listaProductos.size(); i++) {
            for (int j = i + 1; j < listaProductos.size(); j++) {
                if (listaProductos.get(i).nombre.equals(listaProductos.get(j).nombre)) {
                    hayRepetidos = true;
                    break; 
                }
            }
        }

        if (hayRepetidos) {
            System.out.println("   (¡Oferta! Encontramos productos repetidos: -30%)");
            return suma * 0.70;
        } else {
            return suma; 
        }
    }
}

class DescuentoAcumulado implements EstrategiaDescuento {
    public double calcularTotal(List<Producto> listaProductos) {
        double suma = 0;
        if (listaProductos.size() > 3) {
            Producto masBarato = listaProductos.get(0);
            for (Producto p : listaProductos) {
                if (p.precio < masBarato.precio) {
                    masBarato = p;
                }
            }

            for (Producto p : listaProductos) {
                if (p == masBarato) {
                    suma = suma + (p.precio * 0.50);
                    System.out.println("   (Descuento aplicado: 50% en " + p.nombre + ")");
                } else {
                    suma = suma + p.precio;
                }
            }
            return suma;
        } else {
            for (Producto p : listaProductos) {
                suma = suma + p.precio;
            }
            return suma;
        }
    }
}

class CalculadoraDePrecios {
    private EstrategiaDescuento estrategiaActual;

    public void setEstrategia(EstrategiaDescuento nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }

    public double cobrar(List<Producto> carrito) {
        if (estrategiaActual != null) {
            return estrategiaActual.calcularTotal(carrito);
        } else {
            System.out.println("Error: No has seleccionado una estrategia.");
            return 0;
        }
    }
}
public class MainStrategy {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> miCarrito = new ArrayList<>();
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();

        miCarrito.add(new Producto("Zapatillas", 100));
        miCarrito.add(new Producto("Polo", 50));
        miCarrito.add(new Producto("Polo", 50));   
        miCarrito.add(new Producto("Medias", 20)); 

        System.out.println("--- CAJA REGISTRADORA ---");
        System.out.println("Productos en carrito: " + miCarrito.size());
        System.out.println("1. Sin Descuento");
        System.out.println("2. Descuento Fijo (10%)");
        System.out.println("3. Descuento Pares (30% si hay repetidos)");
        System.out.println("4. Descuento Mayorista (>3 items, 50% en el menor)");
        System.out.print("Elige una opción: ");
        
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            calculadora.setEstrategia(new SinDescuento());
        } else if (opcion == 2) {
            calculadora.setEstrategia(new DescuentoFijo());
        } else if (opcion == 3) {
            calculadora.setEstrategia(new DescuentoPorcentual());
        } else if (opcion == 4) {
            calculadora.setEstrategia(new DescuentoAcumulado());
        }

        double total = calculadora.cobrar(miCarrito);
        System.out.println("Total a pagar: S/ " + total);
    }
}