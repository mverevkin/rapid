package ru.sbrf.cl.decision.rapid.document.validator;

import ru.sbrf.cl.decision.rapid.document.Document;
import ru.sbrf.cl.decision.rapid.document.exception.DocumentValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseDocumentValidator implements DocumentValidator {

    private final List<ValidationRule> validationRules;

    public BaseDocumentValidator() {
        validationRules = new ArrayList<>();
        validationRules.add(new DocumentNotNullRule());
    }

    @Override
    public List<ValidationRule> getValidationRules() {
        return validationRules;
    }

    @Override
    public void validateDocument(Document document) {
        validationRules.stream().map(rule -> rule.validate(document))
                .filter(ValidationResult::isError)
                .map(ValidationResult::getErrorMessage)
                .findFirst()
                .ifPresent(error -> {
                    throw new DocumentValidationException(error);
                });
    }

    @Override
    public void addRule(ValidationRule rule) {
        validationRules.add(rule);
    }

    @Override
    public void addRules(List<ValidationRule> rules) {
        validationRules.addAll(rules);
    }
}
