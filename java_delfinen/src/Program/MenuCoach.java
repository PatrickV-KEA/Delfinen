/**
 * @author Adam
 */
package Program;

import UI.UI;

public class MenuCoach {
    private Members members;
    private CoachTournament coachTournament;
    private CoachDiscipline coachDiscipline;
    private UI ui;

    public MenuCoach(Members members, UI ui) {
        this.members = members;
        this.ui = ui;
        this.coachTournament = new CoachTournament(members, ui);
        this.coachDiscipline = new CoachDiscipline(members, ui);
    }
    public void menu() {
        while (true) {
            ui.clearScreen();
            ui.printString("Tryk 1 For at se medlemsliste");
            ui.printString("Tryk 2 For at se holdliste");
            ui.printString("Tryk 3 For at tilføj medlem til svømmehold");
            ui.printString("Tryk 4 For at ændre resultater for medlem");
            ui.printString("Tryk 5 For at se top 5 bedste svømmere for hver diciplin");
            ui.printString("Tryk 6 For at tilføje stævne til medlem");
            ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
            ui.print(">> ");
            try {
                switch (ui.getUserInputInt()) {
                    case 1:
                        //se medlemsliste
                        ui.printArraylist(members.getMembersList());
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 2:
                        //se hold liste
                        ui.printString("Junior hold: \n");
                        ui.printArraylist(members.getTeam("junior", "Crawl"));
                        ui.printArraylist(members.getTeam("junior", "Rygcrawl"));
                        ui.printArraylist(members.getTeam("junior", "Brystsvømning"));
                        ui.printArraylist(members.getTeam("junior", "Butterfly"));

                        ui.printString("\nSenior hold: \n");
                        ui.printArraylist(members.getTeam("senior", "Crawl"));
                        ui.printArraylist(members.getTeam("senior", "Rygcrawl"));
                        ui.printArraylist(members.getTeam("senior", "Brystsvømning"));
                        ui.printArraylist(members.getTeam("senior", "Butterfly"));

                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 3:
                        //tilføj svømmer til hold
                        coachDiscipline.assignMember();
                        break;
                    case 4:
                        //ændre resultat for svømmer
                        coachDiscipline.editResult();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 5:
                        //se top 5
                        ui.printString("Junior hold: \n");
                        ui.printArraylistFive(members.getTeam("junior", "Crawl"));
                        ui.printArraylistFive(members.getTeam("junior", "Rygcrawl"));
                        ui.printArraylistFive(members.getTeam("junior", "Brystsvømning"));
                        ui.printArraylistFive(members.getTeam("junior", "Butterfly"));

                        ui.printString("\nSenior hold: \n");
                        ui.printArraylistFive(members.getTeam("senior", "Crawl"));
                        ui.printArraylistFive(members.getTeam("senior", "Rygcrawl"));
                        ui.printArraylistFive(members.getTeam("senior", "Brystsvømning"));
                        ui.printArraylistFive(members.getTeam("senior", "Butterfly"));

                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 6:
                        //tilføj stævne til medlem
                        coachTournament.assignToTournament();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                    case 0:
                        //tilbage til hovedmenuen
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
