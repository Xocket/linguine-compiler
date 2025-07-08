package tablaSimbolos;

public class Simbolo {
    private String nombre;
    private String tipo;
    private Object[] parametros;
    private Object valor;
    private boolean requiereFunc;
    private int order;

    public Simbolo(String tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.nombre = null;
        this.parametros = null;
        this.requiereFunc = false;
        this.order = 0;
    }

    public Simbolo(String tipo, Object valor, Object[] parametros) {
        this.tipo = tipo;
        this.valor = valor;
        this.nombre = null;
        this.parametros = parametros;
        this.requiereFunc = false;
        this.order = 0;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean requiereFunc() {
        return requiereFunc;
    }

    public void setRequiereFunc() {
        this.requiereFunc = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object[] getParametros() {
        return parametros;
    }

    public void setParametros(String[] parametros) {
        this.parametros = parametros;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }
}
