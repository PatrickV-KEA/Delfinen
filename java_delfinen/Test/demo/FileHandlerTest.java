package demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void getMembersList() {

        FileHandler fileHandler = new FileHandler();
        ArrayList<Member> members = fileHandler.getMembersList();

        assertEquals(1, members.get(0).getMemberNr());
        assertEquals("Adam", members.get(0).getName());
        assertEquals(LocalDate.of(1996, 03,14), members.get(0).getBirthday());
        assertEquals(8755, members.get(0).getCpr());
        assertEquals("Rygkrawl", members.get(0).getDiscipline());
        assertEquals(90, members.get(0).getBestTime());
    }
}