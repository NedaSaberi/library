import java.util.ArrayList;
import java.util.Scanner;

public class BookManagement {
    Book book;
    ArrayList<Book> books;
    int counter = 0;
    static int code = 1000;
    int index = 0;
    boolean excute=true;

    public BookManagement() {
        book = new Book();
        books = new ArrayList<>();

        showMenu();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (excute) {
            System.out.println("============================");
            System.out.printf("1- Books list %n2- Add a new book%n3- Edit%n4- Delete%n5- Search by name%n6- Search by code%n7- exit%n");
            System.out.println("============================");
            option = scanner.nextInt();
            procees(option);
        }
    }

    public void procees(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                showBooks();
                break;
            case 2:
                addNewBook();
                break;
            case 3:
                System.out.print("What do you want to edit? Enter its code: ");
                int code2 = scanner.nextInt();
                editInfo(code2);
                break;
            case 4:
                System.out.print("What are you deleting? Enter the code: ");
                int code1 = scanner.nextInt();
                deleteBook(code1);
                break;
            case 5:
                System.out.print("What are you looking for? Enter the name of the book: ");
                String name = scanner.nextLine();
                ArrayList<Book> books = searchByName(name);
                if (!books.isEmpty()) {
                    for (Book book : books) {
                        System.out.printf("%12d%15s%15d%15s%n", book.getCode(), book.getBookName(), book.getPublishYear(), book.getAuthorName());
                    }
                }
                break;
            case 6:
                System.out.print("What are you looking for? Enter the code: ");
                int code = scanner.nextInt();
                Book book = searchByCode(code);
                if (book != null)
                    System.out.printf("%12d%15s%15d%15s%n", book.getCode(), book.getBookName(), book.getPublishYear(), book.getAuthorName());
                break;
            case 7:
                excute= false;
                break;

        }
    }

    public void addNewBook() {
        code++;
        books.add(getInfo());
    }

    public void showBooks() {
        System.out.printf("%15s%15s%15s%15s%n", "Book_code", "Book_name", "Publish_year", "Author_name");
        for (Book book : books) {
            System.out.printf("%12d%15s%15d%15s%n", book.getCode(), book.getBookName(), book.getPublishYear(), book.getAuthorName());
        }
    }

    public Book getInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book name: ");
        String bName = scanner.nextLine();
        System.out.print("Author name: ");
        String aName = scanner.nextLine();
        System.out.print("Publish year: ");
        int year = scanner.nextInt();
        Book book = new Book(code, bName, aName, year);
        return book;
    }

    public Book searchByCode(int code) {
        Book searchedBook = null;

        for (Book book : books) {
            if (book.getCode() == code) {
                searchedBook = new Book(book.getCode(), book.getBookName(), book.getAuthorName(), book.getPublishYear());
                index = books.indexOf(book);
            }
        }
        if (searchedBook == null) System.out.println("Invalid code! ...");
        return searchedBook;
    }

    public ArrayList<Book> searchByName(String bName) {
        ArrayList<Book> searchedBooks = new ArrayList<>();
        // if (searchedBooks==null) System.out.println("null");
        for (Book book : books) {
            if (book.getBookName().contains(bName)) {
                searchedBooks.add(book);
            }
        }
        if (searchedBooks.isEmpty()) System.out.println("Invalid book name! ...");
        return searchedBooks;
    }

    public void deleteBook(int code) {
        Book book = searchByCode(code);
        if (book != null) {
            System.out.printf("%12d%15s%15d%15s%n", book.getCode(), book.getBookName(), book.getPublishYear(), book.getAuthorName());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you sure to delete? ");
            String yesCheck= scanner.nextLine();
            if (yesCheck.contains("y") || yesCheck.contains("Y"))
                books.remove(index);
        }
    }

    public void editInfo(int code) {
        Book book1 = new Book();
        int cnt=0;
        for (Book book : books) {
            if (book.getCode() == code) {
                System.out.printf("%12d%15s%15d%15s%n", book.getCode(), book.getBookName(), book.getPublishYear(), book.getAuthorName());
                book1= getInfo();
                book.setBookName(book1.getBookName());
                book.setAuthorName(book1.getAuthorName());
                book.setPublishYear(book1.getPublishYear());
                cnt++;
            }
        }
        if (cnt==0) System.out.println("Invalid code number! ...");
    }
}