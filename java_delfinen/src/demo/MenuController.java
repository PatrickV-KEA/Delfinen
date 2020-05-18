package demo;

/**
 *
 * @author Adam
 *
 */

public class MenuController {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui = new UI();
    private MenuBoard menuBoard = new MenuBoard();
    private MenuCoach menuCoach = new MenuCoach();
    private MenuEconomics menuEconomics = new MenuEconomics();
    private Members members = new Members();

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public MenuController() {
    }

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void run() {
        ui.printString("Tryk 1 For træner");
        ui.printString("Tryk 2 For kasseren");
        ui.printString("Tryk 3 For formanden");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //træner menu
                    menuCoach.menu();
                    break;
                case 2:
                    //kasser menu
                    menuEconomics.menu(members.getMembersList());
                    break;
                case 3:
                    //formands menu
                    menuBoard.menu(members.getMembersList());
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}