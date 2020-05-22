package demo;
/**
 * @author kasper
 */

import java.util.ArrayList;
import java.util.Collections;

public class CoachTeams {

    private UI ui = new UI();
    private Members members;

    public CoachTeams(Members members) {
        this.members = members;
    }

    public void teams(Boolean junior, Boolean topFive) {
        ArrayList<Member> crawl = new ArrayList<>();
        ArrayList<Member> backCrawl = new ArrayList<>();
        ArrayList<Member> butterfly = new ArrayList<>();
        ArrayList<Member> breast = new ArrayList<>();
        String category = "";

        if (junior) {
            category = "Junior";
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
        } else if (!junior) {
            category = "Senior";
            for (int i = 0; i < members.getMembersList().size(); i++) {
                String disc = members.getMembersList().get(i).getDiscipline();
                int age = members.getMembersList().get(i).getAge();
                if (disc != null) {
                    if (disc.equals("Krawl") && age >= 18) {
                        crawl.add(members.getMembersList().get(i));
                    }
                    if (disc.equals("Rygkrawl") && age >= 18) {
                        backCrawl.add(members.getMembersList().get(i));
                    }
                    if (disc.equals("Butterfly") && age >= 18) {
                        butterfly.add(members.getMembersList().get(i));
                    }
                    if (disc.equals("Brystsvømning") && age >= 18) {
                        breast.add(members.getMembersList().get(i));
                    }
                }
            }
        }

        if (topFive) {
            Collections.sort(crawl);
            Collections.sort(backCrawl);
            Collections.sort(butterfly);
            Collections.sort(breast);
            ui.printString(category + " Top 5 i Crawl:");
            ui.printArraylistFive(crawl);
            ui.printString("");
            ui.printString(category + " Top 5 i Rygcrawl:");
            ui.printArraylistFive(backCrawl);
            ui.printString("");
            ui.printString(category + " Top 5 i Butterfly:");
            ui.printArraylistFive(butterfly);
            ui.printString("");
            ui.printString(category + " Top 5 i Brystsvømning:");
            ui.printArraylistFive(breast);
            ui.printString("");
        } else if (!topFive) {
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
    }
}