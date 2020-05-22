/**
 * @author Adam
 */
package Program;

import UI.UI;

public class MenuController {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui;
    private Members members;
    private MenuBoard menuBoard;
    private MenuCoach menuCoach;
    private MenuEconomics menuEconomics;

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public MenuController() {
        ui = new UI();
        members = new Members();
        menuBoard = new MenuBoard(members);
        menuCoach = new MenuCoach(members, ui);
        menuEconomics = new MenuEconomics(members);
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void run() {
        ui.printString("Tryk 1 For træner");
        ui.printString("Tryk 2 For kasseren");
        ui.printString("Tryk 3 For formanden");
        ui.print(">>");
        try {
            switch (ui.getUserInputInt()) {
                case 1:
                    //træner menu
                    menuCoach.menu();
                    break;
                case 2:
                    //kasser menu
                    menuEconomics.menu();
                    break;
                case 3:
                    //formands menu
                    menuBoard.menu();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}