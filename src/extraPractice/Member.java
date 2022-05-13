package extraPractice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Member {
    ///////enum state///////
    private String name;
    private int memberCode;
    private LocalDate birthday;
    //int age;
    private final LocalDate membershipDateFrom;
    private LocalDate getMembershipDateTo;
    EnumClass.Gender gender;
    EnumClass.membershipDuration duration;
    private ArrayList<Book> lentBooks=new ArrayList<>();



    public Member(int memberCode, LocalDate membershipDateFrom) {
        this.memberCode = memberCode;
        this.membershipDateFrom = membershipDateFrom;
    }

    public Member(String name, int memberCode, LocalDate birthday, LocalDate membershipDateFrom, EnumClass.Gender gender, EnumClass.membershipDuration duration) {
        this.name = name;
        this.memberCode = memberCode;
        this.birthday = birthday;
        this.membershipDateFrom = LocalDate.now();
        this.gender = gender;
        this.duration = duration;
    }

    public ArrayList<Book> getLentBooks() {
        return lentBooks;
    }

    public void setLentBooks(Book book) {
        lentBooks.add(book);
        this.lentBooks = lentBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getMembershipDateFrom() {
        return membershipDateFrom;
    }

    public LocalDate getGetMembershipDateTo() {
        return getMembershipDateTo;
    }

    public void setGetMembershipDateTo(LocalDate getMembershipDateTo) {
        this.getMembershipDateTo = getMembershipDateTo;
    }

    public EnumClass.Gender getGender() {
        return gender;
    }

    public void setGender(EnumClass.Gender gender) {
        this.gender = gender;
    }

    public EnumClass.membershipDuration getDuration() {
        return duration;
    }

    public void setDuration(EnumClass.membershipDuration duration) {
        this.duration = duration;
    }
}
