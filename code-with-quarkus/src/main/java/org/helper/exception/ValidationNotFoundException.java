package org.helper.exception;

public class ValidationNotFoundException extends PVRestClientRuntimeException {
    public ValidationNotFoundException(String problem, int status) {
        super(problem, status);
    }
}
