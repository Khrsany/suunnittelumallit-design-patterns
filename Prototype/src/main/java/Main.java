import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecommendationManager manager = new RecommendationManager();

        // lisätään pari valmista listaa, jotta ohjelmaa on helpompi testata
        Recommendation students = new Recommendation("Students");
        students.addBook(new Book("Java Basics", "John Smith", "Programming", 2020));
        students.addBook(new Book("Algorithms Made Easy", "Mike Brown", "Computer Science", 2021));
        manager.addRecommendation("studentsList", students);

        Recommendation fantasyFans = new Recommendation("Fantasy Readers");
        fantasyFans.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
        fantasyFans.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 1997));
        manager.addRecommendation("fantasyList", fantasyFans);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Book Recommendation System ===");
            System.out.println("1. View all recommendation lists");
            System.out.println("2. View one recommendation list");
            System.out.println("3. Create a new recommendation list");
            System.out.println("4. Clone an existing recommendation list");
            System.out.println("5. Add a book to a recommendation list");
            System.out.println("6. Remove a book from a recommendation list");
            System.out.println("7. Change target audience");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.showAllRecommendations();
                    break;

                case "2":
                    System.out.print("Enter list name: ");
                    String listNameToView = scanner.nextLine();

                    Recommendation listToView = manager.getRecommendation(listNameToView);
                    if (listToView == null) {
                        System.out.println("List not found.");
                    } else {
                        System.out.println("\nList name: " + listNameToView);
                        listToView.show();
                    }
                    break;

                case "3":
                    System.out.print("Enter new list name: ");
                    String newListName = scanner.nextLine();

                    if (manager.exists(newListName)) {
                        System.out.println("A list with that name already exists.");
                        break;
                    }

                    System.out.print("Enter target audience: ");
                    String audience = scanner.nextLine();

                    Recommendation newRecommendation = new Recommendation(audience);

                    if (manager.addRecommendation(newListName, newRecommendation)) {
                        System.out.println("New recommendation list created.");
                    } else {
                        System.out.println("Could not create list.");
                    }
                    break;

                case "4":
                    System.out.print("Enter source list name: ");
                    String oldName = scanner.nextLine();

                    System.out.print("Enter new cloned list name: ");
                    String clonedName = scanner.nextLine();

                    if (manager.cloneRecommendation(oldName, clonedName)) {
                        System.out.println("List cloned successfully.");
                    } else {
                        System.out.println("Cloning failed. Check the names.");
                    }
                    break;

                case "5":
                    System.out.print("Enter list name: ");
                    String listNameToAdd = scanner.nextLine();

                    Recommendation listToAddBook = manager.getRecommendation(listNameToAdd);
                    if (listToAddBook == null) {
                        System.out.println("List not found.");
                        break;
                    }

                    System.out.print("Book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    System.out.print("Publication year: ");
                    int year;

                    try {
                        year = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid year.");
                        break;
                    }

                    listToAddBook.addBook(new Book(title, author, genre, year));
                    System.out.println("Book added.");
                    break;

                case "6":
                    System.out.print("Enter list name: ");
                    String listNameToRemove = scanner.nextLine();

                    Recommendation listToRemoveBook = manager.getRecommendation(listNameToRemove);
                    if (listToRemoveBook == null) {
                        System.out.println("List not found.");
                        break;
                    }

                    System.out.print("Enter title of the book to remove: ");
                    String titleToRemove = scanner.nextLine();

                    if (listToRemoveBook.removeBookByTitle(titleToRemove)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "7":
                    System.out.print("Enter list name: ");
                    String listNameToEdit = scanner.nextLine();

                    Recommendation listToEdit = manager.getRecommendation(listNameToEdit);
                    if (listToEdit == null) {
                        System.out.println("List not found.");
                        break;
                    }

                    System.out.print("Enter new target audience: ");
                    String newAudience = scanner.nextLine();

                    listToEdit.setTargetAudience(newAudience);
                    System.out.println("Target audience updated.");
                    break;

                case "0":
                    running = false;
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}