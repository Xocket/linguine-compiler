package visitors;

import gramaticas.linguine.LinguineParser;
import gramaticas.linguine.LinguineParserBaseVisitor;
import jasminGen.CodeGenerator;
import org.antlr.v4.runtime.tree.TerminalNode;
import tablaSimbolos.Simbolo;
import tablaSimbolos.TablaSimbolos;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class LinguineVisitor extends LinguineParserBaseVisitor<Simbolo> {
    private CodeGenerator cg;
    private TablaSimbolos tablaSimbolos;
    private String nombreClase;
    String bloqueActual;
    boolean guardarVariables;
    boolean modoParametros;
    String modoParametrosNombre;
    boolean escribirJasmin;

    public LinguineVisitor() {
        this.tablaSimbolos = new TablaSimbolos();
        this.nombreClase = "CodGen";
        this.cg = new CodeGenerator(this.nombreClase);
        cg.generarMain(100, 100);
        this.bloqueActual = "Main body";
        this.guardarVariables = true;
        this.modoParametros = false;
        this.modoParametrosNombre = null;
        this.escribirJasmin = false;
    }

    public CodeGenerator getCg() {
        return cg;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    @Override
    public Simbolo visitMatch_statement(LinguineParser.Match_statementContext ctx) {
        int idMatch = cg.getIndexMatch();
        String nombreVariable = ctx.ID().getText();
        String tipoVariable = this.tablaSimbolos.recogerVariable(nombreVariable).getTipo();
        int numCases = 1;
        ArrayList<String> etiquetas = new ArrayList<String>();

        cg.cargarVariable(this.bloqueActual, nombreVariable, tipoVariable);
        cg.insertarLinea(this.bloqueActual, "lookupswitch");
        for (LinguineParser.CaseContext caseContext : ctx.case_()) {
            String condicionValor = null;
            String nombreEtiqueta = null;
            if (caseContext.ID() != null) {
                condicionValor = caseContext.INT().getText();
                nombreEtiqueta = "lookupswitch_" + idMatch + "_case" + numCases;
            } else if (caseContext.INTERR() != null) {
                condicionValor = caseContext.INTERR().getText();
                nombreEtiqueta = "lookupswitch_" + idMatch + "_case_default";
            }
            cg.insertarLinea(this.bloqueActual, condicionValor + " : " + nombreEtiqueta);
            etiquetas.add(nombreEtiqueta);
            numCases++;
        }
        cg.insertarLinea(this.bloqueActual, "default : lookupswitch_" + idMatch + "_default");

        for (int i = 0; i < etiquetas.size(); i++) {
            String etiqueta = etiquetas.get(i);
            cg.insertarLinea(this.bloqueActual, etiqueta + ":");
            for (LinguineParser.CaseContext caseContext : ctx.case_()) {
                String valor = null;
                if (caseContext.ID() != null) {
                    valor = "\'" + caseContext.ID().getText() + "\'";
//                    introducirSimbolo(this.bloqueActual, "ldc " + valor);
                    cg.guardarString(this.bloqueActual, valor);
                } else if (caseContext.expression() != null) {
                    valor = (String) visit(caseContext.expression()).getValor();
                }
                cg.insertarLinea(this.bloqueActual, "goto " + "lookupswitch_" + idMatch + "End");
            }
        }

        cg.insertarLinea(this.bloqueActual, "lookupswitch_" + idMatch + "_case_default:");
        cg.insertarLinea(this.bloqueActual, "ldc \"Other\"");
        cg.insertarLinea(this.bloqueActual, "lookupswitch_" + idMatch + "End:");
        return null;
//        Simbolo simbolo = null;
//        String nombreVariable = ctx.ID().getText();
//        Simbolo variableMatch = tablaSimbolos.recogerVariable(nombreVariable);
//        if (variableMatch == null) throw new RuntimeException("Simbolo no existente");
//        for (LinguineParser.CaseContext caseContext : ctx.case_()) {
//            int caseNum = Integer.parseInt(caseContext.INT().getText());
//            if (caseNum == (int) variableMatch.getValor()) {
//                simbolo = visit(caseContext.expression());
//            }
//        }
//        return simbolo;
    }

    @Override
    public Simbolo visitForLoop(LinguineParser.ForLoopContext ctx) {
        int indexFor = cg.getIndexFor();
        String nombreFor = "for_" + indexFor;
        String nombreVarFor = visit(ctx.declaration()).getNombre();
        int condicional = (int) visit(ctx.aritmetic()).getValor();

        cg.insertarLinea(this.bloqueActual, nombreFor + ":");
        cg.insertarLinea(this.bloqueActual, "iload " + cg.buscarLocal(nombreVarFor));
        cg.insertarLinea(this.bloqueActual, "ldc " + condicional);
        cg.insertarLinea(this.bloqueActual, "if_icmplt " + nombreFor + "_end");
        this.escribirJasmin = true;
        visit(ctx.expression());
        this.escribirJasmin = false;
        cg.insertarLinea(this.bloqueActual, "iinc " + cg.buscarLocal(nombreVarFor) + " 1");
        cg.insertarLinea(this.bloqueActual, "goto " + nombreFor);
        cg.insertarLinea(this.bloqueActual, nombreFor + "_end:");
        return null;
    }

//    @Override
//    public Simbolo visitWhileLoop(LinguineParser.WhileLoopContext ctx) {
//        int indexWhile = cg.getIndexWhile();
//        String nombreWhile = "while_" + indexWhile;
//        String nombreVarWhile = visit(ctx.declaration()).getNombre();
//        int condicional = (int) visit(ctx.aritmetic()).getValor();
//
//        cg.insertarLinea(this.bloqueActual, nombreWhile + ":");
//        cg.insertarLinea(this.bloqueActual, "iload " + cg.buscarLocal(nombreVarWhile));
//        cg.insertarLinea(this.bloqueActual, "ldc " + condicional);
//        cg.insertarLinea(this.bloqueActual, "if_icmplt " + nombreWhile + "_end");
//        this.escribirJasmin = true;
//        visit(ctx.expression());
//        this.escribirJasmin = false;
//        cg.insertarLinea(this.bloqueActual, "iinc " + cg.buscarLocal(nombreVarWhile) + " 1");
//        cg.insertarLinea(this.bloqueActual, "goto " + nombreWhile);
//        cg.insertarLinea(this.bloqueActual, nombreWhile + "_end:");
//        return null;
//    }

    @Override
    public Simbolo visitCase(LinguineParser.CaseContext ctx) {
        String valor = null;
        if (ctx.ID() != null) {
            valor = "\'" + ctx.ID().getText() + "\'";
            cg.guardarString(this.bloqueActual, valor);
        } else if (ctx.expression() != null) {
            valor = (String) visit(ctx.expression()).getValor();
        }
        return null;
    }

    @Override
    public Simbolo visitConditional(LinguineParser.ConditionalContext ctx) {
        this.escribirJasmin = false;

        String variable = ctx.ID().getText();
        int valorComparado = (int) visit(ctx.aritmetic()).getValor();
        String tipoOperador = ctx.comparator().getText();

        this.escribirJasmin = true;

        cg.generarCabeceraIf(this.bloqueActual, variable, valorComparado, tipoOperador);
        this.guardarVariables = false;
        visit(ctx.expression(0));
        cg.generarElse(this.bloqueActual);
        if (ctx.expression(1) != null) visit(ctx.expression(1));
        cg.finalizarIf(this.bloqueActual);
        this.guardarVariables = true;

        this.escribirJasmin = false;
        return new Simbolo("no tratable", null);
//        String nombre = "if" + (tablaSimbolos.getOrder() + 1);
//        String condicionIf = ctx.comparator().getText();
//        Simbolo simbolo = new Simbolo("if", null);
//        introducirSimbolo(nombre, simbolo);
//        cg.generarIf(this.bloqueActual, nombre, ctx.ID().getText(), (int) visit(ctx.aritmetic()).getValor(), condicionIf);
//        this.bloqueActual = nombre;
//        this.interpretarSimbolos = false;
//        visit(ctx.expression(0));
//        this.bloqueActual = nombre + "_else";
//        visit(ctx.expression(1));
//        this.bloqueActual = "Main body";
//        this.interpretarSimbolos = true;
//        return simbolo;
    }

    @Override
    public Simbolo visitExpression(LinguineParser.ExpressionContext ctx) {
        Simbolo simbolo = null;

        if (ctx.declaration() != null) {
            simbolo = visit(ctx.declaration());
        } else if (ctx.conditional() != null) {
            simbolo = visit(ctx.conditional());
        } else if (ctx.function_call() != null) {
            simbolo = visit(ctx.function_call());
        } else if (ctx.aritmetic() != null) {
            simbolo = visit(ctx.aritmetic());
        } else if (ctx.match_statement() != null) {
            simbolo = visit(ctx.match_statement());
        } else if (ctx.show_statement() != null) {
            simbolo = visit(ctx.show_statement());
        }

        return simbolo;
    }

    @Override
    public Simbolo visitFunction(LinguineParser.FunctionContext ctx) {
        String nombreFuncion = ctx.ID().getText();
        String[] parametrosRaw = (String[]) visit(ctx.param_list()).getValor();
        String parametros = "I".repeat(parametrosRaw.length);
        String tipoRetorno = "I";
        cg.generateFunc(100, 100, nombreFuncion, parametros, tipoRetorno);
        this.bloqueActual = nombreFuncion;
        cg.setBloqueActual(this.bloqueActual);
        int numParametro = 0;
        for (String parametro : parametrosRaw) {
            introducirSimbolo(parametro + "->" + nombreFuncion, new Simbolo("parametro", numParametro));
            cg.asignarLocal(parametro);
            numParametro++;
        }
        this.modoParametrosNombre = nombreFuncion;
        this.modoParametros = true;
        this.escribirJasmin = true;
        visit(ctx.expression());
        this.modoParametrosNombre = null;
        this.modoParametros = false;
        this.bloqueActual = "Main body";
        cg.setBloqueActual(this.bloqueActual);
        this.escribirJasmin = false;
        return null;
//        String funcNombre = ctx.ID().getText();
//        Simbolo simbolo = new Simbolo("declaracion_funcion", ctx.expression().getText(), parametros);
//        introducirSimbolo(funcNombre, simbolo);
//        cg.generateFunc(funcNombre, interpretarParametros(parametros), "I", 100, 100);
//        this.bloqueActual = funcNombre;
//        this.interpretarSimbolos = false;
//        visit(ctx.expression());
//        this.bloqueActual = "Main body";
//        this.interpretarSimbolos = true;
//        return simbolo;
    }

    @Override
    public Simbolo visitFunction_call(LinguineParser.Function_callContext ctx) {
        String nombreFuncion = ctx.ID(0).getText();
        String parametros = "I".repeat(ctx.aritmetic().size());
        String tipoRetorno = "I";

        boolean escribirJasminAnterior = this.escribirJasmin;
        this.escribirJasmin = true;
        this.modoParametros = true;
        this.modoParametrosNombre = nombreFuncion;
        for (LinguineParser.AritmeticContext aritmeticContext : ctx.aritmetic()) {
            visit(aritmeticContext);
        }
        this.modoParametros = false;
        this.modoParametrosNombre = null;
        this.escribirJasmin = escribirJasminAnterior;

        cg.insertarLinea(this.bloqueActual, "invokestatic " + this.nombreClase + "/" + nombreFuncion + "(" + parametros + ")" + tipoRetorno);

        return null;
//        Simbolo simbolo = null;
//        if (this.modoDeclaracion) { // TODO borked
//            List<LinguineParser.AritmeticContext> aritmetics = ctx.aritmetic();
//            String nombreFuncion = ctx.ID(0).getText();
//            Object[] parametros = new Object[aritmetics.size()];
//
//            for (int i = 0; i < aritmetics.size(); i++) {
//                parametros[i] = visit(aritmetics.get(i)).getValor();
//            }
//
//            Simbolo funcion = tablaSimbolos.recogerVariable(nombreFuncion);
//            if (funcion == null) throw new RuntimeException("La funcion " + nombreFuncion + " no ha sido declarada");
//            if (!funcion.getTipo().equals("declaracion_funcion")) throw new RuntimeException("No es una función");
//            simbolo = new Simbolo("llamadaFuncion", nombreFuncion, parametros);
//            simbolo.setRequiereFunc();
//        }
//        return simbolo;
    }

    private String interpretarParametros(String[] parametros) {
        StringBuilder sb = new StringBuilder();

        for (String parametro : parametros) {
            sb.append("I");
        }

        return sb.toString();
    }

    @Override
    public Simbolo visitParam_list(LinguineParser.Param_listContext ctx) {
        List<TerminalNode> listaTokens = ctx.getTokens(LinguineParser.ID);
        String[] parametros = new String[listaTokens.size()];
        for (int i = 0; i < listaTokens.size(); i++) {
            parametros[i] = listaTokens.get(i).getText();
        }
        return new Simbolo("String[]", parametros);
    }

    @Override
    public Simbolo visitDeclaration(LinguineParser.DeclarationContext ctx) {
        this.escribirJasmin = true;
        String nombreVariable = ctx.ID().getText();
        Simbolo simbolo = null;
        if (ctx.aritmetic() != null) {
            simbolo = visit(ctx.aritmetic());
        } else {
            simbolo = visit(ctx.conditional());
        }
        this.escribirJasmin = false;

        switch (simbolo.getTipo()) {
            case "string" -> cg.guardarString(this.bloqueActual, nombreVariable);
            default -> cg.guardarInt(this.bloqueActual, nombreVariable);
        }

        introducirSimbolo(nombreVariable, simbolo);
        return simbolo;
    }

    @Override
    public Simbolo visitAritmetic(LinguineParser.AritmeticContext ctx) {
        Simbolo simbolo = null;

        if (ctx.LPAREN() != null) {
            simbolo = visit(ctx.aritmetic(0));
        } else if (ctx.ASTERISCO() != null) {
            Simbolo simboloIzquierdo = visit(ctx.aritmetic(0));
            Simbolo simboloDerecho = visit(ctx.aritmetic(1));
            if (this.modoParametros) {
                cg.insertarLinea(this.bloqueActual, "imul");
            } else if (simboloIzquierdo.getTipo().equals("int") && simboloDerecho.getTipo().equals("int")) {
                int operadorIzquierdo = (int) simboloIzquierdo.getValor();
                int operadorDerecho = (int) simboloDerecho.getValor();
                if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "imul");
                int resultado = operadorIzquierdo * operadorDerecho;
                simbolo = new Simbolo("int", resultado);
            } else {
                cg.insertarLinea(this.bloqueActual, "imul");
            }
        } else if (ctx.DIVISION() != null) {
            int operadorIzquierdo = (int) visit(ctx.aritmetic(0)).getValor();
            int operadorDerecho = (int) visit(ctx.aritmetic(1)).getValor();
            if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "idiv");
            int resultado = operadorIzquierdo / operadorDerecho;
            simbolo = new Simbolo("int", resultado);
        } else if (ctx.PLUS() != null) {
            Simbolo simboloIzquierdo = visit(ctx.aritmetic(0));
            Simbolo simboloDerecho = visit(ctx.aritmetic(1));
            if (this.modoParametros) {
                cg.insertarLinea(this.bloqueActual, "iadd");
            } else if (simboloIzquierdo.getTipo().equals("int") && simboloDerecho.getTipo().equals("int")) {
                int operadorIzquierdo = (int) simboloIzquierdo.getValor();
                int operadorDerecho = (int) simboloDerecho.getValor();
                if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "iadd");
                int resultado = operadorIzquierdo + operadorDerecho;
                simbolo = new Simbolo("int", resultado);
            } else if (simboloIzquierdo.getTipo().equals("string") && simboloDerecho.getTipo().equals("string")) {
                String operadorIzquierdo = (String) simboloIzquierdo.getValor();
                String operadorDerecho = (String) simboloDerecho.getValor();
                if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;");
                String resultado = operadorIzquierdo + operadorDerecho;
                simbolo = new Simbolo("string", resultado);
            } else {
                cg.insertarLinea(this.bloqueActual, "iadd");
                simbolo = new Simbolo("int", "null");
            }
        } else if (ctx.MENOS() != null) {
            int operadorIzquierdo = (int) visit(ctx.aritmetic(0)).getValor();
            int operadorDerecho = (int) visit(ctx.aritmetic(1)).getValor();
            if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "isub");
            int resultado = operadorIzquierdo - operadorDerecho;
            simbolo = new Simbolo("int", resultado);
        } else if (ctx.asignation() != null) {
            simbolo = visit(ctx.asignation());
        }
        return simbolo;
    }

    @Override
    public Simbolo visitAsignation(LinguineParser.AsignationContext ctx) {
        Simbolo simbolo = null;
        if (ctx.INT() != null) {
            int valor = Integer.parseInt(ctx.INT().getText());
            if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "ldc " + valor);
            simbolo = new Simbolo("int", valor);
        } else if (ctx.ID() != null) {
            String nombreVariable = ctx.ID().getText();
            if (this.modoParametros) {
                nombreVariable = nombreVariable + "->" + this.modoParametrosNombre;
                simbolo = this.tablaSimbolos.recogerVariable(nombreVariable);
                cg.cargarVariableParam(this.bloqueActual, simbolo.getTipo(), (Integer) simbolo.getValor());
            } else {
                simbolo = this.tablaSimbolos.recogerVariable(nombreVariable);
                if (this.escribirJasmin)
                    cg.cargarVariable(this.bloqueActual, nombreVariable, simbolo.getTipo());
            }
        } else if (ctx.STRING() != null) {
            String valor = ctx.STRING().getText();
            if (this.escribirJasmin) cg.insertarLinea(this.bloqueActual, "ldc " + valor);
            simbolo = new Simbolo("string", valor);
        } else if (ctx.function_call() != null) {
            simbolo = visit(ctx.function_call());
            simbolo = new Simbolo("llamada funcion", null);
        }
        return simbolo;
    }

    private String comprobarTipos(List<LinguineParser.AritmeticContext> ctxList) {
        LinkedHashSet<String> tipos = new LinkedHashSet<>();
        for (LinguineParser.AritmeticContext aritmeticContext : ctxList) {
            String tipo = visit(aritmeticContext).getTipo();
            tipos.add(tipo);
        }
        String tipo = tipos.removeLast();
        if (tipos.size() > 1) tipo = "combinacion";
        return tipo;
    }

    @Override
    public Simbolo visitShow_statement(LinguineParser.Show_statementContext ctx) {
//        String parametro = ctx.aritmetic().getText();
////        String[] parametros = new String[1];
////        parametros[0] = ctx.aritmetic().getText();
//        Simbolo simbolo = new Simbolo("llamadaFuncion", "show", parametros);
//        simbolo.setRequiereFunc();
//        tablaSimbolos.introducirSimbolo("show", simbolo);


        cg.insertarLinea(this.bloqueActual, "getstatic java/lang/System/out Ljava/io/PrintStream;");
        this.escribirJasmin = true;
        Simbolo simbolo = visit(ctx.aritmetic());
        switch (simbolo.getTipo()) {
            case "string" ->
                    cg.insertarLinea(this.bloqueActual, "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
            default -> cg.insertarLinea(this.bloqueActual, "invokevirtual java/io/PrintStream/println(I)V");
        }
        this.escribirJasmin = false;

        return null;
    }

    public void introducirSimbolo(String varNombre, Simbolo simbolo) {
        if (this.guardarVariables) {
            simbolo.setNombre(varNombre);
            tablaSimbolos.introducirSimbolo(varNombre, simbolo);
        }
    }
}
