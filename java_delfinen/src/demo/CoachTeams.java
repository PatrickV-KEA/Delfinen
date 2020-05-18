package demo;
/**
 * @author kasper
 */
import java.util.ArrayList;
import java.util.Collections;

public class CoachTeams {

    private UI ui = new UI();
    private Members members = new Members();
    private ArrayList<Member> memberList;
    private ArrayList<Member> crawl = new ArrayList<>();
    private ArrayList<Member> backCrawl = new ArrayList<>();
    private ArrayList<Member> butterfly = new ArrayList<>();
    private ArrayList<Member> breast = new ArrayList<>();

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

    public void topFive () {

    }
    public void teamSorting () {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getDiscipline() == "crawl") { crawl.add(memberList.get(i)); }
            if (memberList.get(i).getDiscipline() == "rygcrawl") { backCrawl.add(memberList.get(i)); }
            if (memberList.get(i).getDiscipline() == "butterfly") { butterfly.add(memberList.get(i)); }
            if (memberList.get(i).getDiscipline() == "brystsvømning") { breast.add(memberList.get(i)); }
        }
    }

    public void editResult(){}

}

