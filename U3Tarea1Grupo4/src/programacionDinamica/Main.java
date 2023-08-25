package programacionDinamica;
import programacionDinamica.Fibonacci;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ejecucion();
    }
    
    public static void ejecucion() {
    	int resultado = 0; // Inicialización de variable para guardar el resultado Fibonacci

        // Instanciaciones
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();

        System.out.print("Ingrese un numero para calcular por el metodo de Fibonacci: ");
        int n = scanner.nextInt(); // Ingreso de valor para obtener diferentes números de la serie de Fibonacci
        System.out.println("");
        
        ////////////////UTILIZANDO METODOS RECURSIVOS///////////////
        // Llamada al método validarNumero para asegurarse de que el número ingresado sea positivo
        int numeroValidado = fibonacci.validarNumero(n);

        if (numeroValidado >= 0) {
            // Cálculo del resultado Fibonacci solo si el número es no negativo
            resultado = fibonacci.fibonacciRecursivo(numeroValidado);
            System.out.println("El resultado Fibonacci (Recursivo) es: " + resultado); // Concatenación
        }

        System.out.println("----------------------------------------------------");
        //////////////////UTILIZANDO METODOS CICLICOS///////////////
        // Llamada al método validarNumero para asegurarse de que el número ingresado sea positivo
        int numero = fibonacci.validacionNegativo(n);

        // Cálculo del resultado Fibonacci
        resultado = fibonacci.fibonacciCiclico(numero);
        
        System.out.println("El resultado Fibonacci (Ciclico) es: " + resultado); // Concatenación
        
        // Complejidad del algoritmo: O(n) para el método fibonacciCiclico, O(2^n) para el método fibonacciRecursivo
        // (donde n es el número ingresado por el usuario).
        // El algoritmo cíclico es más eficiente en términos de tiempo en comparación con el recursivo.
        
        
        /////////////// CALCULO DEL TIEMPO DE EJECUCION /////////////
        System.out.println("");
        System.out.println("------ CALCULO DEL TIEMPO DE EJECUCION -------");
        long startTime, endTime, elapsedTime;
        // Prueba de tiempo para el método fibonacciCiclico
        startTime = System.nanoTime();
        int resultadoCiclico = fibonacci.fibonacciCiclico(numero);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("El resultado Fibonacci (Método Cíclico) es: " + resultadoCiclico);
        System.out.println("Tiempo de ejecución (Método Cíclico): " + elapsedTime + " nanosegundos");
        
        // Prueba de tiempo para el método fibonacciRecursivo
        System.out.println("----------------------------------------------------");
        startTime = System.nanoTime();
        int resultadoRecursivo = fibonacci.fibonacciRecursivo(numeroValidado);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("El resultado Fibonacci (Método Recursivo) es: " + resultadoRecursivo);
        System.out.println("Tiempo de ejecución (Método Recursivo): " + elapsedTime + " nanosegundos");
    }
}