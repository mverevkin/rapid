package ru.sbrf.cl.decision.rapid.document.impl;

import lombok.RequiredArgsConstructor;
import ru.sbrf.cl.decision.rapid.core.functional.Result;
import ru.sbrf.cl.decision.rapid.core.functional.Success;
import ru.sbrf.cl.decision.rapid.document.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class SaveDocumentUseCaseImpl implements SaveDocumentUseCase {

    private final DocumentRepository repository;
    private final DocumentValidator validator;

    @Override
    public Result<Document> saveDocument(Document document) {
        return Result.of(() -> document)
                .ifSuccess(validator::validateDocument)
                .ifSuccess(repository::updateDocument);
    }
}
