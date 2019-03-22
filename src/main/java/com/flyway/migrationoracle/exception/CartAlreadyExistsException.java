package com.flyway.migrationoracle.exception;

/**
 * Created by e068635 on 3/10/2019.
 */
public class CartAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 7899928512143245128L;

    public CartAlreadyExistsException(String message) {
        super(message);
    }

}
