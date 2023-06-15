package sammancoaching;

public class Person {
    public static final int USER_ROLE_ADMIN = 0;
    public static final int USER_ROLE_ENGINEER = 1;
    public static final int USER_ROLE_MANAGER = 2;
    public static final int USER_ROLE_SALES = 3;

    private int role;


    private final SwedishPersonalNumber swedishPersonalNumber;
    private final String phoneNumber;

    public Person(int role, String swedishPersonalNumber, String phoneNumber) {
        setRole(role);
        this.swedishPersonalNumber = new SwedishPersonalNumber(swedishPersonalNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setRole(int role) {
        if (role < 0 || role > 4)
            throw new IllegalArgumentException("illegal role" + role);
        this.role = role;
    }

    public int getBirthYear() {
        return getSwedishPersonalNumber().birthYear();
    }


    public String countryCode() {
        String code = "";
        if (phoneNumber.startsWith("00"))
            code = phoneNumber.substring(2, 4);
        else if (phoneNumber.startsWith("+"))
            code = phoneNumber.substring(1, 3);
        if (!code.isEmpty())
            return "+" + code;
        return "";
    }

    public boolean canDeleteUsers() {
        return this.role == Person.USER_ROLE_MANAGER || this.role == Person.USER_ROLE_ADMIN;
    }

    public SwedishPersonalNumber getSwedishPersonalNumber() {
        return swedishPersonalNumber;
    }
}