package jasminGen;

import tablaSimbolos.TablaSimbolos;

import java.util.ArrayList;
import java.util.HashMap;

public class CodeGenerator {
    private ArrayList<String> codigo;
    private HashMap<String, Integer> referencias;
    private HashMap<String, HashMap<String, Integer>> locales;
    private int numLineas;
    private String nombreClase;
    private String bloqueActual;
    int ifIndex;
    int forIndex;
    int whileIndex;
    int matchIndex;
    private TablaSimbolos ts;

    public CodeGenerator(String nombreClase) {
        this.codigo = new ArrayList<String>();
        this.referencias = new HashMap<String, Integer>();
        this.locales = new HashMap<String, HashMap<String, Integer>>();
        this.locales.put("Main body", new HashMap<String, Integer>());
        this.numLineas = 0;
        this.bloqueActual = "Main body";
        this.nombreClase = nombreClase;
        this.ifIndex = 1;
        this.forIndex = 1;
        this.whileIndex = 1;
        this.matchIndex = 1;
    }

    public void generarMain(int localLimit, int stackLimit) {
        insertarLinea(".class public " + this.nombreClase);
        insertarLinea(".super java/lang/Object");
        insertarLinea(".method public static main([Ljava/lang/String;)V");
        insertarLinea(".limit stack " + stackLimit);
        insertarLinea(".limit locals " + localLimit);
        this.referencias.put("Main body", this.numLineas);
        insertarLinea("return");
        insertarLinea(".end method");
    }

    public void setBloqueActual(String bloqueActual) {
        this.bloqueActual = bloqueActual;
    }

    public void insertarLinea(String codeLine) {
        codigo.add(codeLine);
        numLineas++;
    }

    public void insertarLinea(String referencia, String lineaCodigo) {
        Integer index = this.referencias.remove(referencia);
        codigo.add(index, lineaCodigo);
        this.referencias.put(referencia, index + 1);
        referencias.replaceAll((reference, i) -> i > index + 1 ? i + 1 : i);
        numLineas++;
    }

    public void generateSum(String referencia, int izquierdo, int derecho) {
        insertarLinea(referencia, "ldc " + izquierdo);
        insertarLinea(referencia, "ldc " + derecho);
        insertarLinea(referencia, "iadd");
    }

    public void generateSub(String referencia, int izquierdo, int derecho) {
        insertarLinea(referencia, "ldc " + izquierdo);
        insertarLinea(referencia, "ldc " + derecho);
        insertarLinea(referencia, "isub");
    }

    public void generarCabeceraIf(String referencia, String nombreVariable, int valor, String tipo) {
        String nombreIf = "if_" + this.ifIndex;
        insertarLinea(referencia, "iload " + buscarLocal(nombreVariable));
        insertarLinea(referencia, "ldc " + valor);
        switch (tipo) {
            case "<" -> insertarLinea(referencia, "if_icmplt " + nombreIf);
            case ">" -> insertarLinea(referencia, "if_icmpgt " + nombreIf);
            case "<=" -> insertarLinea(referencia, "if_icmple " + nombreIf);
            case ">=" -> insertarLinea(referencia, "if_icmpge " + nombreIf);
            case "==" -> insertarLinea(referencia, "if_icmpeq " + nombreIf);
            case "!=" -> insertarLinea(referencia, "if_icmpne " + nombreIf);
        }
        insertarLinea(referencia, "goto " + nombreIf + "_else");
        insertarLinea(referencia, nombreIf + ":");
    }

    public void generarElse(String referencia) {
        String nombreIf = "if_" + this.ifIndex;
        insertarLinea(referencia, "goto " + nombreIf + "_end");
        insertarLinea(referencia, nombreIf + "_else:");
    }

    public void finalizarIf(String referencia) {
        String nombreIf = "if_" + this.ifIndex;
        insertarLinea(referencia, nombreIf + "_end:");
        this.ifIndex++;
    }

    public void guardarInt(String referencia, String nombreVariable) {
        int localNum = asignarLocal(nombreVariable);
        insertarLinea(referencia, "istore " + localNum);
    }

    public void guardarString(String referencia, String nombreVariable) {
        int localNum = asignarLocal(nombreVariable);
        insertarLinea(referencia, "astore " + localNum);
    }

    public void generateVarFromFunc(String referencia, String nombreVariable, String nombreFuncion, int[] argumentos) {
        int localNum = asignarLocal(nombreVariable);
        StringBuilder numParametros = new StringBuilder();
        for (int argumento : argumentos) {
            insertarLinea(referencia, "ldc " + argumento);
            numParametros.append("I");
        }
        insertarLinea(referencia, "invokestatic " + this.nombreClase + "/" + nombreFuncion + "(" + numParametros.toString() + ")I");
        insertarLinea(referencia, "istore " + localNum);
    }


