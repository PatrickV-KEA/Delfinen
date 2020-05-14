package demo;
/**
 *
 * @author Adam
 *
 */

public class CoachMenu {

    UI ui = new UI();

    public void menu() {
        //DENNE MENU ER SLET IKKE KLAR ENDNU!
        ui.printString("Tryk 1 For træner");
        ui.printString("Tryk 2 For kasseren");
        ui.printString("Tryk 3 For formanden");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //træner menu

                    break;
                case 2:
                    //kasser menu

                    break;
                case 3:
                    //formands menu

                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

        }
    }
}
