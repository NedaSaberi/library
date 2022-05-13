public class Member {
    private String name;
    private int memberCode;
    private int age;
    String gender;

    public Member() {
    }

    public Member(int memberCode,String name, int age,String gender) {
        this.memberCode= memberCode;
        this.name = name;
        this.age = age;
        this.gender= gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
