package demo;

import java.util.ArrayList;
import java.util.logging.FileHandler;

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
    private MemberFileReader memberFileReader = new MemberFileReader();
    private ArrayList<Member> members = memberFileReader.getMembersList() ;  // det her skal kigges efter.....
    private MenuBoard menuBoard = new MenuBoard(members);
    private MenuCoach menuCoach = new MenuCoach(members);
    private MenuEconomics menuEconomics = new MenuEconomics(members);

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