package ru.sbrf.cl.decision.rapid.document.usecase;

import lombok.RequiredArgsConstructor;
import ru.sbrf.cl.decision.rapid.document.Document;
import ru.sbrf.cl.decision.rapid.document.exception.DocumentNotFoundException;
import ru.sbrf.cl.decision.rapid.document.port.DocumentRepository;

@RequiredArgsConstructor
public class UpdateDocumentUseCaseImpl implements UpdateDocumentUseCase {

    private final DocumentRepository repository;

    @Override
    public Document updateDocument(Document document) {
        Document documentEntity = repository.getDocumentById(document.getId())
                .orElseThrow(() ->
                        new DocumentNotFoundException("Document with id: " + document.getId() + " not found"));
        documentEntity.setName(document.getName());
        return repository.updateDocument(documentEntity);
    }
}
