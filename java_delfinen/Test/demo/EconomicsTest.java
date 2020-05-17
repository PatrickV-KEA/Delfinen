package demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class EconomicsTest {
    private FileReader fileReader = new FileReader();
    private UI ui = new UI();
    ArrayList<Member> memberList = fileReader.getMembersList();

    @Test
    public void printMemberArrears() {
        Member member;
        ArrayList<Member> arrearsList = new ArrayList<>();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).isPayed() == false) {
                member = memberList.get(i);
                arrearsList.add(member);
            }
        }
        ui.printArraylist(arrearsList);
    }

    @Test
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

    @Test
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
    }
