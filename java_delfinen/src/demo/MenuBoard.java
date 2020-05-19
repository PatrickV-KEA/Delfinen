/**
 * @author Adam Patrick
 */
package demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class MenuBoard {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui = new UI();
    private ArrayList<Member> members;

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public MenuBoard(ArrayList<Member> members) {
        this.members = members;
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void menu() {
        boolean condition = true;
        while (condition) {
            ui.print("Tast 0 for hovedmenu\nTast 1 for at tilføje et medlem\n>>");
            switch (ui.scannerInt()) {
                case 0:
                    condition = false;
                    break;
                case 1:
                    members.add(createMember());
                    break;
            }
        }
    }

    private Member createMember() {
        ui.clear();

        ui.print("Her kan du indmelde nye medlemmer.\nIntast navn: ");
        String name = ui.scannerString();

        ui.print("\nintast fødeselsår: ");
        int year = ui.scannerInt();

        ui.print("\nindtast fødeselmåned: ");
        int mouth = ui.scannerInt();

        ui.print("\nindtast fødeseldag: ");
        int day = ui.scannerInt();

        ui.print("\nIndtast cpr (de sidste 4 cifre):");
        int cpr = ui.scannerInt();

        ui.print("Er der betalt kontingent for i år?\nja/nej: ");
        boolean paid = getYN();

        ui.print("Er det et aktivt medlemsskab?\nja/nej: ");
        boolean active = getYN();

        LocalDate birthday = LocalDate.of(year, mouth, day);
        return new Member(name, birthday, cpr, paid, active);
    }

    private boolean getYN() {

        while (true) {
            switch (ui.scannerString()) {
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