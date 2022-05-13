package extraPractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;

public class Book {
   // public static Object State;
     private int code; // static: class variation //
//    private static int counter=0;
    private final String title; //final : just once initializing // just getter
    private final String authorName;
    private Integer publishYear; // optional initializing
    private int price;// compulsory initializing
    private Integer pageNumber; // optional initializing
    private Member lendingInfo;
    private LocalDateTime lendingDateTimeFrom;
    private LocalDateTime lendingDateTimeTo;
    EnumClass.State state;
    { //initializing block => some initializings which is similar within all constructors

    }

    public Book(String title, String authorName) {// final variables should be initialized
        this.title = title;
        this.authorName = authorName;
    }

    public Book(int code, String title, String authorName, int price, EnumClass.State state) {
        this.code= code;
        this.title = title;
        this.authorName = authorName;
        this.publishYear = publishYear;
        this.price = price;
        this.pageNumber = pageNumber;
        this.state=state;
    }
    public Book(int code, String title, String authorName, int price) {
        this.code= code;
        this.title = title;
        this.authorName = authorName;
        this.publishYear = publishYear;
        this.price = price;
        this.pageNumber = pageNumber;
    }

    public EnumClass.State getState() {
        return state;
    }

    public void setState(EnumClass.State state) {
        this.state = state;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code= code;
    }
    //    public static void setCode() { //automation
//        Book.code++;
//    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Member getLendingInfo() {
        return lendingInfo;
    }

    public void setLendingInfo(Member lendingInfo) {
        this.lendingInfo = lendingInfo;
    }

    public LocalDateTime getLendingDateTimeFrom() {
        return lendingDateTimeFrom;
    }

    public void setLendingDateTimeFrom(LocalDateTime lendingDateTimeFrom) {
        this.lendingDateTimeFrom = lendingDateTimeFrom;
    }

    public LocalDateTime getLendingDateTimeTo() {
        return lendingDateTimeTo;
    }

    public void setLendingDateTimeTo(LocalDateTime lendingDateTimeTo) {
        this.lendingDateTimeTo = lendingDateTimeTo;
    }
    // //////   public void setState(String str) {
//        State state= State.valueOf(str);
//    }
//    public State getState() {
//        return this.State;
//    }
//
}

