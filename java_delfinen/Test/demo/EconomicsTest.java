package demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EconomicsTest {
    private FileHandler fileHandler = new FileHandler();
    private UI ui = new UI();
    ArrayList<Member> memberList = fileHandler.getMembersList();

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