/**
*
* @author Adam Kasper Patrick
*
*/

package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Member {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private int         memberNr;
    private String      name;
    private LocalDate   birthday;
    private int         cpr;
    private boolean     payed;
    private String      discipline;
    private float       bestTime;
    private boolean     active;
    private ArrayList<Tournament> tournament = new ArrayList<>();

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public Member( String name, LocalDate birthday, int cpr, boolean payed, boolean active) {
        this.name = name;
        this.birthday = birthday;
        this.cpr = cpr;
        this.payed = payed;
        this.active = active;
    }

    public Member(int memberNr, String name, LocalDate birthday, int cpr, boolean payed, boolean active) {
        this.memberNr = memberNr;
        this.name =     name;
        this.birthday = birthday;
        this.cpr =      cpr;
        this.payed =    payed;
        this.active =   active;
    }

    public Member(int memberNr, String name, LocalDate birthday, int cpr, boolean payed, boolean active, String discipline, float bestTime) {
        this.memberNr =     memberNr;
        this.name =         name;
        this.birthday =     birthday;
        this.cpr =          cpr;
        this.payed =        payed;
        this.active =       active;
        this.discipline =   discipline;
        this.bestTime =     bestTime;
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public Tournament addTournament(String name, int result, float newTime, LocalDate date) {
        if (newTime < bestTime) {
            bestTime = newTime;
        }
        return new Tournament(name, result, newTime, date);
    }

    public void addToTeam(String discipline, float bestTime) {
        this.discipline =   discipline;
        this.bestTime =     bestTime;
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR ACCESSORS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public int getMemberNr() {
        return memberNr;
    }

    public void setMemberNr(int memberNr) {
        this.memberNr = memberNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public float getBestTime() {
        return bestTime;
    }

    public void setBestTime(float bestTime) {
        this.bestTime = bestTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Tournament> getTournaments() {
        return tournament;
    }

    public void setTournaments(ArrayList<Tournament> tournament) {
        this.tournament = tournament;
    }
}
