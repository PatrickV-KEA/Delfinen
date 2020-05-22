/**
 * @author Adam
 */
package Program;

import UI.UI;

public class MenuEconomics {

    private UI ui = new UI();
    private Economics economics;

    public MenuEconomics(Members members) {
        economics = new Economics(members);
    }

    public void menu() {
        Boolean condition = true;
        while (condition) {
            ui.printString("Du har nu følgende muligheder");
            ui.printString("Tryk 1 For restance listen");
            ui.printString("Tryk 2 For medlemslisten");
            ui.printString("Tryk 3 For at ændre aktiv staus hos et medlem");
            ui.printString("tryk 4 for at indskrive en betaling   ");
            ui.printString("Tryk 5 for årest samlede kontingent");
            ui.printString("Tryk 6 for at starte nyt betalingsår");
            ui.printString("Tryk 0 for at vende tilbage til hovedmenuen");
            ui.print(">>");
            try {
                switch (ui.getUserInputInt()) {
                    case 1:
                        //restance liste
                        economics.printMemberArrears();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 2:
                        //medlemsliste
                        economics.printMemberList();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 3:
                        //ændre aktiv status
                        economics.changeActive();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 4:
                        //indkriv betaling
                        economics.changePaymentStatus();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 5:
                        //se samlede kontingent
                        economics.getTotalContingent();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 6:
                        //start nyt betalingsår
                        economics.resetYear();
                        ui.printString("\nTryk enter for menu");
                        ui.getUserLine();
                        break;
                    case 0:
                        //tilbage til hovedmenuen
                        condition = false;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}