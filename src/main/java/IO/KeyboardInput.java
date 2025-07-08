package IO;

import java.util.Scanner;

public class KeyboardInput {
    private static final Scanner sc = new Scanner(System.in);

    private KeyboardInput() {
        throw new IllegalStateException("Clase de utilidad");
    }

    public static String getString() {
        return sc.nextLine();
    }

    public static String getStringConMensaje(String msg) {
        System.out.print(msg);
        String string = sc.nextLine();
        System.out.println();
        return string;
    }

    public static char getChar() {
        return sc.nextLine().charAt(0);
    }

    public static int getInt() {
        return Integer.parseInt(sc.nextLine());
    }

    public static int getIntConMensaje(String msg) {
        System.out.print(msg);
        int integer = Integer.parseInt(sc.nextLine());
        System.out.println();
        return integer;
    }
}
