public class Temperaturas {

    //  Cuenta cuántos días hubo temperaturas mayores a 30°C
    public static int contarDiasCalurosos(int[][] matriz) {
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 30) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //  Calcula el promedio de temperaturas menores a 20°C
    public static double promedioDiasFrescos(int[][] matriz) {
        int suma = 0;
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 20) {
                    suma += matriz[i][j];
                    contador++;
                }
            }
        }
        return (contador > 0) ? (double) suma / contador : 0.0; // Evitar división por cero
    }

    //  Imprime las temperaturas menores a 10°C y mayores a 35°C, junto con su posición
    public static void imprimirTemperaturasExtremas(int[][] matriz) {
        System.out.println("Temperaturas menores a 10°C y mayores a 35°C:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 10 || matriz[i][j] > 35) {
                    System.out.printf("Temperatura: %d°C en posición [%d][%d]%n", matriz[i][j], i, j);
                }
            }
        }
    }

    //  Devuelve la posición [i][j] donde se registró la temperatura más alta
    public static int[] posicionTemperaturaMasAlta(int[][] matriz) {
        int maxTemp = Integer.MIN_VALUE;
        int[] posicion = new int[2]; // [i, j]
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maxTemp) {
                    maxTemp = matriz[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    // BONUS: Método para imprimir la matriz de temperaturas
    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("Matriz de Temperaturas:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%d ", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] temperaturas = {
            {25, 32, 15, 8},
            {29, 35, 40, 22},
            {10, 5, 30, 28},
            {15, 20, 18, 37}
        };

        System.out.println("Días calurosos: " + contarDiasCalurosos(temperaturas));
        System.out.println("Promedio días frescos: " + promedioDiasFrescos(temperaturas));
        imprimirTemperaturasExtremas(temperaturas);
        int[] posicionMax = posicionTemperaturaMasAlta(temperaturas);
        System.out.printf("Posición de la temperatura más alta: [%d][%d]%n", posicionMax[0], posicionMax[1]);
        
        // Imprimir la matriz de temperaturas (BONUS)
        imprimirMatriz(temperaturas);
    }
}
