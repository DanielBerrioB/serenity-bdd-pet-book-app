package co.com.devco.exceptions;

public class ComportamientoInesperado  extends AssertionError {
    public static final String FILTRO_INESPERADO = "El filtro obtenido no es el esperado";

    public ComportamientoInesperado(String message, Throwable cause){
        super(message, cause);
    }
}
