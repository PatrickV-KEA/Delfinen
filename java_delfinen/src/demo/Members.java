/**
 * @author Adam Kasper Patrick
 */
package demo;

import java.util.ArrayList;

public class Members {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private MemberFileReader memberFileReader = new MemberFileReader();
    private ArrayList<Member> membersList = memberFileReader.getMembersList();

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void addMember(Member member) {

        membersList.add(member);
    }

    public Member getMemberFromNumber(int number) {
        for (Member member : membersList) {
            if (number == member.getId()) {
                return member;
            }
        }
        return null;
    }

    public ArrayList<Member> getMembersList() {

        return membersList;
    }
}