package com.brayandvlp.JannieVet.infra.errores;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String message) {
        super(message);
    }
}
