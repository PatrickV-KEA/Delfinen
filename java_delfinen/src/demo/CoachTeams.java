package demo;
/**
 *
 * @author kasper
 *
 */
import java.util.ArrayList;

public class CoachTeams {
    private FileReader fileReader = new FileReader();
    private UI ui = new UI();
    private Members members = new Members();
    ArrayList<Member> memberList = fileReader.getMembersList();


    public void assignSwimmer() {
        Boolean condition = true;
        while (condition) {
            ui.clear();
            ui.printString("\nVælg Disciplin:");
            ui.printString("    1-[Butterfly]\n    2-[Crawl]\n    3-[Rygcrawl]\n    4-[brystsvømning]\n    0-[annuller]");
            ui.print(">>");

            switch (ui.scannerInt()) {
                case 0:
                    condition = false;
                    break;
                case 1:

                    break;
                case 2:

                    condition = false;
                    break;
                case 3:

                    condition = false;
                    break;
                case 4:

                    condition = false;
                    break;
            }

        }
    }

    private Member chooseMember(ArrayList<Member> memberList) {
            Member member;
            try {
        while (true) {
            ui.clear();
            ui.printArraylist(memberList);
            ui.printString("Tilføj en svømmer til et hold: ");
            ui.print("\nAngiv medlemsnummer >>");

            int number = ui.scannerInt();
            member = members.getMemberFromNumber(number);
            if (member == null) {
                ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >>");
                ui.scannerLine();
                ui.clear();
            } else {
                break;
            }
        }
        return member;
    } catch (IllegalArgumentException e) {
        ui.printString("Dette medlemsnummer findes ikke...");
    }
        return null;
}


}
