package demo;

import java.util.Date;

public class Member {

    private String name;
    private Date birthday;
    private int cpr;
    private boolean payed;
    //konkurrence - disiplin - tid
    private boolean activ;
    //stævne - placering - tid


    public Member(String name, Date birthday, int cpr, boolean payed, boolean activ) {
        this.name = name;
        this.birthday = birthday;
        this.cpr = cpr;
        this.payed = payed;
        this.activ = activ;
    }
}
