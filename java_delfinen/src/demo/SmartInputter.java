/**
 * Takes a variable like string "date=00-00-0000".
 * Splits it at '=' so it becomes String[] ["date","00-00-0000"].
 * Index 0 is Variable name, and index 1 is Value.
 * If variable name has been conditioned, converts and inputs value.
 *
 * @author Patrick
 */
package demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SmartInputter {

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void input(Member member, String str) {
        if (!str.isEmpty()) {
            String var = str.split("=")[0];
            String val = str.split("=")[1];

            switch (var) {
                case "id":          member.setId(Integer.parseInt(val));                                                    break;
                case "name":        member.setName(val);                                                                    break;
                case "date":        member.setBirthday(LocalDate.parse(val, DateTimeFormatter.ofPattern("dd-MM-yyyy")));    break;
                case "cpr":         member.setCpr(Integer.parseInt(val));                                                   break;
                case "paid":        member.setPaid(Boolean.parseBoolean(val));                                              break;
                case "active":      member.setActive(Boolean.parseBoolean(val));                                            break;
                case "discipline":  member.setDiscipline(val);                                                              break;
                case "time":        member.setBestTime(Float.parseFloat(val));                                              break;
            }
        }
    }
    public void input(Tournament tournament, String str) {
        if (!str.isEmpty()) {
            String var = str.split("=")[0];
            String val = str.split("=")[1];

            switch (var) {
                case "name":    tournament.setName(val);                                                                break;
                case "result":  tournament.setResult(Integer.parseInt(val));                                            break;
                case "time":    tournament.setTime(Float.parseFloat(val));                                              break;
                case "date":    tournament.setDate(LocalDate.parse(val, DateTimeFormatter.ofPattern("dd-MM-yyyy")));    break;
            }
        }
    }
}