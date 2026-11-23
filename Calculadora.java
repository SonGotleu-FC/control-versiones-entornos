import java.math.BigInteger;
import java.util.Scanner;

/**
 * Calculadora de enteros de hasta 5 digitos [-99999..99999].
 * Operaciones permitidas: suma, resta, multiplicacion y potencia.
 */
public class Calculadora {

    static final int MIN = -99999;
    static final int MAX = 99999;
    // Maximo de cifras que se muestran completas en pantalla
    static final int MAX_CIFRAS_MOSTRADAS = 100;

    public static BigInteger suma(int a, int b) {
        return BigInteger.valueOf(a).add(BigInteger.valueOf(b));
    }

    public static BigInteger resta(int a, int b) {
        return BigInteger.valueOf(a).subtract(BigInteger.valueOf(b));
    }

    public static BigInteger multiplicacion(int a, int b) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
    }

    // El exponente debe ser >= 0 para que el resultado siga siendo entero
    public static BigInteger potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }
        return BigInteger.valueOf(base).pow(exponente);
    }

    public static boolean esValido(int n) {
        return n >= MIN && n <= MAX;
    }

    static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(linea);
                if (esValido(n)) {
                    return n;
                }
                System.out.println("Numero fuera de rango [" + MIN + ".." + MAX + "].");
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero valido.");
            }
        }
    }

    static String formatear(BigInteger r) {
        String s = r.toString();
        if (s.length() <= MAX_CIFRAS_MOSTRADAS) {
            return s;
        }
        return s.substring(0, 50) + "... (" + s.length() + " cifras)";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println();
            System.out.println("1) Suma  2) Resta  3) Multiplicacion  4) Potencia  0) Salir");
            System.out.print("Opcion: ");
            String opcion = sc.nextLine().trim();

            if (opcion.equals("0")) {
                salir = true;
                continue;
            }
            if (!opcion.matches("[1-4]")) {
                System.out.println("Opcion no valida.");
                continue;
            }

            int a = leerEntero(sc, "Primer numero (base en la potencia): ");
            int b = leerEntero(sc, "Segundo numero (exponente en la potencia): ");

            switch (opcion) {
                case "1":
                    System.out.println("Resultado: " + formatear(suma(a, b)));
                    break;
                case "2":
                    System.out.println("Resultado: " + formatear(resta(a, b)));
                    break;
                case "3":
                    System.out.println("Resultado: " + formatear(multiplicacion(a, b)));
                    break;
                case "4":
                    if (b < 0) {
                        System.out.println("El exponente no puede ser negativo.");
                    } else {
                        System.out.println("Resultado: " + formatear(potencia(a, b)));
                    }
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
