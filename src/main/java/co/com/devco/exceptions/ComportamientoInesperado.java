package co.com.devco.exceptions;

public class ComportamientoInesperado  extends AssertionError {
    public static final String FILTRO_INESPERADO = "El filtro obtenido no es el esperado";
    public static final String RESULTADO_INESPERADO = "El resultado obtenido no es el esperado";
    public static final String ID_NO_ENCONTRADO = "El id no se encontro";

    public ComportamientoInesperado(String message, Throwable cause){
        super(message, cause);
    }
}
