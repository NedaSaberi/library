import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagement {
    Member member;
    Member[] members;
    int index = 0;
    static int memberCode = 1000;
    private boolean excute = true;
    private int counter = 0;

    public MemberManagement() {
        member = new Member();
        members = new Member[20];
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (excute) {
            System.out.println("============================");
            System.out.printf("1- Members list %n2- Add a new member%n3- Edit information%n4- Delete%n5- Search by name%n6- Search by code%n7- exit%n");
            System.out.println("============================");
            option = scanner.nextInt();
            procees(option);
        }
    }

    public void procees(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                showMembers();
                break;
            case 2:
                addNewMember();
                break;
            case 3:
                System.out.print("Who do you want to edit? Enter the member code: ");
                int code2 = scanner.nextInt();
                editInfo(code2);
                break;
            case 4:
                System.out.print("Who are you deleting? Enter the member code: ");
                int code1 = scanner.nextInt();
                deleteMember(code1);
                break;
            case 5:
                System.out.print("What are you looking for? Enter the member name: ");
                String name = scanner.nextLine();
                ArrayList<Member> members = searchByName(name);
                if (members != null) {
                    for (Member member : members) {
                        System.out.printf("%12d%15s%15d%15s%n", member.getMemberCode(), member.getName(), member.getAge(), member.getGender());
                    }
                }
                break;
            case 6:
                System.out.print("What are you looking for? Enter the member code: ");
                int code = scanner.nextInt();
                Member member = searchByCode(code);
                if (member != null)
                    System.out.printf("%12d%15s%15d%15s%n", member.getMemberCode(), member.getName(), member.getAge(), member.getGender());
                break;
            case 7:
                excute = false;
                break;

        }
    }

    public void addNewMember() {
        if (counter < members.length) {
            memberCode++;
            members[counter] = getInfo();
            counter++;
        }
    }

    public void showMembers() {
        System.out.printf("%15s%15s%15s%15s%n", "Member_code", "Member_name", "Age", "Gender");
        for (Member member : members) {
            System.out.printf("%12d%15s%15d%15s%n", member.getMemberCode(), member.getName(), member.getAge(), member.getGender());
        }
    }

    public Member getInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String mName = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        Member member = new Member(memberCode, mName, age, gender);
        return member;
    }

    public Member searchByCode(int code) {
        Member searchedMember = null;
        for (int i = 0; i < members.length; i++) {
            if (members[i].getMemberCode() == code) {
                searchedMember = new Member(code, member.getName(), member.getAge(), member.getGender());
                index = i;
            }
        }
        if (searchedMember == null) System.out.println("Invalid code! ...");
        return searchedMember;
    }

    public ArrayList<Member> searchByName(String mName) {
        ArrayList<Member> searchedMembers = new ArrayList<>();
        for (Member member : members) {
            if (member.getName().contains(mName)) {
                searchedMembers.add(member);
            }
        }
        if (searchedMembers.isEmpty()) System.out.println("Invalid book name! ...");
        return searchedMembers;
    }

    public void deleteMember(int code) {
        Member member = searchByCode(code);
        if (member != null) {
            System.out.printf("%12d%15s%15d%15s%n", member.getMemberCode(), member.getName(), member.getAge(), member.getGender());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you sure to delete? ");
            String yesCheck = scanner.nextLine();
            if (yesCheck.contains("y") || yesCheck.contains("Y")) {
                members[index] = null;
                //counter__;

            }
        }
    }

    public void editInfo(int code) {
        Member member1 = new Member();
        int cnt = 0;
        for (int i = 0; i < counter; i++) {
            if (member.getMemberCode() == code) {
                System.out.printf("%12d%15s%15d%15s%n", member.getMemberCode(), member.getName(), member.getAge(), member.getGender());
                member1 = getInfo();
                member.setName(member1.getName());
                member.setAge(member1.getAge());
                member.setGender(member1.getGender());
                cnt++;
            }
        }
        if (cnt == 0) System.out.println("Invalid code number! ...");
    }


}
