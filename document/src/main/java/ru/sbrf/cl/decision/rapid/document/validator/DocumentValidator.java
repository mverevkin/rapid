package ru.sbrf.cl.decision.rapid.document.validator;

import ru.sbrf.cl.decision.rapid.document.Document;

import java.util.List;

public interface DocumentValidator {
    List<ValidationRule> getValidationRules();
    void validateDocument(Document document);
    void addRule(ValidationRule rule);
    void addRules(List<ValidationRule> rules);
}
