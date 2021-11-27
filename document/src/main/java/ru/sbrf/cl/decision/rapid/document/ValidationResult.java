package ru.sbrf.cl.decision.rapid.document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ValidationResult {
    private final String errorMessage;
    private final boolean isError;
}
