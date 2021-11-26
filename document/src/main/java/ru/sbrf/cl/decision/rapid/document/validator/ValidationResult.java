package ru.sbrf.cl.decision.rapid.document.validator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ValidationResult {
    private final String errorMessage;
    private final boolean isError;
}
