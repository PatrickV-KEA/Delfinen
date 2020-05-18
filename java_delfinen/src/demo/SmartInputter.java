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

            if (var.equals("id")) { member.setId(Integer.parseInt(val));
            } else if (var.equals("name")) { member.setName(val);
            } else if (var.equals("date")) { member.setBirthday(LocalDate.parse(val, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            } else if (var.equals("cpr")) { member.setCpr(Integer.parseInt(val));
            } else if (var.equals("paid")) { member.setPaid(Boolean.parseBoolean(val));
            } else if (var.equals("active")) { member.setActive(Boolean.parseBoolean(val));
            } else if (var.equals("discipline")) { member.setDiscipline(val);
            } else if (var.equals("time")) { member.setBestTime(Float.parseFloat(val));
            }
        }
    }
    public void input(Tournament tournament, String str) {
        if (!str.isEmpty()) {
            String var = str.split("=")[0];
            String val = str.split("=")[1];

            if (var.equals("name")) { tournament.setName(val);
            } else if (var.equals("result")) { tournament.setResult(Integer.parseInt(val));
            } else if (var.equals("time")) { tournament.setTime(Float.parseFloat(val));
            } else if (var.equals("date")) { tournament.setDate(LocalDate.parse(val, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
    }
}