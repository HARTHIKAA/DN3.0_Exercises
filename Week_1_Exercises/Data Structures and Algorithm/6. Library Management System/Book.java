import java.util.Arrays;
import java.util.Comparator;

class LibraryManagementSystem {
    private Book[] books;
    private int count;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count == books.length) {
            books = Arrays.copyOf(books, books.length * 2);
        }
        books[count++] = book;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle));
        int left = 0, right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void traverseBooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(2);
        lms.addBook(new Book(1, "The Catcher in the Rye", "J.D. Salinger"));
        lms.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        lms.addBook(new Book(3, "1984", "George Orwell"));

        System.out.println("All Books:");
        lms.traverseBooks();

        System.out.println("\nLinear Search for '1984':");
        Book foundBook = lms.linearSearchByTitle("1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");

        System.out.println("\nBinary Search for 'To Kill a Mockingbird':");
        foundBook = lms.binarySearchByTitle("To Kill a Mockingbird");
        System.out.println(foundBook != null ? foundBook : "Book not found");
    }
}
