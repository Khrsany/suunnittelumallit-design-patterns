import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String searchTerm;
    private final List<File> foundFiles;

    public SearchVisitor(String searchTerm) {
        if (searchTerm == null || searchTerm.isBlank()) {
            throw new IllegalArgumentException("Search term cannot be null or blank.");
        }

        this.searchTerm = searchTerm;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchTerm)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return Collections.unmodifiableList(foundFiles);
    }
}