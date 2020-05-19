/**
 * @author Adam
 */
package demo;

public class MenuCoach {
    private Members members;
    private CoachTeams coachTeams = new CoachTeams();
    UI ui = new UI();

    public MenuCoach(Members members) {
        this.members = members;
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
        ui.printString("Tryk 5 For at se top 5 bedste svømmere for hver diciplin");
        ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
        ui.print(">> ");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //se medlemsliste
                    members.getMembersList();
                    break;

                case 2:
                    //se hold liste
                    ui.printString("Junior hold: \n");
                    coachTeams.juniorTeams();

                    ui.printString("\nSenior hold: \n");
                    coachTeams.seniorTeams();
                    break;
                case 3:
                    //tilføj svømmer til hold
                    coachTeams.chooseMember();
                    break;
                case 4:
                    //ændre resultat for svømmer

                    break;
                case 5:
                    //se top 5
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
