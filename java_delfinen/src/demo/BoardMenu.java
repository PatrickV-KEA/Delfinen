package demo;

import java.time.LocalDate;

public class BoardMenu {
    UI ui = new UI();

    public void menu() {
        String name;
        LocalDate birthday;
        int cpr;
        boolean payed;
        boolean active;
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
            ui.print("y/n >> ");
            String answer = ui.scannerString();
            if (answer == "y") {
                payed = true;
                validAnswer = true;
            } else if (answer == "n") {
                payed = false;
                validAnswer = true;
            } else {
                validAnswer = false;
            }
        } while (!validAnswer);


        boolean validAnswer2 = false;
        do {
            ui.printString("Er det et aktivt medlemsskab?");
            ui.print("y/n >> ");
            String answer = ui.scannerString();
            if (answer == "y") {
                active = true;
                validAnswer2 = true;
            } else if (answer == "n") {
                active = false;
                validAnswer2 = true;
            } else {
                validAnswer2 = false;
            }
        } while (!validAnswer2);
    }
}
