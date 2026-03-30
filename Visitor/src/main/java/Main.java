public class Main {
    public static void main(String[] args) {
        // Create directory structure
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");
        Directory work = new Directory("work");

        // Create files
        File file1 = new File("notes.txt", 1.5);
        File file2 = new File("report.pdf", 2.0);
        File file3 = new File("photo.jpg", 5.2);
        File file4 = new File("presentation.pptx", 8.0);
        File file5 = new File("report_backup.txt", 1.0);

        // Build file system tree
        documents.addElement(file1);
        documents.addElement(file2);

        images.addElement(file3);

        work.addElement(file4);
        work.addElement(file5);

        root.addElement(documents);
        root.addElement(images);
        root.addElement(work);

        // 1) Calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("=== Total size calculation ===");
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");
        System.out.println();

        // 2) Search files by name pattern
        SearchVisitor searchVisitor = new SearchVisitor("report");
        root.accept(searchVisitor);

        System.out.println("=== Search results ===");
        System.out.println("Files containing 'report' in their name:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSize() + " MB)");
        }

        // 3) Another example: search by extension
        SearchVisitor txtSearchVisitor = new SearchVisitor(".txt");
        root.accept(txtSearchVisitor);

        System.out.println();
        System.out.println("=== TXT files ===");
        for (File file : txtSearchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName() + " (" + file.getSize() + " MB)");
        }
    }
}