package demo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void getMembersList() {

        FileReader fileReader = new FileReader();
        ArrayList<Member> members = fileReader.getMembersList();

        assertEquals(1, members.get(0).getMemberNr());
        assertEquals("Adam", members.get(0).getName());
        assertEquals(LocalDate.of(1996, 03,14), members.get(0).getBirthday());
        assertEquals(8755, members.get(0).getCpr());
        assertEquals("Rygkrawl", members.get(0).getDiscipline());
        assertEquals(90, members.get(0).getBestTime());

    }
}