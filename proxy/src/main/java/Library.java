import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, IDocument> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addUnprotectedDocument(String id, String creationDate, String content) {
        if (documents.containsKey(id)) {
            throw new IllegalArgumentException("Document with id '" + id + "' already exists.");
        }

        Document document = new Document(id, creationDate, content);
        documents.put(id, document);
    }

    public void addProtectedDocument(String id, String creationDate, String content) {
        if (documents.containsKey(id)) {
            throw new IllegalArgumentException("Document with id '" + id + "' already exists.");
        }

        Document realDocument = new Document(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);
    }

    public IDocument getDocument(String id) {
        IDocument document = documents.get(id);

        if (document == null) {
            throw new IllegalArgumentException("No document found with id '" + id + "'.");
        }

        return document;
    }

    public Collection<IDocument> getAllDocuments() {
        return documents.values();
    }
}