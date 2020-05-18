package demo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberFileWriterTest {

    @Test
    void writeMember() {
        Member member = new Member(1, "Kasper", LocalDate.of(1997,06,02), 8989, true, true, "Rygkrawl", 90);
        Tournament tournament = new Tournament("Kolding water rave", 3, 43, LocalDate.of(2020,04,02));
        member.addTournament(tournament);

        MemberFileWriter fw = new MemberFileWriter();
        fw.writeMember(member);
    }

    @Test
    void updateMembersList() {
    }
}