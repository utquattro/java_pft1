package ru.stqa.prf.addressbook;

public class UserData {
    private final String lastname;
    private final String firstname;
    private final String address;
    private final String email;
    private final String mobile;
    private final String day;
    private final String month;
    private final String year;
    private final String groupnum;

    public UserData(String lastname, String firstname, String address, String email, String mobile, String day, String month, String year, String groupnum) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.day = day;
        this.month = month;
        this.year = year;
        this.groupnum = groupnum;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getGroupnum() {
        return groupnum;
    }
}