    public void generateShowInt(String referencia, int toPrint) {
        insertarLinea(referencia, "getstatic java/lang/System/out Ljava/io/PrintStream;");
        insertarLinea(referencia, "ldc " + toPrint);
        insertarLinea(referencia, "invokevirtual java/io/PrintStream/println(I)V");
    }

    public void generateShowString(String referencia, String toPrint) {
        insertarLinea(referencia, "getstatic java/lang/System/out Ljava/io/PrintStream;");
        insertarLinea(referencia, "ldc " + toPrint);
        insertarLinea(referencia, "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
    }

    public void generarShowCabecera(String referencia, String toPrint) {
        insertarLinea(referencia, "getstatic java/lang/System/out Ljava/io/PrintStream;");
        insertarLinea(referencia, "ldc " + toPrint);
        insertarLinea(referencia, "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
    }

    public void generarShowFinal(String referencia, String toPrint, String tipo) {
        insertarLinea(referencia, "getstatic java/lang/System/out Ljava/io/PrintStream;");
        insertarLinea(referencia, "ldc " + toPrint);
        insertarLinea(referencia, "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
    }

    public void generateShowVar(String referencia, String nombreVariable, String tipo) {
        insertarLinea(referencia, "getstatic java/lang/System/out Ljava/io/PrintStream;");
        switch (tipo) {
            case "int" -> {
                insertarLinea(referencia, "iload " + buscarLocal(nombreVariable));
                insertarLinea(referencia, "invokevirtual java/io/PrintStream/println(I)V");
            }
            case "string" -> {
                insertarLinea(referencia, "aload " + buscarLocal(nombreVariable));
                insertarLinea(referencia, "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
            }
        }
    }

    public void cargarVariable(String referencia, String nombreVariable, String tipo) {
        switch (tipo) {
            case "string" -> insertarLinea(referencia,"aload " + buscarLocal(nombreVariable));
            default -> insertarLinea(referencia, "iload " + buscarLocal(nombreVariable));
        }
    }

    public void cargarVariableParam(String referencia, String tipo, int local) {
        switch (tipo) {
            case "int" -> insertarLinea(referencia, "iload " + local);
            case "string" -> insertarLinea(referencia,"aload " + local);
            case "parametro" -> insertarLinea(referencia,"iload " + local);
        }
    }

    public void generateFunc(int limiteStack, int limiteLocal, String nombreFuncion, String parametros, String tipoRetorno) {
        this.locales.put(nombreFuncion, new HashMap<String, Integer>());
        insertarLinea(".method public static " + nombreFuncion + "(" + parametros + ")" + tipoRetorno);
        insertarLinea(".limit locals " + limiteLocal);
        insertarLinea(".limit stack " + limiteStack);
        this.referencias.put(nombreFuncion, this.numLineas);
        switch (tipoRetorno) {
            case "I" -> {
                insertarLinea("ireturn");
            }
            case "Ljava/lang/String;" -> {
                insertarLinea("areturn");
            }
            case "V" -> {
                insertarLinea("return");
            }
        }
        insertarLinea(".end method");
    }

    public int asignarLocal(String nombreVariable) {
        if (existeLocal(nombreVariable)) return buscarLocal(nombreVariable);
        HashMap<String, Integer> bloqueActual = this.locales.get(this.bloqueActual);
        int index = bloqueActual.size();
        bloqueActual.put(nombreVariable, index);
        return index;
    }

    public int buscarLocal(String nombreVariable) {
        HashMap<String, Integer> bloqueActual = this.locales.get(this.bloqueActual);
        return bloqueActual.get(nombreVariable);
    }

    private boolean existeLocal(String nombreVariable) {
        HashMap<String, Integer> bloqueActual = this.locales.get(this.bloqueActual);
        return bloqueActual.containsKey(nombreVariable);
    }

    public ArrayList<String> getCodigo() {
        return codigo;
    }

    public int getIndexMatch() {
        int matchIndex = this.matchIndex;
        this.matchIndex++;
        return matchIndex;
    }

    public int getIndexFor() {
        int forIndex = this.forIndex;
        this.forIndex++;
        return forIndex;
    }

    public int getIndexWhile() {
        int whileIndex = this.whileIndex;
        this.whileIndex++;
        return whileIndex;
    }
}
