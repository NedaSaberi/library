package extraPractice;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MemberManage {
    ArrayList<Member> members= new ArrayList<>();
        private int index;
        private static int memCode = 1000;
        private int counter = 0;
        boolean excute ;

    public void menu() {
        excute=true;
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (excute) {
            System.out.println("============================");
            System.out.printf("1- Members list %n2- Add a new member%n3- Edit info%n4- Delete%n5- Search by name%n6- Search by member code%n7- Return%n");
            System.out.println("============================");
            option = scanner.nextInt();
            procees(option);
        }
    }

    public void procees(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:  //show list
                showList();
                break;
            case 2:  //add
                addMember();
                break;
            case 3:   //edit
                System.out.print("Enter the member code to edit: ");
                int code= scanner.nextInt();
                editInfo(code);
                break;
            case 4:  //delete
                System.out.print("Enter the member code to delete: ");
                int code1= scanner.nextInt();
                Integer idx= deleteMember(code1);
                if (idx!=null){
                    members.remove((int) idx);
                    System.out.println("Deleting Done!");
                }
                break;
            case 5:  //dearch by name
                System.out.println("Enter a name to search");
                String name= scanner.nextLine();
                ArrayList<Member> result= searchByName(name);
                if (!result.isEmpty())
                    System.out.printf("%20s%20s%20s%20s%20s%20s%n","Code","Name","Birthday","Gender","From","To");
                System.out.println("_________________________________________________________________________________________________________________________________________________________");
                for (Member member: result){
                        System.out.printf("%20d%20s%20s%20s%20s%20s%n",member.getMemberCode(),member.getName(),member.getBirthday(),member.getGender(),member.getMembershipDateFrom(),member.getGetMembershipDateTo());
                    }
                break;
            case 6:  //search by code
                System.out.print("Enter the member code to search: ");
                int code2= scanner.nextInt();
                Member member=searchByCode(code2);
                if (member!=null) {
                    System.out.printf("%20s%20s%20s%20s%20s%20s%n", "Code", "Name", "Birthday", "Gender", "From", "To");
                    System.out.println("_________________________________________________________________________________________________________________________________________________________");
                    System.out.printf("%20d%20s%20s%20s%20s%20s%n", member.getMemberCode(), member.getName(), member.getBirthday(), member.getGender(), member.getMembershipDateFrom(), member.getGetMembershipDateTo());
                }
                break;
            case 7:  //return
                excute = false;
                break;
        }
    }

    public void addMember() {
        memCode++;
        members.add(getInfo());
        counter++;
    }

    public Member getInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Gender " + Arrays.toString(EnumClass.Gender.values())+": ");
        String str = scanner.nextLine();
        EnumClass.Gender gender= EnumClass.Gender.valueOf(str);

        System.out.print("Date of birthday(yyyy-mm-dd): ");
        String str1 = scanner.next();
        LocalDate birthday= LocalDate.parse(str1);
Scanner scanner1= new Scanner(System.in);
        System.out.print("Duration of membership: "+Arrays.toString(EnumClass.membershipDuration.values()));
        String str2= scanner1.nextLine();
        EnumClass.membershipDuration duration = EnumClass.membershipDuration.valueOf(str2);


        Member member = new Member(name, memCode, birthday, LocalDate.now(), gender, duration);
        return member;
    }

    public void showList(){
        System.out.println("_______________________________________________________________________MEMBER LIST_______________________________________________________________________");
        System.out.printf("%20s%20s%20s%20s%20s%20s%n","Code","Name","Birthday","Gender","From","To");
        System.out.println("_________________________________________________________________________________________________________________________________________________________");
        for (Member member:members) {
            switch (member.getDuration()){
                case ONE_YEAR:
                    member.setGetMembershipDateTo(member.getMembershipDateFrom().plusYears(1));
                    break;

                case ONE_MONTH:
                    member.setGetMembershipDateTo(member.getMembershipDateFrom().plusMonths(1));

                    break;
                case SIX_MONTHS:
                    member.setGetMembershipDateTo(member.getMembershipDateFrom().plusMonths(6));

                    break;
            }
            System.out.printf("%20d%20s%20s%20s%20s%20s%n",member.getMemberCode(),member.getName(),member.getBirthday(),member.getGender(),member.getMembershipDateFrom(),member.getGetMembershipDateTo());
        }
    }

    public void editInfo(int code){
        int cnt=0;
        Scanner scanner= new Scanner(System.in);
        for (Member member:members) {
            if (member.getMemberCode()==code){
                System.out.printf("%20s%20s%20s%20s%20s%20s%n","Code","Name","Birthday","Gender","From","To");
                System.out.printf("%20d%20s%20s%20s%20s%20s%n",member.getMemberCode(),member.getName(),member.getBirthday(),member.getGender(),member.getMembershipDateFrom(),member.getGetMembershipDateTo());
                System.out.print("Enter the name: ");
                String name= scanner.nextLine();
                System.out.print("Birtheday(yyyy-mm-dd): ");
                String str= scanner.nextLine();
                LocalDate birthday= LocalDate.parse(str);
                System.out.print("Gender(Male,Female,Other)");
                String str1= scanner.nextLine();
                EnumClass.Gender gender= EnumClass.Gender.valueOf(str1);
                System.out.println("Duration(ONE_YEAR,SIX_MONTHS,ONE_MONTH):");
                String str2= scanner.nextLine();
                EnumClass.membershipDuration duration= EnumClass.membershipDuration.valueOf(str2);
                member.setName(name);
                member.setGender(gender);
                member.setBirthday(birthday);
                member.setDuration(duration);
                System.out.println("Editing Done! ");
                cnt++;
                break;
            }
        }
        if (cnt==0)
            System.out.println("INVALID CODE...");
    }

    public Integer deleteMember(int code){
        Integer idx=null;
        for (Member member:members){
            if (member.getMemberCode()==code){
                idx= members.indexOf(member);
//                members.remove(index);
                counter--;
                break;
            }
        }
        if (idx==null)
            System.out.println("INVALID CODE...");
        return idx;
    }

    public ArrayList<Member> searchByName(String name){
        ArrayList<Member> searchedMembers= new ArrayList<>();
        for (Member member:members){
            if (member.getName().contains(name)){
                searchedMembers.add(member);
            }
        }
        if (searchedMembers.isEmpty())
            System.out.println("There is no matched result");
        return searchedMembers;
    }

    public Member searchByCode(int code){
        Member result=null;
        for (Member member:members){
            if (member.getMemberCode()==code){
                result= member;
                break;
            }
        }
        if (result==null)
            System.out.println("INVALID MEMBER CODE...");
        return result;
    }

}
