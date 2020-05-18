/**
 * @author Patrick
 */
package demo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void addTournament() {

        Member member = new Member(1, "Kasper", LocalDate.of(1997,06,02), 8989, true, true);
        Tournament tournament = new Tournament("Kolding water rave", 3, 43, LocalDate.of(2020,04,02));
        member.addTournament(tournament);

        assertEquals(1, member.getTournaments().size());
    }
    @Test
    void toFile() {
        Member member = new Member(1, "Kasper", LocalDate.of(1997,06,02), 8989, true, true, "Rygkrawl", 90);
        Tournament tournament = new Tournament("Kolding water rave", 3, 43, LocalDate.of(2020,04,02));
        member.addTournament(tournament);

        System.out.println(member.toFile());
    }
}