/**
 * @author Adam
 */
package demo;

public class MenuCoach {
    private Members members;
    private CoachTeams coachTeams;
    private CoachTournament coachTournament;
    private CoachDiscipline coachDiscipline;
    private UI ui = new UI();

    public MenuCoach(Members members) {
        this.members = members;
        this.coachTeams = new CoachTeams(members);
        this.coachTournament = new CoachTournament(members);
        this.coachDiscipline = new CoachDiscipline(members);
    }
    public void menu() {
        Boolean condition = true;
        while (condition) {
            ui.clear();
            ui.printString("Tryk 1 For at se medlemsliste");
            ui.printString("Tryk 2 For at se holdliste");
            ui.printString("Tryk 3 For at tilføj medlem til svømmehold");
            ui.printString("Tryk 4 For at ændre resultater for medlem");
            ui.printString("Tryk 5 For at se top 5 bedste svømmere for hver diciplin");
            ui.printString("Tryk 6 For at tilføje stævne til medlem");
            ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
            ui.print(">> ");
            try {
                switch (ui.scannerInt()) {
                    case 1:
                        //se medlemsliste
                        ui.printArraylist(members.getMembersList());
                        ui.printString("\nTryk enter for menu");
                        ui.scannerLine();
                        break;
                    case 2:
                        //se hold liste
                        ui.printString("Junior hold: \n");
                        //coachTeams.juniorTeams();
                        coachTeams.teams(true,false);

                        ui.printString("\nSenior hold: \n");
                        //coachTeams.seniorTeams();
                        coachTeams.teams(false,false);

                        ui.printString("\nTryk enter for menu");
                        ui.scannerLine();
                        break;
                    case 3:
                        //tilføj svømmer til hold
                        coachDiscipline.chooseMember();
                        break;
                    case 4:
                        //ændre resultat for svømmer
                        coachDiscipline.editResult();
                        ui.printString("\nTryk enter for menu");
                        ui.scannerLine();
                        break;
                    case 5:
                        //se top 5
                        ui.printString("Junior:\n");
                        //coachTeams.topFiveJunior();
                        coachTeams.teams(true,true);

                        ui.printString("\nSenior: \n");
                        //coachTeams.topFiveSenior();
                        coachTeams.teams(false,true);

                        ui.printString("\nTryk enter for menu");
                        ui.scannerLine();
                        break;
                    case 6:
                        //tilføj stævne til medlem
                        coachTournament.assignToTournament();
                        ui.printString("\nTryk enter for menu");
                        ui.scannerLine();
                    case 0:
                        //tilbage til hovedmenuen
                        condition = false;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
