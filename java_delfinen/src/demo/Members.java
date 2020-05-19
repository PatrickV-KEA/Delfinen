package demo;
/**
 * @author Adam
 */

import java.util.ArrayList;

public class Members {
    private MemberFileReader memberFileReader = new MemberFileReader();
    private ArrayList<Member> membersList = memberFileReader.getMembersList();

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
}




