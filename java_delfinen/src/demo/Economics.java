package demo;
/**
 *
 * @author kasper
 *
 */
import java.util.ArrayList;

public class Economics {

    private UI ui = new UI();
    private ArrayList<Member> memberList;

    public Economics(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public void printMemberArrears() {
        Member member;
        ArrayList<Member> arrearsList = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).isPaid() == false) {
                member = memberList.get(i);
                arrearsList.add(member);
            }
        }
        ui.printArraylist(arrearsList);
    }

    public void getTotalContingent() {
        int total = 0;

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).isActive() == false) {
                total = total + 500;
            } else {
                if (memberList.get(i).getAge() < 18) {
                    total = total + 1000;
                }
                if (memberList.get(i).getAge() > 18 && memberList.get(i).getAge() < 60) {
                    total = total + 1600;
                }
                if (memberList.get(i).getAge() > 60) {
                    total = total + 1200;
                }
            }
        }
        ui.printString("Total Kontingent: " + total + " kr.");
    }

    public void printMemberList(){
        int contingent = 0;

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).isActive() == false) {
                contingent = 500;
            } else {
                if (memberList.get(i).getAge() < 18) {
                    contingent = 1000;
                }
                if (memberList.get(i).getAge() > 18 && memberList.get(i).getAge() < 60) {
                    contingent = 1600;
                }
                if (memberList.get(i).getAge() > 60) {
                    contingent = 1200;
                }
            }

            ui.printString("" + memberList.get(i) + " " + contingent + " kr. kontingent.");
        }

    }

    public void updateInfo(){
        //Update
    }

    /*public void changePaymentStatus(){
        Member member;
        ui.printArraylist(memberList);

        try {
            while (true) {
                ui.clear();
                ui.printArraylist(memberList);
                ui.printString("Vælg et medlem for at opdatere betalingsstatus. ");
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

        } catch (IllegalArgumentException e) {
            ui.printString("Dette medlemsnummer findes ikke...");
        }

    }*/




}
