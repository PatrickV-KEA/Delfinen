package demo;
/**
 *
 * @author Adam
 *
 */

import java.util.ArrayList;

public class Members {
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Member> juniorList = new ArrayList<>();
    ArrayList<Member> seniorList = new ArrayList<>();
    ArrayList<Member> elderList = new ArrayList<>();

    public void addMember (Member member) { members.add(member); }
    public void addJunior (Member member) { juniorList.add(member); }
    public void addSenior (Member member) { seniorList.add(member); }
    public void addElder (Member member) { elderList.add(member); }

    public Member getMemberFromNumber(int number) {
        Member member;
        for (int i = 0; i < members.size(); i++) {
            int id = members.get(i).getMemberNr();
            if (id == number) {
                member = members.get(i);
                return member;
            }
        }
        return null;
    }

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
    }
}



