public class Book {
    private int code;
    private String bookName;
    private String authorName;
    private int publishYear;

    public Book() {
    }
    public Book(int code, String bookName, String authorName, int publishYear) {
        this.code = code;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishYear = publishYear;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
