class Document implements IDocument {
    private final String id;
    private final String creationDate;
    private final String content;

    Document(String id, String creationDate, String content) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Document id cannot be null or blank.");
        }
        if (creationDate == null || creationDate.isBlank()) {
            throw new IllegalArgumentException("Creation date cannot be null or blank.");
        }
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null.");
        }

        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}