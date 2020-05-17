package demo;
/**
 * @author Adam kasper
 */

import java.util.ArrayList;

public class Members {

    private FileReader fileReader = new FileReader();
    ArrayList<Member> membersList = fileReader.getMembersList();

    public Member getMemberFromNumber(int number) {
        Member member;
        for (int i = 0; i < membersList.size(); i++) {
            int id = membersList.get(i).getMemberNr();
            if (id == number) {
                member = membersList.get(i);
                return member;
            }
        }
        return null;
    }
/*
    public void SortMembers() {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getAge() < 18){
                addJunior(members.get(i));
            }
            if (members.get(i).getAge() > 18 && members.get(i).getAge() < 60) {
                addSenior(members.get(i));
            }
            if (members.get(i).getAge() > 60){
                addElder(members.get(i));
            }
        }
    }*/
}



