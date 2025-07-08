package CLI;

import IO.FileSystem;
import IO.KeyboardInput;
import IO.Printer;
import gramaticas.linguine.LinguineLexer;
import gramaticas.linguine.LinguineParser;
import jasminGen.CodeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.LinguineVisitor;

import java.io.File;
import java.nio.file.Path;

public class Menu {
    public static void main(String[] args) throws Exception {
        boolean repetir = true;
        while (repetir) {
            repetir = lanzador();
        }
    }

    private static boolean lanzador() throws Exception {
        linguine();
        Printer.newLine();
        switch (KeyboardInput.getStringConMensaje("\nEscribe e introduce el carácter [r] para realizar otra acción -> ").toLowerCase()) {
            case "r" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private static void linguine() throws Exception {
        LinguineLexer lexer = new LinguineLexer(generarCharset("/ficheros/linguine"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LinguineParser parser = new LinguineParser(tokenStream);
        parser.setBuildParseTree(true);

        Printer.print("Representación del arbol: ");
        ParseTree tree = parser.prog();
        Printer.print(tree.toStringTree());

        LinguineVisitor lv = new LinguineVisitor();
        lv.visit(tree);

        Printer.print("TABLA SIMBOLOS");
        lv.getTablaSimbolos().printSimbolos();
        CodeGenerator cg = lv.getCg();
        FileSystem.writeToFile("/home/ena/Documents/coding/java/PL3-Compiladores/test/test.j", cg.getCodigo().toArray(new String[0]));
    }

    private static CharStream generarCharset(String carpetaFicheros) throws Exception {
        CharStream cs = null;

        Printer.print(new String[]{
                "[1] - Escribir una instrucción",
                "[2] - Elegir un fichero"
        });

        switch (KeyboardInput.getStringConMensaje("\nSelecciona una opción -> ")) {
            case "1" -> {
                cs = CharStreams.fromString(KeyboardInput.getStringConMensaje("Escribe la instrucción: "));
            }
            case "2" -> {
                Path[] ficherosEnCarpeta = FileSystem.getFPathsFromResourceFolder(carpetaFicheros);
                for (int i = 0; i < ficherosEnCarpeta.length; i++) {
                    Printer.print("[" + (i + 1) + "] " + ficherosEnCarpeta[i].getFileName().toString());
                }
                Printer.print("");
                int seleccion = KeyboardInput.getIntConMensaje("¿Que fichero quieres cargar? -> ");
                cs = CharStreams.fromStream(FileSystem.getResourceStream(ficherosEnCarpeta[seleccion - 1].toString()));
            }
            default -> {
                throw new Exception("Opción no existente");
            }
        }

        return cs;
    }
}