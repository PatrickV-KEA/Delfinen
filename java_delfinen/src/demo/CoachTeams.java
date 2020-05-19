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
    private MemberFileWriter memberFileWriter = new MemberFileWriter();

    public void chooseMember() {
        Member member;
        try {
            while (true) {
                ui.clear();
                ui.printArraylist(members.getMembersList());
                ui.printString("Tilføj et medlem til et hold: ");
                ui.print("\nAngiv medlemsnummer >>");

                int number = ui.scannerInt();
                ui.printString("");
                member = members.getMemberFromNumber(number);
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >>");
                    ui.scannerLine();
                    ui.clear();
                } else {
                    ui.printString("Medlem valgt:");
                    ui.print(member.toString());
                    assignSwimmer(member);
                    ui.printString("\nDisciplin ændret:");
                    ui.printString(member.toString());

                break; }
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

            switch (ui.scannerInt()) {
                case 0:
                    condition = false;
                    break;
                case 1:
                    member.setDiscipline("Butterfly");
                    memberFileWriter.updateMembers(members.getMembersList());
                    condition = false;
                    break;
                case 2:
                    member.setDiscipline("Crawl");
                    memberFileWriter.updateMembers(members.getMembersList());
                    condition = false;
                    break;
                case 3:
                    member.setDiscipline("Rygcrawl");
                    memberFileWriter.updateMembers(members.getMembersList());
                    condition = false;
                    break;
                case 4:
                    member.setDiscipline("Bystsvømning");
                    memberFileWriter.updateMembers(members.getMembersList());
                    condition = false;
                    break;
                case 5:
                    member.setDiscipline(null);
                    memberFileWriter.updateMembers(members.getMembersList());
                    condition = false;
                    break;
            }

        }
    }

    public void editResult(){
        Member member;
        try {
            while (true) {
                ui.clear();
                ui.printArraylist(members.getMembersList());
                ui.printString("Ændre svømmer resultat: ");
                ui.print("\nAngiv medlemsnummer >>");

                int number = ui.scannerInt();
                ui.printString("");
                member = members.getMemberFromNumber(number);
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >>");
                    ui.scannerLine();
                    ui.clear();
                } else {
                    ui.printString("Medlem valgt:");
                    ui.print(member.toString());
                    ui.printString("Angiv ny tid:");
                    int time = ui.scannerInt();
                    member.setBestTime(time);
                    ui.printString(member.toString());
                    break; }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
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



}

