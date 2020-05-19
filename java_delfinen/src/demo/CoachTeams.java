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

    public void juniorTeams () {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getDiscipline() == "Crawl" && memberList.get(i).getAge() < 18) {
                crawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Cygcrawl"&& memberList.get(i).getAge() < 18) {
                backCrawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Butterfly"&& memberList.get(i).getAge() < 18) {
                butterfly.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Brystsvømning"&& memberList.get(i).getAge() < 18) {
                breast.add(memberList.get(i));
            }
        }
        ui.printString("Crawl holdet:");
        ui.printArraylist(crawl);
        ui.printString("");
        ui.printString("Rygrawl holdet:");
        ui.printArraylist(backCrawl);
        ui.printString("");
        ui.printString("Butterfly holdet:");
        ui.printArraylist(butterfly);
        ui.printString("");
        ui.printString("Brystsvømmer holdet:");
        ui.printArraylist(breast);
        ui.printString("");
    }

    public void seniorTeams () {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getDiscipline() == "Crawl" && memberList.get(i).getAge() > 18) {
                crawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Rygcrawl"&& memberList.get(i).getAge() > 18) {
                backCrawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Butterfly"&& memberList.get(i).getAge() > 18) {
                butterfly.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Brystsvømning"&& memberList.get(i).getAge() > 18) {
                breast.add(memberList.get(i));
            }
        }
        ui.printString("Crawl holdet:");
        ui.printArraylist(crawl);
        ui.printString("");
        ui.printString("Rygrawl holdet:");
        ui.printArraylist(backCrawl);
        ui.printString("");
        ui.printString("Butterfly holdet:");
        ui.printArraylist(butterfly);
        ui.printString("");
        ui.printString("Brystsvømmer holdet:");
        ui.printArraylist(breast);
        ui.printString("");
    }

    public void topFiveJunior() {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getDiscipline() == "Crawl" && memberList.get(i).getAge() < 18) {
                crawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Rygcrawl" && memberList.get(i).getAge() < 18) {
                backCrawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Butterfly" && memberList.get(i).getAge() < 18) {
                butterfly.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Brystsvømning" && memberList.get(i).getAge() < 18) {
                breast.add(memberList.get(i));
            }
        }
        Collections.sort(crawl);
        Collections.sort(backCrawl);
        Collections.sort(butterfly);
        Collections.sort(breast);
        crawl.subList(5, crawl.size()).clear();
        backCrawl.subList(5, backCrawl.size()).clear();
        butterfly.subList(5, butterfly.size()).clear();
        breast.subList(5, breast.size()).clear();
        ui.printString("Junior Top 5 i Crawl:");
        ui.printArraylist(crawl);
        ui.printString("");
        ui.printString("Junior Top 5 i Rygrawl:");
        ui.printArraylist(backCrawl);
        ui.printString("");
        ui.printString("Junior Top 5 i Butterfly:");
        ui.printArraylist(butterfly);
        ui.printString("");
        ui.printString("Junior Top 5 i Brystsvømning:");
        ui.printArraylist(breast);
        ui.printString("");
    }

    public void topFiveSenior() {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getDiscipline() == "Crawl" && memberList.get(i).getAge() > 18) {
                crawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Rygcrawl" && memberList.get(i).getAge() > 18) {
                backCrawl.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Butterfly" && memberList.get(i).getAge() > 18) {
                butterfly.add(memberList.get(i));
            }
            if (memberList.get(i).getDiscipline() == "Brystsvømning" && memberList.get(i).getAge() > 18) {
                breast.add(memberList.get(i));
            }
        }
        Collections.sort(crawl);
        Collections.sort(backCrawl);
        Collections.sort(butterfly);
        Collections.sort(breast);
        crawl.subList(5, crawl.size()).clear();
        backCrawl.subList(5, backCrawl.size()).clear();
        butterfly.subList(5, butterfly.size()).clear();
        breast.subList(5, breast.size()).clear();
        ui.printString("Senior Top 5 i Crawl:");
        ui.printArraylist(crawl);
        ui.printString("");
        ui.printString("Senior Top 5 i Rygrawl:");
        ui.printArraylist(backCrawl);
        ui.printString("");
        ui.printString("Senior Top 5 i Butterfly:");
        ui.printArraylist(butterfly);
        ui.printString("");
        ui.printString("Senior Top 5 i Brystsvømning:");
        ui.printArraylist(breast);
        ui.printString("");
    }

    public void editResult(){}

}

