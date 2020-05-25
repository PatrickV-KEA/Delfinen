/**
 * @author Adam Patrick
 */
package Program;

import UI.UI;
import java.time.LocalDate;

public class MenuBoard {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui;
    private Members members;

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public MenuBoard(Members members, UI ui) {
        this.members = members;
        this.ui = ui;
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void menu() {
        boolean condition = true;
        while (condition) {
            ui.print("Tast 1 for at tilføje et medlem\nTast 0 for hovedmenu\n>>");
            switch (ui.getUserInputInt()) {
                case 1:
                    members.addMember(createMember());
                    break;
                case 0:
                    condition = false;
                    break;
            }
        }
    }

    private Member createMember() {
        ui.clearScreen();

        ui.print("Her kan du indmelde nye medlemmer.\nIntast navn: ");
        String name = ui.getUserString();

        ui.print("\nintast fødeselsår: ");
        int year = ui.getUserInputInt();

        ui.print("\nindtast fødeselmåned: ");
        int mouth = ui.getUserInputInt();

        ui.print("\nindtast fødeseldag: ");
        int day = ui.getUserInputInt();

        ui.print("\nIndtast cpr (de sidste 4 cifre):");
        int cpr = ui.getUserInputInt();

        ui.print("Er der betalt kontingent for i år?\nja/nej: ");
        boolean paid = getYN();

        ui.print("Er det et aktivt medlemsskab?\nja/nej: ");
        boolean active = getYN();

        LocalDate birthday = LocalDate.of(year, mouth, day);

        ui.clearScreen();
        ui.print("Medlemmet er tilføjet\n\n");
        return new Member(name, birthday, cpr, paid, active);
    }

    private boolean getYN() {

        while (true) {
            switch (ui.getUserString()) {
                case "ja":
                    return true;
                case "nej":
                    return false;
                default:
                    ui.print("\nDu skal skrive enten ja/nej: ");
            }
        }
    }
}