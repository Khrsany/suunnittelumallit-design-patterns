public class DocumentProxy implements IDocument {
    private final Document realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(Document realDocument) {
        if (realDocument == null) {
            throw new IllegalArgumentException("Real document cannot be null.");
        }

        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) {
        if (user == null) {
            throw new AccessDeniedException("Access denied: user is missing.");
        }

        if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        }

        throw new AccessDeniedException(
                "Access denied: user '" + user.getUsername()
                        + "' is not allowed to access document '" + realDocument.getId() + "'."
        );
    }
}