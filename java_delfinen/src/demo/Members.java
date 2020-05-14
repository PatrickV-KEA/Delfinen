package demo;
/**
 *
 * @author Adam
 *
 */

import java.util.ArrayList;

public class Members {
    ArrayList<Member> members = new ArrayList<>();

    public void addMember (Member member) {
        members.add(member);
    }
    public Member getMemberFromNumber(int number) {
        Member member;
        for (int i = 0; i < members.size(); i++) {
            int id = members.get(i).getMembernr;
            if (id == number) {
                member = members.get(i);
                return member;
            }
        }
        return null;
    }
}
