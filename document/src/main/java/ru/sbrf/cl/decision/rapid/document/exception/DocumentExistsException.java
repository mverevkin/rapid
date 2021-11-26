package ru.sbrf.cl.decision.rapid.document.exception;

public class DocumentExistsException extends RuntimeException {
    public DocumentExistsException(String message) {
        super(message);
    }
}
