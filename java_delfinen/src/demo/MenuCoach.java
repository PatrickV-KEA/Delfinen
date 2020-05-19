/**
 * @author Adam
 */
package demo;

import java.util.ArrayList;

public class MenuCoach {
    private Members members = new Members();
    private CoachTeams coachTeams = new CoachTeams();
    UI ui = new UI();
    ArrayList<Member> membersList;

    public MenuCoach(ArrayList<Member> members) {
        this.membersList = membersList;
    }

    public void menu() {
        /*
        Noter til opbygning af menu:
        se medlemsliste
        tilføj medlem til svømmehold
        ændre resultater for medlem
        top bedste svømmere for hver diciplin
        */

        ui.printString("Tryk 1 For at se medlemsliste");
        ui.printString("Tryk 2 For at se holdlist");
        ui.printString("Tryk 3 For at tilføj medlem til svømmehold");
        ui.printString("Tryk 4 For at ændre resultater for medlem");
        ui.printString("Tryk 5 For at se top bedste svømmere for hver diciplin");
        ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
        ui.print(">> ");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    members.getMembersList();
                    break;

                case 2:
                    ui.printString("Junior hold: \n");
                    coachTeams.juniorTeams();

                    ui.printString("\nSenior hold: \n");
                    coachTeams.seniorTeams();
                    break;
                case 3:
                    //tilføj svømmer til hold

                    break;
                case 4:
                    //ændre resultat for svømmer

                    break;
                case 5:
                    ui.printString("Junior:\n");
                    coachTeams.topFiveJunior();

                    ui.printString("\nSenior: \n");
                    coachTeams.topFiveSenior();
                    break;
                case 0:
                    //tilbage til hovedmenuen
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

        }
    }
}
