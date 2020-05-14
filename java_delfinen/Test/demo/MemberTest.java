package demo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void addTournament() {

        Member member = new Member(1, "Kasper", LocalDate.of(1997,06,02), 8989, true, true);
        member.addTournament("Kolding water rave", 3, 43, LocalDate.of(2020,04,02));

        assertEquals(1, member.getTournaments().size());
    }
}