package demo;
/**
 * @author kasper
 */

import java.util.ArrayList;

public class Economics {

    private UI ui = new UI();
    private Members members;
    private MemberFileWriter memberFileWriter = new MemberFileWriter();

    public Economics(Members members) {
        this.members = members;
    }

    public void printMemberArrears() {
        Member member;
        ArrayList<Member> arrearsList = new ArrayList<>();

        for (int i = 0; i < members.getMembersList().size(); i++) {
            if (!members.getMembersList().get(i).isPaid()) {
                member = members.getMembersList().get(i);
                arrearsList.add(member);
            }
        }
        ui.printArraylist(arrearsList);
    }

    public void getTotalContingent() {
        int total = 0;

        for (int i = 0; i < members.getMembersList().size(); i++) {
            if (!members.getMembersList().get(i).isActive()) {
                total = total + 500;
            } else {
                if (members.getMembersList().get(i).getAge() < 18) {
                    total = total + 1000;
                }
                if (members.getMembersList().get(i).getAge() > 18 && members.getMembersList().get(i).getAge() < 60) {
                    total = total + 1600;
                }
                if (members.getMembersList().get(i).getAge() > 60) {
                    total = total + 1200;
                }
            }
        }
        ui.printString("Total Kontingent: " + total + " kr.");
    }

    public void printMemberList() {
        int contingent = 0;

        for (int i = 0; i < members.getMembersList().size(); i++) {
            if (!members.getMembersList().get(i).isActive()) {
                contingent = 500;
            } else {
                if (members.getMembersList().get(i).getAge() < 18) {
                    contingent = 1000;
                }
                if (members.getMembersList().get(i).getAge() > 18 && members.getMembersList().get(i).getAge() < 60) {
                    contingent = 1600;
                }
                if (members.getMembersList().get(i).getAge() > 60) {
                    contingent = 1200;
                }
            }

            ui.printString("" + members.getMembersList().get(i) + " " + contingent + " kr. kontingent.");
        }

    }

    public void updateInfo() {
        //Update
    }

    public void changePaymentStatus() {
        Member member;
        try {
            while (true) {
                ui.clear();
                ui.printArraylist(members.getMembersList());
                ui.printString("Vælg et medlem for at opdatere betalingsstatus. ");
                ui.print("\nAngiv medlemsnummer >>");

                int number = ui.scannerInt();
                member = members.getMemberFromNumber(number);
                if (member == null) {
                    ui.print("Medlem med givet nummer findes ikke...\nTryk Enter >>");
                    ui.scannerLine();
                    ui.clear();
                } else {
                    ui.printString(member.toString());
                    member.setPaid(!member.isPaid());
                    ui.printString(member.toString());
                    memberFileWriter.updateMembers(members.getMembersList());
                    break;
                }
            }

        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }

    }

    public void resetYear();


}
