package ru.sbrf.cl.decision.rapid.document;

import ru.sbrf.cl.decision.rapid.document.Document;

import java.util.List;
import java.util.Optional;

public interface FindDocumentUseCase {
    Optional<Document> findDocumentById(Long id);
    List<Document> findDocuments();
}
