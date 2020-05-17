package demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SmartInputter {

    public void input(Member member, String str) {

        if (!str.isEmpty()) {
            // takes notation "id=1" where '=' is split and left/right operands are checked
            String attr = str.split("=")[0];
            String arg = str.split("=")[1];

            if (attr.equals("id")) { member.setMemberNr(Integer.parseInt(arg));
            } else if (attr.equals("name")) { member.setName(arg);
            } else if (attr.equals("date")) { member.setBirthday(LocalDate.parse(arg, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            } else if (attr.equals("cpr")) { member.setCpr(Integer.parseInt(arg));
            } else if (attr.equals("paid")) { member.setPayed(Boolean.parseBoolean(arg));
            } else if (attr.equals("active")) { member.setActive(Boolean.parseBoolean(arg));
            } else if (attr.equals("discipline")) { member.setDiscipline(arg);
            } else if (attr.equals("time")) { member.setBestTime(Float.parseFloat(arg));
            }
        }
    }

    public void input(Tournament tournament, String str) {
        if (!str.isEmpty()) {
            // takes notation "id=1" where '=' is split and left/right operands are checked
            String attr = str.split("=")[0];
            String arg = str.split("=")[1];

            if (attr.equals("name")) { tournament.setName(arg);
            } else if (attr.equals("result")) { tournament.setResult(Integer.parseInt(arg));
            } else if (attr.equals("time")) { tournament.setTime(Float.parseFloat(arg));
            } else if (attr.equals("date")) { tournament.setDate(LocalDate.parse(arg, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
    }
}
