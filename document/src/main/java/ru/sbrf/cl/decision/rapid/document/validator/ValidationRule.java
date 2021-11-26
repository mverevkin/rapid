package ru.sbrf.cl.decision.rapid.document.validator;

import ru.sbrf.cl.decision.rapid.document.Document;

public interface ValidationRule {
    /**
     * Return error message if validation fail
     *
     * @return error message
     */
    String getErrorMessage(Document document);

    /**
     * Validate document, return false if validation fails and true if validation success
     *
     * @param document document
     * @return return false if validation fails and true if validation success
     */
    boolean hasError(Document document);

    default ValidationResult validate(Document document) {
        return new ValidationResult(getErrorMessage(document), hasError(document));
    }
}
