/**
 * @author Adam
 */
package demo;

public class MenuController {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui = new UI(); //Pass through system
    private Members members = new Members();
    private MenuBoard menuBoard = new MenuBoard(members);
    private MenuCoach menuCoach = new MenuCoach(members);
    private MenuEconomics menuEconomics = new MenuEconomics(members);

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public MenuController() {}

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