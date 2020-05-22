/**
 * @author Adam Kasper Patrick
 */
package demo;

import java.util.ArrayList;
import java.util.Collections;

public class Members {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private MemberFileReader memberFileReader;
    private MemberFileWriter memberFileWriter;
    private ArrayList<Member> membersList;

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public Members() {
        memberFileReader = new MemberFileReader();
        memberFileWriter = new MemberFileWriter();
        membersList = memberFileReader.getMembersList();
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void addMember(Member member) {
        membersList.add(member);
        memberFileWriter.updateMembers(membersList);
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

    public void updateMembers(){
        memberFileWriter.updateMembers(membersList);
    }

    public ArrayList<Member> getTeam(String league, String discipline) {
        ArrayList<Member> team = new ArrayList<>();
        for (Member member: membersList) {
            if (member.getDiscipline() == null) {
                continue;
            } else if (member.getLeague().equals(league) && member.getDiscipline().equals(discipline)) {
                team.add(member);
            }
        } //END OF FOR-LOOP
        Collections.sort(team);
        return team;
    }
}