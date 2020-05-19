/**
 *
 * @author Adam Kasper Patrick
 *
 */

package demo;

import java.time.LocalDate;

public class Tournament {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private String  name;
    private int     result;
    private float   time;
    private LocalDate   date;

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public Tournament(String name, int result, float time, LocalDate date) {
        this.name =     name;
        this.result =   result;
        this.time =     time;
        this.date =     date;
    }

    public Tournament() {}

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR ACCESSORS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Stævne: " +
                name +
                ", placering: " + result +
                ", tid " + time +
                ", D. " + date +
                '}';
    }
}
