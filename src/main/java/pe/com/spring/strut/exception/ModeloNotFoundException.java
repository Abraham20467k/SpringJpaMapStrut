package pe.com.spring.strut.exception;

public class ModeloNotFoundException extends RuntimeException {

    public ModeloNotFoundException(String mensaje) {
        super(mensaje);
    }
}
