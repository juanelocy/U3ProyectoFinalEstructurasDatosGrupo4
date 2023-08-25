package programacionDinamica;
import java.util.Scanner;

public class Fibonacci {
	
	// Método recursivo para calcular el n-ésimo término de la sucesión de Fibonacci
	public static int fibonacciRecursivo(int n) {
	    // Caso base: si n es 0 o 1, el resultado es n (F(0) = 0, F(1) = 1)
	    if (n <= 1) {
	        return n;
	    } else { // Caso general: para n mayor que 1
	        // Llamada recursiva para calcular F(n-1) y F(n-2)
	        // Luego se suman los resultados de las llamadas recursivas
	        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
	    }
	}
	
	//Metodo para realizar el calculo de Fibonacci de manera ciclica
	//Tabulacion (Bottom-up)
    //Concepto: se construye una tabla y se llena con soluciones desde la mas pequeña hasta la mas grande
    // Se crea un arreglo para almacenar los valores 
    public static int fibonacciCiclico(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] valores = new int[n + 1];
        
        // Inicializamos los valores iniciales
        valores[0] = 0;
        valores[1] = 1;

        // Calculamos los valores de Fibonacci desde 2 hasta n
        for (int i = 2; i <= n; i++) {
        	valores[i] = valores[i - 1] + valores[i - 2];
        }

        //El n número de Fibonacci se encuentra en valores[n]
        return valores[n];
    }
    
	//Metodo que valida el numero ingresado sea positivo de manera recursiva
	public static int validarNumero(int n) {
        if (n < 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Error, ingresó un número negativo");
            System.out.print("Ingrese nuevamente: ");
            n = scanner.nextInt();
            return validarNumero(n); // Llamada recursiva para validar el nuevo número ingresado
        }
        System.out.println("El numero " + n + " es correcto");
		return n;
    }
	
	
    //Metodo que valida para que el numero ingresado sea positivo de manera ciclica
    public static int validacionNegativo(int n) {
    	Scanner scanner = new Scanner(System.in);
    	
    	if (n<0) {
    		
    		do {//Estructura ciclica para hacer que se ingrese correctamente el numero
    			System.out.println("Error, ingreso un numero negativo");
    			System.out.print("Ingrese nuevamente: ");
    			n =scanner.nextInt();
    		}while(n<0);
    		
    		System.out.println("El numero "+ n + " es correcto");
    	}
    	else {
    		System.out.println("El numero "+ n + " es correcto");
    	}
    	//retorna el valor ingresado sin calcular Fibonacci aun
		return n;
    }
    
    //Metodo utilizado para la impresion haciendo uso de los metodos ciclico
    public static void impresionCiclico(int n, int resultado) {
    	//Asignamos el numero ingresado al metodo para calcular Fibonacci y despues asignar a una variable int
    	resultado = fibonacciCiclico(n);
    	System.out.println("El resultado Fibonacci es: "+ resultado); // concatenacion
    }
	
    //Metodo utilizado para la impresion haciendo uso de los metodos recursivos
    public static void impresionRecusivo(int n, int resultado) {
    	//Asignamos el numero ingresado al metodo para calcular Fibonacci y despues asignar a una variable int
    	resultado = fibonacciRecursivo(n);
    	System.out.println("El resultado Fibonacci es: "+ resultado); // concatenacion
    }
    
    /*
     * -----------------------------------------------------------
     * 		ANALISIS DE ALGORITMO, COMPLEJIDAD Y EFICIENCIA
     * -----------------------------------------------------------
     *  El método fibonacciRecursivo utiliza un enfoque recursivo para calcular el n-ésimo término de la sucesión de Fibonacci. 
		in embargo, este enfoque tiene una complejidad exponencial, ya que realiza muchas llamadas recursivas duplicadas. 
		Cada llamada genera dos llamadas más, lo que resulta en una explosión exponencial de trabajo. La complejidad de tiempo es O(2^n), 
		lo que lo hace ineficiente para valores de n relativamente grandes.
		
		El método validarNumero es un ejemplo de validación recursiva, pero en este caso no tiene una ventaja clara sobre el enfoque iterativo. 
		La recursión no agrega valor aquí y hace que el código sea más complejo de lo necesario. 
		La eficiencia no se ve afectada en gran medida ya que el número de llamadas recursivas es limitado 
		por la cantidad de veces que el usuario ingrese un número negativo.
		
		El método fibonacciCiclico utiliza un enfoque iterativo para calcular los valores de Fibonacci mediante la tabulación (bottom-up). 
		Este enfoque tiene una complejidad de tiempo lineal O(n), ya que realiza un solo bucle para calcular todos los valores de Fibonacci 
		desde 2 hasta n. Es mucho más eficiente que el enfoque recursivo.
		
		En general, la recursión puede ser poderosa pero también puede llevar a ineficiencias en términos de tiempo y memoria. 
		Es importante considerar la complejidad y la eficiencia al elegir entre enfoques recursivos e iterativos para resolver problemas.
     */
    		
}