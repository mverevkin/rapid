package ru.sbrf.cl.decision.rapid.document;

public interface ValidationRule {
    ValidationResult validate(Document document);
}
