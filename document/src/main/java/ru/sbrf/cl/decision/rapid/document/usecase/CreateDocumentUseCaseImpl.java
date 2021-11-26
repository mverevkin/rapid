package ru.sbrf.cl.decision.rapid.document.usecase;

import lombok.RequiredArgsConstructor;
import ru.sbrf.cl.decision.rapid.document.Document;
import ru.sbrf.cl.decision.rapid.document.exception.DocumentExistsException;
import ru.sbrf.cl.decision.rapid.document.port.DocumentRepository;
import ru.sbrf.cl.decision.rapid.document.validator.DocumentValidator;

@RequiredArgsConstructor
public class CreateDocumentUseCaseImpl implements CreateDocumentUseCase {

    private final DocumentRepository repository;
    private final DocumentValidator validator;

    @Override
    public Document createDocument(Document document) {
        validator.validateDocument(document);
        repository.getDocumentById(document.getId()).ifPresent(doc -> {
            throw new DocumentExistsException("Document with id: " + document.getId() + " already exists");
        });
        return repository.createDocument(document);
    }
}
