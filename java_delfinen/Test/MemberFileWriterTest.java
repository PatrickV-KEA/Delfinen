/**
 * @author Patrick
 */

import FileInteraction.MemberFileReader;
import FileInteraction.MemberFileWriter;
import Program.Member;
import Program.Tournament;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MemberFileWriterTest {

    /*@Test
    void writeMember() {
        Member member = new Member(1, "Kasper", LocalDate.of(1997,06,02), 8989, true, true, "Rygkrawl", 90);
        Tournament tournament = new Tournament("Kolding water rave", 3, 43, LocalDate.of(2020, 04,02));
        member.addTournament(tournament);

        MemberFileWriter fw = new MemberFileWriter("");
        fw.writeMember(member);

        MemberFileReader fr = new MemberFileReader("");
        ArrayList<Member> arr = fr.getMembersList();

        assertEquals(member.getId(),        arr.get(arr.size()-1).getId());
        assertEquals(member.getName(),      arr.get(arr.size()-1).getName());
        assertEquals(member.getBirthday(),  arr.get(arr.size()-1).getBirthday());
        assertEquals(member.getAge(),       arr.get(arr.size()-1).getAge());
    }*/

    @Test
    void updateMembersList() {
        Member member = new Member(1, "Kasper", LocalDate.of(1997,06,02), 8989, true, true, "Rygkrawl", 90);
        Tournament tournament = new Tournament("Kolding water rave", 3, 43, LocalDate.of(2020, 04,02));
        member.addTournament(tournament);

        ArrayList<Member> membersList = new ArrayList<>();
        membersList.add(member);
        membersList.add(member);
        membersList.add(member);
        membersList.add(member);

        MemberFileWriter fw = new MemberFileWriter("");
        fw.updateMembers(membersList);

        MemberFileReader fr = new MemberFileReader("");
        ArrayList<Member> arr = fr.getMembersList();

        for (int i = 0; i < arr.size(); i++) {
            assertEquals(arr.get(i).getId(),        membersList.get(i).getId());
            assertEquals(arr.get(i).getName(),      membersList.get(i).getName());
            assertEquals(arr.get(i).getBirthday(),  membersList.get(i).getBirthday());
            assertEquals(arr.get(i).getAge(),       membersList.get(i).getAge());
        }
    }
}