/**
 * @author kasper, Adam
 */
package demo;

import java.time.LocalDate;

public class CoachTournament {

    UI ui = new UI();
    Members members;

    public CoachTournament(Members members) {
        this.members = members;
    }

    public void assignToTournament() {
        Member member;
        try {
            while (true) {
                ui.clearScreen();
                ui.printArraylist(members.getMembersList());
                ui.printString("Tilføj et medlem til et stævne: ");
                ui.print("\nAngiv medlemsnummer >>");

                int number = ui.getUserInputInt();
                ui.printString("");
                member = members.getMemberFromNumber(number);
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >>");
                    ui.getUserLine();
                    ui.clearScreen();
                } else {
                    ui.printString("Medlem valgt:");
                    ui.print(member.toString());
                    createTournament(member);
                    ui.printString("Stævne angivet: \n");
                    ui.print(member.toString());
                    members.updateMembers();
                    break;
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

        ui.print("Stævne er tilføjet\n\n");
        member.addTournament(new Tournament(name, result, time, date));
    }
}
