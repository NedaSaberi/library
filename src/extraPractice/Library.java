package extraPractice;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    BookManage bookManage;
    MemberManage memberManage;
    boolean execute = true;

    public Library() {
        bookManage = new BookManage();
        memberManage = new MemberManage();

    }

    public void console() {
        Scanner scanner = new Scanner(System.in);
        int option=0;
        while (execute) {
            System.out.println("============================");
            System.out.printf("1- Book sheet%n2- Member sheet%n3- Lending book%n4- Report by book%n5- Report by members%n6- Exit%n");
            System.out.println("============================");
            option = scanner.nextInt();
            process(option);
        }
    }

    public void process(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1: //bookshelf
                bookManage.menu();
                break;
            case 2:  //membership
                memberManage.menu();
                break;
            case 3:  //lending
                showList();
                System.out.print("Enter member code: ");
                int mem = scanner.nextInt();
                System.out.print("Enter Book code: ");
                int bk = scanner.nextInt();
                System.out.print("Enter the number of the days to borrow:");
                int days= scanner.nextInt();
                lending(mem, bk,days);
                break;
            case 4:  //report
                reportLentBooks();
                break;
            case 5: //report by member
                reportDebtors();
                break;
            case 6: // exit
                execute = false;
                break;
        }
    }


    public void showList() {
        //int size;
        int currentPosition = 0;
        System.out.printf("%-35s%2s%35s%n", "Members List", "||", "Books List");
        System.out.println("===================================||=================================================");
        for (Member member : memberManage.members) {

            System.out.printf("%-15s%-20s%2s", member.getMemberCode(), member.getName(), "||");
            if (currentPosition< bookManage.books.size()) {
                bookManage.printBookIn2Column(bookManage.books.get(currentPosition));
            }
            currentPosition++;
        }
        if (currentPosition < bookManage.books.size()) {
            for (int i = currentPosition; i < bookManage.books.size(); i++) {
                System.out.printf("%35s%2s", "", "||");
                bookManage.printBookIn2Column(bookManage.books.get(i));
            }
        }
        System.out.println();
    }

    public void lending(int memberCode, int bookCode, int days) {
        int cnt=0;
        LocalDateTime lendingDateTimeFrom;
        LocalDateTime lendingDateTimeTo;
        Member member = memberManage.searchByCode(memberCode);
        if (member!=null) {
            for (Book book : bookManage.books) {
                if (book.getCode() == bookCode) {
                    cnt++;
                    if (book.getState() == EnumClass.State.Ready) {
                        book.setState(EnumClass.State.Lent);
                        book.setLendingInfo(member);
                        member.setLentBooks(book);
                        lendingDateTimeFrom= LocalDateTime.now();
                        lendingDateTimeTo= lendingDateTimeFrom.plusDays(days);
                        book.setLendingDateTimeFrom(lendingDateTimeFrom);
                        book.setLendingDateTimeTo(lendingDateTimeTo);
                        System.out.println(book.getTitle() + " is lent by " + member.getName());
                    } else System.out.println("Unavailable book...");
                    break;
                }
            }

            if (cnt==0) System.out.println("INVALID BOOK CODE...");
        }
    }

    public void reportLentBooks() {
        for (Book book : bookManage.books) {
            if (book.getState() == EnumClass.State.Lent) {
                System.out.printf("Book%7s(%d)%s%10s(%d) on %s to %s  %n" ,book.getTitle() , book.getCode() , "         is lent by " , book.getLendingInfo().getName() ,book.getLendingInfo().getMemberCode(),book.getLendingDateTimeFrom().toString(),book.getLendingDateTimeTo());
            }
        }
    }

    public void reportDebtors(){
        for (Member member: memberManage.members){
           if (!member.getLentBooks().isEmpty()){
               System.out.printf("%10s(%d) has borrowed %n" , member.getName() ,member.getMemberCode());
               for (Book book:member.getLentBooks()) {
                   System.out.printf("%30s%s(%d)%n", "",book.getTitle(),book.getCode());
               }
           }
        }
    }
}



