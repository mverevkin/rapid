package ru.sbrf.cl.decision.rapid.document.validator;

import ru.sbrf.cl.decision.rapid.document.Document;

public class DocumentNotNullRule implements ValidationRule {

    @Override
    public String getErrorMessage(Document document) {
        return "Document can't be null";
    }

    @Override
    public boolean hasError(Document document) {
        return document == null;
    }
}
