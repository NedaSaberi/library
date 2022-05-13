package extraPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BookManage {

    ArrayList<Book> books;
    private static int counter = 0;
    private static int bCode = 1000;
    boolean execute ;
    private int index;

    public BookManage() {
        books = new ArrayList<Book>();
    }

    public void menu() {
        execute=true;
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (execute) {
            System.out.println("============================");
            System.out.printf("1- Books list %n2- Add a new book%n3- Edit info%n4- Delete%n5- Search by name%n6- Search by code%n7- Return%n");
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
                        System.out.printf("%15d%15s%12d%15s%17d%14d%22s%n", book.getCode(), book.getTitle(), book.getPublishYear(), book.getAuthorName(), book.getPrice(), book.getPageNumber(), book.state);
                    }
                }
                break;
            case 6:
                System.out.print("What are you looking for? Enter the code: ");
                int code = scanner.nextInt();
                Book book = searchByCode(code);
                if (book != null)
                    System.out.printf("%15d%15s%12d%15s%17d%14d%22s%n", book.getCode(), book.getTitle(), book.getPublishYear(), book.getAuthorName(), book.getPrice(), book.getPageNumber(), book.state);
                break;
            case 7:
                execute = false;
                break;

        }
    }


    public void addNewBook() {
        books.add(getInfo());
        counter++;
    }

    public void showBooks() {
        System.out.printf("%15s%15s%15s%15s%15s%19s%15S%n", "Code", "Title", "Publish_year", "Author_name", "Price", "Number_of_pages", "State");
        for (Book book : books) {
            System.out.printf("%15d%15s%12d%15s%17d%14d%22s%n", book.getCode(), book.getTitle(), book.getPublishYear(), book.getAuthorName(), book.getPrice(), book.getPageNumber(), book.state);
        }
    }

    public Book getInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book title: ");
        String bTitle = scanner.nextLine();
        System.out.print("Author name: ");
        String aName = scanner.nextLine();
        System.out.print("Publish year: ");
        Integer year = scanner.nextInt();
        System.out.print("Price: ");
        int price = scanner.nextInt();
        System.out.print("Number of pages: ");
        Integer pNumber = scanner.nextInt();
        System.out.print("Enter the state of the book" + Arrays.toString(EnumClass.State.values()) + ": ");
        Scanner scanner1 = new Scanner(System.in);
        String str = scanner1.nextLine();
        EnumClass.State state = EnumClass.State.valueOf(str);
        bCode++;
        Book book = new Book(bCode, bTitle, aName, price, state);
        book.setPageNumber(pNumber);
        book.setPublishYear(year);
        return book;
    }

    public Book searchByCode(int code) {
        Book searchedBook = null;

        for (Book book : books) {
            if (book.getCode() == code) {
                searchedBook = new Book(book.getCode(), book.getTitle(), book.getAuthorName(), book.getPrice());
                searchedBook.setPublishYear(book.getPublishYear());
                searchedBook.setPrice(book.getPrice());
                searchedBook.setState(book.getState());
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
            if (book.getTitle().contains(bName)) {
                searchedBooks.add(book);
            }
        }
        if (searchedBooks.isEmpty()) System.out.println("There is no match info ...");
        return searchedBooks;
    }

    public void deleteBook(int code) {
        Book book = searchByCode(code);
        if (book != null) {
            System.out.printf("%15d%15s%12d%15s%17d%14d%22s%n", book.getCode(), book.getTitle(), book.getPublishYear(), book.getAuthorName(), book.getPrice(), book.getPageNumber(), book.state);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you sure to delete? ");
            String yesCheck = scanner.nextLine();
            if (yesCheck.contains("y") || yesCheck.contains("Y")) {
                books.remove(index);
                counter--;
                System.out.println("The desired record was deleted! ");

            }
        }
    }

    public void editInfo(int code) {
        Book book1 = new Book("", "");
        int cnt = 0;
        for (Book book : books) {
            if (book.getCode() == code) {
                System.out.printf("%15s%15s%15s%15s%15s%19s%15S%n", "Code", "Title", "Publish_year", "Author_name", "Price", "Number_of_pages", "State");
                System.out.printf("%15d%15s%12d%15s%17d%14d%22s%n", book.getCode(), book.getTitle(), book.getPublishYear(), book.getAuthorName(), book.getPrice(), book.getPageNumber(), book.state);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Publish year: ");
                Integer year = scanner.nextInt();
                System.out.print("Price: ");
                int price = scanner.nextInt();
                System.out.print("Number of pages: ");
                Integer pNumber = scanner.nextInt();
                System.out.println("State: " + Arrays.toString(EnumClass.State.values()));
                Scanner scanner1 = new Scanner(System.in);
                String str = scanner1.nextLine();
                book.setState(EnumClass.State.valueOf(str));
                book.setPublishYear(year);
                book.setPrice(price);
                book.setPageNumber(pNumber);
                //////  book.setState(state);
                cnt++;
                System.out.println("Editing Done!");
            }
        }
        if (cnt == 0) System.out.println("Invalid code number! ...");
    }

    public void printBookIn2Column(Book book) {
        System.out.printf("%15d%15s%22s%n", book.getCode(), book.getTitle(), book.state);
    }
}
