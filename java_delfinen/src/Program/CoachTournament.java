/**
 * @author kasper, Adam
 */
package Program;

import UI.UI;
import java.time.LocalDate;

public class CoachTournament {
    UI ui;
    Members members;

    public CoachTournament(Members members, UI ui) {
        this.members = members;
        this.ui = ui;
    }

    public void assignToTournament() {
        Member member;
        try {
            while (true) {
                ui.clearScreen();
                ui.printArraylist(members.getMembersList());
                ui.print("Tilføj et medlem til et stævne: \nAngiv medlemsnummer >> ");

                member = members.getMemberFromNumber(ui.getUserInputInt());
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >> ");
                    ui.getUserLine();
                    ui.clearScreen();
                } else {
                    ui.print("Medlem valgt:\n" + member.toString());
                    createTournament(member);
                    ui.print("Stævne angivet: \n" + member.toString());
                    members.updateMembers();
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }

    public void createTournament(Member member) {
        ui.print("\nAngiv stævne og resultater til svømmer.\nIntast stævne navn: ");
        String name = ui.getUserString();

        ui.print("\nIndtast svømmerens placering: ");
        int result = ui.getUserInputInt();

        ui.print("\nIndtast tid: ");
        float time = ui.getUserInputFloat();

        ui.print("\nIndtast dag: ");
        int day = ui.getUserInputInt();

        ui.print("\nIndtast måned: ");
        int month = ui.getUserInputInt();

        ui.print("\nIndtast år: ");
        int year = ui.getUserInputInt();

        LocalDate date = LocalDate.of(year, month, day);
        member.addTournament(new Tournament(name, result, time, date));
        ui.print("Stævne er tilføjet\n\n");
    }
}
