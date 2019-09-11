package com.projettisaseptembre.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntouvableException extends RuntimeException {
    public ProduitIntouvableException(String s) {
        super(s);
    }
}
