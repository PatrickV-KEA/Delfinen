package demo;
/**
 * @author Adam kasper
 */

import java.util.ArrayList;

public class Members {

<<<<<<< HEAD
    private MemberFileReader memberFileReader = new MemberFileReader();
    ArrayList<Member> membersList = memberFileReader.getMembersList();
=======
    private FileReader fileReader = new FileReader();
    private ArrayList<Member> membersList = fileReader.getMembersList();
>>>>>>> b12828edfc4564dd9c801592e37d3aa409e626a7

    public Member getMemberFromNumber(int number) {
        Member member;
        for (int i = 0; i < membersList.size(); i++) {
            int id = membersList.get(i).getId();
            if (id == number) {
                member = membersList.get(i);
                return member;
            }
        }
        return null;
    }

    public ArrayList<Member> getMembersList() {
        return membersList;
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



