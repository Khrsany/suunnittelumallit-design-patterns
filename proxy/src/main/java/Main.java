public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService accessControl = AccessControlService.getInstance();

        // Users
        User alice = new User("alice");
        User bob = new User("bob");
        User charlie = new User("charlie");

        // Add documents to library
        library.addUnprotectedDocument(
                "doc1",
                "2026-03-30",
                "This is a public document. Everyone can read this."
        );

        library.addProtectedDocument(
                "secret1",
                "2026-03-29",
                "Top secret content for selected users only."
        );

        library.addProtectedDocument(
                "secret2",
                "2026-03-28",
                "Another protected document."
        );

        // Grant permissions
        accessControl.grantAccess("secret1", "alice");
        accessControl.grantAccess("secret2", "bob");

        // 1) Public document: everyone can read
        System.out.println("=== Public document ===");
        IDocument publicDoc = library.getDocument("doc1");
        System.out.println("ID: " + publicDoc.getId());
        System.out.println("Creation date: " + publicDoc.getCreationDate());
        System.out.println("Content for Alice: " + publicDoc.getContent(alice));
        System.out.println("Content for Bob: " + publicDoc.getContent(bob));
        System.out.println();

        // 2) Protected document: allowed user
        System.out.println("=== Protected document: allowed user ===");
        IDocument protectedDoc1 = library.getDocument("secret1");
        System.out.println("ID: " + protectedDoc1.getId());
        System.out.println("Creation date: " + protectedDoc1.getCreationDate());
        try {
            System.out.println("Content for Alice: " + protectedDoc1.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // 3) Protected document: denied user
        System.out.println("=== Protected document: denied user ===");
        try {
            System.out.println("Content for Bob: " + protectedDoc1.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // 4) Another protected document
        System.out.println("=== Another protected document ===");
        IDocument protectedDoc2 = library.getDocument("secret2");
        System.out.println("ID: " + protectedDoc2.getId());
        System.out.println("Creation date: " + protectedDoc2.getCreationDate());

        try {
            System.out.println("Content for Bob: " + protectedDoc2.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Content for Charlie: " + protectedDoc2.getContent(charlie));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}