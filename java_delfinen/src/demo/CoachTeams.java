package demo;

import java.util.ArrayList;

public class CoachTeams {
    private FileHandler fileHandler = new FileHandler();
    private UI ui = new UI();
    private Members members = new Members();
    ArrayList<Member> memberList = fileHandler.getMembersList();


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
