package ru.sbrf.cl.decision.rapid.document.port;

import ru.sbrf.cl.decision.rapid.document.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository {
    /**
     * Get document by id
     *
     * @param id - document id
     * @return document
     */
    Optional<Document> getDocumentById(Long id);

    /**
     * Get all documents
     *
     * @return documents
     */
    List<Document> getDocuments();

    /**
     * Create new document
     *
     * @param document - new document
     * @return document
     */
    Document createDocument(Document document);

    /**
     * Save document. Used for update state of document.
     *
     * @param document - document
     * @return document
     */
    Document updateDocument(Document document);
}
