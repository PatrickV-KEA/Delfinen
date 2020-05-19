package demo;
/**
 * @author kasper
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class CoachTeams {

    private UI ui = new UI();
    private Members members;
    private MemberFileWriter memberFileWriter = new MemberFileWriter();

    public CoachTeams(Members members) {
        this.members = members;
    }

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

    public void editResult() {
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
                    ui.printString("\nAngiv ny tid:");
                    float time = ui.scannerFloat();
                    member.setBestTime(time);
                    ui.printString(member.toString());
                    memberFileWriter.updateMembers(members.getMembersList());
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }

    /*public ArrayList<ArrayList> juniorTeams() {
        ArrayList<String> iter = new ArrayList<>(4);
        iter.add("Crawl"); iter.add("Rygcrawl"); iter.add("Butterfly"); iter.add("Brystsvømning");

        ArrayList<Member> membersList = members.getMembersList();
        ArrayList<ArrayList> teams = new ArrayList<>(4);

        for (String s : iter) {
            ArrayList<Member> team = new ArrayList<>();
            for (Member member : membersList) {
                String disc = member.getDiscipline();
                int age = member.getAge();

                if (disc != null) {
                    if (disc.equals(s) && age < 18) {
                        team.add(member);
                    }
                }
            }  // END OF FOR-LOOP
            teams.add(team);
        }  // END OF FOR-LOOP

        ArrayList<ArrayList> pack = new ArrayList<>();
        pack.add(iter); pack.add(teams);

        return pack;
    }*/

    public void juniorTeams() {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < members.getMembersList().size(); i++) {
            String disc = members.getMembersList().get(i).getDiscipline();
            int age = members.getMembersList().get(i).getAge();
            if (disc != null) {
                if (disc.equals("Krawl") && age < 18) {
                    crawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Rygkrawl") && age < 18) {
                    backCrawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Butterfly") && age < 18) {
                    butterfly.add(members.getMembersList().get(i));
                }
                if (disc.equals("Brystsvømning") && age < 18) {
                    breast.add(members.getMembersList().get(i));
                }
            }
        }
        ui.printString("Crawl holdet:");
        ui.printArraylist(crawl);
        ui.printString("");
        ui.printString("Rygcrawl holdet:");
        ui.printArraylist(backCrawl);
        ui.printString("");
        ui.printString("Butterfly holdet:");
        ui.printArraylist(butterfly);
        ui.printString("");
        ui.printString("Brystsvømmer holdet:");
        ui.printArraylist(breast);
        ui.printString("");
    }

    public void seniorTeams() {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < members.getMembersList().size(); i++) {
            String disc = members.getMembersList().get(i).getDiscipline();
            int age = members.getMembersList().get(i).getAge();
            if (disc != null) {
                if (disc.equals("Krawl") && age > 18) {
                    crawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Rygkrawl") && age > 18) {
                    backCrawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Butterfly") && age > 18) {
                    butterfly.add(members.getMembersList().get(i));
                }
                if (disc.equals("Brystsvømning") && age > 18) {
                    breast.add(members.getMembersList().get(i));
                }
            }
        }
        ui.printString("Crawl holdet:");
        ui.printArraylist(crawl);
        ui.printString("");
        ui.printString("Rygcrawl holdet:");
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

        for (int i = 0; i < members.getMembersList().size(); i++) {
            String disc = members.getMembersList().get(i).getDiscipline();
            int age = members.getMembersList().get(i).getAge();
            if (disc != null) {
                if (disc.equals("Krawl") && age < 18) {
                    crawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Rygkrawl") && age < 18) {
                    backCrawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Butterfly") && age < 18) {
                    butterfly.add(members.getMembersList().get(i));
                }
                if (disc.equals("Brystsvømning") && age < 18) {
                    breast.add(members.getMembersList().get(i));
                }
            }
        }
        Collections.sort(crawl);
        Collections.sort(backCrawl);
        Collections.sort(butterfly);
        Collections.sort(breast);
        ui.printString("Junior Top 5 i Crawl:");
        ui.printArraylistFive(crawl);
        ui.printString("");
        ui.printString("Junior Top 5 i Rygcrawl:");
        ui.printArraylistFive(backCrawl);
        ui.printString("");
        ui.printString("Junior Top 5 i Butterfly:");
        ui.printArraylistFive(butterfly);
        ui.printString("");
        ui.printString("Junior Top 5 i Brystsvømning:");
        ui.printArraylistFive(breast);
        ui.printString("");
    }

    public void topFiveSenior() {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();

        for (int i = 0; i < members.getMembersList().size(); i++) {
            String disc = members.getMembersList().get(i).getDiscipline();
            int age = members.getMembersList().get(i).getAge();
            if (disc != null) {
                if (disc.equals("Krawl") && age > 18) {
                    crawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Rygkrawl") && age > 18) {
                    backCrawl.add(members.getMembersList().get(i));
                }
                if (disc.equals("Butterfly") && age > 18) {
                    butterfly.add(members.getMembersList().get(i));
                }
                if (disc.equals("Brystsvømning") && age > 18) {
                    breast.add(members.getMembersList().get(i));
                }
            }
        }
        Collections.sort(crawl);
        Collections.sort(backCrawl);
        Collections.sort(butterfly);
        Collections.sort(breast);

        ui.printString("Senior Top 5 i Crawl:");
        ui.printArraylistFive(crawl);
        ui.printString("");
        ui.printString("Senior Top 5 i Rygcrawl:");
        ui.printArraylistFive(backCrawl);
        ui.printString("");
        ui.printString("Senior Top 5 i Butterfly:");
        ui.printArraylistFive(butterfly);
        ui.printString("");
        ui.printString("Senior Top 5 i Brystsvømning:");
        ui.printArraylistFive(breast);
        ui.printString("");
    }

    public void assignToTournament(){
        Member member;
        try {
            while (true) {
                ui.clear();
                ui.printArraylist(members.getMembersList());
                ui.printString("Tilføj et medlem til et stævne: ");
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
                    createTournament(member);
                    ui.printString("Stævne angivet: \n");
                    ui.print(member.toString());
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }
    }

    public void createTournament(Member member){
        ui.print("Angiv stævne og resultater til svømmer.\nIntast stævne navn: ");
        String name = ui.scannerString();

        ui.print("\nIndtast svømmerens placering: ");
        int result = ui.scannerInt();

        ui.print("\nIndtast tid: ");
        float time = ui.scannerFloat();

        ui.print("\nIndtast dag: ");
        int day = ui.scannerInt();

        ui.print("\nIndtast måned: ");
        int month = ui.scannerInt();

        ui.print("\nIndtast år: ");
        int year = ui.scannerInt();

        LocalDate date = LocalDate.of(day, month,year);
        ui.print("Medlemmet er tilføjet\n\n");
        member.addTournament(new Tournament(name,result,time,date));

    }
    }


