/**
 * @author kasper, Adam
 */
package Program;

import UI.UI;

public class CoachDiscipline {
    UI ui;
    Members members;

    public CoachDiscipline(Members members, UI ui) {
        this.members = members;
        this.ui = ui;
    }

    public void assignMember() {
        Member member;
        try {
            while (true) {
                ui.clearScreen();
                ui.printArraylist(members.getMembersList());
                ui.print("Tilføj et medlem til et hold:\nAngiv medlemsnummer \n>> ");
                member = members.getMemberFromNumber(ui.getUserInputInt());
                if (member == null) {
                    ui.print("\nMedlem med givet nummer findes ikke...\nTryk Enter >> ");
                    ui.getUserLine();
                    ui.clearScreen();
                } else {
                    ui.printString("\nMedlem valgt:\n" + member.toString());
                    assignDiscipline(member);
                    ui.printString("\nDisciplin ændret:\n" + member.toString());
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }

    private void assignDiscipline(Member member) {
        while (true) {
            ui.printString("\nVælg Disciplin:");
            ui.printString("1-[Butterfly]\n    2-[Crawl]\n    3-[Rygcrawl]\n    4-[Brystsvømning]\n    5-[Angiv ingen disciplin]\n    0-[annuller]");
            ui.print(">>");
            switch (ui.getUserInputInt()) {
                case 0:
                    return;
                case 1:
                    member.setDiscipline("Butterfly");
                    members.updateMembers();
                    return;
                case 2:
                    member.setDiscipline("Crawl");
                    members.updateMembers();
                    return;
                case 3:
                    member.setDiscipline("Rygcrawl");
                    members.updateMembers();
                    return;
                case 4:
                    member.setDiscipline("Bystsvømning");
                    members.updateMembers();
                    return;
                case 5:
                    member.setDiscipline(null);
                    members.updateMembers();
                    return;
            }
        }
    }

    public void editResult() {
        Member member;
        try {
            while (true) {
                ui.clearScreen();
                ui.printArraylist(members.getMembersList());
                ui.print("Ændre svømmer resultat: \nAngiv medlemsnummer >> ");
                member = members.getMemberFromNumber(ui.getUserInputInt());
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >> ");
                    ui.getUserLine();
                    ui.clearScreen();
                } else {
                    ui.print("Medlem valgt:" + member.toString() + "\nAngiv ny tid >> ");
                    member.setBestTime(ui.getUserInputFloat());
                    ui.printString("\n" + member.toString());
                    members.updateMembers();
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }
}