package ru.sbrf.cl.decision.rapid.document.impl;

import lombok.RequiredArgsConstructor;
import ru.sbrf.cl.decision.rapid.document.Document;
import ru.sbrf.cl.decision.rapid.document.DocumentRepository;
import ru.sbrf.cl.decision.rapid.document.FindDocumentUseCase;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FindDocumentUseCaseImpl implements FindDocumentUseCase {

    private final DocumentRepository repository;

    @Override
    public Optional<Document> findDocumentById(Long id) {
        return repository.getDocumentById(id);
    }

    @Override
    public List<Document> findDocuments() {
        return repository.getDocuments();
    }
}
