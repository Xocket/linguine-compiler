package IO;

public class Printer {

    public Printer() {
        throw new IllegalStateException("Clase de utilidad");
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void printArbol(String msg, int depth) {
        // Rama vertical
        if (depth == 0) { // Si es el axioma
            System.out.print("--");
        } else { // Si es un nodo intermedio
            for (int i = 0; i < depth; i++) System.out.print("  "); // Añade espacios al principio
            System.out.println("|");
            for (int i = 0; i < depth; i++) System.out.print("  "); // Añade espacios al principio
            System.out.println("|");
            for (int i = 0; i < depth; i++) System.out.print("  "); // Añade espacios al principio
            System.out.print("└");
        }

        // Rama horizontal
        for (int i = 0; i < depth; i++) System.out.print("――"); // Añade espacios al principio
        System.out.println("( " + msg + " )"); // Añade el nombre de la regla y salta a la línea siguiente
    }

    public static void newLine() {
        System.out.println();
    }

    public static void print(String[] msgs) {
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }
}
