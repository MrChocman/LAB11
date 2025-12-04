package act2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculadora calculadora = new calculadora();

        calculadora.agregarProducto("Camisa", 50);
        calculadora.agregarProducto("Camisa", 50); 
        calculadora.agregarProducto("Calcetines", 10); 
        
        System.out.println("--- Carrito Cargado: [Camisa $50, Camisa $50, Calcetines $10] ---");

        while (true) {
            System.out.println("\nSeleccione Estrategia de Descuento:");
            System.out.println("1. Sin Descuento");
            System.out.println("2. Descuento Fijo (10% total)");
            System.out.println("3. Descuento Porcentual (2 iguales -> 30%)");
            System.out.println("4. Descuento Acumulado (>3 items -> 50% al más barato)");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            
            int op = scanner.nextInt();

            switch (op) {
                case 1: calculadora.setEstrategia(new nodescuento()); break;
                case 2: calculadora.setEstrategia(new descuentofijo()); break;
                case 3: calculadora.setEstrategia(new descuentoporcentual()); break;
                case 4: calculadora.setEstrategia(new descuentoacumulado()); break;
                case 5: System.exit(0);
                default: System.out.println("Opción no válida"); continue;
            }
            
            calculadora.ejecutarCalculo();
        }
    }
}
