package demo;

public class MenuController {
    // ------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------
    UI ui = new UI();
    BoardMenu boardMenu = new BoardMenu();

    // ------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------
   // public MenuController(UI ui) {

    //}

    // ------------------------------------------------------
    // METHODS
    // ------------------------------------------------------
    public void run() {
        ui.printString("Tryk 1 For træner");
        ui.printString("Tryk 2 For kasseren");
        ui.printString("Tryk 3 For formanden");
        //ui.printString("Tryk 4 Annuller bestilling");
        //ui.printString("Tryk 5 Se menukort");
        //ui.printString("Tryk 6 Se statistik");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //træner menu
                    //CoachMenu.menu();//noget med static
                    break;
                case 2:
                    //kasser menu
                    //EconomicsMenu.menu();//noget med static
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