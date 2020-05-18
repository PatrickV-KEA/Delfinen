/**
 * @author Adam
 */
package demo;

import java.util.ArrayList;

public class MenuCoach {

    UI ui = new UI();
    ArrayList<Member> members;

    public MenuCoach(ArrayList<Member> members) {
        this.members = members;
    }

    public void menu() {
        /*
        Noter til opbygning af menu:
        se medlemsliste
        tilføj medlem til svømmehold
        ændre resultater for medlem
        top bedste svømmere for hver diciplin
        */

        ui.printString("Tryk 1 For at se medlemsliste");
        ui.printString("Tryk 2 For at se holdlist");
        ui.printString("Tryk 3 For at tilføj medlem til svømmehold");
        ui.printString("Tryk 4 For at ændre resultater for medlem");
        ui.printString("Tryk 5 For at se top bedste svømmere for hver diciplin");
        ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
        ui.print(">> ");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //medlemsliste

                    break;

                case 2:
                    //se holdeliste

                    break;
                case 3:
                    //tilføj svømmer til hold

                    break;
                case 4:
                    //ændre resultat for svømmer

                    break;
                case 5:
                    // se top 5

                    break;
                case 0:
                    //tilbage til hovedmenuen
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

        }
    }
}
