package demo;
/**
 *
 * @author Adam
 *
 */
import java.time.LocalDate;

public class BoardMenu {
    UI ui = new UI();


    public void menu() {
        String name;
        LocalDate birthday;
        int cpr;
        boolean payed = false;
        boolean active = true;
        int day, mouth, year;


        ui.printString("Her kan du indmelde nye medlemmer.");
        ui.print("Intast navn: ");
        name = ui.scannerString();
        ui.printString("");
        ui.print("intast fødeselsår: ");
        year = ui.scannerInt();
        ui.printString("");
        ui.print("indtast fødeselmåned: ");
        mouth = ui.scannerInt();
        ui.printString("");
        ui.print("indtast fødeseldag: ");
        day = ui.scannerInt();

        birthday = LocalDate.of(year, mouth, day);

        ui.print("Indtast cpr (de sidste 4 cifre):");
        cpr = ui.scannerInt();
        ui.print("");

        boolean validAnswer = false;
        do {
            ui.printString("Er der betalt kontingent for i år?");
            ui.print("ja/nej >> ");
            String answer = ui.scannerString();
            if (answer.equals( "ja")) {
                payed = true;
                validAnswer = true;
            } else if (answer.equals("nej")) {
                payed = false;
                validAnswer = true;
            } else {
                validAnswer = false;
            }
        } while (!validAnswer);


        boolean validAnswer2 = false;
        do {
            ui.printString("Er det et aktivt medlemsskab?");
            ui.print("ja/nej >> ");
            String answer = ui.scannerString();
            if (answer.equals( "ja")) {
                active = true;
                validAnswer2 = true;
            } else if (answer.equals( "nej")) {
                active = false;
                validAnswer2 = true;
            } else {
                validAnswer2 = false;
            }
        } while (!validAnswer2);

        new Member(name,birthday,cpr,payed,active);
    }
}
