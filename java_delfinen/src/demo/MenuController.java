package demo;

public class MenuController {
    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    UI ui = new UI();
    BoardMenu boardMenu = new BoardMenu();
    CoachMenu coachMenu = new CoachMenu();
    EconomicsMenu economicsMenu = new EconomicsMenu();

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public MenuController() {}

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
                    coachMenu.menu();
                    break;
                case 2:
                    //kasser menu
                    economicsMenu.menu();
                    break;
                case 3:
                    //formands menu
                    boardMenu.menu();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}