package tablaSimbolos;

import IO.Printer;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class TablaSimbolos {
    private LinkedHashMap<String, Simbolo> tabla;
    private Simbolo lastSimbol;
    private int order;

    public TablaSimbolos() {
        this.tabla = new LinkedHashMap<String, Simbolo>();
        this.order = 0;
        this.lastSimbol = null;
    }

    public Simbolo recogerVariable(String varNombre) {
        return tabla.get(varNombre);
    }

    public void introducirSimbolo(String varNombre, Simbolo simbolo) {
        order++;
        simbolo.setOrder(this.order);
        tabla.put(varNombre, simbolo);
        this.lastSimbol = simbolo;
    }

    public int getOrder() {
        return order;
    }

    public Simbolo cogerUltimoSimbolo() {
        return lastSimbol;
    }

    public void printSimbolos() {
        for (String s : this.tabla.keySet()) {
            Simbolo simbolo = this.tabla.get(s);

            String tipo = simbolo.getTipo() != null ? simbolo.getTipo() : "null";
            String valor = simbolo.getValor() != null ? simbolo.getValor().toString() : "null";
            String parametros = simbolo.getParametros() != null ? Arrays.toString(simbolo.getParametros()) : "null";
            String requiereFunc = Boolean.toString(simbolo.requiereFunc());
            String order = String.valueOf(simbolo.getOrder());

            Printer.print("Simbolo: " + s + ", tipo: " + tipo + ", valor: " + valor + ", parametros: " + parametros + ", requiereFunc: " + requiereFunc + ", orden: " + order);
        }
    }

}
