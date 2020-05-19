/**
 * @author Adam
 */
package demo;

import java.util.ArrayList;

public class MenuEconomics {

    private UI ui = new UI();
    private Members members;
    private Economics economics;

    public MenuEconomics(Members members) {
        this.members = members;
        economics = new Economics(members);
    }

    public void menu() {
        ui.printString("Du har nu følgende muligheder");
        ui.printString("Tryk 1 For restance listen");
        ui.printString("Tryk 2 For medlemslisten");
        ui.printString("Tryk 3 For Opdatere et medlems informationer");
        ui.printString("tryk 4 for at indskrive en betaling   ");
        ui.printString("Tryk 5 for årest samlede kontingent");
        ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //restance liste
                    economics.printMemberArrears();
                    break;
                case 2:
                    //medlemsliste
                    economics.printMemberList();
                    break;
                case 3:
                    //opdater info

                    break;
                case 4:
                    //indkriv betaling
                    economics.changePaymentStatus();
                    break;
                case 5:
                    //se samlede kontingent
                    economics.getTotalContingent();
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
