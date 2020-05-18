/**
 * @author Adam Kasper Patrick
 */

package demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class Member {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private int id;
    private String name;
    private LocalDate birthday;
    private int cpr;
    private boolean paid;
    private String discipline;
    private float bestTime;
    private boolean active;
    private ArrayList<Tournament> tournaments = new ArrayList<>();

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public Member() {
    }

    public Member(String name, LocalDate birthday, int cpr, boolean paid, boolean active) {
        this.name = name;
        this.birthday = birthday;
        this.cpr = cpr;
        this.paid = paid;
        this.active = active;
    }

    public Member(int id, String name, LocalDate birthday, int cpr, boolean paid, boolean active) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cpr = cpr;
        this.paid = paid;
        this.active = active;
    }

    public Member(int id, String name, LocalDate birthday, int cpr, boolean paid, boolean active, String discipline, float bestTime) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cpr = cpr;
        this.paid = paid;
        this.active = active;
        this.discipline = discipline;
        this.bestTime = bestTime;
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------

    public void addTournament(Tournament tournament) {
        if (tournament.getTime() < bestTime) {
            bestTime = tournament.getTime();
        }
        tournaments.add(tournament);
    }

    public void addToTeam(String discipline, float bestTime) {
        this.discipline = discipline;
        this.bestTime = bestTime;
    }

    public String toFile() {
        String str =
                "id=" + id +
                " name=" + name.replace(' ', '_') +
                " date=" + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                " cpr=" + cpr +
                " paid=" + paid +
                " active=" + active;
        if (discipline != null) {
            str +=
                " discipline=" + discipline.replace(' ', '_') +
                " time=" + bestTime;
        }
        for (int i = 0; i < tournaments.size(); i++) {
            str +=  " ¤" +
                    " name=" + tournaments.get(i).getName().replace(' ', '_') +
                    " result=" + tournaments.get(i).getResult() +
                    " time=" + tournaments.get(i).getTime() +
                    " date=" + tournaments.get(i).getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        return str;
    }

    @Override
    public String toString() {
        return id +
                ". " + name +
                " " + birthday +
                "-" + cpr +
                " Betaling: " + paid +
                " Aktivt medlem: " + active +
                " Disciplin: " + discipline +
                " Bedste Tid: " + bestTime +
                ". Stævne: " + tournaments;
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR ACCESSORS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = birthday.getYear();
        int age = currentYear - birthYear;
        return age;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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
        return tournaments;
    }

    public void setTournaments(ArrayList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public float compareTo(Member compareMem) {
        float compareTime = ((Member) compareMem).getBestTime();
        //Sorterer efter stigende best times
        return this.bestTime - compareTime;
    }

}
