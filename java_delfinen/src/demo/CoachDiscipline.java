/**
 * @author kasper, Adam
 */
package demo;

public class CoachDiscipline {
    UI ui = new UI();
    Members members;

    public CoachDiscipline(Members members) {
        this.members = members;
    }

    public void chooseMember() {
        Member member;
        try {
            while (true) {
                ui.clear();
                ui.printArraylist(members.getMembersList());
                ui.print("Tilføj et medlem til et hold: \nAngiv medlemsnummer \n>> ");
                member = members.getMemberFromNumber(ui.getUserInputInt());
                if (member == null) {
                    ui.print("\nMedlem med givet nummer findes ikke...\nTryk Enter >> ");
                    ui.scannerLine();
                    ui.clear();
                } else {
                    ui.printString("\nMedlem valgt: \n" + member.toString());
                    assignSwimmer(member);
                    ui.printString("\nDisciplin ændret: \n" + member.toString());
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }

    public void assignSwimmer(Member member) {
        Boolean condition = true;
        while (condition) {
            ui.printString("\nVælg Disciplin:");
            ui.printString("    1-[Butterfly]\n    2-[Crawl]\n    3-[Rygcrawl]\n    4-[Brystsvømning]\n    5-[Angiv ingen disciplin]\n    0-[annuller]");
            ui.print(">>");
            switch (ui.getUserInputInt()) {
                case 0:
                    condition = false;
                    break;
                case 1:
                    member.setDiscipline("Butterfly");
                    members.updateMembers();
                    condition = false;
                    break;
                case 2:
                    member.setDiscipline("Crawl");
                    members.updateMembers();
                    condition = false;
                    break;
                case 3:
                    member.setDiscipline("Rygcrawl");
                    members.updateMembers();
                    condition = false;
                    break;
                case 4:
                    member.setDiscipline("Bystsvømning");
                    members.updateMembers();
                    condition = false;
                    break;
                case 5:
                    member.setDiscipline(null);
                    members.updateMembers();
                    condition = false;
                    break;
            }
        }
    }

    public void editResult() {
        Member member;
        try {
            while (true) {
                ui.clear();
                ui.printArraylist(members.getMembersList());
                ui.printString("Ændre svømmer resultat: ");
                ui.print("\nAngiv medlemsnummer >>");

                int number = ui.getUserInputInt();
                ui.printString("");
                member = members.getMemberFromNumber(number);
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >>");
                    ui.scannerLine();
                    ui.clear();
                } else {
                    ui.printString("Medlem valgt:");
                    ui.print(member.toString());
                    ui.printString("\nAngiv ny tid:");
                    float time = ui.getUserInputFloat();
                    member.setBestTime(time);
                    ui.printString(member.toString());
                    members.updateMembers();
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }
}